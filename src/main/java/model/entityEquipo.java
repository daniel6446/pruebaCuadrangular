/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dnb
 */
public class entityEquipo {
  private int idequipo;
  private String nombre;
  private String dirTecnico;
  private int jugadores;

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirTecnico() {
        return dirTecnico;
    }

    public void setDirTecnico(String dirTecnico) {
        this.dirTecnico = dirTecnico;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
}
