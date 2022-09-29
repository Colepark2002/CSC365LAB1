import java.io.InputStream;
import java.util.Scanner;

public class Util {
    /**
     * @param value the string you want to validate
     * @param errorMessage the message to print if validation fails
     * @return true if value can be parsed as an int, false otherwise
     */
    public static boolean validInt(String value, String errorMessage) {
        boolean valid = validInt(value);
        if (!valid) {
            System.out.println(errorMessage);
        }
        return valid;
    }

    /**
     * @param value the string you want to validate
     * @return true if value can be parsed as an int, false otherwise
     */
    public static boolean validInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param value the string you want to validate
     * @return true if value can be parsed as a double, false otherwise
     */
    public static boolean validDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

                case "S:":
                case "Student:":
                    param = line.split(" ");
                    db.student(param[1], param.length >= 3);
                    break;

                case "T:":
                case "Teacher:":
                    param = line.split(" ");
                    if(param.length == 2)
                        db.teacher(param[1]);
                    else
                        System.out.println("Invalid Teacher command");
                    break;

                case "B:":
                case "Bus:":
                    param = line.split(" ");
                    if(param.length == 2)
                        db.bus(Integer.parseInt(param[1]));
                    else
                        System.out.println("Invalid Bus command");
                    break;

                case "G:":
                case "Grade:":
                    // G[rade]: <number>
                    if (param.length == 2) {
                        if (Util.validInt(param[1], "Please enter an integer for the grade.")) {
                            int number = Integer.parseInt(param[1]);
                            db.printGrade(number);
                        }
                        // G[rade]: <number> [H[igh]|L[ow]]
                    } else if (param.length == 3) {
                        if (Util.validInt(param[1], "Please enter an integer for the grade.")) {
                            int number = Integer.parseInt(param[1]);
                            if (param[2].equals("H") || param[2].equals("High")) {
                                db.printHighGrade(number);
                            } else if (param[2].equals("L") || param[2].equals("Low")) {
                                db.printLowGrade(number);
                            } else {
                                System.out.println("Please format your query in the form " +
                                        "G[rade]: <number> [H[igh]|L[ow]]");
                            }
                        }
                        // Wrong format
                    } else {
                        System.out.println("Please format your query in the form " +
                                "G[rade]: <number> [H[igh]|L[ow]]");
                    }
                    break;
                case "A:":
                case "Average:":
                    if (param.length == 2) {
                        if (Util.validInt(param[1], "Please enter an integer for the grade.")) {
                            int number = Integer.parseInt(param[1]);
                            db.printAverage(number);
                        }
                    } else {
                        System.out.println("Please format your query in the form A[verage]: <Number>");
                    }
                    break;
                case "I":
                case "Info":
                    db.printInfo();
                    break;
                default:
                    System.out.println("Please enter a valid input.");
            }
        }
    }
}
