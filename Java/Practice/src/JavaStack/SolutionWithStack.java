package JavaStack;

import java.util.*;

public class SolutionWithStack {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            Stack<Character> stack = new Stack<Character>();
            boolean result = false;

            for(int i = 0; i < input.length(); i++) {
            	
                char c = input.charAt(i);

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                else if(c == ')' && !stack.empty() && '(' == stack.pop()) {
                    result = true;
                }
                else if(c == '}' && !stack.empty() && '{' == stack.pop()) {
                    result = true;
                }
                else if(c == ']' && !stack.empty() && '[' == stack.pop()) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }

            if(!stack.empty()) {
                result = false;
            }

            System.out.println(result);
        }

    }
}
