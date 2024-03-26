/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_form1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Golden74
 */
public class mysqlconnect {
	
	public static Connection ConnectDb(){
		String url = "jdbc:mysql://localhost/market";
                String username = "root";
                String password = "";
		try{
			 Connection cn = DriverManager.getConnection(url, username, password);
			JOptionPane.showMessageDialog(null, "Connection établie");
			return cn;
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	
	}
}
