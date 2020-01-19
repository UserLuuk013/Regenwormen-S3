package regenwormenshared.messaging.messages.Client;

public class RegisterPlayerMessage {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RegisterPlayerMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
