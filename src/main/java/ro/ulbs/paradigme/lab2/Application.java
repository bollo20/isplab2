package ro.ulbs.paradigme.lab2;

public class Application {
    public static void main(String[] args) {
        Triangle tri = new Triangle("red", 1.1F, 2.0F);
        Circle c = new Circle("yellow", 1.5F);
        Square sq = new Square("blue", 1.2F);
        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        
        Triangle tri2 = new Triangle("red", 1.1F, 2.0F);
        System.out.println("Triangle2 equals to Triangle1: " + tri.equals(tri2));
        
        Triangle tri3 = new Triangle("brown", 1.1F, 2.0F);
        System.out.println("Triangle3 equals to Triangle1: " + tri.equals(tri3));
    }
}
