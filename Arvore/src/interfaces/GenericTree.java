
package interfaces;

import generic.NodeGT;

/**
 *
 * @author lucas
 */
public interface GenericTree extends Tree{
        public void addChild(Position p, Object o);
        public Object remove(Position p) throws InvalidPositionException;
        public Object search(Position p) throws InvalidPositionException; 
}
