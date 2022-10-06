package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cnx {
    public static Connection CNX(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Config.connectionURL,Config.user,Config.motDePasse);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }




}
