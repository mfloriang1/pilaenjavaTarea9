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
public class Pila {
    private int n;//# elementos
    private int tope;
    private Object pila[];

    public Pila(int n) {//constructor
        this.n = n;
        tope=0;
        pila=new Object[n];
    }
    
    public boolean estaVacia(){
        return tope ==0;
            
    }
    
    public boolean estaLlena(){
        return tope ==n;
            
    }
    
    public boolean apliar(Object dato){
        if (estaLlena()) {
            return false;
        }
        pila[tope]=dato;
        tope++;
        return true;
    }
    public Object desapilar(){
        if (estaVacia()){
            return null;
        }
        tope--;
        return pila[tope];
    }
    public Object ElementoTope(){
        return pila[tope-1];//para imprir el ultimo signo
    }

    
}
