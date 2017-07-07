using System;

class DaysAdding
{
    public static void Main()
    {
        DateTime data = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", null);
        DateTime data2 = data.AddDays(999);
        Console.WriteLine(data2.ToString("dd-MM-yyyy"));
    }
}