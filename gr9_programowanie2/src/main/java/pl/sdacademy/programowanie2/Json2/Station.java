package pl.sdacademy.programowanie2.Json2;

public class Station {
    Integer id;
    String stationName;
    Double gegrLat;
    Double gegrLon;
    City city;
    String addressStreet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Double getGegrLat() {
        return gegrLat;
    }

    public void setGegrLat(Double gegrLat) {
        this.gegrLat = gegrLat;
    }

    public Double getGegrLon() {
        return gegrLon;
    }

    public void setGegrLon(Double gegrLon) {
        this.gegrLon = gegrLon;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
}
