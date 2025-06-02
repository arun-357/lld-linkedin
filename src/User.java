import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String email;
    private final String name;
    private final String password;
    private Profile profile;
    private List<Connections> connections;
    private List<Message> inbox;
    private List<Message> sentMessages;
    private List<Notification> notifications;

    public User(String email, String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.password = password;
        this.connections = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addToInbox(Message message) {
        this.inbox.add(message);
    }
    public void addToSentMessages(Message message) {
        this.sentMessages.add(message);
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Connections> getConnections() {
        return connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
