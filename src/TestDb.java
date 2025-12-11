/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kritss
 */
import database.mysqlconnector;

public class TestDb {
    public static void main(String[] args) {
        System.out.println("Running Test...");
        mysqlconnector db = new mysqlconnector();
        db.openConnection();
    }
}

