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
public class ClassBTArray implements BinaryTree{
    
    private NodeBT[] array;
    private int size = 0;
    
    public ClassBTArray(Object o, int tam){
        array = new NodeBT[tam];
        array[0] = new NodeBT(0, size, null);
    }

    @Override
    public NodeBT getLeft(NodeBT no) throws InvalidPositionException {
        return no.getLeft();
    }

    @Override
    public NodeBT getRight(NodeBT no) throws InvalidPositionException {
        return no.getRight();
    }

    @Override
    public NodeBT getSibling(NodeBT no) throws InvalidPositionException {
        NodeBT father = no.getParent();
        if(father.getLeft().getElement().equals(no.getElement()))
            return father.getRight();
        else
            return father.getLeft();
    }

    @Override
    public boolean hasLeft(NodeBT no) throws InvalidPositionException {
        return (no.getLeft() == null);
    }

    @Override
    public boolean hasRight(NodeBT no) throws InvalidPositionException {
        return (no.getRight()== null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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

    @Override
    public int depth(Position p) {
        NodeBT node = (NodeBT) p;
        
        if(isRoot(node))
            return 0;
        else
            return 1 + depth(node.getParent()); 
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector();
        for(int i = 0;i<array.length;i++)
            v.add(array[i].getElement());
        return v.iterator();  
    }

    @Override
    public Iterator nos() {
        Vector v = new Vector();
        for(int i = 0;i<array.length;i++)
            v.add(array[i]);
        return v.iterator();
    }

    @Override
    public Position root() {
        return array[0];
    }

    @Override
    public Position parent(Position p) {
        NodeBT no = (NodeBT)p;
        return array[no.getKey()].getParent();
    }

    @Override
    public Iterator children(Position p) {
        NodeBT no = (NodeBT)p;
        Vector v = new Vector();
        v.add(array[no.getKey()+1]);
        v.add(array[no.getKey()+2]);
        return v.iterator();
    }

    @Override
    public boolean isExternal(Position p) {
        NodeBT node = (NodeBT) p;
        return array[node.getKey()+1] == null && array[node.getKey()+2] == null;
    }

    @Override
    public boolean isInternal(Position p) {
        return (!isExternal(p));
    }

    @Override
    public boolean isRoot(Position p) {
        NodeBT node = (NodeBT) p;
        return array[0].getElement() == node.getElement();
    }

    @Override
    public Object replace(Position p, Object o) {
        NodeBT node = (NodeBT) p;
        Object aux = node.getElement();
        node.setElement(o);
        return aux;
    }

    @Override
    public void add(int key, Object o) {
        NodeBT no = insertRec(array[0], key);
        no.setElement(o);
        array[size++] = no;
    }
    
    public NodeBT insertRec(NodeBT root, int key) {

        if (root == null) {
            root = new NodeBT(key, null, root);
            return root;
        }

        if (key < root.getKey())
            root.setLeft(insertRec(root.getLeft(), key));
        else if (key > root.getKey())
            root.setRight(insertRec(root.getRight(), key));
 
        return root;
    }

    @Override
    public Object remove(int key) throws InvalidPositionException {
        if(isExternal(array[key])){
            Object aux = array[key].getElement();
            array[key] = null;
            return aux;  
        }  
        else
            throw new InvalidPositionException("nó interno!");
    }

    @Override
    public int search(Object o) throws InvalidPositionException {
        for(int i=0;i<array.length;i++){
          if(array[i].getElement() == o)
              return i;
          else throw new InvalidPositionException("nao achou");
        }
        return 0;
    }
    
}
