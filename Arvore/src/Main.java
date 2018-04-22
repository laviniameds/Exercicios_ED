
import generic.ClassGT;
import generic.NodeGT;
import interfaces.InvalidPositionException;
import interfaces.Position;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class Main {
    
    public static void main(String[] args) throws InvalidPositionException{
        
        ClassGT gt = new ClassGT("a");
        
        Position r = gt.root();
        NodeGT root = (NodeGT)gt.root();
        
        gt.add(r,"b");
        gt.add(r,"c");
        gt.add(r,"d");
        
        
        gt.add(gt.search("b"),"e");
        gt.add(gt.search("b"),"f");
        gt.add(gt.search("b"),"g"); 
        
        gt.printTree(root,"",true);
        
        gt.remove(gt.search("e"));
        gt.add(gt.search("c"),"f");
        
        System.out.println("\n\n");
        gt.printTree(root,"",true);
    }
}
