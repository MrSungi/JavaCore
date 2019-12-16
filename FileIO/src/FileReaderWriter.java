import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {

        FileWriter fw;
        fw=new FileWriter("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileRW.txt");//,true);//write more
        fw.write("Hey! Whats Up... This is written with FileWriter!");
        fw.close();
        System.out.println("Writing is done....");


        FileReader fr = new FileReader("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileRW.txt");
        int i;
        while((i=fr.read()) != -1){
            System.out.print((char)i);//use println to see each char
            }
        fr.close();


        //For Text





}
}
