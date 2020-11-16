public class TaskItem {

    private String title, description, date;
    private boolean completed;

    public TaskItem(String t /* title */ , String d /* description */, String date ){
        title = t;
        description = d;
        this.date = date;
        completed = false;
    }

    public String getTitle(){
        return title;
    }

    public void editTitle(String t){
        title = t;
    }

    public String getDescription(){
        return description;
    }

    public void editDecription(String d){
        description = d;
    }

    public String getDate(){
        return date;
    }

    public void editDate(String date){
        this.date = date;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void complete(){
        completed = true;
    }

}
