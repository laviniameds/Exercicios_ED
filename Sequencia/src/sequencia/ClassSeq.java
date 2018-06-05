package sequencia;


import java.util.Random;

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
              
        temp = new ClassArrayNo[arrayNos.length * 2];  
        
        for(int i = 0; i < size(); i++){
            temp[i] = arrayNos[i];
            temp[i].setIndice(i);
        }
        
        return temp;
    }

    @Override
    public int size() {
        return t+1;
    } 

    @Override
    public boolean isEmpty() {
        return (t < 0);
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
        if (t == arrayNos.length-2)
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
    public ClassArrayNo removeAtRank(int r) {
        ClassArrayNo aux = arrayNos[r];
        
        for(int i = r;i < size()-1; i++){
            arrayNos[i] = arrayNos[i+1];
            arrayNos[i].setIndice(i);
        }
        
        t--;
        return aux;
    }

    @Override
    public ClassArrayNo first() {
        return atRank(0);
    }

    @Override
    public ClassArrayNo last() {
        return atRank(t);
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
        Object que = q.getElemento();
        Object no = n.getElemento();
        
        arrayNos[rankN].setElemento(que);
           
        arrayNos[rankQ].setElemento(no);
        
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
        return insertAtRank(t+1, o); 
    }

    @Override
    public ClassArrayNo remove(ClassArrayNo n) {
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
    
    public ClassSeq QuickSort(){
        Random r = new Random();
        int Low = 0;
        int High = this.size();
        int p = r.nextInt(High-Low) + Low;
        System.out.println("p: " + p);
        
        return quickSort(this, p);
    }
    
    private ClassSeq quickSort(ClassSeq S, int p){
        ClassSeq L = new ClassSeq(S.size()), E = new ClassSeq(S.size()), G = new ClassSeq(S.size());
        
        ClassArrayNo x = S.atRank(p);       
        while(!S.isEmpty()){
            ClassArrayNo y = S.remove(S.first());
            
            switch (y.compareTo(x)) {
                case -1:
                    L.insertLast(y.getElemento());
                    break;
                case 0:
                    E.insertLast(y.getElemento());           
                    break;
                case 1:
                    G.insertLast(y.getElemento());
                    break;
            }
        }
        return join(L, E, G);
    }
    
    private ClassSeq order(ClassSeq vetor, int inicio, int fim){
        
        int i, j, meio;
        ClassArrayNo aux;
        i = inicio;
        j = fim;
        meio = inicio+(fim-inicio)/2;

        while(i <= j)
        {
           while(vetor.arrayNos[i].compareTo(vetor.arrayNos[meio]) == -1)
              i++;
           while(vetor.arrayNos[j].compareTo(vetor.arrayNos[meio]) == 1)
              j--;
           if(i <= j)
           {
              aux = vetor.arrayNos[i];
              vetor.arrayNos[i] = vetor.arrayNos[j];
              vetor.arrayNos[i].setIndice(aux.getIndice());
              vetor.arrayNos[j] = aux;
              vetor.arrayNos[j].setIndice(j);
              i++;
              j--;
           }
        }
        if(inicio < j)
           order(vetor, inicio, j);
        if(i < fim)
           order(vetor, i, fim);
        
        return vetor;
    }
    
    private ClassSeq join(ClassSeq L, ClassSeq E, ClassSeq G){
        
        if(!L.isEmpty())
            L = order(L, L.rankOf(L.first()), L.rankOf(L.last()));
        if(!G.isEmpty())
            G = order(G, G.rankOf(G.first()), G.rankOf(G.last()));
        
        while(!E.isEmpty())
            L.insertLast(E.remove(E.first()).getElemento());
        while(!G.isEmpty())
            L.insertLast(G.remove(G.first()).getElemento());
        
        E = null;
        G = null;
        return L;
    }
}
