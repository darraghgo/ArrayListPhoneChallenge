package com.company;

import java.util.ArrayList;

public class MobilePhone {

  private String myNumber;
  private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contacts){

        if(findContact(contacts.getName()) >= 0){

            System.out.println("Contact already exists");
            return false;
        }

        myContacts.add(contacts);
        return true;
    }

    private int findContact(Contacts contacts){

        return this.myContacts.indexOf(contacts);
    }

    public boolean updateContacts(Contacts oldContact, Contacts newContact){

        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }else if(findContact(newContact.getName()) != -1){

            System.out.println("Contact with the name " +  newContact.getName() + " already exists");
            return false;
        }

        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " was replaced with : " + newContact.getName() );
        return true;
    }

    public boolean removeContact(Contacts contacts){


        int foundPosition = findContact(contacts);
        if(foundPosition < 0){
            System.out.println(contacts.getName() + " was not found");
            return false;
        }

        this.myContacts.remove(foundPosition);
        System.out.println(contacts.getName() + " was removed"  );
        return true;

    }

    private int findContact(String contactName){

        for(int i = 0; i < this.myContacts.size(); i++){

            Contacts contacts = this.myContacts.get(i); //new object created so we can search through array of objects
            if(contacts.getName().equals(contactName)){

                return i;
            }
        }

        return -1;
    }

    public String queryContact(Contacts contacts){

        if(findContact(contacts) >= 0 ){

            return contacts.getName();
        }

        return null;
    }

    public Contacts queryContact(String name){

        int position = findContact(name);
        if(position >= 0){

            return this.myContacts.get(position);
        }

        return null;
    }

    public void printContacts(){

        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++){

            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}



