package app;

import app.security.BCrypt;

public class Config {
    public static final String connectionURL = "jdbc:mysql://localhost:3306/macnss";
    public static final String user = "root";
    public static final String motDePasse = "";
    public static final String salt = BCrypt.gensalt();
}
