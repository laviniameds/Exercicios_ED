package sequencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public interface ISeq {
    
    public int size();
    public boolean isEmpty();
    public Object elemAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public Object insertAtRank(int r, Object o) throws Exception;
    public Object removeAtRank(int r);
    
    public Object first();
    public Object last();
    public Object before(ClassArrayNo n);
    public Object after(ClassArrayNo n);
    public Object replaceElement(ClassArrayNo n, Object o);
    public void swapElements(ClassArrayNo n, ClassArrayNo q);
    public Object insertBefore(ClassArrayNo n, Object o);
    public Object insertAfter(ClassArrayNo n, Object o);
    public Object insertFirst(Object o);
    public Object insertLast(Object o);
    public Object remove(ClassArrayNo n);
    
    public ClassArrayNo atRank(int r);
    public int rankOf(ClassArrayNo n);    
}
