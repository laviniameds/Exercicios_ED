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
    
    private ClassArrayNo arrayNos[];
    private int t = -1;
    
    private ClassArrayNo resize(){
        
    }

    @Override
    public int size() {
        return t-1;
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public Object elemAtRank(int r) {
        
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        
    }

    @Override
    public void insertAtRank(int r, Object o) {
        if (size() == arrayNos.length-1)
            arrayNos = resize();
        
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
    public Object before(ClassArrayNo n) {
        
    }

    @Override
    public Object after(ClassArrayNo n) {
        
    }

    @Override
    public Object replaceElement(ClassArrayNo n, Object o) {
        int rank = rankOf(n);
        
        if(rank != -1){
            Object aux = arrayNos[rank].getElemento();
            arrayNos[rank].setElemento(o);
        
            return aux;
        }
        return null;    
    }

    @Override
    public Object swapElements(ClassArrayNo n, ClassArrayNo q) {
        
    }

    @Override
    public Object insertBefore(ClassArrayNo n, Object o) {
        
    }

    @Override
    public Object insertAfter(ClassArrayNo n, Object o) {
        
    }

    @Override
    public Object insertFirst(Object o) {
        
    }

    @Override
    public Object insertLast(Object o) {
        
    }

    @Override
    public Object remove(ClassArrayNo n) {
       
    }

    @Override
    public ClassArrayNo atRank(int r) {
        return arrayNos[r];       
    }

    @Override
    public int rankOf(ClassArrayNo n) {
        for(ClassArrayNo no:arrayNos){
            if(n.getElemento() == no.getElemento())
                return no.getIndice();
        }
        return -1;
    }
    
    
}
