package pl.sdacademy.programowanie2.Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.BinaryOperator;

public class CollectionTest {
    //1.Utworzyć nowy obiekt typu ArrayList typu Integer
    // a następnie zainicjować go 1000 losowych wartości z przedziału o 1 do 500
    // 2.Znaleść ilość unikalnych wartości
    // 3.Posortować listę rosnąco i wypisać jej wartoś
    public static void main(String[] args) {

        ArrayList<Integer> arrli = new ArrayList<>();
        for (int i = 1; i <= 1000; i++){
            int rand = (int) (Math.random() * 500);
            arrli.add(rand);
            i++;
        }
        System.out.println("Długosc arraylisty: " + arrli.size());

        HashSet<Integer> hset = new HashSet<>();
        hset.addAll(arrli);
        System.out.println("Długosc hashset: "+ hset.size());

//        for(Integer num : arrli){
////            hset.add(num);
////        }                       INNY SPOSOB przerzucenie listy do seta

        arrli.sort(new Comparator<Integer>() { // @@@@@@@ MOZNA ZASTAPIC LAMBDA !!!!!!!!!!!
            @Override
            public int compare(Integer integer, Integer t1) {
                return (t1.compareTo(integer)) * -1; //lub o1 - o2
                // posortowanie w kolejnosci odwrotnej to o2 - o1 LUB t1.compareTo(integer)
            }
        });
        System.out.println("Sort: ");
        for (Integer liczba : arrli){
            System.out.println(liczba);
        }

        //ZLICZENIE  ilość wystapień każdej z liczb w zbiorz
        HashMap<Integer, Integer> map = new HashMap<>();    // kluczem jest wartość liczbowa z przedziału który losowalisly, Wartoscią liczba wystąpień
        for (Integer num : arrli){
            Integer counts = map.get(num); //pobierz wartosc klucza
            if(counts == null){
                counts = 0;
            }
            counts++;
            map.put(num, counts);
        }

        for (Integer key : map.keySet()){
            System.out.println(key + " wystąpiła " + map.get(key) + " razy"); //map.get(key) wartość dla danego klucza
        }

        // 1.Zliczyć wszystkie liczby większe od 10 ale mniejsze 33
        long numbers = arrli.stream()
                .filter(value -> value != null)     // mozna łączyć warunki &&
                .filter(value -> value > 10)
                .filter(value -> value < 33).count();
        System.out.println("Ilosc liczb 10>x<33: "+ numbers);

        //2.Wyliczyć sumę z wszystkich liczby z zakresów: [1,16], [20,99], [340, 400
        int sum = arrli.stream()
                .filter(value -> value > 1 && value < 16)
//                .filter(value -> value > 20 && value < 99)
//                .filter(value -> value > 340 && value < 400)
                .reduce((integer, integer2) -> integer + integer2) //binaryoperation skrocony do lambdy
                .get();
        System.out.println("Suma z przedziałów wynosi: " + sum);




    }
}
