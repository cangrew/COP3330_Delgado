import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    void creationFailsWithAllBlankValues(){
        ContactItem test = ContactItem.newContact("","","","");
        assertNull(test);
    }

    @Test
    void creationSucceedsWithBlankEmail(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","");
        assertNotNull(test);
        assertEquals("Andres", test.getName());
        assertEquals("Delgado",test.getLastname());
        assertEquals("123-123-1234",test.getNumber());
        assertEquals("",test.getEmail());
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        ContactItem test = ContactItem.newContact("","Delgado","123-123-1234","a@b.c");
        assertNotNull(test);
        assertEquals("", test.getName());
        assertEquals("Delgado",test.getLastname());
        assertEquals("123-123-1234",test.getNumber());
        assertEquals("a@b.c",test.getEmail());
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        ContactItem test = ContactItem.newContact("Andres","","123-123-1234","a@b.c");
        assertNotNull(test);
        assertEquals("Andres", test.getName());
        assertEquals("",test.getLastname());
        assertEquals("123-123-1234",test.getNumber());
        assertEquals("a@b.c",test.getEmail());
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","","a@b.c");
        assertNotNull(test);
        assertEquals("Andres", test.getName());
        assertEquals("Delgado",test.getLastname());
        assertEquals("",test.getNumber());
        assertEquals("a@b.c",test.getEmail());
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        assertNotNull(test);
        assertEquals("Andres", test.getName());
        assertEquals("Delgado",test.getLastname());
        assertEquals("123-123-1234",test.getNumber());
        assertEquals("a@b.c",test.getEmail());
    }

    @Test
    void editingFailsWithAllBlankValues(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("","","","");
        assertNotNull(test);
        assertEquals("Andres", test.getName());
        assertEquals("Delgado",test.getLastname());
        assertEquals("123-123-1234",test.getNumber());
        assertEquals("a@b.c",test.getEmail());
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("David","Del","321-321-4321","");
        assertNotNull(test);
        assertEquals("David", test.getName());
        assertEquals("Del",test.getLastname());
        assertEquals("321-321-4321",test.getNumber());
        assertEquals("",test.getEmail());
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("","Del","321-321-4321","b@c.d");
        assertNotNull(test);
        assertEquals("", test.getName());
        assertEquals("Del",test.getLastname());
        assertEquals("321-321-4321",test.getNumber());
        assertEquals("b@c.d",test.getEmail());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("David","","321-321-4321","b@c.d");
        assertNotNull(test);
        assertEquals("David", test.getName());
        assertEquals("",test.getLastname());
        assertEquals("321-321-4321",test.getNumber());
        assertEquals("b@c.d",test.getEmail());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("David","Del","","b@c.d");
        assertNotNull(test);
        assertEquals("David", test.getName());
        assertEquals("Del",test.getLastname());
        assertEquals("",test.getNumber());
        assertEquals("b@c.d",test.getEmail());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        test.editContact("David","Del","321-321-4321","b@c.d");
        assertNotNull(test);
        assertEquals("David", test.getName());
        assertEquals("Del",test.getLastname());
        assertEquals("321-321-4321",test.getNumber());
        assertEquals("b@c.d",test.getEmail());
    }

    @Test
    void testToString(){
        ContactItem test = ContactItem.newContact("Andres","Delgado","123-123-1234","a@b.c");
        String str = test.toString();
        assertEquals("Name: Andres Delgado\nPhone: 123-123-1234\nEmail: a@b.c",str);
    }

}