package com.ritesh.springboot.restclient.json;

import java.util.List;

public class AstroResponse {
    private String message;
    private String number;
    private List<Assignment> people;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Assignment> getPeople() {
        return people;
    }

    public void setPeople(List<Assignment> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "AstroResponse [message=" + message + ", number=" + number + ", people=" + people + "]";
    }

    public AstroResponse() {
    }

    public AstroResponse(String message, String number, List<Assignment> people) {
        this.message = message;
        this.number = number;
        this.people = people;
    }

}
