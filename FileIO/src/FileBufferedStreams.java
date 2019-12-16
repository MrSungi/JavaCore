import java.io.*;

public class FileBufferedStreams {
    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileBufferedStreams.txt");
        BufferedOutputStream buffer = new BufferedOutputStream(fos);
        String str="Now we are using Buffered Streams. The same IO Streams" +
                " but we will wrap them in a buffer for better performance!";
        byte b[]=str.getBytes();
        buffer.write(b);
        buffer.flush();
        buffer.close();
        fos.close();
        System.out.println("Buffer has finished writing.. ");


        FileInputStream fis = new FileInputStream("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\FileBufferedStreams.txt");
        BufferedInputStream buffer1 = new BufferedInputStream(fis);
        int i;
        while((i=buffer1.read()) != -1){
            System.out.print((char)i);
        }
        buffer.close();
        fis.close();

        System.out.println("Buffer has finished writing... ");

        //For Bytes

    }
}
