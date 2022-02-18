//approach: use Stack And Map
//map will hold all the key as closing parentheses and value as a opening parenthesis
//stack will be just collecting the value if we see the opening parenthesis
// as soon as we see any closing parenthesis, we will compare: 
//stack.pop() == map.get(s[i]); //we need to know if the next value is the closing parenthesis or not
//if not return false;
//else continue;
//edge case: 
//if the length of s == 1, return false
var isValid = function (s) {
    if (s.length == 1) return false;

    let stack = new Array();

    let map = new Map();
    map.set(')', '(');
    map.set(']', '[');
    map.set('}', '{');

    for (let c of s) {
        if (c == ')' || c == ']' || c == '}') {
            if (map.get(c) != stack.pop()) return false;
        } else {
            stack.push(c);
        }
    }
    if (stack.length) return false;

    return true;
};