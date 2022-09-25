import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    ArrayList<String[]> studentInfo;
    private enum Schema {
        ST_LAST, ST_FIRST, GRADE, ROOM, BUS, GPA, T_LAST, T_FIRST
    }

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
        if (currInfo.length != Schema.values().length) {
            return false;
        }
        // Bus, Grade, and Classroom are ints
        return Util.validInt(currInfo[Schema.BUS.ordinal()]) &&
                Util.validInt(currInfo[Schema.GRADE.ordinal()]) &&
                Util.validInt(currInfo[Schema.ROOM.ordinal()]);
        // GPA is a String in the spec, no need to check
    }

    // assumes studentInfo is properly formatted
    public void printGrade(int qGrade) {
        for (String[] student : studentInfo) {
            int sGrade = Integer.parseInt(student[Schema.GRADE.ordinal()]);
            if (qGrade == sGrade){
                System.out.printf("%s,%s\n",
                        student[Schema.ST_LAST.ordinal()],
                        student[Schema.ST_FIRST.ordinal()]);
            }
        }
    }
}
