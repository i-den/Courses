using System;

public class Program
{
    public static void Main()
    {
        var materialsArr = Console.ReadLine().Split();
        var materialQuantityArr = Console.ReadLine().Split();
        var materialPriceArr = Console.ReadLine().Split();

        while (true)
        {
            var currProductToPrint = Console.ReadLine();
            var currProductIndex = 0;

            if (currProductToPrint == "done")
            {
                break;
            }

            for (int i = 0; i < materialsArr.Length; i++)
            {
                var currMaterial = materialsArr[i];

                if (currMaterial == currProductToPrint)
                {
                    currProductIndex = i;
                    break;
                }
            }

            Console.WriteLine($"{materialsArr[currProductIndex]} costs: {materialPriceArr[currProductIndex]}; Available quantity: {materialQuantityArr[currProductIndex]}");
        }
    }
}