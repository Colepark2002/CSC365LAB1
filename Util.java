public class Util {
    /**
     * @param value the string you want to validate
     * @param errorMessage the message to print if validation fails
     * @return true if value can be parsed as an int, false otherwise
     */
    public static boolean validInt(String value, String errorMessage) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            return false;
        }
    }

    /**
     * Database schema, access index using ordinal()
     * e.g. ordinal(GRADE) == 2
     */
    public enum Schema {
        ST_LAST, ST_FIRST, GRADE, ROOM, BUS, GPA, T_LAST, T_FIRST
    }
}
