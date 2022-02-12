package CodeSignal;

public class IsIPv4Address {
    boolean solution(String inputString) {
        String[] input = inputString.split("\\.");

        if (input.length != 4)
            return false;

        for (String num : input) {
            try {
                int n = Integer.parseInt(num);
                if (num.charAt(0) == '0' && num.length() > 1)
                    return false;
                if (n < 0 || n > 255)
                    return false;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        return true;
    }

}
