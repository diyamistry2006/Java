import java.util.Scanner;
 
class Program 
{
    double ans;

    public void ADD(double a, double b)
    {
        ans = a + b;
        System.out.println("Addition :" + ans);
    } 

    public void SUB(double a, double b) 
    {
        ans = a - b;
        System.out.println("Subtraction :" + ans);
    }

    public void MUL(double a, double b) 
    {
        ans = a * b;
        System.out.println("Multiplication :" + ans);
    }

    public void DIV(double a, double b) 
    {
        if (b != 0) 
        {
            ans = a / b;
            System.out.println("Division :" + ans);
        } 
        else
        {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

class Result
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = in.nextDouble();
        System.out.print("Enter second number: ");
        double b = in.nextDouble();

        Program c1 = new Program();
        c1.ADD(a, b);
        c1.SUB(a, b);
        c1.MUL(a, b);
        c1.DIV(a, b);
    }    
}

