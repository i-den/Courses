using System;

public class Program
{
    public static void Main()
    {
        var ingredientsCount = 0;

        while (true)
        {
            var cookingProduct = Console.ReadLine();

            if (cookingProduct == "Bake!")
            {
                break;
            }

            Console.WriteLine($"Adding ingredient {cookingProduct}.");
            ingredientsCount++;
        }

        Console.WriteLine($"Preparing cake with {ingredientsCount} ingredients.");
    }
}