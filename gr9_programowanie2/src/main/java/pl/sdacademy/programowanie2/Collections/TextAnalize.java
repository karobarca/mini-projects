package pl.sdacademy.programowanie2.Collections;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class TextAnalize {
//3. Napisać aplikację wczytującą dowolny plik tekstowy,
// która wyliczy i wypisze wystąpienie każdej litery w tekście w porządku rosnącym
    private static String readTextFromFile(String path) throws IOException {
        Path sciezka = Paths.get(path);
        String text = new String( Files.readAllBytes(sciezka)); //wrzucenie calego pliku do stringa
        return text;
    }

    private static void CountLetters(String text){
//        char[] tablica = text.toCharArray();
//        HashMap<Character, Integer> mapka = new HashMap<>();
//        for (Character num : tablica){
//            Integer counts = mapka.get(num);
//            if(num.equals('a')){
//                counts++;
//                mapka.put(num, counts);
//            }
//        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char litera : text.toCharArray()){
            Integer counts = map.get(litera); //pobierz wartosc klucza
            if(counts == null){
                counts = 0;
            }
            counts++;
            map.put(litera, counts);
        }
//        for (Character key : map.keySet()) {
//            System.out.println(key + " wystąpiła " + map.get(key) + " razy");
//        } INNY FOREACH
        map.keySet().stream().filter(key -> key.compareTo('\n') != 0)
                .sorted()
                .forEach(key -> {
                    System.out.println(key + ": " + map.get(key));
                });

    }
    //4. Napisać aplikację wczytującą dowolny plik tekstowy,
    // która wypisze wyrazy w kolejności częstości ich wystąpień

    private static class LetterCount {
        Integer count;
        Character letter;

        public LetterCount(Integer count, Character letter) {
            this.count = count;
            this.letter = letter;
        }
    }

    private static void showWordsCount(String text){
        HashMap<String, Integer> map = new HashMap<>();
        for (String slowa : text.split("[ !,.;]")){
            Integer counts = map.get(slowa);
            if(counts == null){
                counts = 0;
            }
            counts++;
            map.put(slowa, counts);
        }
        map.keySet().stream()
                .sorted()
                .forEach(key -> {
                    System.out.println(key + ": " + map.get(key));
                });
    }


    public static void main(String[] args) throws IOException {
        showWordsCount(readTextFromFile("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\PanTadeusz.txt"));
    }
}
