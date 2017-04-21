using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test
{
    class Program
    {
        static void Main(string[] args)
        {
            var Sarea = double.Parse(Console.ReadLine()); // Най-малката площ
            var Karea = double.Parse(Console.ReadLine()); // Кухня - площ

            var PricePerMeterSq = double.Parse(Console.ReadLine()); // Цена на кв. метър

            var Barea = Sarea / 2.00; // Баня - площ - 1/2 от най-малката площ
            var SRarea = Sarea * 1.10; // Втора стая - площ - 1.10 по-голяма от най-малката площ
            var TRarea = SRarea * 1.10; // Трета стая - площ - 1.10 по-голяма от втората площ

            var Total = (Sarea + Karea + Barea + SRarea + TRarea) * 1.05; // Общата площ на жилището
            var TotalPrice = (Total * PricePerMeterSq);
            Console.WriteLine("{0:00.00}", TotalPrice);




        }
    }
}
