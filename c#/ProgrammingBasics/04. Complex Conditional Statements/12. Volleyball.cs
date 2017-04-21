using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Volleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            var year = Console.ReadLine().ToLower();
            var p = double.Parse(Console.ReadLine()); 
            var h = double.Parse(Console.ReadLine()); 
            
            var sofiaweekends = 48 - h; // Weekends he's in Sofia 45
            var playweekends = sofiaweekends * 3 / 4; // 3/4 of thoe Weekends he's playing 
            var hometownplays = h; //Days he's in his hometown, playing //3

            var playholidays = p * 2 / 3; //Holidays he's playing while in Sofia 
            var playtotaloffdays = playweekends + hometownplays + playholidays; //total playdays

            switch (year)
            {
                case "leap":
                    Console.WriteLine(Math.Floor(playtotaloffdays * 1.15)); //15% more playdays
                     break;
                default:
                    Console.WriteLine(Math.Floor(playtotaloffdays)); //normal playdays
                    break;
            }


        }
        }
    }

