package interfaces;


import java.util.Iterator;

public interface Tree {
    public int size();
    public int height(Position p);
    public int depth(Position p);
    public boolean isEmpty();
    public Iterator elements();
    public Iterator nos();
    public Position root();
    public Position parent(Position p);
    public Iterator children(Position p);
    public boolean isExternal(Position p);
    public boolean isInternal(Position p);
    public boolean isRoot(Position p);
    public Object replace(Position p,Object o); 
    
    public void add(Position p1, Object o);
    public Object remove(Position p1) throws InvalidPositionException;
    public Position search(Position p1) throws InvalidPositionException;
    public void swapElements(Position p1, Position p2) throws InvalidPositionException;
}
