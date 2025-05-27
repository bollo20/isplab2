package laborator2;


public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }

    public Triangle(float height, float base, String color) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", triangle with base " + base + " and height " + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle other = (Triangle) obj;
        return this.height == other.height &&
                this.base == other.base &&
                this.getColor().equals(other.getColor());
    }
}
