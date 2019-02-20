package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("account")
public class Account {

    @Transient
    public static final String SEQUENCE_NAME = "accounts_sequence";

    @Id
    Long id;
    String email;
    String firstName;
    String lastName;
    String password;
    String mobileNumber;
    Date dob;
    char gender;

    public Account(Long id, String email, String firstName, String lastName,
                   String password, String mobileNumber, Date dob, char gender) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Date getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }
}
