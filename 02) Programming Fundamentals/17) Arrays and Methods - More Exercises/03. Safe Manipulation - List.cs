using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var inputList = Console.ReadLine().Trim().Split().ToList();

        while (true)
        {
            var command = Console.ReadLine().Split();

            if (command[0] == "END")
            {
                break;
            }

            switch (command[0])
            {
                case "Reverse":
                    inputList.Reverse();
                    break;
                case "Distinct":
                    inputList = inputList.Distinct().ToList();
                    break;
                case "Replace":
                    var indexToReplace = int.Parse(command[1]);
                    var wordToReplaceWith = command[2];

                    if (indexToReplace < 0 || indexToReplace >= inputList.Count)
                    {
                        Console.WriteLine("Invalid input!");
                        break;
                    }

                    inputList = inputList.Select((x, index) => index == indexToReplace ? wordToReplaceWith : x).ToList();
                    break;
                default:
                    Console.WriteLine("Invalid input!");
                    break;
            }
        }

        Console.WriteLine(string.Join(", ", inputList));
    }
}