using System;

namespace _09.Password_Guess
{
    class Program
    {
        static void Main(string[] args)
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
}
