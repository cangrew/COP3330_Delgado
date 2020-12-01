public class TaskItem {

    private String title, description, date;
    private boolean completed;

    public static TaskItem newTask(String t /* title */ , String d /* description */, String date ){
        TaskItem task = new TaskItem();
        if(t.length() < 1){
            System.out.println("WARNING: title must be at least 1 character long; task not created.");
            return null;
        }
        if(!task.isValidDate(date)){
            System.out.println("WARNING: invalid due date; task not created.");
            return null;
        }
        task.title = t;
        task.description = d;
        task.date = date;
        task.completed = false;
        return task;
    }
    private boolean isValidDate(String date){
        if(date.length() != 10) return false;
        for(int i = 0; i < date.length();i++){
            if(i < 4 || (i >4 && i <7) || i > 7){
                if(!Character.isDigit(date.charAt(i))){
                    return false;
                }
            }
            if(i == 4 || i == 7) {
                if (date.charAt(i) != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public String getTitle(){
        return title;
    }

    public boolean editTitle(String t){
        if(t.length() < 1){
            System.out.println("WARNING: title must be at least 1 character long; title not changed.");
            return false;
        }
        title = t;
        return true;
    }

    public String getDescription(){
        return description;
    }

    public void editDescription(String d){
        description = d;
    }

    public String getDate(){
        return date;
    }

    public boolean editDate(String date){
        if(!isValidDate(date)){
            System.out.println("WARNING: invalid due date; date not changed.");
            return false;
        }
        this.date = date;
        return true;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void complete(){
        completed = true;
    }

    public void unComplete(){
        completed = false;
    }

    public String toString(){
        String str = "Tittle: " + this.title + "\nDescription: " + this.description + "\nDate: " + this.date;
        return str;
    }

}
