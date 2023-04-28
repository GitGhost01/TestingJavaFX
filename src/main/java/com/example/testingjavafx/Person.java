package com.example.testingjavafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Return the firstName value i.e. "Bucky"
    public String getFirstName() {
        return firstName.get();
    }

    //Set firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
