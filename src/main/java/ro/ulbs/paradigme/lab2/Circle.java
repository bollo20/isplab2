package ro.ulbs.paradigme.lab2;

import ro.ulbs.paradigme.lab2.Form;

public  class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + " and is a Circle with area " + getArea();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            Circle c = (Circle) obj;
            return super.equals(obj) && this.radius==c.radius;
        }
        return false;
    }
}

