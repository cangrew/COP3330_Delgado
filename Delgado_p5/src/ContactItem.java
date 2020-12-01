public class ContactItem {
    private String name, lastname, number, email;

    public static ContactItem newContact(String n /* name */ , String l /* last name */, String num, String e ){
        ContactItem contact = new ContactItem();
        int filedFlag = 0;
        if(!contact.isValidNumber(num)){
            System.out.println("WARNING: invalid number; task not created.");
            return null;
        }
        if(!contact.isValidEmail(e)){
            System.out.println("WARNING: invalid email; task not created.");
            return null;
        }
        if(n.length() > 0 || l.length() > 0 || num.length() > 0 || e.length() > 0){
            filedFlag = 1;
        }
        if(filedFlag != 1){
            System.out.println("WARNING: Not enough fields; task not created.");
            return null;
        }
        contact.name = n;
        contact.lastname = l;
        contact.number = num;
        contact.email = e;
        return contact;
    }

    public void editContact(String n /* name */ , String l /* last name */, String num, String e ){
        int filedFlag = 0;
        if(!this.isValidNumber(num)){
            System.out.println("WARNING: invalid number; task not created.");
            return;
        }
        if(!this.isValidEmail(e)){
            System.out.println("WARNING: invalid email; task not created.");
            return;
        }
        if(n.length() > 0 || l.length() > 0 || num.length() > 0 || e.length() > 0){
            filedFlag = 1;
        }
        if(filedFlag != 1){
            System.out.println("WARNING: Not enough fields; task not created.");
            return;
        }
        this.name = n;
        this.lastname = l;
        this.number = num;
        this.email = e;
    }

    private boolean isValidNumber(String num){
        //if(num.length() != 12) return false;
        for(int i = 0; i < num.length();i++){
            if(i < 3 || (i >3 && i <7) || i > 7){
                if(!Character.isDigit(num.charAt(i))){
                    return false;
                }
            }
            if(i == 3 || i == 7) {
                if (num.charAt(i) != '-') {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidEmail(String e){
        if(e.isBlank()) return true;
        if(!(e.contains("@")) || !(e.contains("."))) return false;
        if(e.indexOf('@') > e.indexOf('.')) return false;
        return e.indexOf('@') > 0 && e.indexOf('.') < e.length() - 1 && (e.indexOf('.') - e.indexOf('@') > 1);
    }

    public String toString(){
        String str = "Name: " + this.name + " " + this.lastname + "\nPhone: " + this.number + "\nEmail: " + this.email;
        return str;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
