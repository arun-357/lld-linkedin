import java.time.LocalDateTime;

public class Connections {

    private final User user;
    private ConnectionStatus status;
    private final LocalDateTime connectionDate;

    public Connections(User user, ConnectionStatus status) {
        this.user = user;
        this.status = status;
        this.connectionDate = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    public void setConnectionStatus(ConnectionStatus status) {
        this.status = status;
    }

    public LocalDateTime getConnectionDate() {
        return connectionDate;
    }
}
