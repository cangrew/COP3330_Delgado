import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        menu();
        TaskList list = new TaskList();
        TaskItem a = new TaskItem("task 1","task number 1", "2000-12-12");
        list.add(a);
        list.printUncompleted();

    }

    private static void menu(){
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
        TaskList list = new TaskList();
        operationMenu(list);


    }

    private static void loadList(){

    }

    private static void operationMenu(TaskList list){
        System.out.println("\nList Operation Menu\n---------\n");
        System.out.print("1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n\nEnter Selection: ");
        int answer = sc.nextInt();
        sc.nextLine();
        switch (answer){
            case 1: list.printTaskList(); break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            case 8: return;
        }
        operationMenu(list);
    }
}
