import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private final String id;
    private final NotificationType type;
    private final String userId;
    private final String content;
    private final LocalDateTime timestamp;

    public Notification(NotificationType type, String userId, String content) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.userId = userId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
