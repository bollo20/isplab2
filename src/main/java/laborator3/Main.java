package laborator3;


public class Main {
    public static void main(String[] args) {
        Form form1 = new Form();
        Form form2 = new Form("red");
        Form form3 = new Form("blue");

        System.out.println("Number of Form instances created: " + Form.getCounter());
       // ro.ulbs.paradigme.lab3.util.PasswordMaker passwordMaker = ro.ulbs.paradigme.lab3.util.PasswordMaker.getInstance();
       // System.out.println("Generated Password: " + passwordMaker.getPassword());
       // System.out.println("getInstance() called " + ro.ulbs.paradigme.lab3.util.PasswordMaker.getAccessCounter() + " times");
    }
}



