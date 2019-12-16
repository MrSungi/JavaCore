import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RWforImage {
    public static void main(String[] args) throws Exception {
        //from downloads
        FileInputStream fis = new FileInputStream("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\Wolf.png");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\Wolverine.png");

        int i=0;
        while((i=fis.read()) != -1){
            //System.out.print((char)i);
            fos.write(i);
        }

        System.out.println("Image...Reading & Writing is done!");





    }


}
