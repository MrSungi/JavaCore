public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}//class




class ProgramToGo{
    public static void main(String[] args) {

        User Us1 = new User();

        Us1.setName("Ignas");
        System.out.println(Us1.getName());


    }//psvm
}//class