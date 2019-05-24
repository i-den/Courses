using System;

public class Program
{
    public static void Main()
    {
        var ingredientsArray = Console.ReadLine().Split();

        var validIngredientsArray = new string[ingredientsArray.Length];
        var maxIngredientLength = int.Parse(Console.ReadLine());
        var ingredientsAdded = 0;


        for (int i = 0, j = 0; i < ingredientsArray.Length; i++)
        {
            var currentIngredient = ingredientsArray[i];

            if (currentIngredient.Length == maxIngredientLength)
            {

                Console.WriteLine($"Adding {currentIngredient}.");
                validIngredientsArray[j] = currentIngredient;
                ingredientsAdded++;
                j++;

                if (ingredientsAdded == 10)
                {
                    break;
                }
            }
        }

        Console.WriteLine($"Made pizza with total of {ingredientsAdded} ingredients.");
        Console.Write($"The ingredients are: ");

        var ingredientsToPrint = new string[ingredientsAdded];

        for (int i = 0; i < ingredientsAdded; i++)
        {
            ingredientsToPrint[i] = validIngredientsArray[i];
        }

        Console.WriteLine("{0}.",string.Join(", ", ingredientsToPrint));
    }
}