package org.sfsoft.carreracaballos;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class Caballo extends SwingWorker<Void, Integer>{

        private int velocidad;
        private int distanciaCarrera;
        private int distanciaRecorrida;
        private JLabel marcador;
        private String nombre;

        public Caballo(int var1, int var2, JLabel var3, String var4) {
            this.velocidad = var1;
            this.distanciaCarrera = var2;
            this.distanciaRecorrida = 0;
            this.marcador = var3;
            this.nombre = var4;
        }

        public Caballo(int var1, JLabel var2, String var3) {
            this.velocidad = (new Random()).nextInt(30) + 5;
            this.distanciaCarrera = var1;
            this.distanciaRecorrida = 0;
            this.marcador = var2;
            this.nombre = var3;
        }

        protected Void doInBackground() throws Exception {
            for(; this.distanciaRecorrida < this.distanciaCarrera; this.setProgress(this.distanciaRecorrida * 100 / this.distanciaCarrera)) {
                Thread.sleep(100L);
                this.distanciaRecorrida += this.velocidad;
                if (this.distanciaRecorrida > this.distanciaCarrera) {
                    this.distanciaRecorrida = this.distanciaCarrera;
                }
            }

            this.marcador.setText(this.nombre + ": He ganado");
            this.firePropertyChange("ganador", "", this.nombre);
            return null;
        }
    }


