import java.util.List;

public class Profile {
    private String pictureUrl;
    private String bio;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
