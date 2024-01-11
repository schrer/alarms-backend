package at.schrer.alarms.data.client.bgl;

import com.opencsv.bean.CsvBindByName;

public class BglFireBrigade {
    @CsvBindByName(column = "Bezeichnung")
    private String name;
    @CsvBindByName(column = "Strasse")
    private String street;
    @CsvBindByName(column = "PLZ")
    private String postcode;
    @CsvBindByName(column = "Ort")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
