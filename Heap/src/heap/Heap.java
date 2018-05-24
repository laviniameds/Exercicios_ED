/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import binary.NodeBT;

/**
 *
 * @author lavinia
 */
public class Heap{
    
    private NodeBT[] array;
    private int size = 1;
    private int lastKey;
    
    public Heap(int key, Object o, int tam){
        array = new NodeBT[tam];
        array[0] = new NodeBT(0, size, null);
        array[1] = new NodeBT(key, o, null);
    }

    public void insert(int key, Object o){
        NodeBT no = inserir(key);
        
        if(no.getKey() < no.getParent().getKey())
            no.getParent().setLeft(no);       
        else
            no.getParent().setRight(no);
        
        no.setElement(o);
        size++;
    }
    
    private NodeBT inserir(int key) {
        
        int i = 1;
        int indexParent = 1;
        
        while(true){
            if (array[i] == null){
                array[i] = new NodeBT(key, null, array[indexParent]);
                return array[i];
            } 
            else if (key > array[i].getKey()){
                indexParent = i;
                i = (2 * i + 1); 
            }
            else if (key < array[i].getKey())
                indexParent = i;
                i = (2 * i);           
        }
    }
        
    /*public Object removeMin(int key){
        
    }
    
    private void upHeap(){
        
    }
    
    private void downHeap(){
        
    }*/
    
    public Object min(){
       return array[lastKey].getElement(); 
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return false;
    }
    
    public void mostrar(){
        System.out.println(size());
        for(int i = 1;i<array.length;i++){
            if(array[i] != null)
                System.out.println("Key: " +array[i].getKey() + " Element: " + array[i].getElement());
        }                
    }
}
