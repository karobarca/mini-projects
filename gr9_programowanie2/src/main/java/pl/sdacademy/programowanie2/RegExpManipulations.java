package pl.sdacademy.programowanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpManipulations {

    private static boolean isNameAndLastName(String text){
        String patternText = "[A-Z][a-z]+[ ][A-Z][a-z]+"; //def wzorzec
        Pattern pattern = Pattern.compile(patternText); //kompilujemy go
        Matcher matcher = pattern.matcher(text); //dopasowujemy do tekstu
        return matcher.find();
    }

    //dzielenie dopasowania na grupy, wyciagamy imie i nazwisko
    private static void printParts(String text){
        String patternText = "([A-Z][a-z]+) ([A-Z][a-z]+)";
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println("imie: " + matcher.group(1));
            System.out.println("nazwisko: " + matcher.group(2));
        }
    }

    //Napisać aplikację rozdzielającą podany adres na grupy w formacie:
    // ‘ulica’ ‘numer lokalu’ ‘kod pocztowy’ ‘poczta’

    private static void printPartsOfAdress(String adress){
        //String patternText = "(ul\\. [A-Z][a-z]+[ ][0-9]{3}[A-Z]*[a-z]*) ([1-9][0-9][-][0-9]{3}) ([A-Z][a-z]+)";
        String patternText = "([a-z]{2}[.]+ [A-Z][a-z ąęńśćó]+) ([0-9]+) ([0-9]{2}-[0-9]{3}) ([A-Z][a-z ńąęśćó]+)";
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(adress);
        if(matcher.find()){
            System.out.println("Ulica: " + matcher.group(1));
            System.out.println("Nr lokalu: " + matcher.group(2));
            System.out.println("Kod pocztowy " + matcher.group(3));
            System.out.println("Poczta: " + matcher.group(4));
        }
    }
    //Utworzyć aplikację do przeszukiwania plików.
    //Parametry wyszukiwania to:
    // -poszukiwana fraza (wyrażenie regularne)
    // -ścieżka do folderu z plikami do przeszukiwania
    // -rozszerzenie plików które mają być analizowane
    //Aplikacja powinna przeszukać wszystkie pliki o zadanym rozszerzeniu w danym katalogu
    // a następnie wypisać numery linii oraz nazwy plików gdzie poszukiwana fraza została znaleziona

    private static void searchText(String dir, String ext, String regexp ) throws IOException {
        //najpierw wylistowac wszystkie pliki
        Path path = Paths.get(dir);
        Files.walk(path).forEach(file -> {
            if (file.getFileName().toString().endsWith(ext) == true) {
                try {
                    //wczytujemy wszystkie linie
                    List<String> lines = Files.readAllLines(file);
                    for (int i = 0; i < lines.size(); i++) {
                        String line = lines.get(i);
                        Pattern pattern = Pattern.compile(regexp);
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            System.out.println(line);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Błąd: " + file.getFileName());
                }

            }
        });
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(isNameAndLastName("Niewiem"));
//        System.out.println(isNameAndLastName("aaaaaaa"));
//        System.out.println(isNameAndLastName("Jan Kowalski"));
//        System.out.println(isNameAndLastName("jan kowalski"));
      //  printParts("Jan Kowalski");
        //printPartsOfAdress("ul. Kopernika 5 37-403 Jastkowice");
            searchText("C:\\Program Files",".txt","\\D[\\w\\.]+@([\\w-]+\\.)+\\D+");
    }
}
