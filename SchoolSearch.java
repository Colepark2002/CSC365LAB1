import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class SchoolSearch
{
    public static void main(String[] args) {
        String dbPath = "students.txt";
        InputStream inputStream = System.in;
        try {
            Database db = new Database(dbPath);
            Util.interact(inputStream, db);
        } catch (IOException e) {
            System.out.printf("Database %s could not be initialized. \n", dbPath);
        }
    }
}

