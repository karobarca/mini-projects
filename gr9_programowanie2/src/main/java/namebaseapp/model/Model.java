package namebaseapp.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    //arrayliste danymi z childName
    private ArrayList<ChildName> names = new ArrayList<>();
    public ArrayList<ChildName> getNames(){
        return names;
    }

    public void load(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> rows = Files.readAllLines(path);
        for(int i = 1; i < rows.size(); i++){
            String row = rows.get(i);
            String[] columns = row.split(",");

            ChildName child = new ChildName();
            child.setYear(Integer.valueOf(columns[0])); //trzeba sparsowac na Integer bo dzielony był String na mniejsze stringi
            child.setName(columns[1]);
            child.setCount(Integer.valueOf(columns[2]));
            child.setSex(columns[3].equals("M") ? SexType.MALE : SexType.FEMALE);
            names.add(child);
        }
    }

    public List<ChildName> howManyNames(String name){
        List<ChildName> listOfNames = names.stream()
                .filter(childName -> childName.getName().equals(name))
                .collect(Collectors.toList());
        return listOfNames;
    }


}
