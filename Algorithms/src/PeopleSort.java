class Person{
    int age;
    String name;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}


public class PeopleSort {
    public static void main(String[] args) {

    Person p1 = new Person("Ignas", 24);
    Person p2 = new Person("Jonas", 35);
    Person p3 = new Person("Petras", 65);
    Person p4 = new Person("Stasys", 13);
    Person p5 = new Person("Maryte", 18);
    Person p6 = new Person("Ruta", 23);

    Person[]arr = {p1,p2,p3,p4,p5,p6};


        System.out.println("Before sorting>>");
    for(int i = 0; i <arr.length;i++){
        System.out.println(i+1 + ". Narys: " + arr[i].name + " Metai: " + arr[i].age);
    }

        System.out.println("*********************************************\n");

        PersonSort(arr);
        System.out.println("After sorting>>");
        for(int i = 0; i <arr.length;i++){
            System.out.println(i+1 + ". Narys: " + arr[i].name + " Metai: " + arr[i].age);
        }
    }



    public static void PersonSort(Person arr[]){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){ // 1 optimization used
                if (arr[j].age > arr[j+1].age){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


}//class
