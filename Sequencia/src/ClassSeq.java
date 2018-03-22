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
    
    public ClassSeq(int tamanho){
        arrayNos = new ClassArrayNo[tamanho];       
    }
    
    private ClassArrayNo[] resize(){
        ClassArrayNo temp[];
              
        temp = new ClassArrayNo[size() * 2];  
        
        for(int i = 0; i < size(); i++)
            temp[i] = arrayNos[i];
        
        return temp;
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
        return atRank(r).getElemento();
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Object aux = atRank(r).getElemento();
        atRank(r).setElemento(o);
        
        return aux;
    }

    @Override
    public Object insertAtRank(int r, Object o) {
        if (size() == arrayNos.length-1)
            arrayNos = resize();
        
        ClassArrayNo no = new ClassArrayNo();
        no.setElemento(o);
        no.setIndice(r);
        
        ClassArrayNo aux;
                
        for(int i = r; i <= t+1; i++){
            aux = arrayNos[i];
            arrayNos[i] = no;
            no = aux;
            
            if(no != null)
                no.setIndice(i+1);
        } 
        t++;
        return o;
    }

    @Override
    public Object removeAtRank(int r) {
        Object aux = arrayNos[r].getElemento();
        
        for(int i = r;i < size(); i++)
            arrayNos[i] = arrayNos[i++];                  
        
        t--;
        return aux;
    }

    @Override
    public Object first() {
        return atRank(0).getElemento();
    }

    @Override
    public Object last() {
        return atRank(t).getElemento();
    }

    @Override
    public Object before(ClassArrayNo n) {
        return atRank(rankOf(n)-1).getElemento();
    }

    @Override
    public Object after(ClassArrayNo n) {
        return atRank(rankOf(n)+1).getElemento();
    }

    @Override
    public Object replaceElement(ClassArrayNo n, Object o) {
             
        Object aux = atRank(rankOf(n)).getElemento();           
        atRank(rankOf(n)).setElemento(o);
        atRank(rankOf(n)).setIndice(rankOf(n));

        return aux;   
    }

    @Override
    public void swapElements(ClassArrayNo n, ClassArrayNo q) {
        int rankQ = rankOf(q);
        int rankN = rankOf(n);
        
        atRank(rankN).setElemento(q.getElemento());
        atRank(rankN).setIndice(q.getIndice());
        
        atRank(rankQ).setElemento(n.getElemento());
        atRank(rankQ).setIndice(n.getIndice());
    }

    @Override
    public Object insertBefore(ClassArrayNo n, Object o) {
        return insertAtRank(rankOf(n)-1, o);
    }

    @Override
    public Object insertAfter(ClassArrayNo n, Object o) {
        return insertAtRank(rankOf(n)+1, o);
    }

    @Override
    public Object insertFirst(Object o) {
        return insertAtRank(0, o);       
    }

    @Override
    public Object insertLast(Object o) {
        return insertAtRank(t, o); 
    }

    @Override
    public Object remove(ClassArrayNo n) {
       return removeAtRank(rankOf(n));
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
