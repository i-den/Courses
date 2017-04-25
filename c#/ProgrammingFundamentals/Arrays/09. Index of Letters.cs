using System;

public class Program
{
    public static void Main()
    {
        var charArray = Console.ReadLine().ToCharArray() ;

        for (int i = 0; i < charArray.Length; i++)
        {
            Console.WriteLine("{0} -> {1}", charArray[i], (int)charArray[i] - 97);
        }
    }
}