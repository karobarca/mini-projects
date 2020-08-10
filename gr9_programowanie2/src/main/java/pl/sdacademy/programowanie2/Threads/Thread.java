package pl.sdacademy.programowanie2.Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread {

    private  static int count = 0;

    synchronized private static void incCounter() { //synchronizacja. Jednoczesnie ta metoda nie moze byc wywolywana przez dwa wątki
        count++;
    }

    public static double pi(int randomCount, int cores){ //int cores definiowac mozna ile watkow chcemy wykorzystac
        int hitCunt = 0;
        ExecutorService ex = Executors.newFixedThreadPool(cores);
//        ex.execute(() ->) {
//            for (long i = 0; i < randomCount / cores; i++) {
//                double x = Math.random();
//                double y = Math.random();
//                double r = Math.sqrt(x * x + y * y);
//                if (r <= 1) {
//                    hitCunt++;
//                }
//            }
//        });
    return 4.0 * hitCunt / randomCount;
    }

    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.execute(() -> {
            int localCounter = 0;
            for(int i = 0; i < 100000;i++) {localCounter++;} //count zamieniamy na incCounter() metode. Mozna stworzyc lokalna zmienną i raz po wszystkim przypisac
        }); //Jak najmniej odwolywac sie do zasobów, oszczedzamy czas
        es.execute(() -> {
            int localCounter = 0;
            for(int i = 0; i < 100000;i++) {localCounter++;};
        });

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(count);
        System.out.println("Time " + (System.currentTimeMillis() - starTime));
    }
}
