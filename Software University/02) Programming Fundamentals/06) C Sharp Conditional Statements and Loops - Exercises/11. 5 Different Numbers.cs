using System;

public class Program
{
    public static void Main()
    {
        var startingIndex = int.Parse(Console.ReadLine());
        var endingIndex = int.Parse(Console.ReadLine());
        var cycledAtLeastOnce = false;

        if (endingIndex - startingIndex > 3)
        {
            for (int firstNum = startingIndex; firstNum <= endingIndex; firstNum++)
            {
                for (int secondNum = firstNum + 1; secondNum <= endingIndex; secondNum++)
                {
                    for (int thirdNum = secondNum + 1; thirdNum <= endingIndex; thirdNum++)
                    {
                        for (int fourthNum = thirdNum + 1; fourthNum <= endingIndex; fourthNum++)
                        {
                            for (int fifthNum = fourthNum + 1; fifthNum <= endingIndex; fifthNum++)
                            {
                                Console.WriteLine($"{firstNum} {secondNum} {thirdNum} {fourthNum} {fifthNum}");
                                cycledAtLeastOnce = true;
                            }
                        }
                    }
                }
            }
        }
        else
        {
            Console.WriteLine("No");
        }
    }
}