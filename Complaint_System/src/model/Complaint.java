package model;

public class Complaint {

    int id;
    String name;
    String complaint;
    String department;
    String status;
    boolean socialImpact;
    int points;

    public Complaint() {}

    public Complaint(int id, String name, String complaint, String department,
                     String status, boolean socialImpact, int points) {

        this.id = id;
        this.name = name;
        this.complaint = complaint;
        this.department = department;
        this.status = status;
        this.socialImpact = socialImpact;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getSocialImpact() {
        return socialImpact;
    }

    public void setSocialImpact(boolean socialImpact) {
        this.socialImpact = socialImpact;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}