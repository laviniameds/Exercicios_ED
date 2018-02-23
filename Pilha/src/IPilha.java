/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public interface IPilha {
    public boolean isEmpty();
    public int size();
    public Object top() throws EPilhaVazia;
    public Object pop() throws EPilhaVazia;
    public void push(Object o);
}
