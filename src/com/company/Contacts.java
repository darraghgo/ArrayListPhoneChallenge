package com.company;

public class Contacts  {

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacts createContacts(String name, String phoneNumber){
        //this used to create a new contact, will be useful for accessing later
        return new Contacts(name,phoneNumber);
    }
}
