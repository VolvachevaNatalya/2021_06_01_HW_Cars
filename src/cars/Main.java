package cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Auto auto1 = new Auto("Audi", 1800, 2000, 900, 1100);
        Auto auto2 = new Auto("Toyota", 1800, 2000, 900, 1100);
        Auto auto3 = new Auto("BMW", 1800, 2000, 900, 1100);

        List<ResultInfo> resultInfoList = new ArrayList<>();

        Thread car1 = new Thread(new Game(4, auto1, resultInfoList));
        Thread car2 = new Thread(new Game(4, auto2, resultInfoList));
        Thread car3 = new Thread(new Game(4, auto3, resultInfoList));

        car1.start();
        car2.start();
        car3.start();
        car1.join();
        car2.join();
        car3.join();

//        System.out.println("THE SIZE:" +resultInfoList.size());

        for (ResultInfo resultInfo : resultInfoList) {
            System.out.println("Car " + resultInfo.getName() + " total time: " + resultInfo.getResultTime());
        }
        System.out.println("--- end ---");






    }
}
