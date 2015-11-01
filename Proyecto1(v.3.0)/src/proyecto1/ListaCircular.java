/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class ListaCircular extends Object { //Lista Circular
    
    //atributos de la clase
    public NodoDoble primero;
    public NodoDoble ultimo;
    public int tamaño;

    //método constructor vacío
    public ListaCircular() {
        this.primero = this.ultimo = null;
        this.tamaño = 0;
    }
    
    //método que agrege al Final de la lista
    /**
     * Método que agrega al Final de la Lista
     * @param pDato: Recibe el dato que se almacenará en el nodo en lista
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
                this.ultimo.sgte = nuevo;
                nuevo.ant = this.ultimo;
                this.ultimo = nuevo;
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

    //método que borra el primer elemento de la lista
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
                this.primero.ant = this.ultimo;
                actual = null;
            }
            this.tamaño--;
        }

        return (retorno);
    }
    
     //método toString
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