using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var ingredientsList = Console.ReadLine().Split().ToList();
        var maxIngredientLength = int.Parse(Console.ReadLine());

        ingredientsList = ingredientsList.Where( a => a.Length == maxIngredientLength).ToList();

        foreach (var ingredient in ingredientsList.Where((x, index) => index <= 10))
        {
            Console.WriteLine($"Adding {ingredient}.");
        }

        Console.WriteLine("Made pizza with total of {0} ingredients.", ingredientsList.Count >= 10 ? 10 : ingredientsList.Count);
        Console.Write("The ingredients are: {0}.", string.Join(", ", ingredientsList.Where((i, index) => index < 10)));
    }
}