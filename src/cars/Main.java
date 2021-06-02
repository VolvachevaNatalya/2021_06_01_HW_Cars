package cars;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Auto auto1 = new Auto("Audi", 1800, 2000, 900, 1100);
        Auto auto2 = new Auto("Toyota", 1800, 2000, 900, 1900);


        Thread car1 = new Thread(new Game(8, auto1));
        Thread car2 = new Thread(new Game(8, auto2));

        car1.start();
        car2.start();

    }
}
