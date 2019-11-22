/* 
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constantes
        final int MIN_RAIN = 0;
        final int MAX_RAIN = 500;
        final int NUM_DIAS = 7;
        final String[] DIA = {"Lunes", "Martes", "Miércoles",
            "Jueves", "Viernes", "Sábado", "Domingo"};

        //Variables
        String rainDiaMin = "";
        String rainDiaMax = "";
        double rainTotal = 0;
        double rainMedia;
        int numDia;
        int rainDia;
        int rainMax = 0;
        int rainMin = 0;

        //Bucle principal
        for (numDia = 0; numDia < NUM_DIAS; numDia++) {
            //RND lluvia del día.
            rainDia = RND.nextInt(MAX_RAIN - MIN_RAIN + 1) + MIN_RAIN;

            //sout dia de la semana.
            System.out.printf("Día semanal..............................: "
                    + "%s.%n", DIA[numDia]);

            //sout lluvia del dia.
            System.out.printf("Lluvia aleatoria ........................: "
                    + "%03d l/m2.%n", rainDia);

            //Asignaremos al primer día ambos valores
            if (numDia == 0) {
                //El mínimo
                rainMin = rainDia;
                rainDiaMin = DIA[numDia];

                //Y el máximo
                rainMax = rainDia;
                rainDiaMax = DIA[numDia];
            } else {//En el resto de días...

                //Comprobamos si cualquier otro día
                //llueve menos que en el anterior.
                if (rainDia < rainMin) {
                    rainMin = rainDia;
                    rainDiaMin = DIA[numDia];
                }

                //Ahora, comporbaremos en caso de que cualquier
                //otro día llueve más que en el anterior.
                if (rainDia > rainMax) {
                    rainMax = rainDia;
                    rainDiaMax = DIA[numDia];
                }
            }

            //Haremos un total de los siete valores
            rainTotal += rainDia;

            //Le decimos al usuario cómo proseguir.
            System.out.printf("%n%n---Pulse ENTER para continuar---%n");

            //Y le daremos un poco de tranquilidad al programa.
            SCN.nextLine();
        }

        //Ya una vez terminado el bucle, devolvemos la media.
        rainMedia = rainTotal / NUM_DIAS;

        //sout lluvia acumulada semanal.
        System.out.printf(Locale.ENGLISH,
                "%nLa lluvia acumulada semanal es de .......: %04.0f l/m2.%n",
                rainTotal);

        //sout media semanal.
        System.out.printf(Locale.ENGLISH,
                "%nLa media de lluvia semanal es de ........: %03.2f l/m2.%n",
                rainMedia);

        //sout dia con más lluvia.
        System.out.printf(
                "%nEl dia de mayor lluvia semanal es el ....: %s.%n"
                + "Y llovió ................................: %03d l/m2.%n",
                rainDiaMax, rainMax);

        //sout dia con menos lluvia.
        System.out.printf(
                "%nEl dia de menor lluvia semanal es el ....: %s.%n"
                + "Y llovió ................................: %03d l/m2.%n",
                rainDiaMin, rainMin);
    }
}
