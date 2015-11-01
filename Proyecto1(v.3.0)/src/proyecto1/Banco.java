/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class Banco {
    
//atributos de la clase
    public ListaCircular fila;
    public int consec;
    public String[] nom = new String[10];
    
    //metodo constructor de la clase
    /**
     *Método Constructor de Banco
     */
    public Banco() {
        fila = new ListaCircular(); //Arreglo para una Fila de Espera en el Banco
        consec = 1;
        //Nombres cualesquiera elegidos aleatoriamente, previamente determinados
        nom[0] = "Ándres";
        nom[1] = "Allan";
        nom[2] = "Melissa";
        nom[3] = "Cristina";
        nom[4] = "Diego";
        nom[5] = "María";
        nom[6] = "Olger";
        nom[7] = "Pablo";
        nom[8] = "Juan";
        nom[9] = "Estefani";
    }
    
//metodo que crea la fila
    /**
     * Método que crea la Fila
     * @param cl: Variable de Tipo Cliente
     */
    public void crearFila(Cliente cl) {
        int prio = (int) (Math.random() * 3 + 1);
        int tiemp = (int) (Math.random() * (11 - 2) + 2);
        int nombre = (int) (Math.random() * 9 + 1);
        switch (prio) { //Orden de Prioridades
            case 1:
                cl.setPrioridad('A');
                cl.setNumFila(consec);
                cl.setNombre(this.nom[nombre]);
                consec++;
                break;
            case 2:
                cl.setPrioridad('B');
                cl.setNumFila(consec);
                while (nombre != 2 && nombre != 3 && nombre != 5 && nombre != 9) {
                    nombre = (int) (Math.random() * 9 + 1);
                }
                cl.setNombre(this.nom[nombre]);
                consec++;
                break;
            case 3:
                cl.setPrioridad('C');
                cl.setNumFila(consec);
                cl.setNombre(this.nom[nombre]);
                consec++;
                break;
        }
        cl.setTiempoTramite(tiemp);
        fila.agregar(cl); //Agrega Clientes a la Fila
    }

    //metodo que retorna los usuarios atendidos por cada cajero y el tiempo total
    /**
     * Método que promedia el tiempo de atención de las cajas
     * @param caj: Variable de Tipo "Caja"
     * @return: Retorna los datos ordenados sobre la atención en la caja
     */
    public String promedioCajero(Caja caj) {
        String retorno = "";
        int tiempoTotal = 0;
        NodoSimple temp = caj.clientes.primero;
        for (int i = 0; i < caj.clientes.tamaño; i++) {
            tiempoTotal = tiempoTotal + temp.dato.getTiempoTramite();
            temp = temp.sgte;
        }
        retorno = "<html><font color=#E11B1B>" + caj.nombre + "\n" + "<html><font color=#065204> Total de clientes atendidos : " + caj.clientes.tamaño + "\n" + "<html><font color=#080463> Tiempo total : "
                + tiempoTotal + " minutos" + "\n" + "<html><font color=#310344> Promedio : " + (tiempoTotal / caj.clientes.tamaño) + " min/cliente" + "\n\n";
        return (retorno);
    }

    //metodo que ordena la fila por prioridad
    /**
     *Método que ordena las Filas por Prioridad
     */
    public void ordenaFila() {
        NodoDoble temp = this.fila.primero;
        Cliente temp1 = new Cliente("", "");
        Cliente temp2 = new Cliente("", "");
        for (int i = 0; i < this.fila.tamaño; i++) {
            temp = this.fila.primero;
            for (int j = 0; j < this.fila.tamaño - 1; j++) {
                if (temp.dato.getNumFila() <= temp.sgte.dato.getNumFila()) {
                    temp = temp.sgte;
                } else if (temp.dato.getNumFila() > temp.sgte.dato.getNumFila()) {
                    temp1 = temp.sgte.dato;
                    temp2 = temp.dato;
                    temp.sgte.dato = temp2;
                    temp.dato = temp1;
                    temp = temp.sgte;
                }
            }
        }
        String s = "";
        String s2 = "";
        for (int i = 0; i < this.fila.tamaño; i++) {
            temp = this.fila.primero;
            for (int j = 0; j < this.fila.tamaño - 1; j++) {
                s = "" + temp.dato.getPrioridad();
                s2 = "" + temp.sgte.dato.getPrioridad();
                if (s.compareTo(s2) <= 0) {
                    temp = temp.sgte;
                } else if (s.compareTo(s2) > 0) {
                    temp1 = temp.sgte.dato;
                    temp2 = temp.dato;
                    temp.sgte.dato = temp2;
                    temp.dato = temp1;
                    temp = temp.sgte;
                }
            }
        }
    }
}