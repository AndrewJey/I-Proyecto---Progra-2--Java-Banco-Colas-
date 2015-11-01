/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrés J. Jiménez Leandro & M. Samuel Aragón Navarro
 */
public class Interfaz_Usuario extends javax.swing.JFrame {
//Interfaz que interactúa con el usuario
    /**
     * Creates new form Interfaz_Usuario
     */
    //Atributos de la clase
    Banco banco;
    Caja cajaUno;
    Caja cajaDos;
    Caja cajaTres;
    Caja cajaCuatro;
    //Metodo constructor de la clase

    public Interfaz_Usuario() {
        //Definición de Instancias
        cajaUno = new Caja("Caja 1");
        cajaDos = new Caja("Caja 2");
        cajaTres = new Caja("Caja 3");
        cajaCuatro = new Caja("Caja 4");
        banco = new Banco();
        //Ciclo que maneja los randoms de los clientes para la fila
        for (int i = 0; i < 10; i++) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        //Inicialización de componentes
        initComponents();
        agregarC1();
        agregarC2();
        agregarC3();
        agregarC4();
        if (!issuspended) {//si no esta suspendido o pausado
            hilo.start();//el hilo empieza

        } else {//de lo contrario
            hilo.resume();//el hilo se reanuda
            issuspended = false;//el hilo ya no esta suspendido

        }

        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
        setLocationRelativeTo(null);
    }
    public boolean issuspended = false;//para saber si el hilo esta suspendido o pausado
    int seg1 = 0, ds1 = 0;//unidades de medida
    int seg2 = 0, ds2 = 0;
    int seg3 = 0, ds3 = 0;
    int seg4 = 0, ds4 = 0;
    Thread hilo = new Thread() {//declaramos el hilo
        @Override
        public void run() {
            try {
                while (true) {//ciclo infinito
                    NodoSimple c1 = cajaUno.clientes.primero;
                    NodoSimple c2 = cajaDos.clientes.primero;
                    NodoSimple c3 = cajaTres.clientes.primero;
                    NodoSimple c4 = cajaCuatro.clientes.primero;
                    if (ds1 == 99) {//si los decisegundos son iguales a 99
                        ds1 = 0;//decisegundo vuelve a empezar en cero
                        seg1++;//y aumenta un segundo
                    }
                    if (seg1 == 59) {//si los segundos son iguales a 59
                        seg1 = 0;//segundo vuelve a empezar en cero
                    }
                    ds1++;//aumentan las decimas de segundo
                    if (ds2 == 99) {//si los decisegundos son iguales a 99
                        ds2 = 0;//decisegundo vuelve a empezar en cero
                        seg2++;//y aumenta un segundo
                    }
                    if (seg2 == 59) {//si los segundos son iguales a 59
                        seg2 = 0;//segundo vuelve a empezar en cero
                    }
                    ds2++;//aumentan las decimas de segundo
                    if (ds3 == 99) {//si los decisegundos son iguales a 99
                        ds3 = 0;//decisegundo vuelve a empezar en cero
                        seg3++;//y aumenta un segundo
                    }
                    if (seg3 == 59) {//si los segundos son iguales a 59
                        seg3 = 0;//segundo vuelve a empezar en cero
                    }
                    ds3++;//aumentan las decimas de segundo
                    if (ds4 == 99) {//si los decisegundos son iguales a 99
                        ds4 = 0;//decisegundo vuelve a empezar en cero
                        seg4++;//y aumenta un segundo
                    }
                    if (seg4 == 59) {//si los segundos son iguales a 59
                        seg4 = 0;//segundo vuelve a empezar en cero
                    }
                    ds4++;//aumentan las decimas de segundo
                    if (seg1 == c1.dato.getTiempoTramite()) {
                        seg1 = 0;
                        agregarC1();
                    }
                    if (seg2 == c2.dato.getTiempoTramite()) {
                        seg2 = 0;
                        agregarC2();
                    }
                    if (seg3 == c3.dato.getTiempoTramite()) {
                        seg3 = 0;
                        agregarC3();
                    }
                    if (seg4 == c4.dato.getTiempoTramite()) {
                        seg4 = 0;
                        agregarC4();
                    }
                    tiempoC1.setText("" + seg1);//se muestra en el jlabel
                    tiempoC2.setText("" + seg2);
                    tiempoC3.setText("" + seg3);
                    tiempoC4.setText("" + seg4);
                    hilo.sleep(10);//que duerma una decima de segundo
                }

            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caja1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        caja2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        caja3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        caja4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOrd = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        detener = new javax.swing.JButton();
        reiniciar = new javax.swing.JButton();
        tiempoC1 = new javax.swing.JLabel();
        tiempoC2 = new javax.swing.JLabel();
        tiempoC3 = new javax.swing.JLabel();
        tiempoC4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SALA DE ATENCIÓN AL CLIENTE");
        setBackground(new java.awt.Color(187, 187, 241));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        caja1.setEditable(false);
        caja1.setBackground(new java.awt.Color(235, 250, 250));
        caja1.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        getContentPane().add(caja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 36, 163, 87));

        jLabel1.setText("CAJA 01");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 11, 64, -1));

        jLabel2.setText("CAJA 02");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 11, 58, -1));

        caja2.setEditable(false);
        caja2.setBackground(new java.awt.Color(235, 250, 250));
        caja2.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        getContentPane().add(caja2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 36, 163, 87));

        jLabel3.setText("CAJA 03");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 11, -1, -1));

        caja3.setEditable(false);
        caja3.setBackground(new java.awt.Color(235, 250, 250));
        caja3.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        getContentPane().add(caja3, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 36, 163, 87));

        jLabel4.setText("CAJA 04");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 11, -1, -1));

        caja4.setEditable(false);
        caja4.setBackground(new java.awt.Color(235, 250, 250));
        caja4.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        getContentPane().add(caja4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 36, 163, 87));

        listaDes.setEditable(false);
        listaDes.setBackground(new java.awt.Color(231, 255, 231));
        listaDes.setColumns(20);
        listaDes.setFont(new java.awt.Font("Bookman Old Style", 3, 12)); // NOI18N
        listaDes.setRows(5);
        jScrollPane2.setViewportView(listaDes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 244, -1, 170));

        jLabel6.setText("FILA DE INGRESO AL BANCO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 205, -1, -1));

        listaOrd.setEditable(false);
        listaOrd.setBackground(new java.awt.Color(231, 255, 231));
        listaOrd.setColumns(20);
        listaOrd.setFont(new java.awt.Font("Bookman Old Style", 3, 12)); // NOI18N
        listaOrd.setRows(5);
        jScrollPane3.setViewportView(listaOrd);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 244, -1, 170));

        jLabel7.setText("FILA DE ATENCIÓN PREFERENCIAL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        detener.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detener.setForeground(new java.awt.Color(204, 0, 0));
        detener.setText("Detener");
        detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerActionPerformed(evt);
            }
        });
        getContentPane().add(detener, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, -1));

        reiniciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reiniciar.setForeground(new java.awt.Color(0, 0, 204));
        reiniciar.setText("Simular Otra Vez");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));
        getContentPane().add(tiempoC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 103, 20));
        getContentPane().add(tiempoC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 60, 20));
        getContentPane().add(tiempoC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 60, 20));
        getContentPane().add(tiempoC4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 50, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/ico_banco.png"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 100, 80));

        jLabel5.setText("(DESORDENADA)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel8.setText("(ORDENADA)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, -1, -1));

        jLabel9.setText("BANCO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jMenu2.setForeground(new java.awt.Color(0, 153, 0));
        jMenu2.setText("Salir");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Para Salir de la Aplicación
    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu2ActionPerformed
//Para Salir de la Aplicación
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked
    
    //Metodo que agrega clientes a la lista de la caja 1
    public void agregarC1() {
        cajaUno.clientes.agregar(banco.fila.primero.dato);
        cajaUno.setOcupado(true);
        caja1.setText(banco.fila.primero.dato.toString());
        banco.fila.borrar();
        while (banco.fila.tamaño < 10) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
    }
    
//Metodo que agrega clientes a la lista de la caja 2
    public void agregarC2() {
        cajaDos.clientes.agregar(banco.fila.primero.dato);
        caja2.setText(banco.fila.primero.dato.toString());
        banco.fila.borrar();
        while (banco.fila.tamaño < 10) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
    }
    
//Metodo que agrega clientes a la lista de la caja 3
    public void agregarC3() {
        cajaTres.clientes.agregar(banco.fila.primero.dato);
        caja3.setText(banco.fila.primero.dato.toString());
        banco.fila.borrar();
        while (banco.fila.tamaño < 10) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
    }
    
//Metodo que agrega clientes a la lista de la caja 4
    public void agregarC4() {
        cajaCuatro.clientes.agregar(banco.fila.primero.dato);
        caja4.setText(banco.fila.primero.dato.toString());
        banco.fila.borrar();
        while (banco.fila.tamaño < 10) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
    }
    
    //Detiene la simulacion y despliega un resumen de cada cajero
    private void detenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerActionPerformed
        hilo.suspend();//se suspende el hilo.
        JOptionPane.showMessageDialog(null, banco.promedioCajero(cajaUno) + banco.promedioCajero(cajaDos)
                + banco.promedioCajero(cajaTres) + banco.promedioCajero(cajaCuatro), "RESULTADO DEL DÍA", JOptionPane.WARNING_MESSAGE);
        
        caja1.setText("");
        caja2.setText("");
        caja3.setText("");
        caja4.setText("");
        listaDes.setText("");
        listaOrd.setText("");
        seg1 = seg2 = seg3 = seg4 = 0;//todas las unidades en cero
        tiempoC1.setText("0");//cronometro en cero
        tiempoC2.setText("0");
        tiempoC3.setText("0");
        tiempoC4.setText("0");
        issuspended = true;//el hilo esta suspendido
    }//GEN-LAST:event_detenerActionPerformed

    //Crea una nueva fila y vuelve a iniciar la simulación
    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        cajaUno = new Caja("Caja 1");
        cajaDos = new Caja("Caja 2");
        cajaTres = new Caja("Caja 3");
        cajaCuatro = new Caja("Caja 4");
        banco = new Banco();
        for (int i = 0; i < 10; i++) {
            Cliente cl = new Cliente((int) (Math.random() * (8000 - 1000) + 1000) + "", "");
            banco.crearFila(cl);
        }
        agregarC1();
        agregarC2();
        agregarC3();
        agregarC4();
        if (!issuspended) {//si no esta suspendido o pausado
            hilo.start();//el hilo empieza

        } else {//de lo contrario
            hilo.resume();//el hilo se reanuda
            issuspended = false;//el hilo ya no esta suspendido

        }
        listaDes.setText(banco.fila.toString());
        banco.ordenaFila();
        listaOrd.setText(banco.fila.toString());
    }//GEN-LAST:event_reiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //Corre la Simulación
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Usuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caja1;
    private javax.swing.JTextField caja2;
    private javax.swing.JTextField caja3;
    private javax.swing.JTextField caja4;
    private javax.swing.JButton detener;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea listaDes;
    private javax.swing.JTextArea listaOrd;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel tiempoC1;
    private javax.swing.JLabel tiempoC2;
    private javax.swing.JLabel tiempoC3;
    private javax.swing.JLabel tiempoC4;
    // End of variables declaration//GEN-END:variables
}//FiN