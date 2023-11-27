import java.util.Scanner;

public class PrintString {

    public static void main(String[] args) {
        display();
    }

    private static void display() {

           for (int i = 100;i >= 1;i--)
           {
               if (i % 5 == 0) {
                   System.out.println("Number "+ i + " is divisible by 5, so printing " + "Agile");
               }
               else if (i % 3 ==0) {
                   System.out.println("Number "+ i + " is divisible by 3, so printing " + "Software");

               } else if (i % 3 ==0 && i % 5 ==0) {
                   System.out.println("Number" + i +" is divisible by 3 and 5 both so printing "+ "Testing");
               }
               else
                   System.out.println("Number " + i +" is not divisible by 3 or 5");
           }

        }
    }
