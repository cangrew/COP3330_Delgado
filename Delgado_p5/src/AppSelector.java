import java.util.Scanner;

public class AppSelector {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        menu();
    }

    private static void menu(){
        int sel = 0;
        System.out.println("\nSelect Your Application\n-----------------------\n");
        System.out.println("1) task list\n" +
                "2) contact list\n" +
                "3) quit\n");
        sel = sc.nextInt();
        sc.nextLine();
        switch(sel){
            case 1: TaskApp.menu() ;break;
            case 2: ContactApp.menu(); break;
            case 3: return;
        }
        menu();
    }

}
