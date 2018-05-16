/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

import interfaces.BinaryTree;
import interfaces.InvalidPositionException;
import interfaces.Position;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author lavinia
 */
public class ClassBTArray{
    
    private NodeBT[] array;
    private int size = 0;
    
    public ClassBTArray(int key, Object o, int tam){
        array = new NodeBT[tam];
        array[0] = new NodeBT(0, size, null);
        array[1] = new NodeBT(key, o, null);
    }

    
    public NodeBT getLeft(NodeBT no) throws InvalidPositionException {
        return no.getLeft();
    }

    
    public NodeBT getRight(NodeBT no) throws InvalidPositionException {
        return no.getRight();
    }

    
    public NodeBT getSibling(NodeBT no) throws InvalidPositionException {
        NodeBT father = no.getParent();
        if(father.getLeft().getElement().equals(no.getElement()))
            return father.getRight();
        else
            return father.getLeft();
    }

    
    public boolean hasLeft(NodeBT no) throws InvalidPositionException {
        return (no.getLeft() == null);
    }

    
    public boolean hasRight(NodeBT no) throws InvalidPositionException {
        return (no.getRight()== null);
    }

    
    public int size() {
        return size;
    }

    
    public int height(Position p) {
        NodeBT node = (NodeBT) p;
        int l = height(node.getLeft());
        int r = height(node.getRight());

        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    
    public int depth(Position p) {
        NodeBT node = (NodeBT) p;
        
        if(isRoot(node))
            return 0;
        else
            return 1 + depth(node.getParent()); 
    }

    
    public boolean isEmpty() {
        return false;
    }

    
    public Iterator elements() {
        Vector v = new Vector();
        for(int i = 0;i<array.length;i++)
            v.add(array[i].getElement());
        return v.iterator();  
    }

    
    public Iterator nos() {
        Vector v = new Vector();
        for(int i = 0;i<array.length;i++)
            v.add(array[i]);
        return v.iterator();
    }

    
    public Position root() {
        return array[1];
    }

    
    public Position parent(Position p) {
        NodeBT no = (NodeBT)p;
        return array[no.getKey()].getParent();
    }

    
    public Iterator children(Position p) {
        NodeBT no = (NodeBT)p;
        Vector v = new Vector();
        v.add(array[no.getKey()+1]);
        v.add(array[no.getKey()+2]);
        return v.iterator();
    }

    
    public boolean isExternal(Position p) {
        NodeBT node = (NodeBT) p;
        return array[node.getKey()+1] == null && array[node.getKey()+2] == null;
    }

    
    public boolean isInternal(Position p) {
        return (!isExternal(p));
    }

    
    public boolean isRoot(Position p) {
        NodeBT node = (NodeBT) p;
        return array[1].getElement() == node.getElement();
    }

    
    public Object replace(Position p, Object o) {
        NodeBT node = (NodeBT) p;
        Object aux = node.getElement();
        node.setElement(o);
        return aux;
    }

    
    public void add(int key, Object o) {
        NodeBT no = insert(key);
        
        if(no.getKey() < no.getParent().getKey())
            no.getParent().setLeft(no);       
        else
            no.getParent().setRight(no);
        
        no.setElement(o);
    }
    
    public NodeBT insert(int key) {
        
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
    
    
    private Object remover(int key) throws InvalidPositionException{
        NodeBT no = search(key);
        return remove(no, key);
    }

  
    public Object remove(NodeBT no, int key) throws InvalidPositionException {
               
        Object aux = new Object();     

        if (isExternal(no)){
            aux = no.getElement();
            no = null;
            return aux;
        }       
        if(hasLeft(no) && !hasRight(no)){
            aux = no.getElement();
            no.setElement(no.getLeft().getElement());
            no.setLeft(null);
            return aux;
        }
        else if(!hasLeft(no) && hasRight(no)){
            aux = no.getElement();
            no.setElement(no.getRight().getElement());
            no.setRight(null);
            return aux;
        }
        else{
            NodeBT n = no.getRight();
            while(n.getLeft() != null){
                n = n.getLeft();
            }
            aux = n.getElement();
            int intKey = n.getKey();
            remove(n, intKey);
            n.setElement(aux);
            size--;
            return aux; 
        }
               
        
        
        /*
        int i = 1;
        
        while(i<array.length){
            if(no.getLeft() == null && no.getRight() == null){
                if(no.getParent().getLeft() == no){
                    no.getParent().setLeft(null);
                }
                else if(no.getParent().getRight() == no){
                    no.getParent().setRight(null);
                }               
            }
        }*/
    
        
/*        while(true){
            if (array[i] == no){
                array[i] = null;
            } 
            else if (array[i].getKey() < key){
                i = (2 * i + 1); 
            }
            else if (array[i].getKey() > key)
                i = (2 * i);           
        }
*/
    }

    public NodeBT search(int key){        
        int i = 1;
        
        while(i<array.length){
            if(array[i].getKey() == key)
                return array[i];
            else if (array[i].getKey() < key){
                i = (2 * i + 1); 
            }
            else if (array[i].getKey() > key)
                i = (2 * i);              
        }
        return null;
    }
    
    public void printTree(){
        int i = 1;
        
        
    }

    
}
