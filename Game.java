public class Game {
    public static void controlador(String[] args) {

        Player caballo1 = new Player("ping", lock);
        Player caballo2 = new Player("pong", lock);

        caballo1.setNextPlayer(caballo2);
        caballo2.setNextPlayer(caballo1);

        System.out.println("Game starting...!");

        caballo1.setPlay(true);

        Thread thread2 = new Thread(caballo2);
        thread2.start();
        Thread thread1 = new Thread(caballo1);
        thread1.start();

        //Let the players play!
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Tell the players to stop
        thread1.interrupt();
        thread2.interrupt();

        //Wait until players finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game finished!");
    }
}
