/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.mysqlconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.BloodBank;

/**
 *
 * @author rojal
 */
public class BloodBankDAO {
        private mysqlconnection db = new mysqlconnection();

    public List<BloodBank> getAllBloodBanks() {
        List<BloodBank> list = new ArrayList<>();
        Connection conn = db.openConnection();
        String query = "SELECT * FROM blood_banks";

        try {
            ResultSet rs = db.runQuery(conn, query);
            while (rs.next()) {
                BloodBank b = new BloodBank();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setPhone(rs.getString("phone"));
                b.setLocation(rs.getString("location"));
                b.setType(rs.getString("type"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conn);
        }
        return list;
    }
    
    
}
