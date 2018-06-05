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
public class ClassArrayNo implements Comparable<ClassArrayNo>{
    private int indice;
    private Object elemento;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    @Override
    public int compareTo(ClassArrayNo no) {
        if(Integer.parseInt(this.getElemento().toString()) < Integer.parseInt(no.getElemento().toString()))
            return -1;
        else if(Integer.parseInt(this.getElemento().toString()) == Integer.parseInt(no.getElemento().toString()))
            return 0;
        else
            return 1;
    }


}