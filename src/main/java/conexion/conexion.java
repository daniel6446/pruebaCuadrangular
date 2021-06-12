/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dnb
 */

//conexion base de datos

public class conexion {
    //nombre base de datos
    private final String base ="cuadrangular";
    //usuario networkworbeanch
    private final String user="root";
    //clave networkworbeanch
    private final String password=" ";
    // url  xampp 
    private final String url  ="jdbc:mysql://localhost:3306" + base ;
    public Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println("");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
