package binary;


import interfaces.Position;
import java.util.Vector;


public class NodeBT implements Position{
    private Object element;
    private NodeBT parent,left,right;
   
    //coloquei o costrutor com apenas esses dois atributos
    public NodeBT(Object element, NodeBT parent) {
        this.element = element;
        this.parent = parent;      
    }
    
    @Override
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public NodeBT getParent() {
        return parent;
    }

    public void setParent(NodeBT parent) {
        this.parent = parent;
    }

    public NodeBT getLeft() {
        return left;
    }

    public void setLeft(NodeBT left) {
        this.left = left;
        
    }

    public NodeBT getRight() {
        return right;
    }

    public void setRight(NodeBT right) {
        this.right = right;
    }
    
}
