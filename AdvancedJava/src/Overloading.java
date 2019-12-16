public class Overloading {
    public int add(int x, int y) {
        return (x + y);
    }

    public int add(int x, int y, int z) {
        return (x + y + z);
    }

    public double add(double x, double y) {
        return (x + y);
    }

    public String add(String x, String y) {
        return (x + y);
    }

    public String add(char x) {
        return "abcd..." + x;
    }

    public static void main(String args[]) {
        Overloading obj = new Overloading();
        System.out.println(obj.add(10, 20));
        System.out.println(obj.add(10, 20, 30));
        System.out.println(obj.add(10.5, 20.5));
        System.out.println(obj.add("YO, ", "Its me!"));
        System.out.println(obj.add('z'));
    }

    int x = 0;
    // int x = 5

    public void hi() {};
    // public void hi(){};

    public void makeStudent(String name, int age) {};

    public void makeStudent(int age, String name) {};

}
