/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import heap.Heap;
import interfaces.InvalidPositionException;

/**
 *
 * @author lavinia
 */
public class Main {
    
    public static void main(String[] args) throws InvalidPositionException{
        Heap heap = new Heap(5, "5", 200);
        
        heap.insert(56, "56");
        heap.insert(6, "6");
        heap.insert(7, "7");
        heap.insert(9, "9");
        heap.insert(6, "65");
        heap.insert(7, "7");
        heap.insert(2, "29");
        heap.insert(1, "1");
        
        heap.heapSort();
    }
      
}
