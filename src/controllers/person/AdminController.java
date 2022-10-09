package controllers.person;

import affichage.view.Agent;
import app.Config;
import app.security.BCrypt;
import models.Admin;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
public class AdminController {
    public Boolean authenticate(String email, String password) {
        Admin admin = new Admin();
        String result = admin.getPassword(email,"admin","email");
        if (result == null) {
            return null;
        } else {
            return BCrypt.checkpw(password,result);
        }
    }

    public Boolean addAgent(){
        HashMap agentInfo = Agent.addAgent();
        String matricule = agentInfo.get("matricule").toString();
        String nom = agentInfo.get("nom").toString();
        String prenom = agentInfo.get("prenom").toString();
        String email = agentInfo.get("email").toString();

        String password =sendpasswod(email);

        String hashedPassword = BCrypt.hashpw(password, Config.salt);
        models.Agent agent = new models.Agent(matricule,prenom,nom,email,hashedPassword);
        return agent.addAgent();
    }
    public static String sendpasswod(String email){
        Courier.init("pk_prod_Q02ESMDGP3MRBNMWTZ3Q1XN0A244");
        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", email);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Password  :");
        String idOne = getAlphaNumericString(8);
        content.put("body", "your password to access a Mcnss :"+ idOne);
        sendRequestMessage.setContent(content);
        HashMap<String, Object> data = new HashMap<String, Object>();
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);
        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println("nous sommes envoyer password de patient dans leur email :");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idOne;
    }

    static String getAlphaNumericString(int n)
    {
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }
        // return the resultant string
        return r.toString();
    }


}
