using System;

public class Program
{
    public static void Main()
    {
        string figureType = Console.ReadLine();

        switch (figureType)
        {
            case "triangle":
                double side = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());
                Console.WriteLine("{0:f2}", (side*height)/2);
                break;
            case "square":
                double sidee = double.Parse(Console.ReadLine());
                Console.WriteLine("{0:f2}", sidee * sidee);
                break;
            case "rectangle":
                double width = double.Parse(Console.ReadLine());
                double heightt = double.Parse(Console.ReadLine());
                Console.WriteLine("{0:f2}", width * heightt);
                break;
            case "circle":
                double radiues = double.Parse(Console.ReadLine());
                Console.WriteLine("{0:f2}", Math.PI * radiues * radiues);
                break;
        }
    }
}