package sdaacademy.mvcapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private ArrayList<Person> persons = new ArrayList<>();

    private Path pathToFile = null;

    public void loadModel(String path) throws IOException {
        if(path != null && path.isEmpty() == false){
            pathToFile = Paths.get(path);
            String jsonText = new String(Files.readAllBytes(pathToFile));
            ObjectMapper om = new ObjectMapper();
            Person[] loadedPersons = om.readValue(jsonText, Person[].class);
            persons = new ArrayList<>(Arrays.asList(loadedPersons));
        }
    }

    private void save(){
        if(pathToFile != null){
            ObjectMapper om = new ObjectMapper();
            try {
                String jsonText = om.writeValueAsString(persons);
                Files.write(pathToFile, jsonText.getBytes());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void addNewPerson(Person person){
        // przeszukanie osób, znaleźć maxId
        Person maxId = persons.stream().max((p1, p2) -> p1.getId().compareTo(p2.getId())).orElse(null);
        if (maxId != null){
            person.setId((maxId.getId() + 1));
        } else {
            person.setId(1);
        }
        persons.add(person);
        save();
    }

    public Person findByName(String name){
        Person found = persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst() // pobieramy pierwszy znaleziony
                .orElse(null);
        return found;
    }

    public void deletePersonById(Integer id){
//        Person personToDelete = persons.stream()
//                .filter(person -> person.getId().equals(id))
//                .findAny()
//                .get();
//        if(personToDelete != null){
//            persons.remove(personToDelete);
//        }  TEŻ POPRAWNIE ALE Dłużej

        persons.removeIf(person -> person.getId().equals(id));
        save();
    }

    public void updatePerson(Person person){
        Person toUpdate = persons.stream()
                .filter(p -> p.getId().equals(person.getId()))
                .findFirst()
                .orElse(null);
        if(toUpdate != null){
            toUpdate.setName(person.getName());
            toUpdate.setPhone(person.getPhone());
        }
        save();
    }

    public List<Person> getAll(){
        return persons;
    }

    public List<Person> findAllByName(String name){
        List<Person> allNameslist = persons.stream()
                .filter(person -> person.getName().equals(name)).collect(Collectors.toList());
        return allNameslist;
    }

}
