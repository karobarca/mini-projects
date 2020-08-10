package namebaseapp.view;



import namebaseapp.model.ChildName;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    public MenuOpt menuOptions(){
        System.out.println("Opcje do wyboru:");
        System.out.println("--------------------------");
        System.out.println("[1] Ilość wystąpień podanego imienia w roku");


        return null;
    }

    public String howManyNames(){
        System.out.println("Podaj imię do wyszukania:");
        String name = scanner.next();
        return name;
    }
    public void displayNames(List<ChildName> list){
        System.out.println(list);
    }


}
