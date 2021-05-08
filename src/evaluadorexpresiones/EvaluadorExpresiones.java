/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluadorexpresiones;

import java.util.Scanner;

/**
 *
 * @author Maria Florian
 */
public class EvaluadorExpresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese una Expresión a Evaluar:");
        String infija=sc.next();
        System.out.println("\n El resultado es: " + Evaluador.evaluar(infija));
        
    }
    
}
