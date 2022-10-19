
import java.util.Scanner;

public class Menu {
    public static void lanzador(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {

            System.out.println("1. Opción N caballos");
            System.out.println("2. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opción 1");
                        Game.controlador(args);
                        break;
                    case 2:
                        salir = true;
                        System.out.println("Has seleccionado la opción 2");
                        Game.controlador(args);
                        break;
                    default:
                        System.out.println("Solo se puede seleccionar la opción 1 o la opción 2");
                }
            } catch (Exception e) {
                System.out.println("Debes introducir un número");
            }
            sn.close();
        }while(sn.nextInt()!=3);

    }


}


