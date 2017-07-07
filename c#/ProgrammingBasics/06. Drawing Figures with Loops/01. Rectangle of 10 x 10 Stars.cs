using System;

class Program
{
    public static void Main()
    {
        int n = 10;
        for (int rows = 0; rows < n; rows++)
            Console.WriteLine(new string('*', n));
    }
}