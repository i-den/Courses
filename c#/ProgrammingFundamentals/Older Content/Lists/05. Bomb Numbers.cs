using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = GetIntList();
        List<int> detonationCouple = GetIntList();

        int detonationNumber = detonationCouple[0];
        int detonationPower = detonationCouple[1];

        int resultSum = 0;

        DetonateList(inputList, detonationNumber, detonationPower);

        resultSum = GetResultSum(inputList, resultSum);

        Console.WriteLine(resultSum);
    }

    public static List<int> GetIntList()
    {
        return Console.ReadLine().Split().Select(int.Parse).ToList();
    }

    public static void DetonateList(List<int> inputList, int detonationNumber, int detonationPower)
    {
        for (int i = 0; i < inputList.Count; i++)
        {
            for (int j = i; j < inputList.Count; j++)
            {
                if (inputList[j] == detonationNumber)
                {
                    NullifyListElements(inputList, j, detonationPower);
                }
                else
                {
                    continue;
                }
            }
        }
    }

    public static void NullifyListElements(List<int> inputList, int j, int detonationPower)
    {
        inputList[j] = 0;

        while (detonationPower != 0)
        {
            if (j - detonationPower >= 0)
            {
                inputList[j - detonationPower] = 0;
            }

            if (j + detonationPower < inputList.Count)
            {
                inputList[j + detonationPower] = 0;
            }

            detonationPower--;
        }
    }

    public static int GetResultSum(List<int> inputList, int resultSum)
    {
        for (int i = 0; i < inputList.Count; i++)
        {
            resultSum += inputList[i];
        }

        return resultSum;
    }
}