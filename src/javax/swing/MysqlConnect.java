/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.swing;
import java.sql.DriverManager;


import java.sql.*;
import javax.swing.*;
public class MysqlConnect {
    Connection conn=null;
    public static Connection ConnecrDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Contact the Admin");
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}

