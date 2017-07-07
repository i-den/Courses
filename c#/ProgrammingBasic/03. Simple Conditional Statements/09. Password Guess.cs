using System;

class Program
{
    public static void Main()
    {
        var pwd = Console.ReadLine();
        if (pwd == "s3cr3t!P@ssw0rd")
        {
            Console.WriteLine("Welcome");
        }
        else
        {
            Console.WriteLine("Wrong Password!");
        }
    }
}