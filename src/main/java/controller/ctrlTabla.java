/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.consultationEquipo;
import model.consultationPartido;
import model.entityEquipo;
import model.entityPartido;
import view.formulario;
import view.tablaPosiciones;


/**
 *
 * @author dnb
 */
public class ctrlTabla implements ActionListener{
    // clases modelo mvc
    private entityPartido mode;
    private consultationPartido modct;
    private tablaPosiciones frmst;
    private entityEquipo mod;
    private consultationEquipo modc;
    
    
    public  ctrlTabla (entityPartido mode, consultationPartido modct, tablaPosiciones frmst, entityEquipo mod, consultationEquipo modc){
     this.mod = mod;
     this.modc = modc;
     this.mode = mode;
     this.modct = modct;
     this.frmst = frmst;
    
     // llamada  controlador de las vistas
     this.frmst.buscarPartido.addActionListener(this);
     this.frmst.buscarEquipo.addActionListener(this);
     
             }
    public  void  iniciar(){
     frmst.setTitle("Tabla de Posiciones");
     frmst.setLocationRelativeTo(null);
     
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == frmst.buscarPartido) {
           
            mode.setGolesFavor(Integer.parseInt(frmst.txtGolesFavor.getText()));
            mode.setGolesContra(Integer.parseInt(frmst.txtGolesContra.getText()));
           
            
            if(modct.buscar(mode)){
                
              JOptionPane.showMessageDialog(null,"registro encontrado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error registro");
              limpiar();
            }
        }
         if (e.getSource() == frmst.buscarEquipo) {
            mod.setNombre(frmst.txtEquipo.getText());
            mod.setDirTecnico(frmst.txtTecnico.getText());
            mod.setJugadores(Integer.parseInt(frmst.txtJugadores.getText()));
            
            if(modc.registrar(mod)){
                
              JOptionPane.showMessageDialog(null,"registro guardado");
              limpiar();
            } else{
              JOptionPane.showMessageDialog(null,"error guardado");
              limpiar();
            }
        }
         
       
        if (e.getSource()== frmst.limpiar) {
            limpiar();
        }
         
    } 
    public  void  limpiar(){
    
      
       frmst.txtEquipo.setText(null);
       frmst.txtJugadores.setText(null);
       frmst.txtTecnico.setText(null);
       frmst.txtGolesContra.setText(null);
       frmst.txtGolesFavor.setText(null);
    }
    
}