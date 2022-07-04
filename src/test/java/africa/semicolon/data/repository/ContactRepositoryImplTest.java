package africa.semicolon.data.repository;

import africa.semicolon.data.model.Contact;
import africa.semicolon.exception.NoContactException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;
    private Contact contact;
    @BeforeEach
    public void  startWith(){
        contact = new Contact();
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void testThatWeHaveAContact(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact saveMyContact = contactRepository.save(contact);
        assertEquals("make", saveMyContact.getFirstName());
        assertEquals(1, saveMyContact.getId());

    }

    @Test
    public void testThatYouCanSaveMoreThanOneTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);

        assertEquals("make", contact2.getFirstName());
        assertEquals(1, contact2.getId());

        assertEquals("sol", contact3.getFirstName());
        assertEquals(2, contact3.getId());
        assertEquals(2, contactRepository.count());

    }

    @Test
    public void findContactByIdTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);

        Contact findMyContact = contactRepository.findById(1);
        assertEquals("Bola", findMyContact.getLastName());

    }

    @Test
    public void findContactByFirstNameTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);




    }

    @Test
    public void findContactByLastNameTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);
    }

    @Test
    public void findByPhoneNumberTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);

        Contact findMyContact = contactRepository.findByPhoneNumber("1233");
        assertEquals(2, findMyContact.getId());
    }

    @Test
    public void deleteContactTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);

        Contact findMyContact = contactRepository.findByPhoneNumber("1233");
        assertEquals(2, findMyContact.getId());

        contactRepository.delete(contact1);
        assertEquals(1, contactRepository.count());

        assertThrows(NoContactException.class, () -> contactRepository.findByPhoneNumber("1233"));

    }

    @Test
    public void updateContactTest(){
        contact.setFirstName("make");
        contact.setLastName("Bola");
        contact.setPhoneNumber("1223");

        Contact contact1 = new Contact();
        contact1.setFirstName("sol");
        contact1.setLastName("ola");
        contact1.setPhoneNumber("1233");

        Contact contact2 = contactRepository.save(contact);
        Contact contact3 = contactRepository.save(contact1);


        Contact findMyContact = contactRepository.findById(1);
        assertEquals("make", findMyContact.getFirstName());

        Contact findMyContact2 = contactRepository.findByPhoneNumber("1233");
        assertEquals(2, findMyContact2.getId());

    }

}
