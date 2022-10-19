public class Menu {
    public static void lanzador(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        do {

            System.out.println("1. Opción de N jugadores");
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
                        GameScale.controlador(args);
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 2 para seleccionar las opciones");
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
            }
            sn.close();
        }while(sn.nextInt()!=3);

    }

    private static int NUM_CABALLOS;

    public static int dameCaballos(){
        Scanner sc = new Scanner(System.in);

        // Entrada de datos numéricos
        // byte, short y float
        try{
            System.out.println("Introduce el numero de caballos que van a correr:");
            NUM_CABALLOS = sc.nextInt();
            if (NUM_CABALLOS > 8) {
                System.out.println("Vuelve a introducir un número válido");
            }
            }
        catch(Exception e){
            System.out.println("No es un valor válido");
        }
        sc.close();
        return NUM_CABALLOS;
    }
}


