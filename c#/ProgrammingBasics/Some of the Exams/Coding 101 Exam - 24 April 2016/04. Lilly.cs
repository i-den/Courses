using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Lilly
{
    class Program
    {
        static void Main(string[] args)
        {

            int age = int.Parse(Console.ReadLine());
            double WasherPrice = double.Parse(Console.ReadLine());
            int ToyPrice = int.Parse(Console.ReadLine());

            var MoneyPerYear = 10;
            var HasMoney = 0;
            var BrotherSteal = 0;
            var Toys = 0;

            for (int years = 1; years <= age; years++)
            {
                if (years % 2 == 0)
                {
                    HasMoney += MoneyPerYear;
                    MoneyPerYear += 10;
                    BrotherSteal++;
                }
                else
                    Toys++;
                
            }

            var MoneyFromToys = Toys * ToyPrice;
            var TotalMoney = HasMoney - BrotherSteal + MoneyFromToys;

            if (TotalMoney >= WasherPrice)
                Console.WriteLine("Yes! {0:f2}",(double)(TotalMoney - WasherPrice));
            else
                Console.WriteLine("No! {0:f2}",(double)(WasherPrice - TotalMoney));
        }
    }
}
