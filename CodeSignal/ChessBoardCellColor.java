package CodeSignal;

public class ChessBoardCellColor {
    boolean solution2(String cell1, String cell2) {
        // the slope in both cell must be both odd or even
        int r = Math.abs(cell1.charAt(0) - cell2.charAt(0));
        int c = Math.abs(cell1.charAt(1) - cell2.charAt(1));

        return r % 2 == c % 2;
    }


    // intuition
    boolean solution1(String cell1, String cell2) {
        int r1 = cell1.charAt(0) - 'A';
        int c1 = cell1.charAt(1) - '1';

        int r2 = cell2.charAt(0) - 'A';
        int c2 = cell2.charAt(1) - '1';

        int color1 = r1 % 2 + c1 % 2;
        int color2 = r2 % 2 + c2 % 2;

        return color1 % 2 == color2 % 2;
    }

}
