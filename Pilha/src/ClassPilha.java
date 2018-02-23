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
    
    public ClassPilha(int tamanho){
        arrayObj = new Object[tamanho];
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
        arrayObj[++t] = o;
    }
    
}
