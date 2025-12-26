package dao;

import Model.Shipping;
import database.DBConnections;
import java.sql.*;

public class ShippingDAO {

    public Shipping getLatestShippingByUserId(int userId) {

        String sql = "SELECT * FROM addresses WHERE user_id=? ORDER BY id DESC LIMIT 1";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                 Shipping shipping = new Shipping();
                 shipping.setFullName(rs.getString("full_name"));
                 shipping.setPhone(rs.getString("phone"));
                 shipping.setAddress(rs.getString("address"));
                 return shipping;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
