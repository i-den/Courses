using System;

class Program
{
    public static void Main()
    {
        var type = Console.ReadLine();

        bool isFruit = (type == "banana" || type == "apple" || type == "kiwi" || type == "cherry" || type == "lemon" || type == "grapes");
        bool isVegetable = (type == "tomato" || type == "cucumber" || type == "pepper" || type == "carrot");

        if (isFruit)
            Console.WriteLine("fruit");
        else if (isVegetable)
            Console.WriteLine("vegetable");
        else
            Console.WriteLine("Unknown");
    }
}