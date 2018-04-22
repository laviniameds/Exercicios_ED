
package interfaces;

/**
 *
 * @author lucas
 */
public interface GenericTree extends Tree{
        public void add(Position p, Object o);
        public Object remove(Position p) throws InvalidPositionException;
        public Position search(Object p) throws InvalidPositionException;
        public void swapElements(Position p1, Position p2) throws InvalidPositionException;
}
