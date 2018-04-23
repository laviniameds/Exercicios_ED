package binary;

import interfaces.InvalidPositionException;
import interfaces.Position;
import interfaces.BinaryTree;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Vector;


public class ClassBT implements BinaryTree{
    NodeBT root;
    int size;
    
    public ClassBT(int key, Object o){
        root = new NodeBT(key, o, null);
        size = 1;
    }

    @Override
     public NodeBT getLeft(NodeBT no) throws InvalidPositionException {
        if(hasLeft(no))
            return no.getLeft();      
        else
            return null;
    }

    
     public NodeBT insertLeft(NodeBT no,Object o,int key) throws InvalidPositionException{
         if(hasLeft(no))
             throw new InvalidPositionException("Já tem nó esquerdo!");
         
         NodeBT n = new NodeBT(key,o,no);
         no.setLeft(n);
         n.setParent(no);
         size++;
         return n;
     }
     
   
    public NodeBT insertRight(NodeBT no,Object o, int key) throws InvalidPositionException{
        if(hasRight(no))
            throw new InvalidPositionException("Já tem nó direito!");
        
        NodeBT n = new NodeBT(key,o,no);
        no.setRight(n);
        size++;
        return n;
    }
     
     
    
    public NodeBT getRight(NodeBT no) throws InvalidPositionException {
         if(hasRight(no))
            return no.getRight();       
        else
            return null;
    }

    @Override
    public boolean hasLeft(NodeBT no) throws InvalidPositionException {
        return no.getLeft() != null;
    }

    @Override
    public boolean hasRight(NodeBT no) throws InvalidPositionException {
        return  no.getRight() != null;
    }

    @Override
    public int size() {
       return size;
    }

    @Override
    public int height(Position p) {
        NodeBT node = (NodeBT) p;
        int heightLeft;  
        int heightRight; 
        
        if(node!=null)  {  
            heightLeft = height(node.getLeft());  
            heightRight = height(node.getRight());   
            
            if(heightLeft > heightRight)   
                return (heightLeft+1);  
            else  
                return (heightRight+1);  
        }  
        else  
            return 0;
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
    //return sempre false, pois não se pode remover a raiz segundo as informações do prof
    public boolean isEmpty() {       
       return false;
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector();
        v = getVectorElements(v, root);
        
        return v.iterator();
    }
    
    private Vector getVectorElements(Vector v, NodeBT node) {
       
        if (node != null) {
            v.add(node.getElement());
            getVectorElements(v, node.getLeft());
            getVectorElements(v, node.getRight());
        }
        
        return v;
    }

    @Override
    public Iterator nos() {        
        
    }
    
    /*private Vector getVectorNos(Vector v, NodeBT node) {
       
        if (node != null) {
            v.add(node);
            getVectorElements(v, node.getLeft());
            getVectorElements(v, node.getRight());
        }
        
        return v;
    }*/

    @Override
    public NodeBT root() {
       return root;
    }

    @Override
    public Position parent(Position p) {
         NodeBT node = (NodeBT) p;
         return node.getParent();
    }

    @Override
    public Iterator children(Position p) {
        NodeBT node = (NodeBT) p;
        if(isExternal(node))
            return null;
        else{
            Vector children = new Vector();
            children.add(node.getLeft());
            children.add(node.getRight());
            return children.iterator();
        }
    }

    @Override
    public boolean isExternal(Position p) {
        NodeBT node = (NodeBT) p;
        return node.getLeft()== null && node.getRight()== null;
    }

    @Override
    public boolean isInternal(Position p) {
         NodeBT node = (NodeBT) p;
         return !isExternal(node); // ou return node.getLeft()!= null && node.getRight()!= null;
    }

    @Override
    public boolean isRoot(Position p) {
        NodeBT node = (NodeBT) p;
        return node == root;
    }

    @Override
    public Object replace(Position p, Object o) {
        NodeBT node = (NodeBT) p;
        Object aux = node.getElement();
        node.setElement(o);
        return aux;   
    }
    
  
    public NodeBT insert(Object o, int key,Position p) throws InvalidPositionException{        
          NodeBT node = (NodeBT) search(key,(NodeBT) p);
          if(key == node.getKey())//significa que o nodo é interno nesse caso faz uma chamada recursiva para o filho e insere
              return insert(o,key,node.getLeft());
          insertAtExternal(node,o);
          return node;
    }

    @Override
    public Object remove(Position p) throws InvalidPositionException {
       
        return null;
    }
    
    private NodeBT removeLower(NodeBT node) throws InvalidPositionException{
        if (node == null) {
            return root;
        } 
        else if (node.getLeft() != null) {
            node.setLeft(removeLower(node.getLeft()));
            return node;
        } 
        else
            return node.getRight();
    }

    @Override
    public NodeBT getSibling(NodeBT no) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Para o root como primeiro nodo
    public Position search(int key,Position p) throws InvalidPositionException {
        NodeBT node = (NodeBT) p;  
        if(isExternal(node))
            return node;
        if(key < node.getKey())
            return search(key,node.getLeft());
        else if(key == node.getKey())
            return node;
       else
            return search(key,node.getRight());
        
    }
    
    private void insertAtExternal(NodeBT node,Object o){
        node.setLeft(null);
        node.setRight(null);
        node.setElement(o);
        size++;
    }
    
   
   

    @Override
    public void swapElements(Position p1, Position p2) throws InvalidPositionException {
        NodeBT node1 = (NodeBT) p1;
        NodeBT node2 = (NodeBT) p2;
        Object aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
        
    }

    @Override
    public void add(Position p1, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position search(Object o) throws InvalidPositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    
   
    
}
