package pl.sdacademy.programowanie2.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Pogoda {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\dane.txt");
        ObjectMapper om = new ObjectMapper();
        Stacja[] stacje = om.readValue(Files.readAllBytes(path), Stacja[].class);
        double sumaTemp = 0;
        int iloscStacji = 0;
        double temp = -1000;
        for(Stacja stacja : stacje){
//            System.out.println("ID: " + stacja.getId_stacji() + " Stacja: " + stacja.getStacja() + " " + stacja.getData_pomiaru() +
//            " "+ stacja.getGodzina_pomiaru() +" "+ stacja.getTemperatura() +" "+ stacja.getPredkosc_wiatru());
            sumaTemp = sumaTemp + stacja.getTemperatura();
            iloscStacji++;
            if (stacja.getTemperatura() > temp)
            {
                temp = stacja.getTemperatura();
            }

        }
        System.out.println("średnia temp wynosi: " + (sumaTemp/iloscStacji)); //mozna sumaTemp/stacje.length
        System.out.println("Max temp2 = " + temp);

        Stacja maxTemp = Arrays.stream(stacje).max((o1,o2) -> (int)(o1.getTemperatura() - o2.getTemperatura())).get();
//        Stacja maxCis = Arrays.stream(stacje).max((o1,o2) -> (int)(o1.getCisnienie() - o2.getCisnienie())).get();
//        Stacja minCis = Arrays.stream(stacje).min((o1,o2) -> (int)(o1.getCisnienie() - o2.getCisnienie())).get();
        System.out.println("Max temp: " +maxTemp.getPredkosc_wiatru());
   //     System.out.println("Max cis: " +maxCis);
    //    System.out.println("Min cis: " +minCis);

        Stacja s = new Stacja();
        System.out.println(s);
    }
}
