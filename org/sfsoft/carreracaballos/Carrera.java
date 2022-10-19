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
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JProgressBar pbCaballo3;
    private JLabel lblNewLabel_2;
    private JTextField tfDistancia;
    private JButton btCorrer;
    private JLabel lblDistancia;
    private JLabel lbMarcador;
    private JLabel progresoCaballo1;

    private void correr() {

        int distancia = Integer.parseInt(tfDistancia.getText());

        final Coche caballo1 = new Coche(5, distancia, lbMarcador, "Opel");
        final Coche caballo2 = new Coche(20, distancia, lbMarcador, "Ford");
        final Coche caballo3 = new Coche(30, distancia, lbMarcador, "Seat");

        caballo1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    caballo1.setValue((Integer) event.getNewValue());
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
                    Carrera.this.pbCaballo1.cancel(true);
                    caballo3.cancel(true);
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
                    Carrera.this.pbCaballo1.cancel(true);
                    caballo2.cancel(true);
                }
            }
        });

        caballo1.execute();
        caballo2.execute();
        caballo3.execute();
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

    public Carrera() /*inicializar la carrrera*/{
        initialize();
    }

    private void initialize() {
        frmCarrea = new JFrame();
        frmCarrea.setTitle("Carrera");
        frmCarrea.setBounds(100, 100, 450, 300);
        frmCarrea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCarrea.getContentPane().setLayout(null);
        frmCarrea.getContentPane().add(getPbCoche1());
        frmCarrea.getContentPane().add(getPbCoche2());
        frmCarrea.getContentPane().add(getLblNewLabel());
        frmCarrea.getContentPane().add(getLblNewLabel_1());
        frmCarrea.getContentPane().add(getPbCoche3());
        frmCarrea.getContentPane().add(getLblNewLabel_2());
        frmCarrea.getContentPane().add(getTfDistancia());
        frmCarrea.getContentPane().add(getBtCorrer());
        frmCarrea.getContentPane().add(getLblDistancia());
        frmCarrea.getContentPane().add(getLbMarcador());
        frmCarrea.getContentPane().add(getProgresoCoche1());
    }

}
