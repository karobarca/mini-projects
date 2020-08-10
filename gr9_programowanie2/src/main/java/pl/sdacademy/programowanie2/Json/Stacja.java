package pl.sdacademy.programowanie2.Json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

//dodajemy adnotacje ze interesuja nas tylko te pola (a jest ich wiecej)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stacja {

    int id_stacji;
    String stacja;
    //tutaj bedzie data w takim formacie, podpowiadamy bibliotece
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date data_pomiaru;
    Integer godzina_pomiaru;
    Double temperatura;
    Double predkosc_wiatru;
    Integer kierunek_wiatru;
    Double wilgotnosc_wzgledna;
    Double suma_opadu;
    Double cisnienie;

//    public Integer getKierunek_wiatru() {
//        return kierunek_wiatru;
//    }
//
//    public void setKierunek_wiatru(Integer kierunek_wiatru) {
//        this.kierunek_wiatru = kierunek_wiatru;
//    }
//
//    public Double getWilgotnosc_wzgledna() {
//        return wilgotnosc_wzgledna;
//    }
//
//    public void setWilgotnosc_wzgledna(Double wilgotnosc_wzgledna) {
//        this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
//    }
//
//    public Double getSuma_opadu() {
//        return suma_opadu;
//    }
//
//    public void setSuma_opadu(Double suma_opadu) {
//        this.suma_opadu = suma_opadu;
//    }
//
//    public Double getCisnienie() {
//        return cisnienie;
//    }
//
//    public void setCisnienie(Double cisnienie) {
//        this.cisnienie = cisnienie;
//    }


    //getery za pomoca lombok wiec te del
   /* public int getId_stacji() {
        return id_stacji;
    }

    public void setId_stacji(int id_stacji) {
        this.id_stacji = id_stacji;
    }

    public String getStacja() {
        return stacja;
    }

    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    public Date getData_pomiaru() {
        return data_pomiaru;
    }

    public void setData_pomiaru(Date data_pomiaru) {
        this.data_pomiaru = data_pomiaru;
    }

    public Integer getGodzina_pomiaru() {
        return godzina_pomiaru;
    }

    public void setGodzina_pomiaru(Integer godzina_pomiaru) {
        this.godzina_pomiaru = godzina_pomiaru;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPredkosc_wiatru() {
        return predkosc_wiatru;
    }

    public void setPredkosc_wiatru(Double predkosc_wiatru) {
        this.predkosc_wiatru = predkosc_wiatru;
    }*/
}
