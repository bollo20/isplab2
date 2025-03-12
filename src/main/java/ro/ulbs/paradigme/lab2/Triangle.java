package ro.ulbs.paradigme.lab2;
  class Triangle extends Form {
    private float height;
    private float base;
    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }
    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }
    @Override
    public float getArea() {
        return (height * base) / 2;
    }
    @Override
    public String toString() {
        return super.toString() + " and is a Triangle with area " + getArea();
    }


      public static class Circle extends Form {
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
                  Triangle triangle = (Triangle) obj;
                  return super.equals(obj) && height == triangle.height && base == triangle.base;
              }
          return false;
          }
