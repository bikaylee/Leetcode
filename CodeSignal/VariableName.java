package CodeSignal;

public class VariableName {
    boolean solution(String name) {
        if (Character.isDigit(name.charAt(0)))
            return false;

        for (char c : name.toCharArray()) {
            if (c != '_' && !Character.isDigit(c) && !Character.isAlphabetic(c))
                return false;
        }

        return true;
    }
}
