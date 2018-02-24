/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassPilha implements IPilha{
    
    private Object arrayObj[];
    private int t = -1;
    private int FC;
    
    public ClassPilha(int tamanho, int FC){
        arrayObj = new Object[tamanho];
        this.FC = FC;
    }
    
    public Object[] getPilha(){
        return arrayObj;
    }
    
    public Object[] resize(int FC){
        Object temp[];
        if(FC == 0){
           temp = new Object[size()*2];
           for(int i = 0; i < size(); i++)
               temp[i] = arrayObj[i];
           return temp;
        }
        else{
           temp = new Object[size()+FC];
           for(int i = 0; i < size(); i++)
               temp[i] = arrayObj[i];
           return temp;
        }
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public Object top() throws EPilhaVazia{
        if(isEmpty())
            throw new EPilhaVazia("Pilha vazia!");
        else
            return arrayObj[t];
    }

    @Override
    public Object pop() throws EPilhaVazia{
        if(isEmpty())
            throw new EPilhaVazia("Pilha vazia!");
        else
            return arrayObj[t--];
    }

    @Override
    public void push(Object o) {
        if(t == arrayObj.length - 1)
            arrayObj = resize(FC);
        arrayObj[++t] = o;
    }
    
}
