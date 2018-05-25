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
    private int lastindex;
    
    public Heap(int key, Object o, int tam){
        array = new NodeBT[tam];
        array[0] = new NodeBT(0, size, null);
        array[1] = new NodeBT(key, o, null);
    }

    public void insert(int key, Object o){
        NodeBT no = inserir(key);
        
        if(no.getKey() > no.getParent().getKey())
            no.getParent().setLeft(no);       
        else
            no.getParent().setRight(no);
        
        no.setElement(o);
        size++;
        
        upHeap(key, lastindex);
    }
    
    private NodeBT inserir(int key) {
        
        lastindex = 1;
        int indexParent = 1;
        
        while(true){
            if (array[lastindex] == null){
                array[lastindex] = new NodeBT(key, null, array[indexParent]);
                return array[lastindex];
            } 
            else if (key < array[lastindex].getKey()){
                indexParent = lastindex;
                lastindex = (2 * lastindex + 1); 
            }
            else if (key > array[lastindex].getKey())
                indexParent = lastindex;
                lastindex= (2 * lastindex);           
        }
    }
        
    /*public Object removeMin(int key){
        
    }*/
    
    private int getIndexParent(int i){
        if(i % 2 == 0)
            return i/2;
        else
            return (i-1)/2;
    }
    
    private void upHeap(int key, int index){
        while(key < array[index].getParent().getKey() || index >= 1){            
            NodeBT aux = array[getIndexParent(index)];            
            array[getIndexParent(index)] = array[index];
            array[index] = aux;
            
            array[index].setParent(aux.getParent());
            aux.setParent(array[index]);
            
            index = getIndexParent(index);
        }
    }
    
    /*private void downHeap(){
        
    }*/
    
    public Object min(){
       return array[lastindex].getElement(); 
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
            if(array[i] != null){
                System.out.println("Key: " +array[i].getKey() + " Element: " + array[i].getElement());
            }
        }
        System.out.println(array[1].getLeft().getElement());
    }
}
