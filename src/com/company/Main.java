package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("018381300");

    public static void main(String[] args) {


        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit){
            System.out.println("\n Enter action : Press 6 for menu");
           int action =  scanner.nextInt();
            scanner.nextLine();

            switch (action){

                case 0 :
                    System.out.println("\n Shutting down");
                    quit = true;
                    break;

                case 1:

                    // printActions();
                    mobilePhone.printContacts();
                    break;

                case 2:

                    addNewContact();
                    break;

                case 3 :
                    updateContact();
                    break;

                case 4 :
                    removeContact();
                    break;

                case 5 :
                    queryContact();
                    break;

                case 6 :
                    printActions();
                    break;
            }

        }




    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contacts newContacts = Contacts.createContacts(name,phone); //this why use createContacts method, also know as factory method, creating new class without creating new object or instance
        if(mobilePhone.addContact(newContacts)){

            System.out.println("New contact added: name = " + name + " phone = " + phone );
        }else{

            System.out.println("cannot add , " + name + " already on file");
        }
    }

    private static void updateContact(){

        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contacts existingContactsRecord = mobilePhone.queryContact(name);
        if(existingContactsRecord == null){

            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("enter new number");
        String newNumber = scanner.nextLine();
        Contacts newContacts = Contacts.createContacts(newName,newNumber);
        if(mobilePhone.updateContacts(existingContactsRecord,newContacts)){

            System.out.println("successfully updated record");
        }else{

            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {

        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contacts existingContactsRecord = mobilePhone.queryContact(name);
        if (existingContactsRecord == null) {

            System.out.println("Contact not found");
            return;
        }

        if( mobilePhone.removeContact(existingContactsRecord)){

            System.out.println("successfully deleted");
        }else{

            System.out.println("Error deleting record");
        }
    }

    private static void queryContact() {

        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contacts existingContactsRecord = mobilePhone.queryContact(name);
        if (existingContactsRecord == null) {

            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name : " + existingContactsRecord.getName() + " phone number : " + existingContactsRecord.getPhoneNumber());


    }

/*    private static void printContacts(){

        //have to decide on where to print contacts, going to Mobilephone class seems like best place instead of using for loop here
        mobilePhone.printContacts();

        //can also just delete this method and put above line in switch statement
    }*/

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions(){

        System.out.println("\nAvailable actions:\n");
        System.out.println("0 - to shutdown\n" +
        "1 - to print actions\n" +
        "2 - add new contact\n" +
        "3 - update existing contacts\n" +
        "4 - remove existing contact\n" +
        "5 - query if an existing contact exists\n" +
        "6 - print list of all actions available");
        System.out.println("Choose your actions");
    }
}
