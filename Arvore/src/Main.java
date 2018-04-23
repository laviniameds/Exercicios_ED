
import binary.ClassBTArray;
import binary.NodeBT;
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
        
        /*
        
        TESTE ARVORE GENERICA

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
        
        System.out.println("\n");
        gt.printTree(root,"",true);
        
        gt.replace(gt.search(6), 25);
        
        System.out.println("\n");
        gt.printTree(root,"",true);
        
        gt.swapElements(gt.search(25), gt.search(3));
        
        System.out.println("\n");
        gt.printTree(root,"",true);
        
        */
        
        /*
        
        TESTE ARVORE BINARIA DE BUSCA(ARRAY)
        
        */
        
        ClassBTArray btA = new ClassBTArray("eae", 50);
        NodeBT root = (NodeBT)btA.root();
        
        btA.add(5, "opa");
        btA.add(2, "aaa");
        btA.add(1, "ccc");
        
        btA.printTree(root, "", true);
    }
}
