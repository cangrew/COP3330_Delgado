import java.util.ArrayList;

public class ContactList extends ArrayList<ContactItem> {

    public void addContact(String n /* name */ , String l /* last name */, String num, String e ){
        ContactItem contact = ContactItem.newContact(n,l,num,e);
        if(contact == null){
            return;
        }
        this.add(contact);
    }

    public boolean editContactAt(int pos, String n /* name */ , String l /* last name */, String num, String e){
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.get(0).editContact(n,l,num,e);
        return true;
    }


    public boolean removeContact(int pos) {
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.remove(pos);
        return true;
    }




    public void printContactList(){
        System.out.println("\nCurrent Tasks\n--------------\n");
        int i = 0;
        for(ContactItem contact : this){
            System.out.println(i + " ) Name: "+contact.getName()+" "+contact.getLastname()+"\nPhone: "+contact.getNumber()+"\nEmail: "+contact.getEmail()+"\n" );
            i++;
        }
    }

}
