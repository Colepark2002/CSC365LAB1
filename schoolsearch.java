import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class schoolsearch
{
    public static void main(String[] args) throws IOException {
        boolean quit = false;
        Scanner input = new Scanner(System.in);

        File file =  new File("students.txt");
        if(!file.canRead())
        {
            System.out.println("File students.txt does not exist");
        }

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String l;
        ArrayList<String[]> studentInfo = new ArrayList<>();
        while((l = br.readLine()) != null)
        {
            studentInfo.add(l.split(","));
        }


        while (!quit)
        {
            String line = input.nextLine();
            String[] param;
            switch (line)
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
                    param = line.split(" ");
                    if(param.length < 3)
                        System.out.println("Grade with High or Low ");
                    else
                        System.out.println("Grade without high or low");
                    System.out.println("Grade");
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

    public void Student()
    {

    }

    public void Teacher()
    {

    }

    public void Bus()
    {

    }

    public void Grade()
    {

    }

    public void Average()
    {

    }
    public void Info()
    {

    }
}

