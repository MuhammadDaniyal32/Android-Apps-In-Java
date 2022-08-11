package com.example.crud_task;

public class crud_class {
    private String Name;
    private String Gender;
    private String City;
    private String Places;
    private int Id;

    // creating getter and setter methods
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPlaces() {
        return Places;
    }

    public void setPlaces(String Places) {
        this.Places = Places;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    // constructor
    public crud_class(String Name, String Gender, String City, String Places) {
        this.Name = Name;
        this.Gender = Gender;
        this.City = City;
        this.Places = Places;
    }
}
