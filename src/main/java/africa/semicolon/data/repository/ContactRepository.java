package africa.semicolon.data.repository;

import africa.semicolon.data.model.Contact;

import java.util.ArrayList;


public interface ContactRepository {
    Contact save(Contact contact);
    Contact findById(int id);

    Contact findByPhoneNumber(String phoneNumber);
    void delete(Contact contact);

    int count();

    ArrayList<Contact> findByName(String name);
}

