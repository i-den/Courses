using System;

class Program
{
    public static void Main()
    {

        int n = int.Parse(Console.ReadLine());
        int m = int.Parse(Console.ReadLine());

        char type = char.Parse(Console.ReadLine());
        string type2;

        if (type == '+')
        {
            if ((n + m) % 2 == 0)
                type2 = "even";
            else type2 = "odd";
            Console.WriteLine("{0} {1} {2} = {3} - {4}", n, type, m, (n + m), type2);
        }
        else if (type == '-')
        {
            if ((n - m) % 2 == 0)
                type2 = "even";
            else type2 = "odd";
            Console.WriteLine("{0} {1} {2} = {3} - {4}", n, type, m, (n - m), type2);
        }
        else if (type == '*')
        {
            if ((n * m) % 2 == 0)
                type2 = "even";
            else type2 = "odd";
            Console.WriteLine("{0} {1} {2} = {3} - {4}", n, type, m, (n * m), type2);
        }
        else if (type == '/')
        {

            if (m == 0)
                Console.WriteLine("Cannot divide {0} by zero", n);
            else
            {
                double result = (double)n / (double)m;
                Console.WriteLine("{0} {1} {2} = {3:f2}", n, type, m, result);
            }
        }
        else
        {

            if (m == 0)
                Console.WriteLine("Cannot divide {0} by zero", n);
            else
            {
                double result = n % m;
                Console.WriteLine("{0} {1} {2} = {3}", n, type, m, result);
            }
        }
    }
}