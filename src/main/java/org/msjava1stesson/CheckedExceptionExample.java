package org.msjava1stesson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheckedExceptionExample {

    public static void main(String[] args) throws IOException {
        Exception e = new Exception("Checked exception");
       // List<String> con = getConte("sad");
        //System.out.println(con);

       // throw new EntitiNotDoundExeption("MESSaGE");

        try(FileReader fr = new FileReader(new File(""))) {
            fr.read();
            return;
        }
        catch (IOException e1) {
            throw new EntitiNotDoundExeption("MESSaGE!!!");
        }
    }

    private static List<String> getConte(String name)  throws IOException {

//        try {
//            return Files.readAllLines(Path.of(name));
//        } catch (IOException e) {
//            System.out.print("dfghjk"+e.getMessage());
//            return List.of();
//        }
        return Files.readAllLines(Path.of(name));
    }
}
