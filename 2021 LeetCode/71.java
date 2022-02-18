// 71. Simplify Path
/**
 * Given a string path, which is an absolute path (starting with a slash `/`) to
 * a file or directory in a Unix-style file system, convert it to the simplified
 * canonical path.
 * 
 * Input: path = `"/a/./b/../../c/"`
 * 
 * Output: `"/c"`
 */
class Solution {
    /**
     * - First, split the string by the delimiter slash `/`. Iterate through the
     * split array, if there any `..` which means up a level, then pop the top
     * directory off the stack. If the element is null or equals `.` which means
     * stay on the current directory, then ignore. What's left over in the stack is
     * the path in canonical.
     * 
     * @param path
     * @return String
     */

    // Time: O(n)
    // Space: O(n)
    public String simplifyPath(String path) {

        String[] arr = path.split("/");
        Stack<String> st = new Stack();

        for (String s : arr) {
            if (s.length() == 0 || s.equals("."))
                continue;
            else if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else
                st.add(s);
        }

        String res = "";
        while (!st.isEmpty()) {
            res = "/" + st.pop() + res;
        }

        return res.length() > 0 ? res : "/";
    }
}
