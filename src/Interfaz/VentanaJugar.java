package Interfaz;

import ArcoirisMainPackage.Juego;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaJugar extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;
    private JButton[][] botones;

    public VentanaJugar(Juego unJuego, VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.setModelo(unJuego);
        this.setVentanaPrincipal(ventanaPrincipal);

        //Agrego evento para manejar el hacer click en la X al cerrar el JFrame actual y asi poder volver a habilitar el menu
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                getVentanaPrincipal().UpdateMenu(true);
                dispose();
            }
        });
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 3 - this.getSize().width / 3, dim.height / 3 - this.getSize().height / 3);
        
        jPanelJugar.setLayout(new GridLayout(13, 13));
        botones = new JButton[14][14];

        ImageIcon img = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\src\\Imagenes\\negraQ.png");
        Image imag = img.getImage();
        Image newimg = imag.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);

        ImageIcon neg = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\src\\Imagenes\\negra.png");
        Image negra = neg.getImage();
        Image fichaNegra = negra.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        neg = new ImageIcon(fichaNegra);

        ImageIcon blan = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\src\\Imagenes\\blanca.png");
        Image blanca = blan.getImage();
        Image fichaBlanca = blanca.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        blan = new ImageIcon(fichaBlanca);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                jButton.setPreferredSize(new Dimension(20, 20));
                jButton.setFont(new Font("Arial", Font.PLAIN, 10));
                jPanelJugar.add(jButton);
                botones[i][j] = jButton;
            }
        }

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (medirDistanciaMarco(i, j, 1)) {
                    botones[i][j].setBackground(Color.RED);
                } else if (medirDistanciaMarco(i, j, 2)) {
                    botones[i][j].setBackground(Color.ORANGE);
                } else if (medirDistanciaMarco(i, j, 3)) {
                    botones[i][j].setBackground(Color.YELLOW);
                } else if (medirDistanciaMarco(i, j, 4)) {
                    botones[i][j].setBackground(Color.GREEN);
                } else if (medirDistanciaMarco(i, j, 5)) {
                    botones[i][j].setBackground(Color.CYAN);
                } else if (medirDistanciaMarco(i, j, 6)) {
                    botones[i][j].setBackground(Color.BLUE);
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                }
            }
        }

    }

    private void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }

    private Juego getModelo() {
        return this.modelo;
    }
    public VentanaPrincipal getVentanaPrincipal() {
        return framePrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal unaVentana) {
        this.framePrincipal = unaVentana;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelJugar = new javax.swing.JPanel();
        jPanelColumnas = new javax.swing.JPanel();
        jPanelFilas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 650));
        setResizable(false);

        jPanelJugar.setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout jPanelJugarLayout = new javax.swing.GroupLayout(jPanelJugar);
        jPanelJugar.setLayout(jPanelJugarLayout);
        jPanelJugarLayout.setHorizontalGroup(
            jPanelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelJugarLayout.setVerticalGroup(
            jPanelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        jPanelColumnas.setPreferredSize(new java.awt.Dimension(600, 40));

        javax.swing.GroupLayout jPanelColumnasLayout = new javax.swing.GroupLayout(jPanelColumnas);
        jPanelColumnas.setLayout(jPanelColumnasLayout);
        jPanelColumnasLayout.setHorizontalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelColumnasLayout.setVerticalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanelFilas.setPreferredSize(new java.awt.Dimension(40, 500));

        javax.swing.GroupLayout jPanelFilasLayout = new javax.swing.GroupLayout(jPanelFilas);
        jPanelFilas.setLayout(jPanelFilasLayout);
        jPanelFilasLayout.setHorizontalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanelFilasLayout.setVerticalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean medirDistanciaMarco(int fila, int columna, int marcoAPintar) {
        boolean bandera = false;

        switch (marcoAPintar) {
            case 1:
                if ((fila == 0 && (columna >= 0 && columna <= 12))
                        || (columna == 0 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                } else if ((fila == 12 && (columna >= 0 && columna <= 12))
                        || (columna == 12 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                }
                break;
            case 2:
                if ((fila == 1 && (columna >= 1 && columna <= 11))
                        || (columna == 1 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                } else if ((fila == 11 && (columna >= 1 && columna <= 11))
                        || (columna == 11 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                }
                break;
            case 3:
                if ((fila == 2 && (columna >= 2 && columna <= 10))
                        || (columna == 2 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                } else if ((fila == 10 && (columna >= 2 && columna <= 10))
                        || (columna == 10 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                }
                break;
            case 4:
                if ((fila == 3 && (columna >= 3 && columna <= 9))
                        || (columna == 3 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                } else if ((fila == 9 && (columna >= 3 && columna <= 9))
                        || (columna == 9 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                }
                break;
            case 5:
                if ((fila == 4 && (columna >= 4 && columna <= 8))
                        || (columna == 4 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                } else if ((fila == 8 && (columna >= 4 && columna <= 8))
                        || (columna == 8 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                }
                break;
            case 6:
                if ((fila == 5 && (columna >= 5 && columna <= 7))
                        || (columna == 5 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                } else if ((fila == 7 && (columna >= 5 && columna <= 7))
                        || (columna == 7 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                }
                break;
            default:
                break;
        }

        return bandera;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelColumnas;
    private javax.swing.JPanel jPanelFilas;
    private javax.swing.JPanel jPanelJugar;
    // End of variables declaration//GEN-END:variables

//    public static Tablero llenarConFichasEnI(int marcoInicio) {
//
//        Tablero tab = new Tablero();
//
//        ImageIcon neg = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image negra = neg.getImage();
//        Image fichaNegra = negra.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        neg = new ImageIcon(fichaNegra);
//
//        ImageIcon blan = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image blanca = blan.getImage();
//        Image fichaBlanca = blanca.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        blan = new ImageIcon(fichaBlanca);
//
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 13; j++) {
//                if (Prueba.medirDistanciaMarco(i, j, marcoInicio)) {
//                    if (i == marcoInicio - 1 && j == marcoInicio - 1) {
//                        tab.botones[i][j].setIcon(blan);
//                    } else if (i == marcoInicio - 1 && j != marcoInicio - 1) {
//                        tab.botones[i][j].setIcon(neg);
//                    } else if (i == tab.botones.length - marcoInicio - 1 && j != tab.botones.length - marcoInicio - 1) {
//                        tab.botones[i][j].setIcon(neg);
//                    } else if (i == tab.botones.length - marcoInicio - 1 && j == tab.botones.length - marcoInicio - 1) {
//                        tab.botones[i][j].setIcon(blan);
//                    } else {
//                        tab.botones[i][j].setIcon(blan);
//                    }
//                }
//            }
//        }
//        return tab;
//    }

//    public static Tablero llenarConFichasEnL(int marcoInicio) {
//
//        Tablero tab = new Tablero();
//
//        ImageIcon neg = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image negra = neg.getImage();
//        Image fichaNegra = negra.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        neg = new ImageIcon(fichaNegra);
//
//        ImageIcon blan = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image blanca = blan.getImage();
//        Image fichaBlanca = blanca.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        blan = new ImageIcon(fichaBlanca);
//
//        boolean bandera = true;
//        int contador = 0;
//
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 13; j++) {
//
//                if (Prueba.medirDistanciaMarco(i, j, marcoInicio)) {
//                    //Manejo las fichas dentro del marco que se pasa por parametro
//                    bandera = !bandera;
//
//                    if (contador >= 3) {
//                        //Este codigo se corre solo para la ultima linea del marco seleccionado
//                        tab.botones[i][j - 2].setIcon(blan);
//                        tab.botones[i][j].setIcon(blan);
//
//                        if (tab.botones.length - marcoInicio - 1 == j) {
//                            tab.botones[i][j].setIcon(neg);
//                        }
//                    } else {
//                        if (bandera) {
//                            tab.botones[i][j].setIcon(neg);
//                            bandera = false;
//                        } else {
//                            tab.botones[i][j].setIcon(neg);
//                        }
//                    }
//
//                    if (i > 6) {
//                        contador++;
//                    }
//                }
//            }
//
//            contador = 0;
//            bandera = true;
//        }
//        return tab;
//    }

//    public static Tablero llenarConFichasAlAzar(int marcoInicio) {
//        Tablero tab = new Tablero();
//
//        ImageIcon neg = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image negra = neg.getImage();
//        Image fichaNegra = negra.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        neg = new ImageIcon(fichaNegra);
//
//        ImageIcon blan = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Arcoiris\\imagenes\\negra.png");
//        Image blanca = blan.getImage();
//        Image fichaBlanca = blanca.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//        blan = new ImageIcon(fichaBlanca);
//
//        int fichas = 0;
//        int blancas = 0;
//        int negras = 0;
//
//        switch (marcoInicio) {
//            case 1:
//                fichas = 48;
//                break;
//            case 2:
//                fichas = 20;
//                break;
//            case 3:
//                fichas = 16;
//                break;
//            case 4:
//                fichas = 12;
//                break;
//        }
//
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 13; j++) {
//
//                if (Prueba.medirDistanciaMarco(i, j, marcoInicio)) {
//                    if ((Math.random() * 2) < 1 && fichas > 0) {
//                        fichas--;
//                        tab.botones[i][j].setIcon(blan);
//                    } else {
//                        tab.botones[i][j].setIcon(neg);
//                    }
//                }
//            }
//        }
//
//        return tab;
//    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }

        private void clickBoton(int fila, int columna) {
        // Método a completar!.
            // En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
            // fila 1 y columna 1 corresponden a la posición de arriba a la izquierda.
            // Debe indicarse cómo responder al click de ese botón.
        }
    }
}
