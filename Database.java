import java.io.*;
import java.util.ArrayList;

public class Database {
    private ArrayList<String[]> studentInfo;

    // indexes of each attribute in the array
    private static final int ST_LAST = 0; // student last name
    private static final int ST_FIRST = 1;
    private static final int GRADE = 2;
    private static final int ROOM = 3;
    private static final int BUS = 4;
    private static final int GPA = 5;
    private static final int T_LAST = 6; // teacher last name
    private static final int T_FIRST = 7;
    private static final int SCHEMA_LENGTH = 8;


    /**
     * Initializes a database
     * @param pathname path of the database
     * @throws IOException if database cannot be loaded/is unusable
     */
    public Database(String pathname) throws IOException {
        studentInfo = new ArrayList<>();

        File file =  new File(pathname);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String l;
        while((l = br.readLine()) != null) {
            String[] currInfo = l.split(",");
            // validate db
            if (!validFormat(currInfo)) {
                throw new IOException(); //TODO: correct exception?
            }
            studentInfo.add(currInfo);
        }
    }

    /**
     * Checks currInfo follows the schema in the spec
     * @param currInfo a String[] representing a line in the txt file
     * @return true if currInfo follows the spec, false otherwise
     */
    private boolean validFormat(String[] currInfo) {
        // check to see if input file has same length as db schema
        if (currInfo.length != SCHEMA_LENGTH) {
            return false;
        }
        // Bus, Grade, and Classroom are ints
        return Util.validInt(currInfo[BUS]) &&
                Util.validInt(currInfo[GRADE]) &&
                Util.validInt(currInfo[ROOM]) &&
                Util.validDouble(currInfo[GPA]);
        // TODO: GPA is a String in the spec -- we'll check for double anyways
    }

    public void printGrade(int qGrade) {
        for (String[] student : studentInfo) {
            int sGrade = Integer.parseInt(student[GRADE]);
            if (qGrade == sGrade){
                System.out.printf("%s,%s\n",
                        student[ST_LAST],
                        student[ST_FIRST]);
            }
        }
    }
    public void printHighGrade(int qGrade) {
        if (studentInfo.size() == 0) {
            return;
        }
        double maxGpa = Double.MIN_VALUE;
        String[] ans = new String[8];
        for (String[] student : studentInfo) {
            int sGrade = Integer.parseInt(student[GRADE]);
            double gpa = Double.parseDouble(student[GPA]);
            if (qGrade == sGrade && gpa > maxGpa){
                maxGpa = gpa;
                ans = student;
            }
        }
        System.out.printf("%s,%s,%s,%s,%s,%s\n",
                ans[ST_LAST], ans[ST_FIRST], ans[GPA],
                ans[T_LAST], ans[T_FIRST], ans[BUS]);
    }
    public void printLowGrade(int qGrade) {
        if (studentInfo.size() == 0) {
            return;
        }
        double minGpa = Double.MAX_VALUE;
        String[] ans = new String[8];
        for (String[] student : studentInfo) {
            int sGrade = Integer.parseInt(student[GRADE]);
            double gpa = Double.parseDouble(student[GPA]);
            if (qGrade == sGrade && gpa < minGpa){
                minGpa = gpa;
                ans = student;
            }
        }
        System.out.printf("%s,%s,%s,%s,%s,%s\n",
                ans[ST_LAST], ans[ST_FIRST], ans[GPA],
                ans[T_LAST], ans[T_FIRST], ans[BUS]);
    }
    public void student(String lastName, boolean bus)
    {
        if(!bus)
        {
            for(String[] student : studentInfo)
            {
                if(student[ST_LAST].equals(lastName))
                {
                    System.out.println(student[ST_LAST] + ", " + student[ST_FIRST] + ", " + student[GRADE] +
                            ", " + student[ROOM] + ", " + student[T_LAST] + ", " + student[T_FIRST]);
                }
            }
        }
        else
        {
            for(String[] student : studentInfo)
            {
                if(student[ST_LAST].equals(lastName))
                {
                    System.out.println(student[ST_LAST] + ", " + student[ST_FIRST] + ", " + student[BUS]);
                }
            }
        }
    }
    public void teacher(String lastname)
    {
        for(String[] student : studentInfo)
        {
            if(student[T_LAST].equals(lastname))
            {
                System.out.println(student[ST_LAST] + ", " + student[ST_FIRST]);
            }
        }
    }
    public void bus(int number)
    {
        for(String[] student : studentInfo)
        {
            if(Integer.parseInt(student[BUS]) == (number))
            {
                System.out.println(student[ST_LAST] + ", " + student[ST_FIRST] + ", " + student[GRADE]
                        + ", " + student[ROOM]);
            }
        }
    }

}
