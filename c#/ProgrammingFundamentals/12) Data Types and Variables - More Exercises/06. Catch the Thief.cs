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

        Console.WriteLine(thiefIndentitiyNumber);
    }
}