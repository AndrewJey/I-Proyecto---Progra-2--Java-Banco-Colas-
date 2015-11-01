/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class NodoDoble { //Clase Nodo Doble
    
    //atributos de la clase
    public NodoDoble sgte;
    public NodoDoble ant;
    public Cliente dato;
    
//metodo constructor de la clase
    /**
     * Método Constructor de Nodo Doble
     * @param pDato: Dato que recibe el Nodo
     */
    public NodoDoble(Cliente pDato) {
        this.dato = pDato;
        sgte = ant = null;
    }
}