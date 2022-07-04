package africa.semicolon.service;
//
//import africa.semicolon.data.model.Contact;
//
//public interface ContactService {
//    void addContact(String firstName, String lastName, String phoneNumber);
//
//    void addContact(String firstName, String phoneNumber);
//
//    Contact findById(int id);
//    Contact findByFirstName(String firstName);
//    Contact findByLastName(String lastName);
//    void delete(Contact contact);
//}



import africa.semicolon.data.model.Contact;


import java.util.ArrayList;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int i);


    Contact update (Contact contact);

    Contact findByPhoneNumber(String phoneNumber);


    void delete(Contact contact);

    int count();

    ArrayList<Contact> findName(String name);

}


