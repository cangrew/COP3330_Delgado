import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    void addingTaskItemsIncreasesSize() {
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        assertEquals(1,test.size());
    }

    @Test
    void editingItemsFailsWithAllBlankValues(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        test.editContactAt(0,"","","", "");
        assertEquals("Andres", test.get(0).getName());
        assertEquals("Delgado",test.get(0).getLastname());
        assertEquals("202-101-1032",test.get(0).getNumber());
        assertEquals("a@b.c",test.get(0).getEmail());
        assertEquals(1,test.size());
    }

    @Test
    void editingItemsFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        boolean t = test.editContactAt(2,"test2","test2","102-123-2000", "a@b.c");
        assertFalse(t);
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        test.editContactAt(0,"","Del","123-123-1234", "a@b.d");
        assertEquals("", test.get(0).getName());
        assertEquals("Del",test.get(0).getLastname());
        assertEquals("123-123-1234",test.get(0).getNumber());
        assertEquals("a@b.d",test.get(0).getEmail());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        test.editContactAt(0,"David","","123-123-1234", "a@b.d");
        assertEquals("David", test.get(0).getName());
        assertEquals("",test.get(0).getLastname());
        assertEquals("123-123-1234",test.get(0).getNumber());
        assertEquals("a@b.d",test.get(0).getEmail());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        test.editContactAt(0,"David","Del","", "a@b.d");
        assertEquals("David", test.get(0).getName());
        assertEquals("Del",test.get(0).getLastname());
        assertEquals("",test.get(0).getNumber());
        assertEquals("a@b.d",test.get(0).getEmail());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        test.editContactAt(0,"David","Del","123-123-1234", "a@b.d");
        assertEquals("David", test.get(0).getName());
        assertEquals("Del",test.get(0).getLastname());
        assertEquals("123-123-1234",test.get(0).getNumber());
        assertEquals("a@b.d",test.get(0).getEmail());
    }

    @Test
    void newListIsEmpty() {
        ContactList test = new ContactList();
        assertEquals(0,test.size());
    }

    @Test
    void removingItemsDecreasesSize(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        assertEquals(1,test.size());
        test.removeContact(0);
        assertEquals(0,test.size());
    }

    @Test
    void removingItemsFailsWithInvalidIndex() {
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        assertFalse(test.removeContact(3));
        assertEquals(1,test.size());
    }

    @Test
    void savedContactListCanBeLoaded(){
        ContactList test = new ContactList();
        test.addContact("Andres","Delgado","202-101-1032", "a@b.c");
        ContactApp.saveList(test,"test.txt");
        ContactList test2 = ContactApp.loadList("test.txt");
        System.out.println(test2.toString());
        assertEquals(test2.toString(),test.toString());
    }

}