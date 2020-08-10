package sdaacademy.mvcapp.view;

import sdaacademy.mvcapp.model.Person;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    public MenuOption showOptions(){
        System.out.println("Opcje do wyboru:");
        System.out.println("--------------------------");
        System.out.println("Wyświetl wszystko [1]");
        System.out.println("Dodaj nowy [2]");
        System.out.println("Wyszukaj pierwszą osobę po imieniu [3]");
        System.out.println("Wyszukaj wszystkie osoby po imieniu [4]");
        System.out.println("Usuń [5]");
        System.out.println("Aktualizuj [6]");
        System.out.println("Zamknij program [7]");


        int option = scanner.nextInt();
        switch (option){
            case 1: return MenuOption.SHOW_ALL;
            case 2: return MenuOption.ADD_NEW;
            case 3: return MenuOption.FIND_BY_NAME;
            case 4: return MenuOption.FIND_ALL_BY_NAME;
            case 5: return MenuOption.DELETE;
            case 6: return MenuOption.UPDATE;
            case 7: return MenuOption.EXIT_APP;
        }
        return null;
    }

    public void showMenuError(){
        System.out.println("Niepoprawna opcja. Spróbuj ponownie.");
    }

    public void showAllPersons(List<Person> personList) {

        System.out.println("Lista osób:");
        System.out.println("----------------------");
        for (Person person : personList){
            System.out.println(person);
        }
        System.out.println("----------------------");
      //  personList.forEach(person -> System.out.println(person));
    }

    public Person readPerson(){
        Person person = new Person();
        System.out.println("Podaj imię: ");
        person.setName(scanner.next());

        System.out.println("Podaj numer telefonu");
        person.setPhone(scanner.next());

        return person;
    }

    public String findByName(){
        System.out.println("Podaj imię do wyszukania:");
        String name = scanner.next();
        return name;
    }

    public String findAllByName(){
        System.out.println("Podaj imię do wyszukania:");
        String name = scanner.next();
        return name;
    }

    public Integer readPersonIdToDelete(){
        System.out.println("Podaj id osoby do usunięcia:");
        Integer idToDelete = scanner.nextInt();
        return idToDelete;
    }

    public Person getPersonToUpdate(){
        Person person = new Person();
        System.out.println("Podaj id osoby do aktualizacji");
        person.setId(scanner.nextInt());

        System.out.println("Podaj nową nazwę:");
        person.setName(scanner.next());

        System.out.println("Podaj nową numer:");
        person.setPhone(scanner.next());

        return person;
    }

    public void displayPerson(Person person){
        System.out.println(person);
    }

    public void displayListPerson(List<Person> personList){
        System.out.println(personList);
    }
}
