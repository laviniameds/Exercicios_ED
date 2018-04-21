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

    @Override
    public void addChild(Position p, Object o) {
        
    }

    @Override
    public Object remove(Position p) throws InvalidPositionException {
        
    }

    @Override
    public Object search(Position p) throws InvalidPositionException {
        
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
            Iterator<NodeGT> itr = no.children();
            int h = 0;
            while(itr.hasNext()){
                NodeGT noChild = itr.next();
                h = Math.max(h, altura(noChild));
            }
            return 1 + h;
        }
    }

    @Override
    public int depth(Position p) {
        NodeGT no = (NodeGT) p;
        return depth(no);
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
        
    }

    @Override
    public Iterator nos() {
        
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

    @Override
    public Object replace(Position p, Object o) {
        
    }
    
}
