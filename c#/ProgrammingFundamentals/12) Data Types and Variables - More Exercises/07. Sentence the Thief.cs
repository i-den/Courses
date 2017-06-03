using System;

public class Program
{
    public static void Main()
    {
        var inputType = Console.ReadLine();
        var identityCount = int.Parse(Console.ReadLine());

        var maxValue = default(long);
        var thiefIndentitiyNumber = long.MinValue;

        switch (inputType)
        {
            case "sbyte":
                maxValue = sbyte.MaxValue;
                break;
            case "int":
                maxValue = int.MaxValue;
                break;
            case "long":
                maxValue = long.MaxValue;
                break;
        }

        for (int i = 0; i < identityCount; i++)
        {
            var currentIdentityNumber = long.Parse(Console.ReadLine());

            if (currentIdentityNumber >= thiefIndentitiyNumber && currentIdentityNumber <= maxValue)
            {
                thiefIndentitiyNumber = currentIdentityNumber;
            }
        }

        double divider = thiefIndentitiyNumber > 0 ? sbyte.MaxValue : sbyte.MinValue;

        var sentence = Math.Ceiling(thiefIndentitiyNumber / divider);
        var time = sentence > 1 ? "years" : "year";

        Console.WriteLine($"Prisoner with id {thiefIndentitiyNumber} is sentenced to {sentence} {time}");
    }
}