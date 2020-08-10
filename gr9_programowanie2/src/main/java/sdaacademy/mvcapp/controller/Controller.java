package sdaacademy.mvcapp.controller;

import sdaacademy.mvcapp.model.Model;
import sdaacademy.mvcapp.model.Person;
import sdaacademy.mvcapp.view.MenuOption;
import sdaacademy.mvcapp.view.View;

import java.io.IOException;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller(){
        model = new Model();
        view = new View();
        try {
            model.loadModel("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\ksiazka.txt");
        } catch (IOException e) {
            System.err.println("Błąd odczytu + " + e.getMessage());
        }
    }

    void start(){
        MenuOption option = null;
        while (option != MenuOption.EXIT_APP) {
            option = view.showOptions();

            switch (option){
                case SHOW_ALL: showAllHandle();break;
                case ADD_NEW: addNewHandle();break;
                case FIND_BY_NAME: findByNameHandle();break;
                case DELETE: idToDeleteHandle();break;
                case UPDATE: updateHandle();break;
                case FIND_ALL_BY_NAME: findAllByNameHandle();break;
            }
        }
    }
    void showAllHandle(){
        List<Person> list = model.getAll();
        view.showAllPersons(list);
    }

    void addNewHandle(){
        Person newPerson = view.readPerson();
        //ewentualna walidacja
        model.addNewPerson(newPerson);
    }

    void findByNameHandle(){
        String name = view.findByName();
        Person found = model.findByName(name);
        view.displayPerson(found);
    }

    void findAllByNameHandle(){
        String name = view.findAllByName();
        List<Person> list = model.findAllByName(name);
        view.displayListPerson(list);

    }

    void idToDeleteHandle(){
        model.deletePersonById(view.readPersonIdToDelete());
    }

    void updateHandle(){
       Person personToUpdate = view.getPersonToUpdate();
       model.updatePerson(personToUpdate);
    }




}
