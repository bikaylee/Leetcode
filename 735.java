// 735. Asteroid Collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

        // (A, B) represents each pair in the given array

        // Case 1: A(pos) is to the right and B(neg) is to the left (collision happened)
        // Case 2: A(neg) is to the left and B(pos) is to the right (no collision happened)
        // Case 3 & 4: A(pos) and B(pos), or A(neg) and B(neg), since they're towards the same direction (no collision)

        // Based on the 4 cases, only consider the collision case:
        //      *Always add the positives to the stack, all leftover of the stack will be the remaining asteroids
        //      if two asteroids collides, A is from the top of stack and B is the current asteroid
        //          Case 1 (A < B or B < A) : the smaller one will explode
        //          Case 2 (A == B): both explode

        for (int current : asteroids) {
            boolean collided = false;

            // if A(left) has positive asteroids and B(right) is negative (collision occurred)
            while (!stack.isEmpty() && current < 0 && stack.peek() > 0 && !collided) {

                // abs(B) > abs(A), remove smaller asteroid
                if (stack.peek() < -current) {
                    stack.pop();
                    continue; // check all of the left side (elements in stack) until no collisions
                }
                // abs(B) == abs(A), remove both (do not add right and remove left)
                else if (stack.peek() == -current) {
                    stack.pop();
                    collided = true;
                }
                // abs(B) < abs(A), do not add right and move on to other new asteroids
                else
                    collided = true;
            }

            if (!collided)
                stack.add(current);
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }

        return ans;
    }
}