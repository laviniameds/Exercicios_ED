package interfaces;

import binaria.NodeBT;

public interface BinaryTree extends Tree {
    public NodeBT left(NodeBT no) throws InvalidPositionException;
    public NodeBT right(NodeBT no) throws InvalidPositionException;
    public boolean hasLeft(NodeBT no) throws InvalidPositionException;
    public boolean hasRight(NodeBT no) throws InvalidPositionException;
    public NodeBT insertLeft(NodeBT no,Object o) throws InvalidPositionException;
    public NodeBT insertRight(NodeBT no,Object o) throws InvalidPositionException;
        
}
