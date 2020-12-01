import java.io.*;
import java.util.Scanner;

public class ContactApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        System.out.println("\nMain Menu");
        System.out.println("---------\n");
        System.out.print("1) create a new list\n2) load an existing list\n3) quit\n\nEnter Selection: ");
        int answer = sc.nextInt();
        sc.nextLine();
        switch (answer){
            case 1: newList(); break;
            case 2: loadList(); break;
            case 3: return;
        }
        menu();
    }

    private static void newList(){
        System.out.println("New task list has been created.");
        ContactList list = new ContactList();
        operationMenu(list);
    }

    public static void loadList(){
        String name;
        ContactList list = new ContactList();
        System.out.print("Enter the filename to load: ");
        name = sc.nextLine();
        try{
            File fin = new File(name);
            Scanner finput = new Scanner(fin);
            while (finput.hasNextLine()) {
                list.addContact(finput.nextLine(),finput.nextLine(),finput.nextLine(),finput.nextLine());
            }
            finput.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: Could not load list.");
            return;
        }
        operationMenu(list);
    }
    public static ContactList loadList(String add){
        ContactList list = new ContactList();
        try{
            File fin = new File(add);
            Scanner finput = new Scanner(fin);
            while (finput.hasNextLine()) {
                list.addContact(finput.nextLine(),finput.nextLine(),finput.nextLine(),finput.nextLine());
            }
            finput.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: Could not load list.");
            return null;
        }
        return list;
    }

    private static void operationMenu(ContactList list){
        System.out.println("\nList Operation Menu\n---------\n");
        System.out.print("1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n\nEnter Selection: ");
        int answer = sc.nextInt();
        sc.nextLine();
        switch (answer){
            case 1: list.printContactList(); break;
            case 2: addToList(list); break;
            case 3: editList(list); break;
            case 4: remove(list); break;
            case 5: saveList(list); break;
            case 6: return;
        }
        operationMenu(list);
    }

    public static void addToList(ContactList list){
        String n,l,num,e;
        System.out.print("First name: ");
        n = sc.nextLine();
        System.out.print("Last name: ");
        l = sc.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        num = sc.nextLine();
        System.out.print("Email address (x@y.z): ");
        e = sc.nextLine();
        list.addContact(n,l,num,e);
    }

    public static void editList(ContactList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        String n,l,num,e;
        int answer;

        list.printContactList();
        System.out.print("\n\nWhich Contact will you edit?: ");
        answer = sc.nextInt();
        sc.nextLine();

        if(answer >= list.size()){
            System.out.println("WARNING: invalid Selection.");
            return;
        }

        System.out.print("Enter a new name for contact "+answer+": ");
        n = sc.nextLine();
        System.out.print("Enter a new last name for contact "+answer+": ");
        l = sc.nextLine();
        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact "+answer+": ");
        num = sc.nextLine();
        System.out.print("Enter a new email address (x@y.z) for contact "+answer+": ");
        e = sc.nextLine();

        list.editContactAt(answer, n, l, num, e);
    }

    public static void remove(ContactList list){

        int answer;

        list.printContactList();
        System.out.print("\n\nWhich contact will you remove?: ");
        answer = sc.nextInt();
        sc.nextLine();

        list.removeContact(answer);
    }



    public static void saveList(ContactList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        String name;
        System.out.print("Enter the filename to save as: ");
        name = sc.nextLine();
        try{
            FileWriter fw = new FileWriter(name);
            for(ContactItem task : list){
                fw.write(task.getName()+"\n"+task.getLastname()+"\n"+task.getNumber()+"\n"+task.getEmail()+"\n");
            }
            fw.close();
            System.out.println("Contact list has been saved.");
        }catch (IOException e){
            System.out.println("Error: Could not save list.");
        }
    }

    public static void saveList(ContactList list, String name){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }

        try{
            FileWriter fw = new FileWriter(name);
            for(ContactItem task : list){
                fw.write(task.getName()+"\n"+task.getLastname()+"\n"+task.getNumber()+"\n"+task.getEmail()+"\n");
            }
            fw.close();
            System.out.println("Contact list has been saved.");
        }catch (IOException e){
            System.out.println("Error: Could not save list.");
        }
    }


}
