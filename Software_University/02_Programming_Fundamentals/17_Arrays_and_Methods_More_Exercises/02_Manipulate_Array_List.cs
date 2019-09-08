using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Trim().Split().ToList();
        var commandsCount = int.Parse(Console.ReadLine());

        for (int i = 0; i < commandsCount; i++)
        {
            var currentCommand = Console.ReadLine().Split();

            switch (currentCommand[0])
            {
                case "Reverse":
                    inputList.Reverse();
                    break;
                case "Distinct":
                    inputList = inputList.Distinct().ToList();
                    break;
                case "Replace":
                    var indexToReplace = int.Parse(currentCommand[1]);
                    var wordToReplaceWith = currentCommand[2];
                    inputList = inputList.Select((x, index) => index == indexToReplace ? wordToReplaceWith : x).ToList();
                    break;
            }
        }

        Console.WriteLine(string.Join(", ", inputList));
    }
}