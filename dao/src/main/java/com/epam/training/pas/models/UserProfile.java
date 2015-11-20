package com.epam.training.pas.models;

/**
 * Created by Drazz on 20.11.2015.
 */
public class UserProfile {
    private int id;
    private String first_name;
    private String last_name;
    private int country_id;
    private String passport_number;

    public UserProfile(int id, String first_name, String last_name, int country_id, String passport_number) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country_id = country_id;
        this.passport_number = passport_number;
    }

    public UserProfile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }


}
