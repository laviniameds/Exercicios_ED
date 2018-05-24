
package interfaces;

/**
 *
 * @author lucas
 */
public interface GenericTree extends Tree{
    public void add(Position p1, Object o);
    public Object remove(Position p1) throws InvalidPositionException;
    public Position search(Object o) throws InvalidPositionException;
    public void swapElements(Position p1, Position p2) throws InvalidPositionException;
}
