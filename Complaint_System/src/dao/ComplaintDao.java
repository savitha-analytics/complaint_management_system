package dao;

import java.sql.*;

public class ComplaintDao {

    // ADD COMPLAINT
    public void addComplaint(String name, String text, String dept, boolean social) {

        try {
            Connection con = DBConnection.getConnection();

            String q = "INSERT INTO complaints(name, complaint_text, department, status, social_impact, points) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, text);
            ps.setString(3, dept);
            ps.setString(4, "Pending");
            ps.setBoolean(5, social);
            ps.setInt(6, 0);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Complaint ID: " + rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW ALL
    public void viewComplaints() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM complaints");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | " +
                                   rs.getString(4) + " | Points: " +
                                   rs.getInt("points"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE STATUS + SMART POINTS ⭐
    public void updateStatus(int id, String status) {

        try {
            Connection con = DBConnection.getConnection();

            // Update status
            String q = "UPDATE complaints SET status=? WHERE complaint_id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

            // 🔥 Check social impact
            String check = "SELECT social_impact FROM complaints WHERE complaint_id=?";
            PreparedStatement ps2 = con.prepareStatement(check);
            ps2.setInt(1, id);

            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {

                boolean social = rs.getBoolean("social_impact");

                if (status.equalsIgnoreCase("Solved")) {

                    if (social) {
                        markUseful(id, 20); // ⭐ HIGH impact
                    } else {
                        markUseful(id, 10); // Normal
                    }
                }
            }

            System.out.println("Status Updated!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ADD POINTS (increment)
    public void markUseful(int id, int points) {

        try {
            Connection con = DBConnection.getConnection();

            String q = "UPDATE complaints SET points = points + ? WHERE complaint_id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, points);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Points Added: " + points);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // CHECK STATUS + POINTS
    public void checkFullDetails(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT * FROM complaints WHERE complaint_id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Points: " + rs.getInt("points"));
            } else {
                System.out.println("Invalid ID");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // SOCIAL IMPACT
    public void viewSocialImpact() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM complaints WHERE social_impact=TRUE");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | Points: " +
                                   rs.getInt("points"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DEPARTMENT FILTER
    public void viewByDepartment(String dept) {

        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT * FROM complaints WHERE department=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, dept);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | Points: " +
                                   rs.getInt("points"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}