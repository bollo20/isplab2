package laborator2;


public class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(float radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float)(Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + ", circle with radius " + radius;
    }
}

