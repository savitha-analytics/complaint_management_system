package dao;

import java.sql.*;

public class AdminDao {

    public boolean login(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}