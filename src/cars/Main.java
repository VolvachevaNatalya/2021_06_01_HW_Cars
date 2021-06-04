package cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        for (ResultInfo resultInfo : resultInfoList) {
            System.out.println("Car " + resultInfo.getName() + " total time: " + resultInfo.getResultTime());
        }
        System.out.println("--- end ---");


        Comparator<ResultInfo> resComparator = new Comparator<ResultInfo>() {
            @Override
            public int compare(ResultInfo o1, ResultInfo o2) {
                return (int) (o2.getResultTime()- o1.getResultTime());
            }
        };
        resultInfoList.sort(resComparator);
        System.out.println("The champion of today's race is " + resultInfoList.get(0).getName());



    }

}
