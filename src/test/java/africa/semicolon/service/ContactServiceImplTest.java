
package africa.semicolon.service;

import africa.semicolon.data.model.Contact;
import africa.semicolon.data.repository.ContactRepository;
import africa.semicolon.data.repository.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactService contactService;
    private ContactRepository contactRepository;
    @BeforeEach
    public void startWith(){
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl();
    }

    @Test
    public void saveContact_findContactReturnsContact(){
        contactService.addContact("asa", "bool", "1234");
        Contact contact = contactService.findById(1);
        assertEquals("asa",contact.getFirstName());
        assertEquals("bool",contact.getLastName());
        assertEquals("1234", contact.getPhoneNumber());

    }

    @Test
    public void testToFindByDifferentId(){
        contactService.addContact("asa", "bae","7788");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("kemi", "tola", "peace");
        Contact contact = contactService.findById(2);
        assertEquals("bae",contact.getFirstName());

    }



    @Test
    public void findContactByPhoneNumber(){
        contactService.addContact("asa", "hope", "8888");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("kemi", "peace","1235");

        Contact contact1 = contactService.findByPhoneNumber("4567");

        contact1.setPhoneNumber("1111");
        Contact contact2 = contactService.update(contact1);

        assertEquals("1111",contact2.getPhoneNumber());
        assertEquals("bae", contact1.getFirstName());
        assertEquals(3, contactService.count());
    }


    @Test
    public void testToDeleteAndUpdateContact(){
        contactService.addContact("bola", "faith", "1234");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("bola", "peace", "1567");
        Contact contact = contactService.findById(3);
        assertEquals("peace", contact.getLastName());
        contactService.delete(contact);
        assertEquals(2, contactService.count());

        Contact contact1 = contactService.findById(2);
        contact1.setFirstName("ade");
        contact1.setLastName("nut");
        Contact contact2 = contactService.update(contact1);
        assertEquals("nut", contact2.getLastName());
        assertEquals(2, contactService.count());

    }

    @Test
    public void findMyName(){
        contactService.addContact("bola", "faith", "1234");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("bola", "peace", "1567");

        Contact contact = contactService.findById(1);
        assertEquals("bola", contact.getFirstName());
        contact.setFirstName("lola");
        contactService.update(contact);
        contactService.delete(contact);

        ArrayList<Contact> find = contactService.findName("bola");

        assertEquals(2, contactService.count());
        Contact contact1 = contactService.findById(1);
        assertEquals("bae", contact1.getFirstName());

        contactService.addContact("Segun","seyi", "0999");
        assertEquals(3, contactService.count());
        Contact contact2 = contactService.findById(3);
        assertEquals("Segun", contact2.getFirstName());

        assertEquals("", find.toString());
    }



}
