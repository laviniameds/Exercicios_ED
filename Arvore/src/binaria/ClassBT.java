package binaria;


import interfaces.InvalidPositionException;
import interfaces.Position;
import interfaces.BinaryTree;
import java.util.Iterator;
import java.util.ArrayList;


public class ClassBT implements BinaryTree{
    NodeBT root;
    int size;
    
    public ClassBT(Object o){
        root = new NodeBT(o,null);
        size = 1;
    }

    @Override
     public NodeBT left(NodeBT no) throws InvalidPositionException {
        if(hasLeft(no)){
            return no.getLeft();
        }
        else
            return null;
    }

     @Override
      public NodeBT insertLeft(NodeBT no,Object o) throws InvalidPositionException{
          if(hasLeft(no)){
              //lançar exceção se no já tiver um filho esquerdo
          }
          NodeBT n = new NodeBT(o,no);
          no.setLeft(n);
          size++;
          return n;
      }
      @Override
      public NodeBT insertRight(NodeBT no,Object o) throws InvalidPositionException{
          if(hasRight(no)){
              //lançar exceção se no já tiver um filho direita(bolsonaro)
          }
          NodeBT n = new NodeBT(o,no);
          no.setRight(n);
          size++;
          return n;
      }
     
     
    @Override
    public NodeBT right(NodeBT no) throws InvalidPositionException {
         if(hasRight(no)){
            return no.getRight();
        }
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
        //falta implementar
    }

    @Override
    public Iterator nos() {
       //falta implementar
    }

    @Override
    public Position root() {
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
   
    
  

   
    
}
