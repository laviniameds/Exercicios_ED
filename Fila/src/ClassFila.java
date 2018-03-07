/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class ClassFila implements IFila{
    
    private int n, i, f, FC;
    private Object fila[];
    
    public ClassFila(int n, int FC){
        i=0;
        f=0;
        this.n = n;
        this.FC = FC;
        fila = new Object[n];
    }
    
    private Object[] resize(){
        Object aux[];
        if(FC == 0)
            aux = new Object[n*2];
        else
            aux = new Object[n+FC];
        
        for(int k=0;k<n;k++){
            aux[k] = i;
            i = (i + 1) % n;
        }
        return aux;
    }

    @Override
    public int tamanho() {
        return (n - i + f) % n;
    }

    @Override
    public boolean estaVazia() {
        return (i == f);
    }

    @Override
    public Object inicio() throws EFilaVazia {
        if(estaVazia())
            throw new EFilaVazia("Fila Vazia!");
        else
            return fila[i];
    }

    @Override
    public void enfileirar(Object o) throws EFilaVazia{
        if (tamanho() == (n - 1)){
            fila = resize();
        }          
        else{
            fila[f] = o;
            f = (f + 1) % n; 
        }
    }

    @Override
    public Object desenfileirar() throws EFilaVazia {
        if (estaVazia()) 
            throw new EFilaVazia("Fila Vazia!");
        else{
            Object o = new Object();
            o = fila[i];
            i = (i + 1) % n;
            return o;
        }
    }
    
}
