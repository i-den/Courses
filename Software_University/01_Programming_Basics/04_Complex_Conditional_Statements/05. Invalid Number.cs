using System;

class Program
{
    public static void Main()
    {
        var num = int.Parse(Console.ReadLine());
        bool isInvalid = num >= 100 && num <= 200 || num == 0;

        if (isInvalid)
            return;
        else
            Console.WriteLine("invalid");
    }
}