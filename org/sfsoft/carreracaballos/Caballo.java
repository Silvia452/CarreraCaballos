package org.sfsoft.carreracaballos;

import java.util.Scanner;

public class Caballo {
    public static int numCarreras;
    private static OperacionHilo corredor[];
    private static int numCorredores;
    public static void lanzador(String[] args) {
        int caballos = dameCaballos();

        numCarreras=caballos;
        numCorredores=numCarreras;

        Resultado res = new Resultado(numCorredores, numCarreras);
        corredor = new OperacionHilo[numCarreras];

        //Realizo varias carreras una a continuación de la otra
        for (int i = 0; i < 1; i++) {
            corredor[i] = new OperacionHilo (i+1, res, numCarreras);
            corredor[i].start(); //Empiezo el hilo

            System.out.println("La carrera ha comenzado... Hagan sus apuestas...");
            try {
                corredor[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La carrera ha finalizado... Han llegado los " + numCarreras + " caballos");
        res.getResultados();
        for (int t = 0; t < 1; t++) {
            for (int i = 0; i < numCarreras; i++)
                System.out.print(res.cadena[t][i]);
        }
    }

    public static int dameCaballos() {
        Scanner sn = new Scanner(System.in);
        int contador_de_caballos, caballos;
        do {
            System.out.println("Cuantos caballos quieres que corran? [Máximo 8]");
            caballos = sn.nextInt();
            contador_de_caballos = caballos;
        } while (contador_de_caballos > 8);
        return caballos;
    }
}