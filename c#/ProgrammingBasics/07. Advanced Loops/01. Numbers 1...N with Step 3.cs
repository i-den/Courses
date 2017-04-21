using System;

namespace _01.Numbers_1._._.N_with_Step_3
{
class Program
{
static void Main()
{
var n = int.Parse(Console.ReadLine());

for (int num = 1; num <= n; num+=3)
{
Console.WriteLine(num);
}
}
}
}
