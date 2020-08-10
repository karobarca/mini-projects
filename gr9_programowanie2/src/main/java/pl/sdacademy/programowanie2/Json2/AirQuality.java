package pl.sdacademy.programowanie2.Json2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AirQuality {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\jakosc_powietrza.txt");
        ObjectMapper objmp = new ObjectMapper();
        Station[] stations = objmp.readValue(Files.readAllBytes(path), Station[].class);

        for (Station stacje : stations){
            System.out.println("ID:"+stacje.getId()+" NAZWA: "+stacje.getStationName()+ " MIASTO: "+stacje.getCity().getName()
            + " WOJEWODZTWO: " + stacje.getCity().getCommune().getCommuneName() );

        }
    }

}
