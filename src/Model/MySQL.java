/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pasan
 */
public class MySQL {
  private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_shop", "root", "");
            // Statement stmt = con.createStatement();
        } catch (Exception e) {
        }
    }

    public static ResultSet execute(String query) throws Exception{
      
            Statement stmt = con.createStatement();

            if (query.startsWith("SELECT")) {
                ResultSet resultset = stmt.executeQuery(query);
                return resultset;
            } else {
                int result = stmt.executeUpdate(query);
                return null;
            }

     }

}
