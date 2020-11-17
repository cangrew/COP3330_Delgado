import java.util.ArrayList;

public class TaskList extends ArrayList<TaskItem> {

    public void addTask(String t /* title */ , String d /* description */, String date ){
        TaskItem task = new TaskItem(t,d,date);
        this.add(task);
    }

    public void editTask(int pos, String t /* title */ , String d /* description */, String date ){
        this.get(pos).editTitle(t);
        this.get(pos).editDecription(d);
        this.get(pos).editDate(date);
    }

    public void markTask(int pos){
        this.get(pos).complete();
    }

    public void unMarkTask(int pos){
        this.get(pos).unComplete();
    }

    public void printUncompleted(){
        System.out.println("\nUncompleted Tasks\n--------------\n");
        int i = 0;
        for(TaskItem task : this){
            if(!task.isCompleted()){
                System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            }
            i++;
        }
    }

    public void printCompleted(){
        System.out.println("\nCompleted Tasks\n--------------\n");
        int i = 0;
        for(TaskItem task : this){
            if(task.isCompleted()){
                System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            }
            i++;
        }
    }

    public void printTaskList(){
        System.out.println("\nCurrent Tasks\n--------------\n");
        int i = 0;
        for(TaskItem task : this){
            if(task.isCompleted()){
                System.out.print(i + ") *** ");
            }else {
                System.out.print(i + ") ");
            }
            System.out.println("[" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            i++;
        }
    }

}
