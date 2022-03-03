package CodeSignal;

public class Sudoku2 {
    boolean solution(char[][] grid) {
        int n = grid.length;
        HashSet<Character> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != '.' && !set.add(grid[r][c]))
                    return false;
            }
            set = new HashSet<>();
        }

        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                if (grid[r][c] != '.' && !set.add(grid[r][c]))
                    return false;
            }
            set = new HashSet<>();
        }

        HashSet<Character>[] box = new HashSet[n];
        for (int i = 0; i < n; i++)
            box[i] = new HashSet<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != '.') {
                    int i = (r / 3) * 3 + (c / 3);
                    // System.out.println(r + " " + c + ": " + i);
                    if (!box[i].add(grid[r][c]))
                        return false;
                }
            }
        }

        return true;
    }

}
