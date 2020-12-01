import java.util.ArrayList;

public class TaskList extends ArrayList<TaskItem> {

    public void addTask(String t /* title */ , String d /* description */, String date ){
        TaskItem task = TaskItem.newTask(t,d,date);
        if(task == null){
            return;
        }
        this.add(task);
    }

    public boolean editTask(int pos, String t /* title */ , String d /* description */, String date ){
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.get(pos).editTitle(t);
        this.get(pos).editDescription(d);
        this.get(pos).editDate(date);
        return true;
    }

    public boolean removeTask(int pos) {
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.remove(pos);
        return true;
    }

    public boolean markTask(int pos){
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.get(pos).complete();
        return true;
    }

    public boolean unMarkTask(int pos){
        if(pos >= this.size()){
            System.out.println("WARNING: Invalid Position.");
            return false;
        }
        this.get(pos).unComplete();
        return true;
    }

    public boolean printUncompleted(){
        System.out.println("\nUncompleted Tasks\n--------------\n");
        int i = 0;
        boolean empty = true;
        for(TaskItem task : this){
            if(!task.isCompleted()){
                empty = false;
            }
            i++;
        }
        if(empty){
            System.out.println("WARNING: no uncompleted tasks.");
            return false;
        }
        for(TaskItem task : this){
            if(!task.isCompleted()){
                System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            }
            i++;
        }
        return true;
    }

    public boolean printCompleted(){
        System.out.println("\nCompleted Tasks\n--------------\n");
        int i = 0;
        boolean empty = true;
        for(TaskItem task : this){
            if(task.isCompleted()){
                empty = false;
            }
            i++;
        }
        if(empty){
            System.out.println("WARNING: no completed tasks.");
            return false;
        }
        for(TaskItem task : this){
            if(task.isCompleted()){
                System.out.println(i + ") [" + task.getDate() + "] " + task.getTitle() + ": " + task.getDescription());
            }
            i++;
        }
        return true;
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
