import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileBufferedRW {
    public static void main(String[] args)throws Exception {

    FileWriter fw = new FileWriter("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileBufferRW.txt");
        BufferedWriter buffer = new BufferedWriter(fw);
        buffer.write("We have written this using File Buffer");
        buffer.close();
        fw.close();//cant put this before buffer.close()
        System.out.println("Writing has been done!");


        FileReader fr = new FileReader("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileBufferRW.txt");
        BufferedReader buffer2 = new BufferedReader(fr);
        int i;
        while((i=buffer2.read()) != -1){
            System.out.println((char)i);
        }
        buffer.close();
        fr.close();
        System.out.println("Reading the file is over...");


    }
}
