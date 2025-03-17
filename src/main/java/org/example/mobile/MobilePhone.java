package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // Constructor with myNumber and a list of contacts
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts); // Create a new ArrayList from the provided list
    }

    // Getter methods
    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    // Method to add a new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    // Method to update an existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println("Contact not found.");
            return false;
        }
        myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    // Method to remove a contact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println("Contact not found.");
            return false;
        }
        myContacts.remove(position);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    // Method to find the index of a contact (using Contact object)
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Method to find the index of a contact (using name)
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Method to query a contact by name
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    // Method to print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}