/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluadorexpresiones;

/**
 *
 * @author Maria Florian
 */
public class Evaluador {
    public static double evaluar(String infija){
        String postfija=convertir(infija);
        System.out.print("La expresión postfija es: "+postfija);
        return evaluarpostfija(postfija);
    }

    private static String convertir(String infija) {
        String postfija="";
        Pila pila=new Pila(100);
        for (int i=0;i<infija.length();i++){
            char letra=infija.charAt(i);
            if (esOperador(letra)){
               if (pila.estaVacia()){
                   pila.apliar(letra);
                } else{
                   int pe =prioridadEnExpresion(letra);
                   int pp=prioridadEnPila(( char)pila.ElementoTope());
                   if (pe>pp){
                       pila.apliar(letra);
                   }else{
                       postfija+=pila.desapilar();
                       pila.apliar(letra);
                       
                   }
                }
            } else{
                postfija += letra;
            }
            
        }
        while(!pila.estaVacia()){
            postfija+=pila.desapilar();
        }
        return postfija;
    }
//niveles jerarquicos de operadores ya establecidos
    private static int prioridadEnExpresion(char operador){
        if (operador=='^')return 4;
        if (operador=='*'|| operador=='/')return 2;
        if (operador=='+'|| operador=='-')return 1;
        if (operador=='(')return 5;
        return 0;     
    }
    
    private  static int prioridadEnPila(char operador){
        if (operador=='^')return 3;
        if (operador=='*'|| operador=='/')return 2;
        if (operador=='+'|| operador=='-')return 1;
        if (operador=='(')return 0;
        return 0;     
    }
    
    private static double evaluarpostfija(String postfija) {
        Pila pila=new Pila(100);
        for(int i=0;i<postfija.length();i++){
            char letra=postfija.charAt(i);
            if (!esOperador(letra)){
                double num = new Double(letra+"");
                pila.apliar(num);
                                  
            }else{
                double num2=(double)pila.desapilar();
                double num1=(double)pila.desapilar();
                double num3=operacion(letra,num1,num2);
                pila.apliar(num3);
               
            }
            
        }
        return (double)pila.ElementoTope();
    }

    private static boolean esOperador(char letra) {
        if (letra == '*'|| letra =='/'|| letra=='+'|| letra=='-'|| letra=='('||letra==')'|| letra=='^'){
            return true;
        }
        return false;
    }

    private static double operacion(char letra, double num1, double num2) {
        if (letra=='*') return num1*num2;
        if (letra=='/') return num1/num2;
        if (letra=='+') return num1+num2;
        if (letra=='-') return num1-num2;
        if (letra=='^') return Math.pow(num1,num2);
        return 0;
    }
    
}
