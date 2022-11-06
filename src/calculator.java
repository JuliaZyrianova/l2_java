import java.util.Stack;
/**
 *Class-calculator
 */
public class calculator {
    /**
     * Function of checking count of parentheses.
     * @param str the string entered by the user
     * @return true, if each opening bracket has a closing one.
     */
    public static boolean check_parentheses(String str) {
        int count=0;
        for (int i = 0; i < str.length(); i++) {
           if(str.charAt(i)=='(') count++;
           if(str.charAt(i)==')') count--;
        }
    return count==0;
    }

    /**
     * Function of conversion of the infix form str to the postfix form.
     * @param str the string entered by the user
     * @return string in postfix form
     */
    public static String reverse_str(String str) {
        String cur = "";
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < str.length(); i++) {
            priority = get_priority(str.charAt(i));
            if (priority == 0) cur += str.charAt(i);
            if (priority == 1) stack.push(str.charAt(i));
            if (priority > 1) {
               cur += ' ';
                while (!stack.isEmpty() &&get_priority(stack.peek()) >= priority) {
                     cur += stack.pop();
                     cur += ' ';
                }
                stack.push(str.charAt(i));
            }
            if (priority == -1) {
                cur += ' ';
                while (get_priority(stack.peek()) != 1) cur += stack.pop();
                stack.pop();
            }
        }
        cur += ' ';
        while(!stack.isEmpty()) cur+=stack.pop();
        return cur;
}

    /**
     * Function of calculating the formula
     * @param rev_str the string in postfix form
     * @return double number: the result of calculating the formula
     */
    public static double result(String rev_str){
        String op=new String();
        Stack<Double> stack= new Stack<>();
        for(int i=0; i<rev_str.length(); i++){
           if(rev_str.charAt(i) == ' ') continue;
            if(get_priority(rev_str.charAt(i))==0){
                while(i!=rev_str.length() && rev_str.charAt(i)!=' '&& get_priority(rev_str.charAt(i))==0) {
                    op += rev_str.charAt(i);
                    i++;
                    //if(i==rev_str.length()) break;
                }
            stack.push(Double.parseDouble(op));
                op=new String();
            }
            if(get_priority(rev_str.charAt(i))>1){
                double a=stack.pop();
                double b=stack.pop();
                if(rev_str.charAt(i)=='+') stack.push(b+a);
                if(rev_str.charAt(i)=='-') stack.push(b-a);
                if(rev_str.charAt(i)=='*') stack.push(b*a);
                if(rev_str.charAt(i)=='/') stack.push(b/a);
            }
        }
        return stack.pop();
    }

    /**
     * Function of finding the operation priority value
     * @param symbol the symbol -,+,*,/,(,)
     * @return int number: the result of priority value
     */
    private static int get_priority(char symbol){
        if (symbol=='*'|| symbol=='/') return 3;
        else if(symbol=='+'|| symbol=='-') return 2;
        else if (symbol=='(') return 1;
        else if (symbol==')') return -1;
        else return 0;
    }
}
