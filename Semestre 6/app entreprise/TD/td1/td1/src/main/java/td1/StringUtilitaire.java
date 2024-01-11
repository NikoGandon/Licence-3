package td1;

public class StringUtilitaire {
    public static String tronquer(String input, int limit) {

        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative");
        }

        if (input.length() > limit) {
            return input.substring(0, limit) + "…";
        } else {
            return input;
        }
    }
}
