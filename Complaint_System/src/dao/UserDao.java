package dao;

import java.sql.*;
import model.User;

public class UserDao {

    public void addUser(User user) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            System.out.println("User Added!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public boolean login(String u, String p) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, u.trim());
            ps.setString(2, p.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}