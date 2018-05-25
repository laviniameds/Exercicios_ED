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
    private int size;
    
    public Heap(int key, Object o, int tam){
        array = new NodeBT[tam];
        array[0] = new NodeBT(size, size, null);
        array[1] = new NodeBT(key, o, null);
        size = 1;
    }

    public void insert(int key, Object o){
        NodeBT parent = array[getIndexParent(++size)];
        NodeBT no = new NodeBT(key, o, parent);

        array[size] = no;
        upHeap(key, size);
    }
    
    public void heapSort(){
        while(size != 0){
            System.out.print(remmoveMin() + " ");
        }
    }
    
    public Object min(){
       return array[1].getElement(); 
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void mostrar(){
        System.out.println(size());
        for(int i = 1;i<array.length;i++){
            if(array[i] != null){
                System.out.println("index: " + i +" Key: " +array[i].getKey() + " Element: " + array[i].getElement());
            }
        }
    }
    
    private Object remmoveMin(){
        NodeBT aux = array[1];
        array[1] = array[size];
        array[1].setParent(null);
        array[size] = null;
        size--;
        downHeap();
        return aux.getKey();
    }
    
    private void swap(int index1, int index2) {
        NodeBT no = array[index1];
        array[index1] = array[index2];
        array[index2] = no;
    }
    
    private void upHeap(int key, int index){

        while(index > 1){
            if(key < array[getIndexParent(index)].getKey())
                swap(index, getIndexParent(index));           
            index = getIndexParent(index);
        }  
        
    }
    
    private void downHeap(){
        int index = 1;
        while (index <= size) {
            if (hasLeft(index) && hasRight(index)) {
                if (array[leftIndex(index)].getKey() < array[index].getKey() && array[rightIndex(index)].getKey() < array[index].getKey()) {
                    if (array[rightIndex(index)].getKey() < array[leftIndex(index)].getKey()) {
                        swap(index, rightIndex(index));
                        index = rightIndex(index);
                    } else {
                        swap(index, leftIndex(index));
                        index = leftIndex(index);
                    }
                    continue;
                } else if (array[leftIndex(index)].getKey() < array[index].getKey()) {
                    swap(index, leftIndex(index));
                    index = leftIndex(index);
                    continue;
                } else if (array[rightIndex(index)].getKey() < array[index].getKey()) {
                    swap(index, rightIndex(index));
                    index = rightIndex(index);
                    continue;
                }
            } else if (hasLeft(index) && array[leftIndex(index)].getKey() < array[index].getKey()) {
                swap(index, leftIndex(index));
                index = leftIndex(index);
                continue;
            } else if (hasRight(index) && array[rightIndex(index)].getKey() < array[index].getKey()) {
                swap(index, rightIndex(index));
                index = rightIndex(index);
                continue;
            }
            break;
        }
    }
    
    private boolean hasLeft(int index) {
        return !(leftIndex(index) > size || array[leftIndex(index)] == null);
    }

    private boolean hasRight(int index) {
        return !(rightIndex(index) > size || array[rightIndex(index)] == null);
    }
    
    private int leftIndex(int index) {
        return index * 2;
    }

    private int rightIndex(int index) {
        return (index * 2) + 1;
    }
    
    private int getIndexParent(int index){
        if(index % 2 == 0)
            return index/2;
        else
            return (index-1)/2;
    }
}
