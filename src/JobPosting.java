import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JobPosting {
    private final String id;
    private final String title;
    private final String company;
    private final String location;
    private final String description;
    private Map<String, User> applicants;

    public JobPosting(String title, String company, String location, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.applicants = new ConcurrentHashMap<>();
    }

    public void apply(User user) {
        if (user != null && !applicants.containsKey(user.getId())) {
            System.out.println("User " + user.getName() + " has already applied for the job: " + title);
        }
    }

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, User> getApplicants() {
        return applicants;
    }
}
