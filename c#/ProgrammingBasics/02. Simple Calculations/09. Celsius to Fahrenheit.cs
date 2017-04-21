using System;

namespace _09.Celsius_to_Fahrenheit
{
    class Program
    {
        static void Main()
        {
            //var celsius = double.Parse(Console.ReadLine());
            //var fahrenheit = celsius * 1.8 + 32;
            //Console.WriteLine(Math.Round(fahrenheit, 2));

            Console.WriteLine(Math.Round(double.Parse(Console.ReadLine())*1.8+32,2));
        }
    }
}
