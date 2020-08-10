package pl.sdacademy.programowanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesManipulations {

    private static void printAlllines(String filePath) throws IOException {
        //definiujemy sciezke do pliku
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        for(int i = 0; i < lines.size(); i++){
            System.out.println(i + ": " + lines.get(i));
        }
    }

    private static void printSome(String filePath) throws IOException{
        Path path = Paths.get(filePath);
        //Files.write(path, "tekstyyyy".getBytes());
        Files.write(path, "tekstAPPEND".getBytes(), StandardOpenOption.APPEND); //<-- z opcją APPEND doda a nie podmieni napis

    }

    private static void saveText(String file, String text) throws IOException {
        Path path = Paths.get(file);
        Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
    }

    private static void printText(String file, String text) throws IOException{
        Path path = Paths.get(file);
        Files.list(path).forEach(fileName -> {
            if(fileName.getFileName().toString().endsWith(".txt")){
                System.out.print(fileName);
            }
        });
    }

    private static void readFromEveryTxt(String file) throws IOException{
        Path path = Paths.get(file);
        Files.list(path).forEach(fileName -> {
            if(fileName.getFileName().toString().endsWith(".txt")){
                try {
                    List<String> lines = Files.readAllLines(fileName);
                    if(lines.size() > 0){
                        System.out.println(lines.get(0));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private static void readFromEveryTxtWithPhrase(String file) throws IOException{
        Path path = Paths.get(file);
        Files.list(path).forEach(fileName -> {
            if(fileName.getFileName().toString().endsWith(".txt")){
                try {
                    List<String> lines = Files.readAllLines(fileName);
                    if(lines.size() > 0){
                        System.out.println(lines.toString().contains("abc"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            });
    }


    public static void main(String[] args) throws IOException {
//        printAlllines("C:/Users/Lenovo/Downloads/logi/app-info.log"); //C:\Users\Lenovo\Downloads\logi
//        printSome("C:/Users/Lenovo/Downloads/logi/app-info.log");
//        printText("C:/Users/Lenovo/Downloads/logi/plik.txt", "napis print");
        //readFromEveryTxt("C:/Users/Lenovo/Downloads/logi");
        readFromEveryTxtWithPhrase("C:/Users/Lenovo/Downloads/logi");
    }

}
