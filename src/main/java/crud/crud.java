/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import controller.ctrlEquipo;
import model.consultationEquipo;
import model.consultationPartido;
import model.entityEquipo;
import model.entityPartido;
import view.formulario;
import view.partidos;
import view.tablaPosiciones;

/**
 *
 * @author dnb
 */
public class crud{
    
    
public static void main(String[]args){
    entityEquipo mod = new entityEquipo();
    consultationEquipo modc = new consultationEquipo();
    formulario frm = new formulario();
    entityPartido mode = new entityPartido();
    consultationPartido modct = new consultationPartido();
    partidos frms = new partidos();
    tablaPosiciones frmst = new tablaPosiciones();
    
    ctrlEquipo ctrl = new ctrlEquipo(mod, modc, frm);
    ctrl.iniciar();
    frm.setVisible(true);

}

    
}
