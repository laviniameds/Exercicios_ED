/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassNo {
    private Object elemento;
    private ClassNo proximo;
    
    public Object getElemento() {
        return elemento;
    }
    
    public void setElemento(Object o){
        elemento = o;
    }
    
    public void setProximo(ClassNo o){
        proximo = o;
    }
    
    public ClassNo getProximo() {
        return proximo;
    }
    
}
