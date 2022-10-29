package clientmodel;

public class Message {
    private String text;
    private String username;
    private boolean isPrivateRequest;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
        this.isPrivateRequest = false;
    }

    public Message(String text, String username, boolean isPrivateRequest) {
        this.text = text;
        this.username = username;
        this.isPrivateRequest = isPrivateRequest;
    }

    public boolean isPrivateRequest() {
        return isPrivateRequest;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return getUsername() + ": " + getText();
    }
}
