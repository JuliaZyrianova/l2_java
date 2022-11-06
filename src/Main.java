import javax.naming.NameNotFoundException;
import java.util.Scanner;
/**
 * Laboratory work 2
 * <p>
 * the program implements the analysis of the expression and the calculation of it's value
 * @author Julia Zyrianova
 * @version 1.0
 */

public class Main {
    public static void main(String[] args){
        /** The main method of the program.
         * The user is asked to choose from two options:
         * enter the formula yourself or use simple formula templates.
         * After that, the value of the expression is calculated.
         */
        int choice;
        boolean var = true;
        String order;
        Scanner sc= new Scanner(System.in);
        System.out.println("Menu <Enter formula>");
        System.out.println("0. Exit From menu ");
        System.out.println("1.I want to enter the formula myself ");
        System.out.println("2.I want to look at the ready-made formulas ");
        System.out.println("x+y,  x-y,  x*y,  x/y");
        System.out.println(" Enter choice (0-2) ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You can use symbols *,/,+,-, 0...9,(,) ");
                    String str = sc.next();
                    if (calculator.check_parentheses(str)) {
                        System.out.println(calculator.reverse_str(str));
                        Double result= calculator.result(calculator.reverse_str(str));
                        if(result != 1.0/0.0)
                            System.out.println("result= " +result);
                        else
                            System.out.println("Error: Check divide by zero");
                    } else
                        System.out.println("Error: Check count of parentheses ");
                    System.out.println("________________");
                    break;
                case 2:
                    System.out.println("Enter x,y ");
                    String x = sc.next();
                    String y = sc.next();
                    String s1 = x + "+" + y;
                    System.out.println(calculator.reverse_str(s1));
                    System.out.println("result= " + calculator.result(calculator.reverse_str(s1)));
                    System.out.println("________________");
                    String s2 = x + "-" + y;
                    System.out.println(calculator.reverse_str(s2));
                    System.out.println("result= " + calculator.result(calculator.reverse_str(s2)));
                    System.out.println("________________");
                    String s3 = x + "*" + y;
                    System.out.println(calculator.reverse_str(s3));
                    System.out.println("result= " + calculator.result(calculator.reverse_str(s3)));
                    System.out.println("________________");
                    String s4 = x + "/" + y;
                    if(y!="0") {
                        System.out.println(calculator.reverse_str(s4));
                        System.out.println("result= " + calculator.result(calculator.reverse_str(s4)));
                    }
                    else System.out.println("Error: you can't divide by zero");
                    System.out.println("________________");
                    break;
                    default:
                    order = "not in menu";
            }
        if (choice == 0)
            var = false;
    } while (var);


    }
}