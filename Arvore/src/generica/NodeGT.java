package generica;

import interfaces.Position;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author lucas
 */
public class NodeGT implements Position{
    private NodeGT parent;
    private Object element;
    private Vector children = new Vector(); //Coleção com todos os filhos do nó
   
    public Object getElement() {
      return element;
    }
    
    public void setElement(Object element){
        this.element = element;
    }

    public NodeGT getParent() {
        return parent;
    }

    public void setParent(NodeGT parent) {
        this.parent = parent;
    }
    
    public void addChild(NodeGT n){
        children.add(n);
        
    }
    
    public int childrenNumber(){
        return children.size();
    }
    
    public Iterator children(){
        return children.iterator();
    }
    
    
    
}
