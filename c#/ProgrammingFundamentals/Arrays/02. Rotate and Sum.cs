using System;
using System.Linq;

public class RotateAndSum
{
    public static void Main()
    {
        var intArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        var sumArray = new int[intArray.Length];

        var shifts = int.Parse(Console.ReadLine());

        for (int currentShift = 0; currentShift < shifts; currentShift++)
        {
            ShiftArray(intArray);

            GetSumOfCurrentShift(intArray, sumArray);
        }

        Console.WriteLine(string.Join(" ", sumArray));
    }

    public static void ShiftArray(int[] intArray)
    {
        int lastArrayNumber = intArray.Last();

        for (int i = intArray.Length - 1; i > 0; i--)
        {
            intArray[i] = intArray[i - 1];
        }

        intArray[0] = lastArrayNumber;
    }

    private static void GetSumOfCurrentShift(int[] intArray, int[] sumArray)
    {
        for (int i = 0; i < intArray.Length; i++)
        {
            sumArray[i] += intArray[i];
        }
    }
}
