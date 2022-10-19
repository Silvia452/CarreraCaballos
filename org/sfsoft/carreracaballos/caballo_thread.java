package org.sfsoft.carreracaballos;

public class caballo_thread {
    private Resultado res;
    private int numCorredores;
    private int numCarrera;

    caballo_thread(int i, Resultado res, int numCorredores){
        this.numCarrera = i;
        this.res = res;
        this.numCorredores = numCorredores;
    }

    public void run(){
        res.carreras[numCarrera-1] = numCarrera;
        Operacionesenhilo[] corredor = new Operacionesenhilo[numCorredores];
        for (int i = 0; i < numCorredores; i++) {
            corredor[i] = new Operacionesenhilo (i+1, res, numCarrera);
            corredor[i].start();
        }

        try{
            for (int i = 0; i < numCorredores; i++) {
                corredor[i].join();
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
