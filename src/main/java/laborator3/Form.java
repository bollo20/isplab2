package laborator3;

public class Form {
    private String color;
    public static int counter=0;
    public int area;

public Form()
{
    this.color="white";
    counter++;
}
public Form(String color){
    this.color=color;
    counter++;
}
public  static String getCounter(){
    return "Sunt"+counter+"forme";
}
}
