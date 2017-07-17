using System;
using System.Linq;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        if (n == 0)
            Console.WriteLine(1);
        else
        {
            int[] arr = new int[n + 1];
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 1; i < arr.Length - 1; i++)
                arr[i + 1] = arr[i - 1] + arr[i];

            Console.WriteLine(arr.Last());
        }
    }
}