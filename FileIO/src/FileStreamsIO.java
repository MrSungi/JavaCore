import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamsIO {
    public static void main(String[] args) throws Exception {
/*

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Dell\\Downloads\\FileStreams.txt");
        String str="This is going to be a really long line. We need to see" +
                "if the getBytes() method will execute this perfectly in one shot!" +
                "We will be using Streams to handle this File operation.";
        byte b[]=str.getBytes();//need to convert to a byte array
        fos.write(b);
        fos.close();

        System.out.println("File Output Stream has finished Writing...");
//for(int i = 0; i<b.length; i++){System.out.print(b[i]);}

*/

        FileInputStream fis=new FileInputStream("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileStreams.txt");
        int i=0;
        while((i=fis.read()) != -1){
            System.out.print((char)i);
        }
        fis.close();
        System.out.println("File Input Stream has finished Reading...");




    }
}
