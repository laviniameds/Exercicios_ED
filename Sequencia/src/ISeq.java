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
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    
    public Object first();
    public Object last();
    public Object before(ClassNo n);
    public Object after(ClassNo n);
    public Object replaceElement(ClassNo n, Object o);
    public Object swapElements(ClassNo n, ClassNo q);
    public Object insertBefore(ClassNo n, Object o);
    public Object insertAfter(ClassNo n, Object o);
    public Object insertFirst(Object o);
    public Object insertLast(Object o);
    public Object remove(ClassNo n);
    
    public ClassNo atRank(int r);
    public Object rankOf(ClassNo n);    
}
