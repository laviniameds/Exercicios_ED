/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic;

import interfaces.GenericTree;
import interfaces.InvalidPositionException;
import interfaces.Position;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lavinia
 */
public class ClassGT implements GenericTree{
    
    private NodeGT root;
    private int size;
    
    public ClassGT(Object o){
        root = new NodeGT(null, o);
        size = 1;
    }
    
    public void printTree(NodeGT no, String indent, Boolean last){
        System.out.println(indent + "+- " + no.getElement());
        indent += last ? "   " : "|  ";
                
        Iterator itr = no.children();
        while(itr.hasNext()){
            NodeGT n = (NodeGT)itr.next();
            printTree(n, indent, itr.hasNext());
        }
    }

    @Override
    public void add(Position p, Object o) {
        NodeGT no = (NodeGT) p;
        NodeGT noFilho = new NodeGT(no, o);
        no.addChild(noFilho);
        size++;
    }

    @Override
    public Object remove(Position p) throws InvalidPositionException {
        NodeGT no = (NodeGT) p;
        NodeGT father = no.getParent();
        Object o = no.getElement();
        if (father != null || isExternal(no))
            father.removeChild(no);      
        else
            throw new InvalidPositionException("Nó inválido!");
        size--;
        return o;
    }

    @Override
    public Position search(Object o) throws InvalidPositionException {
        Iterator itr = nos();
                
        while(itr.hasNext()){
            NodeGT no = (NodeGT)itr.next();          
            if(no.getElement().equals(o))
                return no;
        }
        return null;
    }
    
    @Override
    public Object replace(Position p, Object o) {
        NodeGT no = (NodeGT) p;
        Object aux = no.getElement();
        no.setElement(o);
        return aux;
    }

    @Override
    public void swapElements(Position p1, Position p2) throws InvalidPositionException {
        NodeGT no1 = (NodeGT)p1;
        NodeGT no2 = (NodeGT)p2;
        
        Object o1 = no1.getElement();
        Object o2 = no2.getElement();
        
        no1.setElement(o2);
        no2.setElement(o1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height(Position p) {
        NodeGT no = (NodeGT) p;
        return altura(no);
    }
    
    private int altura(NodeGT no){
        if(isExternal(no))
            return 0;
        else {
            Iterator itr = no.children();
            int h = 0;
            while(itr.hasNext()){
                NodeGT noChild = (NodeGT)itr.next();
                h = Math.max(h, altura(noChild));
            }
            return 1 + h;
        }
    }

    @Override
    public int depth(Position p) {
        NodeGT no = (NodeGT) p;
        return profundidade(no);
    }
    
    private int profundidade(NodeGT no){
        if (no == root)
            return 0;
        else
            return 1 + profundidade(no.getParent());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector();
        return getElements(v, root()).iterator();
    }
    
    public Vector getElements(Vector v, Position p){        
        NodeGT no = (NodeGT)p;
        v.add(no.getElement());
        
        if (isInternal(no)) {
            Iterator itr = no.children();
            while (itr.hasNext()) {
                NodeGT NoChild = (NodeGT) itr.next();
                Vector childs = getElements(v, NoChild);
                v.addAll(childs);
            }
        }
        
        return v;
    }

    @Override
    public Iterator nos() {
        Vector v = new Vector();
        return getNos(v, root()).iterator();
    }
    
    public Vector getNos(Vector v, Position p){ 
        NodeGT no = (NodeGT)p;
        v.add(no);
        
        if (isInternal(no)) {
            Iterator itr = no.children();
            while (itr.hasNext()) {
                NodeGT NoChild = (NodeGT) itr.next();
                Vector childs = getNos(v, NoChild);
                v.addAll(childs);
            }
        }
        
        return v;
    }

    @Override
    public Position root() {
        return root;
    }

    @Override
    public Position parent(Position p) {
        NodeGT no = (NodeGT) p;
        return no.getParent();
    }

    @Override
    public Iterator children(Position p) {
        NodeGT no = (NodeGT) p;
        return no.children();
    }

    @Override
    public boolean isExternal(Position p) {
        NodeGT no = (NodeGT) p;
        return (no.childrenNumber() == 0);  
    }

    @Override
    public boolean isInternal(Position p) {
        NodeGT no = (NodeGT) p;
        return (no.childrenNumber() > 0);  
    }

    @Override
    public boolean isRoot(Position p) {
        return (p == root());
    }
    
}
