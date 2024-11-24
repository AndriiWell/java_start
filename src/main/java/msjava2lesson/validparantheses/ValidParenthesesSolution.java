package msjava2lesson.validparantheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        int stringLength = s.length();
        // Constraints:
        // 1 <= s.length <= 104
        if(stringLength < 1 || stringLength > 10_000) {
            throw new ParenthesesException();
        }

        // Constraints:
        // s consists of parentheses only '()[]{}'.
        Set<Character> validCharacters = new HashSet<>();
        validCharacters.add('(');
        validCharacters.add(')');
        validCharacters.add('{');
        validCharacters.add('}');
        validCharacters.add('[');
        validCharacters.add(']');

        if(stringLength % 2 != 0) {
            // String length should be even.
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for (char character: s.toCharArray()) {
            if(!validCharacters.contains(character)) {
                throw new ParenthesesException();
            }

            if(map.containsKey(character)) {
                // Close bracer found...
                char stackTop = stack.isEmpty()?'-':stack.pop();
                if(map.get(character) != stackTop) {
                    // Whether the top element of stack is not one of opens bracer.
                    return false;
                }
            }
            else {
                // For open bracer symbols: {,[,(.
                stack.push(character);
            }
        }

        return true;
    }
}
