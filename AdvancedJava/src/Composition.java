public class Composition {
    public static void main(String[] args) {

        Owner me = new Owner("iOS", 14, 99);
        me.getMyStatus();
    }
}

class OS{
    String name;
    public OS(String name){
        this.name=name;
    }
    
    public String getStatus(){
        if(name.equals("Android")){return "Cool OS";}
        else if(name.equals("iOS")){return "hmmm... gerai!";}
        else{return "Blogai!";}// missing return statement
    }
}

class Version {
    int version;

    public Version(int version) {
        this.version = version;
    }

    public String getStatus() {
        if (version > 10) {
            return "Great!";
        } else if (version < 10) {
            return "Please Update,,,";
        } else {
            return "Special Case!";
        }
    }
}

class Battery{
    int power;

    public Battery(int power){
        this.power= power;
    }

    public String getStatus(){
        if (power > 100) {
            return "Much power";
        } else if (power < 100) {
            return "So low man,,,";
        } else {
            return "Cool dude";
        }
    }

}


    class Owner{
        Version v;
        OS os;
        Battery b;


        public Owner(String os, int v, int b){
            this.os= new OS(os);
            this.v = new Version(v);
            this.b = new Battery(b);
        }

        public void getMyStatus(){
            System.out.println(os.getStatus());
            System.out.println(v.getStatus());
            System.out.println(b.getStatus());
        }
    }
