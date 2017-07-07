using System;

class Program
{
    public static void Main()
    {
        string hours = Console.ReadLine();
        string minutes = Console.ReadLine();
        string time = hours + ":" + minutes;
        Console.WriteLine(time);
        DateTime datey = DateTime.ParseExact(time, "h:mm", null);
        datey = datey.AddMinutes(15);
        Console.WriteLine(datey.ToString("h:mm"));
    }
}