/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassSeq implements ISeq{
    
    private Object arrayNos[];
    private int n, i, f, FC;

    @Override
    public int size() {
        return (n - i + f) % n;
    }

    @Override
    public boolean isEmpty() {
        return (i == f);
    }

    @Override
    public Object elemAtRank(int r) {
        
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        
    }

    @Override
    public void insertAtRank(int r, Object o) {
        
    }

    @Override
    public Object removeAtRank(int r) {
        
    }

    @Override
    public Object first() {
        
    }

    @Override
    public Object last() {
        
    }

    @Override
    public Object before(ClassNo n) {
        
    }

    @Override
    public Object after(ClassNo n) {
        
    }

    @Override
    public Object replaceElement(ClassNo n, Object o) {
        
    }

    @Override
    public Object swapElements(ClassNo n, ClassNo q) {
        
    }

    @Override
    public Object insertBefore(ClassNo n, Object o) {
        
    }

    @Override
    public Object insertAfter(ClassNo n, Object o) {
        
    }

    @Override
    public Object insertFirst(Object o) {
        
    }

    @Override
    public Object insertLast(Object o) {
        
    }

    @Override
    public Object remove(ClassNo n) {
       
    }

    @Override
    public ClassNo atRank(int r) {
        
        
    }

    @Override
    public Object rankOf(ClassNo n) {
        
    }
    
    
}
