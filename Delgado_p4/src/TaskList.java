import java.util.ArrayList;

public class TaskList extends ArrayList<TaskItem> {

    public void addTask(String t /* title */ , String d /* description */, String date ){
        TaskItem task = new TaskItem(t,d,date);
        this.add(task);
    }

    public void printUncompleted(){
        System.out.println("\nUncompleted Tasks\n--------------\n");
        int i = 0;
        for(TaskItem task : this){
            if(task.isCompleted() == false){
                System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
                i++;
            }
        }
    }

    public void printTaskList(){
        System.out.println("\nCurrent Tasks\n--------------\n");
        int i = 0;
        for(TaskItem task : this){
            System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            i++;
        }
    }

}
