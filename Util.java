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
}
