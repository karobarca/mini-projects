package pl.sdacademy.programowanie2.Threads;

public class Pi {
    //Wykorzystując metodę MonteCarlo obliczyć przybliżoną wartość liczby Pi.
    // Zmodyfikować metodę tak by przy użyciu wielowątkowości przyśpieszyć obliczenia.

    public static void main(String[] args) {
        int hitCunt = 0;
        for (long i = 0; i < 200; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                hitCunt++;
            }
        }
        System.out.println(4.0 * hitCunt / 200);
    }

}
