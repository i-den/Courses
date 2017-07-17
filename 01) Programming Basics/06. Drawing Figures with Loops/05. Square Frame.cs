using System;

class Program
{
    public static void Main()
    {
        int num = int.Parse(Console.ReadLine());

        Wrapper(num);
        Body(num);
        Wrapper(num);

    }

    private static void Body(int num)
    {
        for (int j = 0; j < num - 2; j++)
        {
            Console.Write("| ");
            for (int i = 1; i <= num - 2; i++)
                Console.Write("- ");
            Console.WriteLine("|");
        }
    }

    private static void Wrapper(int num)
    {
        Console.Write("+ ");
        for (int i = 1; i <= num - 2; i++)
            Console.Write("- ");
        Console.WriteLine("+");
    }
}