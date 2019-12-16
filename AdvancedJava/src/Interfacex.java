public class Interfacex {

    public static void main(String[] args) {

        //Shape s = new Shape();
        Rectangle r = new Rectangle(5,8);
        System.out.println("Rectangle Area: " + r.getArea());
        System.out.println("Rectangle Perimeter: " + r.getPerimeter());

        Circle c = new Circle(7);
        System.out.println("Circle Area: " + c.getArea());
        System.out.println("Circle Perimeter: " + c.getPerimeter());

        Shape myShape = new Rectangle(8,8);
        System.out.println("Shape/Rectangle Area: " + myShape.getArea());
        System.out.println("Shape/Rectangle Perimeter: " + myShape.getPerimeter());
        System.out.println("Shape int a : " + Shape.a);

        //Shape.a = 16;  //interface variable is always final, and cannot be changed...

    }
}

interface Shape {
int a = 15;



    double getArea();
    double getPerimeter();

}

class Rectangle implements Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }
    @Override
    public double getPerimeter() {
        return (a + b)*2;
    }

}

class Circle implements Shape {
    private double r;


    public Circle(double r){
        this.r = r;

    }

    @Override
    public double getArea() {
        return r*r*3.1415;
    }
    @Override
    public double getPerimeter() {
        return 2*r*3.1415;
    }
}

