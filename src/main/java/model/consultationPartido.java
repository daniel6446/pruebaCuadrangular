/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dnb
 */
public class consultationPartido extends conexion.conexion{
 public boolean registrar(entityPartido part){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
     String sql ="INSERT INTO cuadrangular.partido  (idpartido, golesFavor, golesContra, ronda) VALUES (?, ?,?,?)";
     
     try {
        ps = con.prepareStatement(sql);
       
        ps.setInt(1, part.getGolesFavor());
        ps.setInt(2, part.getGolesContra());
        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println(e);
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
     }} 
 public boolean modificar (entityPartido part){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
     String sql ="UPDATE cuadrangular.partido  SET idpartido=?, golesFavor=?, golesContra=?, ronda=? WHERE id=?";
     
     try {
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, part.getGolesFavor());
        ps.setInt(2, part.getGolesContra());
        ps.setInt(3, part.getIdpartidos());

        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println(e);
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
     }} 
 public boolean eliminar (entityPartido part){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
     String sql ="DELETE FROM cuadrangular.partido  WHERE id=?";
     
     try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, part.getIdpartidos());
        

        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println(e);
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
         
     }}
 public boolean buscar (entityPartido part){
 
     PreparedStatement ps = null;
     ResultSet rs = null;
     Connection con = getConexion();
     
     String sql ="SELECT * FROM cuadrangular.partido  WHERE idpartidos=?";
     
     try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, part.getIdpartidos());
        

        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println(e);
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
     }}
}
