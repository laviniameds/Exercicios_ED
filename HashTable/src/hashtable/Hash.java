/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author lavinia
 */
public class Hash {
    private Integer key;
    private Object element;
    
    public Hash(Integer key, Object element){
        this.key = key;
        this.element = element;
    }

    public Integer getKey() {
        return key;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
        
}
