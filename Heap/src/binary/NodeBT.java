package binary;


import interfaces.Position;
import java.util.Vector;


public class NodeBT implements Position{
    private int key;
    private Object element;
    private NodeBT parent,left,right;
   
    public NodeBT(int key, Object element, NodeBT parent) {
        this.key = key;
        this.element = element;
        this.parent = parent;      
    }

    @Override
    public Object getElement() {
        return this.element;
    }
    
    public void setElement(Object element){
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
