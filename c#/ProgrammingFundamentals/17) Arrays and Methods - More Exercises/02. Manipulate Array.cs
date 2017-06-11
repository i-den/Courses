using System;

public class Program
{
    public static void Main()
    {
        var inputArr = Console.ReadLine().Trim().Split();
        var commandsCount = int.Parse(Console.ReadLine());

        for (int i = 0; i < commandsCount; i++)
        {
            var input = Console.ReadLine().Split();

            switch (input[0])
            {
                case "Reverse":
                    Array.Reverse(inputArr);
                    break;
                case "Distinct":
                    inputArr = RemoveDuplicateElements(inputArr);
                    break;
                case "Replace":
                    ReplaceArray(inputArr, input);
                    break;
            }
        }

        Console.WriteLine(string.Join(", ", inputArr));
    }

    public static string[] RemoveDuplicateElements(string[] inputArr)
    {
        var strToReturn = string.Empty;

        for (int i = 0; i < inputArr.Length; i++)
        {
            var currArrElement = inputArr[i];

            if (!strToReturn.Contains(currArrElement))
            {
                strToReturn += $"{currArrElement} ";
            }
        }

        return strToReturn.Trim().Split();
    }

    public static void ReplaceArray(string[] inputArr, string[] input)
    {
        var indexToReplace = int.Parse(input[1]);
        var wordToReplaceWith = input[2];

        inputArr[indexToReplace] = wordToReplaceWith;
    }
}