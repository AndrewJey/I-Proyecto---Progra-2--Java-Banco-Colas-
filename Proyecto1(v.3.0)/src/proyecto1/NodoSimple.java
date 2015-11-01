/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class NodoSimple { //Clase Nodo Simple
    
    //atributos de la clase
    public NodoSimple sgte;
    public Cliente dato;
    
//metodo constructor de la clase
    /**
     * Método Constructor de Nodo Simple
     * @param pDato = Datos que se recibe dentro del nodo
     */
    public NodoSimple(Cliente pDato) {
        this.dato = pDato;
        sgte = null;
    }
}