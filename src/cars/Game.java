package cars;

import java.util.Random;

public class Game implements Runnable {
    int loopNumber;
    Auto auto;

    public Game(int loopNumber, Auto auto) {
        this.loopNumber = loopNumber;
        this.auto = auto;
    }

    @Override
    public void run() {
        long[] res = new long[loopNumber];
        long totalTime = 0;
        long totalPitStopTime = 0;
        for (int i = 0; i < loopNumber; i++) {
            long start = System.currentTimeMillis();
            long pitStopStart = System.currentTimeMillis();

            if (i>0 && i<loopNumber && i%2 == 0 )  {
                try {
                    Thread.sleep(new Random().nextInt(auto.maxPitStopTime-auto.minPitStopTime) +auto.minPitStopTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long pitStopEnd = System.currentTimeMillis();
            totalPitStopTime += (pitStopEnd - pitStopStart);

            try {
                Thread.sleep(new Random().nextInt(auto.maxLoopTime - auto.minLoopTime) + auto.minLoopTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long end = System.currentTimeMillis();
            long pitStopTime = pitStopEnd - pitStopStart;

            res[i] = end-start;
            System.out.println("Car " + auto.getName() + " Loop number: " + (i+1) + ", Loop time: " + (end-start));
            if(pitStopTime > 0) {
                System.out.println("Car " + auto.getName() + " pitStop after loop number: " + (i) + ", Pit stop time: " + pitStopTime);
            }
        }

        System.out.println(" ============ FINISH ============= ");
        System.out.println("The race is finished! Please, see the results of the race for " + auto.getName());
        System.out.println("Results for "+ auto.getName() + ": Number of loops: " + loopNumber + "; Time of each loop: ");
        for (long r : res) {
            totalTime +=r;
            System.out.print(r + ", ");
        }
        System.out.println();
        System.out.println("Total time of the race including pit stops: " + (totalTime + totalPitStopTime));
        System.out.println(" ============ THE END ============= ");
    }
}
