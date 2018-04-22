
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
        
        ClassGT gt = new ClassGT(1);
        
        Position r = gt.root();
        NodeGT root = (NodeGT)gt.root();
        
        gt.add(r,2);
        gt.add(r,3);
        gt.add(r,4);
        
        
        gt.add(gt.search(2),5);
        gt.add(gt.search(2),6);
        gt.add(gt.search(2),7); 
        
        gt.printTree(root,"",true);
        
        gt.remove(gt.search(7));
        
        System.out.println("\n\n");
        gt.printTree(root,"",true);
    }
}
