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
            interact(inputStream, db);
        } catch (IOException e) {
            System.out.printf("Database %s could not be loaded. \n", dbPath);
        }
    }

    public static void interact(InputStream inputStream, Database db) {
        boolean quit = false;
        boolean scriptMode = inputStream != System.in; //i.e. testing with an input file
        Scanner scanner = new Scanner(inputStream);

        while (!quit)
        {
            String line = scanner.nextLine();
            String[] param = line.split(" ");
            if (scriptMode) {
                System.out.println(line);
            }

            switch (param[0])
            {
                case "Q":
                case "Quit":
                    quit = true;
                    break;

                case "S":
                case "Student":
                    param = line.split(" ");
                    if(param.length < 3)
                        System.out.println("Student without bus");
                    else
                        System.out.println("Student with bus");
                    break;

                case "T":
                case "Teacher":
                    param = line.split(" ");
                    if(param.length == 2)
                        System.out.println("Valid Teacher command");
                    else
                        System.out.println("Invalid Teacher command");
                    break;

                case "B":
                case "Bus":
                    param = line.split(" ");
                    if(param.length == 2)
                        System.out.println("Valid Bus command");
                    else
                        System.out.println("Invalid Bus command");
                    break;

                case "G":
                case "Grade":
                    // G[rade]: <number>
                    if (param.length == 2) {
                        if (Util.validInt(param[1], "Please enter an integer for the grade.")) {
                            int number = Integer.parseInt(param[1]);
                            db.printGrade(number);
                        }
                        // G[rade]: <number> [H[igh]|L[ow]]
                    } else if (param.length == 3) {
                        System.out.println("Grade with high or low");
                        // Wrong format
                    } else {
                        System.out.println("Please format your query in the form " +
                                "G[rade]: <number> [H[igh]|L[ow]]");
                    }
                    break;
                case "A":
                case "Average":
                    System.out.println("Average");
                    break;
                case "I":
                case "Info":
                    System.out.println("Info");
                    break;
                default:
                    System.out.println("Please enter a valid input.");
            }
        }
    }
}

