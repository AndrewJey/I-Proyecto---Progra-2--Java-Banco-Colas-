/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class Caja { //Clase Caja
    
    //atributos de la clase
    public ListaSimple clientes;
    public String nombre;
    private boolean ocupado;
    
//metodo constructor de la clase
    /**
     * Método Constructor de la Clase Caja
     * @param pNombre: Recibe una Cadena de Letras para formar un "Nombre"
     */
    public Caja(String pNombre) {
        this.ocupado = false;
        clientes = new ListaSimple();
        nombre = pNombre;
    }
    
//metodos set y get de los atributos de la clase
    
    /**
     *
     * @return: Método que avisa que el cajero está ocupado
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * Método que "setea" el estado de "ocupado"
     * @param ocupado: Recibe por dato, si se está ocupado ó no
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}