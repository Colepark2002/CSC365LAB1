import java.io.*;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String dbPath = "students.txt";
        try {
            makeTestIn("testIn.txt");
            InputStream inputStream = new FileInputStream("testIn.txt");
            try {
                Database db = new Database(dbPath);
                Util.interact(inputStream, db);
            } catch (IOException e) {
                System.out.printf("Database %s could not be initialized. \n", dbPath);
            }
        } catch (Exception e) {
            System.out.println("testIn failed to generate");
        }
    }


    public static void makeTestIn(String pathname) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));
        InputStream inputStream = new FileInputStream("tests.txt");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (!line.startsWith("//") && !line.isEmpty()) {
                writer.write(line + "\n");
            }
        }
        writer.close();
    }

}
