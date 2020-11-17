import java.io.*;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        menu();
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
        String name;
        TaskList list = new TaskList();
        System.out.print("Enter the filename to load: ");
        name = sc.nextLine();
        try{
            File fin = new File(name);
            Scanner finput = new Scanner(fin);
            while (finput.hasNextLine()) {
                list.addTask(finput.nextLine(),finput.nextLine(),finput.nextLine());
            }
            finput.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: Could not load list.");
            return;
        }
        operationMenu(list);
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
            case 2: addToList(list); break;
            case 3: editList(list); break;
            case 4: remove(list); break;
            case 5: mark(list); break;
            case 6: unMark(list); break;
            case 7: saveList(list); break;
            case 8: return;
        }
        operationMenu(list);
    }

    private static void addToList(TaskList list){
        String t,d,date;
        System.out.print("Task title: ");
        t = sc.nextLine();
        System.out.print("Task description: ");
        d = sc.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        date = sc.nextLine();
        list.addTask(t,d,date);
    }

    private static void editList(TaskList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        String t,d,date;
        int answer;

        list.printTaskList();
        System.out.print("\n\nWhich task will you edit?: ");
        answer = sc.nextInt();
        sc.nextLine();

        if(answer >= list.size()){
            System.out.println("WARNING: invalid Selection.");
            return;
        }

        System.out.print("Enter a new title for task "+answer+": ");
        t = sc.nextLine();
        System.out.print("Enter a new description for task "+answer+": ");
        d = sc.nextLine();
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task "+answer+": ");
        date = sc.nextLine();

        list.editTask(answer, t, d, date);
    }

    private static void remove(TaskList list){

        int answer;

        list.printTaskList();
        System.out.print("\n\nWhich task will you remove?: ");
        answer = sc.nextInt();
        sc.nextLine();

        list.removeTask(answer);
    }

    private static void mark(TaskList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        int answer;

        boolean empty = !list.printUncompleted();
        if(empty) return;
        System.out.print("\n\nWhich task will you mark as completed?: ");
        answer = sc.nextInt();
        sc.nextLine();
        list.markTask(answer);
    }

    private static void unMark(TaskList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        int answer;
        boolean empty = !list.printCompleted();
        if(empty) return;
        System.out.print("\n\nWhich task will you unmark as completed?: ");
        answer = sc.nextInt();
        sc.nextLine();
        list.unMarkTask(answer);
    }

    private static void saveList(TaskList list){
        if(list.size() < 1){
            System.out.println("WARNING: List is empty.");
            return;
        }
        String name;
        System.out.print("Enter the filename to save as: ");
        name = sc.nextLine();
        try{
            FileWriter fw = new FileWriter(name);
            for(TaskItem task : list){
                fw.write(task.getTitle()+"\n"+task.getDescription()+"\n"+task.getDate()+"\n");
            }
            fw.close();
            System.out.println("Task list has been saved.");
        }catch (IOException e){
            System.out.println("Error: Could not save list.");
        }
    }



}
