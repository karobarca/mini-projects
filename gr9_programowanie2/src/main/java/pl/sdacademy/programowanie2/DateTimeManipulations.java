package pl.sdacademy.programowanie2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateTimeManipulations {
//1.Napisać metodę pozwalającą na sprawdzenie czy w danym miesiącu i roku jest piątek 13.
    public static boolean isFriday13th(LocalDate date){
        if((date.getDayOfWeek()== DayOfWeek.FRIDAY) && (date.getDayOfMonth() == 13)){
            return true;
        }
        return false;
    }

    //2.Napisać metodę wypisującą dzień tygodnia dla danego roku
    // dla: Wigilii Bożego Narodzenia, Nowego Roku, Święta Konstytucji 3 Maja
    public static void whichDay(int year){
        LocalDate date = LocalDate.of(year, 1,1);
        System.out.println("New Year is on " + date.getDayOfWeek());

    }
    //3.Napisać metodę wypisującą nazwy wszystkich pierwszych dni miesiąca dla podanego roku
    public static void firstDay(int year){
        for (int i = 1; i <= 12; i++){
            LocalDate date = LocalDate.of(year,i,1);
            System.out.println(i + ". : " + date.getDayOfWeek());
        }
    }

    //4.Napisać metodę wyświetlającą daty wszystkich niedziel dla danego miesiąca i roku
    public static void allSundays(int year, int month){
        LocalDate date = LocalDate.of(year, month, 1);
        for (int i = 1; i <= date.lengthOfMonth(); i++){
            LocalDate day = LocalDate.of(year,month,i); //zwiekszamy i++, kazdy kolejny dzien
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.println("niedziela " + LocalDate.of(year, month , i));
        }
    }

    public static void main(String[] args) {
//        LocalDate date13 = LocalDate.of(2019,12,13);
//        LocalDate dateNot13 = LocalDate.of(2018,11,17);
//        System.out.println(isFriday13th(date13));
//        System.out.println(isFriday13th(dateNot13));
      //  whichDay(2020);
     //   firstDay(2020);
        allSundays(2020,1);
    }
}
