/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassFila{
    private int size;
    private ClassNo inicio, fim;
    
    public ClassFila(){
        size = 0;
    }

    public int tamanho() {
        return size;
    }

    public boolean estaVazia() {
        return (size == 0);
    }
    
    public ClassNo inicio() throws EFilaVazia {
        if(estaVazia())
            throw new EFilaVazia("Fila Vazia!");
        else
            return inicio;
    }

    public void enfileirar(Object o){        
        ClassNo no = new ClassNo();       
        no.setElemento(o);                                
        no.setProximo(null);
        
        if(inicio == null)            
            inicio = fim = no;
        
        else{
            fim.setProximo(no);
            fim = no; 
        }
        
        size++; 
    }

    public ClassNo desenfileirar() throws EFilaVazia {
        if (estaVazia()) 
            throw new EFilaVazia("Fila Vazia!");
        else{
            ClassNo aux;
            
            aux = inicio;
            inicio = inicio.getProximo();           
            size--;
            aux.getProximo().setElemento(null);
            
            return aux;
        }
    }
    
}