/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoexepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class Ejemplo12 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese cuantas operaciones quiere realizar");
        int valor = entrada.nextInt();
        int[] resultados = new int[valor];

        /*Realizar un proceso repetitivo que permita realizar la división de 
        números ingresados por teclado; el resultado de cada división debe ir 
        almacenandose en cada posición del arreglo. Considerar las excepciones
        posibles*/
        
        for (int i = 0; i < valor; i++) {
            int num1 = 0;
            int num2 = 0;
            boolean operacionValida = true;

            while (operacionValida) {
                try {
                    System.out.println("Ingrese el numerador para la operación " + (i + 1));
                    num1 = entrada.nextInt();

                    System.out.println("Ingrese el denominador para la operación " + (i + 1));
                    num2 = entrada.nextInt();

                    if (num2 == 0) {
                        throw new ArithmeticException("No se puede dividir por cero.");
                    }

                    resultados[i] = num1 / num2;
                    operacionValida = false;

                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un número entero. Intenta nuevamente.");
                    entrada.nextLine();
                } catch (ArithmeticException e) {
                    System.out.println(e);
                    operacionValida = true;
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e);
                }
            }
        }

        System.out.println("Resultados de las divisiones:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("Resultado de la operación " + (i + 1) + ": " + resultados[i]);
        }
    }
}
