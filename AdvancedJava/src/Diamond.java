public class Diamond {
    public static void main(String[] args) {

        ABi obj = new ABi();
        obj.duplicate();
        obj.XXX();
        //obj.doWork();
    }
}

class A{
    public void doWork(){
        System.out.println("From A");
    }
}


class B{
    public void doWork(){
        System.out.println("From A");
    }
}
/*

class AB extends A,B{

}


*/
interface X{
    void XXX();
}

interface Ai extends X{
    @Override
    default void XXX() {
        System.out.println("from Ai for XXX");
    }

    void duplicate();

}


interface Bi extends X{
    @Override
    default void XXX() {
        System.out.println("from Bi for XXX");
    }

    void duplicate();

}

class ABi implements Ai,Bi{
    @Override
    public void XXX() {
        System.out.println("from ABi for XXX");
    }

    @Override
    public void duplicate() {
        System.out.println("From ABi");
    }

}
/*
From X to Ai/Bi
Implementation means giving a body in Ai/Bi
But plane overriding will just declare the same abstract method with no body Ai/Bi
once implemented with a body, the Interfaces method will obviously become Default

Class ABi wont be allowed to proceed without overriding or implementing
the common Default method

Why classes cant pass the Diamond Problem
But if class AB was to extend abstract A ... and ... abstract B...
and both of them have provided a body to the common method,
you are not forced to still override or implement a body for that method.

*/
