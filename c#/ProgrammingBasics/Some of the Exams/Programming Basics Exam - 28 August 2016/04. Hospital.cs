using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Hospital
{
    class Program
    {
        static void Main(string[] args)
        {

            int Period = int.Parse(Console.ReadLine());
            int Docs = 7;
            int TreatedPatientsCounter = 0;
            int UntreatedPatientsCounter = 0;
            int Treated = 0;
            int Untreated = 0;


            for (int i = 1; i <= Period; i++)
            {

                int Patients = int.Parse(Console.ReadLine());

                if (i % 3 == 0)
                {
                    if (UntreatedPatientsCounter > TreatedPatientsCounter)
                    {
                        Docs++;
                    }
                }

                if (Docs >= Patients)
                    {
                        TreatedPatientsCounter += Patients;
                    }

                else
                    {
                        TreatedPatientsCounter += Docs;
                        UntreatedPatientsCounter += Patients - Docs;
                    }
                

            }

            Console.WriteLine("Treated patients: {0}.", TreatedPatientsCounter);
            Console.WriteLine("Untreated patients: {0}.", UntreatedPatientsCounter);

        }
    }
}
