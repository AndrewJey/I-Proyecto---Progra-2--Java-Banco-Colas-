/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class Lista { //Clase Lista
    
    //atributos de la clase
    public NodoDoble primero;
    public NodoDoble ultimo;
    public int tamaño;

    //método constructor
    public Lista() {
        this.primero = this.ultimo = null;
        this.tamaño = 0;
    }
    
    //método que agrege al inicio de la lista
    /**
     * Método para Agregar Datos al Nodo al Inicio de la Lista
     * @param pDato: Recibe el dato del Nodo
     * @return: Dato falso ó verdadero, sobre el estado del nodo agregado
     */
    public boolean agregar(Cliente pDato) {
        boolean retorno = true;
        try {
            //en caso que la lista esté vacía
            if (this.primero == null) {
                NodoDoble nuevo = new NodoDoble(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;
                this.ultimo.sgte = this.primero;
                this.primero.ant = this.ultimo;
            } //inserta al inicio de la lista cuando ya hay al menos un elemento
            else {
                NodoDoble nuevo = new NodoDoble(pDato);
                nuevo.sgte = this.primero;
                this.primero = nuevo;
                nuevo.sgte.ant = nuevo;
                this.ultimo.sgte = this.primero;
                this.primero.ant = this.ultimo;
            }
            //incrementa el tamaño de la lista
            tamaño++;
        } catch (Exception e) {
            retorno = false;
        }
        return (retorno); //Retorna verdadero ó falso
    }

    //método que borra el último elemento de la lista
    /**
     * Método que Borra el Último Nodo en la Lista
     * @return: Dato falso ó verdadero, sobre el estado del nodo Borrado
     */
    public boolean borrar() {
        boolean retorno = true;
        //si la lista está vacía no puede borrar
        if (this.primero == null) {
            retorno = false;
        } //en caso de que la lista tenga elementos
        else {
            //si la lista tiene únicamente un elemento
            if (this.primero == this.ultimo) {
                this.primero = this.ultimo = null;
            } //si la lista tiene más de un elemento
            else {
                NodoDoble actual = this.primero;
                this.primero = actual.sgte;
                actual = null;
            }
            //Disminuye el tamaño de la lista
            this.tamaño--;
        }
        return (retorno); //Retorna verdadero ó falso
    }
    
     //método toString
    /**
     * Método "To String" de Lista
     * @return: Una cadena ordenada de carácteres sobre los Nodos Enlistados
     */
    @Override
    public String toString() {
        String retorno = "";
        NodoDoble temp = this.primero;
        for (int i = 0; i < this.tamaño; i++) {
            retorno = retorno + String.valueOf(temp.dato.toString()) + "\n";
            temp = temp.sgte;
        }

        return (retorno);
    }
}