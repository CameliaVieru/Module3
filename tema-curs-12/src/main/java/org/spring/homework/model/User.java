package org.spring.homework.model;

public class User {

    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private String dateOfBirth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
