package org.sfsoft.carreracaballos;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
public class Carrera {

    private JFrame frmCarrea;
    private JProgressBar pbCaballo1;
    private JProgressBar pbCaballo2;
    private JProgressBar pbCaballo3;
    private JProgressBar pbCaballo4;
    private JProgressBar pbCaballo5;
    private JProgressBar pbCaballo6;
    private JProgressBar pbCaballo7;
    private JProgressBar pbCaballo8;

    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JTextField tfDistancia;
    private JButton btCorrer;
    private JLabel lblDistancia;
    private JLabel lbMarcador;
    private JLabel progresoCaballo1;

    private void correr() {

        int distancia = Integer.parseInt(tfDistancia.getText());

        final Caballo caballo1 = new Caballo(5, distancia, lbMarcador, "Opel");
        final Caballo caballo2 = new Caballo(20, distancia, lbMarcador, "Ford");
        final Caballo caballo3 = new Caballo(30, distancia, lbMarcador, "Seat");
        final Caballo caballo4 = new Caballo(30, distancia, lbMarcador, "Seat");
        final Caballo caballo5 = new Caballo(30, distancia, lbMarcador, "Seat");
        final Caballo caballo6 = new Caballo(30, distancia, lbMarcador, "Seat");
        final Caballo caballo7 = new Caballo(30, distancia, lbMarcador, "Seat");
        final Caballo caballo8 = new Caballo(30, distancia, lbMarcador, "Seat");


        caballo1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo1.setValue((Integer) event.getNewValue());
                    progresoCaballo1.setText(
                            event.getNewValue() + " %");

                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo2.cancel(true);
                    caballo3.cancel(true);
                }
            }
        });
        caballo2.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo2.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo1.cancel(true);
                    caballo3.cancel(true);
                    caballo4.cancel(true);
                    caballo5.cancel(true);
                    caballo6.cancel(true);
                    caballo7.cancel(true);
                    caballo8.cancel(true);
                }
            }
        });
        caballo3.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo3.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo1.cancel(true);
                    caballo2.cancel(true);
                    caballo4.cancel(true);
                    caballo5.cancel(true);
                    caballo6.cancel(true);
                    caballo7.cancel(true);
                    caballo8.cancel(true);
                }
            }
        });
        caballo4.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo4.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo1.cancel(true);
                    caballo2.cancel(true);
                    caballo3.cancel(true);
                    caballo5.cancel(true);
                    caballo6.cancel(true);
                    caballo7.cancel(true);
                    caballo8.cancel(true);
                }
            }
        });


        caballo1.execute();
        caballo2.execute();
        caballo3.execute();
        caballo4.execute();
        caballo5.execute();
        caballo6.execute();
        caballo7.execute();
        caballo8.execute();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carrera window = new Carrera();
                    window.frmCarrea.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Carrera() /*inicializar la carrrera*/ {
        initialize();
    }

    private void initialize() {
        frmCarrea = new JFrame();
        frmCarrea.setTitle("Carrera");
        frmCarrea.setBounds(100, 100, 450, 300);
        frmCarrea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCarrea.getContentPane().setLayout(null);
        frmCarrea.getContentPane().add(getPbCaballo1());
        frmCarrea.getContentPane().add(getPbCaballo2());
        frmCarrea.getContentPane().add(getLblNewLabel());
        frmCarrea.getContentPane().add(getLblNewLabel_1());
        frmCarrea.getContentPane().add(getPbCaballo3());
        frmCarrea.getContentPane().add(getLblNewLabel_2());
        frmCarrea.getContentPane().add(getTfDistancia());
        frmCarrea.getContentPane().add(getBtCorrer());
        frmCarrea.getContentPane().add(getLblDistancia());
        frmCarrea.getContentPane().add(getLbMarcador());
        frmCarrea.getContentPane().add(getProgresoCaballo1());
        frmCarrea.getContentPane().add(getProgresoCaballo2());
        frmCarrea.getContentPane().add(getProgresoCaballo3());

    }

    public JProgressBar getPbCaballo1() {
        if (this.pbCaballo1 == null) {
            this.pbCaballo1 = new JProgressBar();
            this.pbCaballo1.setBounds(10, 65, 422, 19);
        }

        return this.pbCaballo1;
    }

    public JProgressBar getPbCaballo2() {
        if (this.pbCoche2 == null) {
            this.pbCoche2 = new JProgressBar();
            this.pbCoche2.setBounds(10, 137, 422, 19);
        }

        return this.pbCoche2;
    }

    public JLabel getLblNewLabel() {
        if (this.lblNewLabel == null) {
            this.lblNewLabel = new JLabel("Coche 1");
            this.lblNewLabel.setBounds(10, 43, 46, 14);
        }

        return this.lblNewLabel;
    }

    public JLabel getLblNewLabel_1() {
        if (this.lblNewLabel_1 == null) {
            this.lblNewLabel_1 = new JLabel("Coche 2");
            this.lblNewLabel_1.setBounds(10, 114, 46, 14);
        }

        return this.lblNewLabel_1;
    }

    public JProgressBar getPbCaballo3() {
        if (this.pbCoche3 == null) {
            this.pbCoche3 = new JProgressBar();
            this.pbCoche3.setString("34");
            this.pbCoche3.setBounds(10, 207, 422, 19);
        }

        return this.pbCoche3;
    }

    public JLabel getLblNewLabel_2() {
        if (this.lblNewLabel_2 == null) {
            this.lblNewLabel_2 = new JLabel("Coche 3");
            this.lblNewLabel_2.setBounds(10, 182, 46, 14);
        }

        return this.lblNewLabel_2;
    }

    public JTextField getTfDistancia() {
        if (this.tfDistancia == null) {
            this.tfDistancia = new JTextField();
            this.tfDistancia.setBounds(247, 12, 86, 20);
            this.tfDistancia.setColumns(10);
        }

        return this.tfDistancia;
    }

    public JButton getBtCorrer() {
        if (this.btCorrer == null) {
            this.btCorrer = new JButton("Correr");
            this.btCorrer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent var1) {
                    Carrera.this.correr();
                }
            });
            this.btCorrer.setBounds(343, 11, 89, 23);
        }

        return this.btCorrer;
    }

    public JLabel getLblDistancia() {
        if (this.lblDistancia == null) {
            this.lblDistancia = new JLabel("Distancia");
            this.lblDistancia.setBounds(176, 15, 72, 14);
        }

        return this.lblDistancia;
    }

    public JLabel getLbMarcador() {
        if (this.lbMarcador == null) {
            this.lbMarcador = new JLabel("");
            this.lbMarcador.setBounds(147, 241, 144, 14);
        }

        return this.lbMarcador;
    }

    public JLabel getProgresoCaballo1() {
        if (this.progresoCaballo1 == null) {
            this.progresoCaballo1 = new JLabel("");
            this.progresoCaballo1.setBounds(65, 40, 46, 14);
        }

        return this.progresoCaballo1;
    }

    public JLabel getProgresoCaballo2() {
        if (this.progresoCaballo2 == null) {
            this.progresoCaballo2 = new JLabel("");
            this.progresoCaballo2.setBounds(65, 40, 46, 14);
        }
        return this.progresoCaballo2;
    }
    public JLabel getProgresoCaballo3(){
        if (this.progresoCaballo3 == null) {
            this.progresoCaballo3 = new JLabel("");
            this.progresoCaballo3.setBounds(65, 40, 46, 14);
        }
        return this.progresoCaballo3;
    }
}



