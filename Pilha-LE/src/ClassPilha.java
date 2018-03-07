/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassPilha {
    private int size;
    private ClassNo topo;
    
    public ClassPilha(){
        size = 0;       
    }
    
    public int getSize(){
        return size;
    }
    
    public void push(Object elemento){
        ClassNo no = new ClassNo();   
        
        no.setElemento(elemento);         
        no.setProximo(topo);
        
        topo = no;
        size++;
    }
    
    public ClassNo pop() throws EPilhaVazia{
        if (topo == null) 
            throw new EPilhaVazia("Pilha Vazia!");
        else{
            ClassNo aux;
            aux = topo;
            topo = topo.getProximo();
            size--;
            return aux;
        }
    }
    
    public ClassNo top() throws EPilhaVazia{
        if (topo == null) 
            throw new EPilhaVazia("Pilha Vazia!");
        else
            return topo;
    }
    
}
