using System;

class Program
{
    static void Main()
    {
        var type = Console.ReadLine().ToLower();
        var rows = int.Parse(Console.ReadLine());
        var cols = int.Parse(Console.ReadLine());

        var cost = 0.0;

        switch (type)
        {
            case "premiere":
                cost = 12.00;
                break;
            case "normal":
                cost = 7.50;
                break;
            case "discount":
                cost = 5.00;
                break;
        }
        var inc = cost * rows * cols;
        Console.WriteLine("{0:00}", inc);
    }
}