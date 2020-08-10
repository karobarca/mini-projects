package namebaseapp.controller;

import namebaseapp.model.ChildName;
import namebaseapp.model.Model;
import namebaseapp.view.View;
import namebaseapp.view.MenuOpt;

import java.io.IOException;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
        try {
            model.load("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\imiona.csv");
        } catch (IOException e) {
            System.err.println("Błąd odczytu + " + e.getMessage());
        }
    }

    void start(){
        MenuOpt option = null;
        while (option != MenuOpt.EXIT_APP) {
            option = view.menuOptions();
            switch (option){
                case HOW_MANY_NAMES: howManyNamesHandle();break;
            }
        }
    }

    void howManyNamesHandle(){
        String name = view.howManyNames();
        List<ChildName> lista = model.howManyNames(name);
        view.displayNames(lista);
    }


}