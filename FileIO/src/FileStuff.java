import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.Files.createDirectory;

public class FileStuff {
    public static void main(String[] args) {

/*
        File tempFile = new File("myFile.txt");
        boolean exists = tempFile.exists();
        System.out.println(exists);
*/



        //need path
        //System.out.println("Read: " + Files.isReadable(tempFile));//error

        /*Path pathObj = Paths.get("myFile.txt");
        System.out.println("Read: " + Files.isReadable(pathObj));
        System.out.println("Write: " + Files.isWritable(pathObj));
        */



        /*Path path = Paths.get("New_dir/Sub_dir");//error
        try {
            Path newDirPath = Files.createDirectory(path);
        } catch(FileAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*Path path_to_make_NewDir = Paths.get("New_dir");//one by one
        try {
            Files.createDirectory(path_to_make_NewDir);
            Path path_to_make_subDir = Paths.get(path_to_make_NewDir.toString()+"/subDir");
            Files.createDirectory(path_to_make_subDir);

            System.out.println(path_to_make_NewDir.toString());
            System.out.println(path_to_make_subDir.toString());

        } catch(FileAlreadyExistsException e){
            System.out.println("ERROR1: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR2: " + e.getMessage());
        }*/


      /*  Path sourcePath      = Paths.get("myFile.txt");
        Path destinationPath = Paths.get("C:\\Users\\Dell\\Downloads");//error
        //Path destinationPath = Paths.get("C:\\Users\\Dell\\Downloads\\myCopy.txt");
        try {
            Files.copy(sourcePath, destinationPath);
        } catch(FileAlreadyExistsException e) {
            System.out.println("ERROR1: " + e.toString());
        } catch (IOException e) {
            System.out.println("ERROR2: " + e.toString());
        }*/

/*
        Path sourcePath      = Paths.get("myFile.txt");
        Path destinationPath = Paths.get("C:\\Users\\Dell\\Downloads\\myCopy.txt");
        //Path destinationPath = Paths.get("C:/Users/Dell/Downloads/myCopy.txt");//works on all systems
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            //Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("ERROR2: " + e.toString());
        }
*/

        Path f1 = Paths.get("myFile.txt");
        Path f2 = Paths.get("C:\\Users\\Ignas\\IdeaProjects\\FileIO\\src\\Files\\myCopy.txt");

        System.out.println("File name :"+ f1.getFileName() + "....|...." + f2.getFileName());
        System.out.println("Absolute path:" +f1.toAbsolutePath() + "....|...." + f2.toAbsolutePath());
        System.out.println("Parent:"+ f1.getParent() + "....|...." + f2.getParent());


        Path currentPath = Paths.get("");
        System.out.println(currentPath.toAbsolutePath());



        /*Path path = Paths.get("C:\\Users\\Dell\\Downloads\\myCopy.txt");
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("ERROR2: " + e.toString());
        }*/


    }

}
