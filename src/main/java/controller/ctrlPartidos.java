/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.consultationPartido;
import model.entityPartido;
import view.partidos;

/**
 *
 * @author dnb
 */
public class ctrlPartidos implements ActionListener{
    // clases modelo mvc
    private entityPartido mode;
    private consultationPartido modct;
    private partidos frms;
    
    public  ctrlPartidos (entityPartido mode, consultationPartido modct, partidos frms){
 
     this.mode = mode;
     this.modct = modct;
         this.frms = frms;
    
     // llamada  controlador de las vistas
     this.frms.guardarPartido.addActionListener(this);
     this.frms.modificarPartido.addActionListener(this);
     this.frms.elminarPartido.addActionListener(this);
     this.frms.buscarPartido.addActionListener(this);
     
             }
    public  void  iniciar(){
     frms.setTitle("Partidos");
     frms.setLocationRelativeTo(null);
     frms.txtIdPartidos.setVisible(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == frms.guardarPartido) {
            mode.setIdequipo(Integer.parseInt(frms.txtEquipo.getText()));
            mode.setGolesFavor(Integer.parseInt(frms.txtGolesFavor.getText()));
            mode.setGolesContra(Integer.parseInt(frms.txtGolesContra.getText()));
            
            if(modct.registrar(mode)){
                
              JOptionPane.showMessageDialog(null,"registro guardado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error guardado");
              limpiar();
            }
        }
         if (e.getSource() == frms.modificarPartido) {
            mode.setIdequipo(Integer.parseInt(frms.txtEquipo.getText()));
            mode.setGolesFavor(Integer.parseInt(frms.txtGolesFavor.getText()));
            mode.setGolesContra(Integer.parseInt(frms.txtGolesContra.getText()));
            
            
            if(modct.modificar(mode)){
              JOptionPane.showMessageDialog(null,"registro modificado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error modificar");
              limpiar();
            }
        }
         if (e.getSource() == frms.elminarPartido) {
            mode.setIdpartidos(Integer.parseInt(frms.txtIdPartidos.getText()));
            
            if(modct.eliminar(mode)){
              JOptionPane.showMessageDialog(null,"registro eliminado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error eliminar");
              limpiar();
            }
        }
         if (e.getSource() == frms.buscarPartido) {
            mode.setIdequipo(Integer.parseInt(frms.txtEquipo.getText()));
            mode.setGolesFavor(Integer.parseInt(frms.txtGolesFavor.getText()));
            mode.setGolesContra(Integer.parseInt(frms.txtGolesContra.getText()));
            
            
            if(modct.modificar(mode)){
                
              frms.txtIdPartidos.setText(String.valueOf(mode.getIdequipo()));
              frms.txtEquipo.setText(String.valueOf(mode.getIdequipo()));
              frms.txtGolesContra.setText(String.valueOf(mode.getGolesContra()));
              frms.txtGolesFavor.setText(String.valueOf(mode.getGolesFavor()));
              
              
            
            } else{
              JOptionPane.showMessageDialog(null,"error registro");
              limpiar();
            }
        }if (e.getSource()== frms.limpiarPartido) {
            limpiar();
        }
         
    } 
    public  void  limpiar(){
    
       frms.txtIdPartidos.setText(null);
       frms.txtEquipo.setText(null);
       frms.txtGolesContra.setText(null);
       frms.txtGolesFavor.setText(null);
    }
    
}
