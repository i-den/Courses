using System;

public class Program
{
    public static void Main()
    {
        var numberOfIngredients = int.Parse(Console.ReadLine());
        var caloriesCount = 0;

        for (int i = 0; i < numberOfIngredients; i++)
        {
            var currentIngredient = Console.ReadLine().ToLower();

            switch (currentIngredient)
            {
                case "cheese":
                    caloriesCount += 500; break;
                case "tomato sauce":
                    caloriesCount += 150; break;
                case "salami":
                    caloriesCount += 600; break;
                case "pepper":
                    caloriesCount += 50; break;
            }
        }

        Console.WriteLine($"Total calories: {caloriesCount}");
    }
}