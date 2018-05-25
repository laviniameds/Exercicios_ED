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
        Heap heap = new Heap(5, "oi eu sou antigo root", 20);
        
        heap.insert(8, "topper");
        heap.insert(15, "vkevefe");
        heap.insert(10, "epaa");
        heap.insert(1, "root novo");
        
        heap.mostrar();
    }
      
}
