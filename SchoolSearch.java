import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class SchoolSearch
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
            String[] param = line.split(" ");
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
                            findGrade(number, studentInfo);
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

    public void Student()
    {

    }

    public void Teacher()
    {

    }

    public void Bus()
    {

    }

    // assumes studentInfo is properly formatted
    public static void findGrade(int qGrade, ArrayList<String[]> studentInfo) {
        for (String[] student : studentInfo) {
            int sGrade = Integer.parseInt(student[Util.Schema.GRADE.ordinal()]);
            if (qGrade == sGrade){
                System.out.println(student[Util.Schema.ST_LAST.ordinal()] +
                                ", " +
                                student[Util.Schema.ST_FIRST.ordinal()]);
            }
        }
    }

    public void Average()
    {

    }
    public void Info()
    {

    }
}

