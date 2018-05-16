package binary;

import generic.NodeGT;
import interfaces.InvalidPositionException;
import interfaces.Position;
import interfaces.BinaryTree;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClassBT implements BinaryTree{
    NodeBT root;
    int size;
    ArrayList<NodeBT> nodesPost = new ArrayList<NodeBT>();
    ArrayList<NodeBT> nodesPre = new ArrayList<NodeBT>();
    ArrayList<NodeBT> nodesIn = new ArrayList<NodeBT>();
    
    public ClassBT(){
        root = null;
        size = 0;
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
        if(root == null)
            return 0;
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
   
    public boolean isEmpty() {       
       return root == null;
    }

    @Override
    public Iterator elements() {
        if(isEmpty())
            return null;
        ArrayList<Object> elements = new ArrayList<Object>();
        Iterator nodes = inOrder(root);
        while(nodes.hasNext()){
            NodeBT node = (NodeBT) nodes.next();
            elements.add(node.getElement());
        }
        return elements.iterator();
    }
    
    @Override
    public Iterator nos() {   
        if(root == null)
            return null;
        else
            return inOrder(root);
    }

    @Override
    public NodeBT root() {
       return root;
    }
    
    public void setRoot(NodeBT root){
        this.root = root;
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
            ArrayList<NodeBT> children = new ArrayList<NodeBT>();
            children.add(node.getLeft());
            children.add(node.getRight());
            return (Iterator) children;
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
        NodeBT node;  
        if(isEmpty()){
              node = new NodeBT(key,o,null);
              setRoot(node);
              size++;
          }
          else{
          node = (NodeBT) search(key,(NodeBT) p);
          if(key == node.getKey())//significa que o nodo é interno nesse caso faz uma chamada recursiva para o filho e insere
              return insert(o,key,node.getLeft());
          insertAtExternal(node,o);
          size++;
          }
          return node;
        }

    @Override
    public Object remove(int key) throws InvalidPositionException {
        if( isEmpty()){
            throw new InvalidPositionException("Ávore vazia");
        }
        NodeBT node = (NodeBT) search(key, root);
        if(isRoot(node)){
            throw new InvalidPositionException("Não é possível remover a raiz");
         }
        if(isExternal(node)){
            if(node.getKey()<= node.getParent().getKey())
                node.getParent().setLeft(null);
            else
                node.getParent().setRight(null);
            
        }
        if(hasLeft(node) && !hasRight(node)){
            if(node.getKey()<= node.getParent().getKey()){
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
            else{
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getRight());
            }
            size--;
            return node;
        }
        if(!hasLeft(node) && hasRight(node)){
            if(node.getKey()<= node.getParent().getKey()){
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
                
            }
            else{
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
            }
            size--;
            return node;
        }
       NodeBT passer = node.getRight();
        while (passer.getLeft() != null) 
                passer = passer.getLeft();
        
        int auxKey = passer.getKey();
        remove(auxKey);
        node.setKey(auxKey);
        size--;
        return node;
    
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
        if(isEmpty()){
            throw new InvalidPositionException("ávore vazia.");
        }
        NodeBT node = no.getParent();
        NodeBT nodeAux = null;
        if(node.getLeft()==no)
            nodeAux = node.getRight();
        else if(node.getRight()==no)
            nodeAux =  node.getLeft();
        return nodeAux;
    }
    
    @Override
    public void add(int key, Object o) throws InvalidPositionException {
        NodeBT node = new NodeBT(key,o,null);
        NodeBT node2 = (NodeBT) search(key,root());
        if(key == node2.getKey()){
           throw new InvalidPositionException("Posição inválida");
        }
        else if(key<node2.getKey()){
            node2.setLeft(node);
            node.setParent(node2);
            size++;
        }
        
        else{
            node2.setRight(node);
            node.setParent(node2);
            size++;
        }
       
    }
    //Para o root como primeiro nodo

    public Position search(int key,Position p){
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
    
    
    public void swapElements(Position p1, Position p2) throws InvalidPositionException {
        NodeBT node1 = (NodeBT) p1;
        NodeBT node2 = (NodeBT) p2;
        Object aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
        
    }
    
    public Iterator posOrder(Position p){

        NodeBT node = (NodeBT) p;
        if(node.getLeft() != null){
            posOrder(node.getLeft());
        }
        if(node.getRight() != null)
            posOrder(node.getRight());
        nodesPost.add(node);
        return nodesPost.iterator();
    }
    
    
    public Iterator preOrder(Position p){
        NodeBT node = (NodeBT) p;
        nodesPre.add(node);
        if(node.getLeft() != null)
            preOrder(node.getLeft());
        if(node.getRight()!=null)
            preOrder(node.getRight());
        return nodesPre.iterator();
    }
    
    public Iterator inOrder(Position p){
        NodeBT node = (NodeBT) p;
        if(isInternal(node)){
            inOrder(node.getLeft());
            nodesIn.add(node);
        }
        else if(node != null){
            nodesIn.add(node);
        }
        if(isInternal(node)){
            inOrder(node.getRight());
        }
        return nodesIn.iterator();    
       
    }
   
        
    public void printTree(NodeBT no, String indent, Boolean last){
        System.out.println(indent + "+- " + no.getElement());
        indent += last ? "   " : "|  ";
                
        Iterator itr = inOrder(no);
        while(itr.hasNext()){
            NodeBT n = (NodeBT)itr.next();
            printTree(n, indent, itr.hasNext());
        }
    }
     
    
}
