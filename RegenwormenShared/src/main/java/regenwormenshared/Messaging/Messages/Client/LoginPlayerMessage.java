package regenwormenshared.Messaging.Messages.Client;

public class LoginPlayerMessage {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginPlayerMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
