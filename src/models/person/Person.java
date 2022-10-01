package models.person;

public abstract class Person {
	protected String matricule;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String passWord;

    public Person(String matricule, String firstName, String lastName, String email, String passWord) {
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
    }
    
   
    protected abstract Boolean authenticate(String email,String password);
    
}
