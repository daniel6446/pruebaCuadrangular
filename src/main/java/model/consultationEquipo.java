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
public class consultationEquipo extends conexion.conexion{
public boolean registrar(entityEquipo equip){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
     String sql ="INSERT INTO cuadrangular.equipo  (idequipo, nombre, dirTecnico, jugadores) VALUES (?, ?,?,?)";
     
     try {
        ps = con.prepareStatement(sql);
        ps.setString(1, equip.getNombre());
        ps.setString(2, equip.getDirTecnico());
        ps.setInt   (3, equip.getJugadores());
        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println("e");
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
     }}
public boolean modificar (entityEquipo equip){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
    String sql ="UPDATE cuadrangular.equipo SET idequipo=?, nombre=?, dirTecnico=?, jugadores=? WHERE id=?";
     
     try {
         
        ps = con.prepareStatement(sql);
        ps.setString(1, equip.getNombre());
        ps.setString(2, equip.getDirTecnico());
        ps.setInt   (3, equip.getJugadores());
        ps.setInt   (4, equip.getIdequipo());
        ps.execute();
        return true;
        
     }catch(SQLException e) {
         System.err.println("e");
      return false;
     }finally{
         try {
             con.close();
         } catch (SQLException e) {
             System.err.println(e);
         }
     }}
public boolean eliminar (entityEquipo equip){
 
     PreparedStatement ps = null;
     Connection con = getConexion();
     
     String sql ="DELETE FROM cuadrangular.equipo  WHERE id=?";
     
     try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, equip.getIdequipo());
        

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
public boolean buscar (entityEquipo equip){
 
     PreparedStatement ps = null;
     ResultSet rs = null;
     Connection con = getConexion();
     
     String sql ="SELECT * FROM cuadrangular.equipo  WHERE idequipo=?";
     
     try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, equip.getIdequipo());
        rs = ps.executeQuery();
        
        if(rs.next())
        {
            equip.setIdequipo(Integer.parseInt(rs.getString("id")));
            equip.setNombre(rs.getString("nombre"));
            equip.setDirTecnico(rs.getString("tecnico"));
            equip.setJugadores(Integer.parseInt(rs.getString("jugadores")));
            return true;
        }
        
        return false;
        
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
