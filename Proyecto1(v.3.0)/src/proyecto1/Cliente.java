/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class Cliente { //Clase Cliente
    
    //atributos de la clase
    private String cedula;
    private String nombre;
    private char prioridad;
    private int numFila;
    private int tiempoTramite;
    
//metodo constructor de la clase
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
//metodos set y get de los atributos de la clase
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(char prioridad) {
        this.prioridad = prioridad;
    }

    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }

    public int getTiempoTramite() {
        return tiempoTramite;
    }

    public void setTiempoTramite(int tiempoTramite) {
        this.tiempoTramite = tiempoTramite;
    }

//metodo toString de la clase
    /**
     * Método "To String" de Cliente
     * @return: Datos del Cliente
     */
    @Override
    public String toString() {
        return nombre + "       " + prioridad + numFila+",    tiempo: "+ tiempoTramite;
    }
}