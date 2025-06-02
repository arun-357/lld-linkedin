import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedIn {
    private static LinkedIn instance;
    private final Map<String, User> users;
    private final Map<String, JobPosting> jobPostings;
    private final Map<String, List<Notification>> notifications;

    private LinkedIn() {
        this.users = new ConcurrentHashMap<>();
        this.jobPostings = new ConcurrentHashMap<>();
        this.notifications = new ConcurrentHashMap<>();
    }

    public static synchronized LinkedIn getInstance() {
        if (instance == null) {
            instance = new LinkedIn();
        }
        return instance;
    }

    public User registerUser(String email, String name, String password) {
        User user = new User(email, name, password);
        users.put(user.getEmail(), user);
        return user;
    }

    public User loginUser(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void sendConnectionRequest(User user, User receiver) {
        Connections connection = new Connections(user, ConnectionStatus.PENDING);
        if(!receiver.getConnections().contains(connection)) {
            receiver.getConnections().add(connection);
        } else {
            System.out.println("Connection request already sent to " + receiver.getName());
        }
    }

    public void acceptConnectionRequest(User user, User sender) {
        User acceptingUser = users.get(user.getEmail());
        Connections sendersConnection = (Connections) acceptingUser.getConnections().stream().filter(
            con -> con.getUser().equals(sender) && con.getStatus() == ConnectionStatus.PENDING
        );
        sendersConnection.setConnectionStatus(ConnectionStatus.ACCEPTED);
    }

    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content);
        receiver.addToInbox(message);
        sender.addToSentMessages(message);
    }

    public void postJob(String title, String company, String location, String description) {
        JobPosting jobPosting = new JobPosting(title, company, location, description);
        jobPostings.put(jobPosting.getId(), jobPosting);
    }

    public List<JobPosting> getJobPostings(String keyword) {
        return jobPostings.values().stream().filter(jobPosting -> jobPosting.getTitle().contains(keyword)).toList();
    }

}
