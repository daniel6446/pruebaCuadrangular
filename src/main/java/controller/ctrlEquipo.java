/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.consultationEquipo;
import model.entityEquipo;
import model.entityPartido;
import view.formulario;
import javax.swing.*;

/**
 *
 * @author dnb
 */
public  class ctrlEquipo  implements ActionListener{
    // clases modelo mvc
    private entityEquipo mod;
    private consultationEquipo modc;
    private formulario frm;
    
    public  ctrlEquipo (entityEquipo mod, consultationEquipo modc, formulario frm){
     this.frm = frm;
     this.mod = mod;
     this.modc = modc;
    
    
     this.frm.guardarEquipo.addActionListener(this);
     this.frm.modificarEquipo.addActionListener(this);
     this.frm.eliminarEquipo.addActionListener(this);
     this.frm.buscarEquipo.addActionListener(this);
     
             }
    public  void  iniciar(){
     frm.setTitle("equipo");
     frm.setLocationRelativeTo(null);
     frm.txtId.setVisible(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == frm.guardarEquipo) {
            mod.setNombre(frm.txtEquipo.getText());
            mod.setDirTecnico(frm.txtTecnico.getText());
            mod.setJugadores(Integer.parseInt(frm.txtJugadores.getText()));
            
            if(modc.registrar(mod)){
                
              JOptionPane.showMessageDialog(null,"registro guardado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error guardado");
              limpiar();
            }
        }
         if (e.getSource() == frm.modificarEquipo) {
            mod.setIdequipo(Integer.parseInt(frm.txtId.getText()));
            mod.setNombre(frm.txtEquipo.getText());
            mod.setDirTecnico(frm.txtTecnico.getText());
            mod.setJugadores(Integer.parseInt(frm.txtJugadores.getText()));
            
            if(modc.modificar(mod)){
              JOptionPane.showMessageDialog(null,"registro modificado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error modificar");
              limpiar();
            }
        }
         if (e.getSource() == frm.eliminarEquipo) {
            mod.setIdequipo(Integer.parseInt(frm.txtId.getText()));
            
            if(modc.eliminar(mod)){
              JOptionPane.showMessageDialog(null,"registro eliminado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error eliminar");
              limpiar();
            }
        }
         if (e.getSource() == frm.buscarEquipo) {
            mod.setIdequipo(Integer.parseInt(frm.txtId.getText()));
            mod.setNombre(frm.txtEquipo.getText());
            
            
            if(modc.modificar(mod)){
                
              frm.txtId.setText(String.valueOf(mod.getIdequipo()));
              frm.txtEquipo.setText(mod.getNombre());
              frm.txtJugadores.setText(String.valueOf(mod.getJugadores()));
              frm.txtTecnico.setText(mod.getDirTecnico());
              
            
            } else{
              JOptionPane.showMessageDialog(null,"error registro");
              limpiar();
            }
        }if (e.getSource()== frm.limpiarEquipo) {
            limpiar();
        }
         
    } 
    public  void  limpiar(){
    
       frm.txtId.setText(null);
       frm.txtEquipo.setText(null);
       frm.txtTecnico.setText(null);
       frm.txtJugadores.setText(null);
    }
    
}
