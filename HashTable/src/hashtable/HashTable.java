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
public class HashTable {
    Hash[] table;
    int i, p, size;
    Object NO_SUCH_KEY = "Nenhuma chave encontrada!";
    Object AVAIABLE = "Disponível";
    
    public HashTable(int tam){
        table = new Hash[tam];
    }
    
    public void put(int key, Object element){
        
    }
    
    public Object find(int key){
        i = table[key].getKey();
        p = 0;
        while(p != size){
            if(table[key] == null)
                return NO_SUCH_KEY;
            else if(i == key)
                return table[key].getElement();
            else{
                i = (i + 1) % size;
                p++;
            }
        }
        return NO_SUCH_KEY;
    }
    
    public Object remove(int key){
        Object o = find(key);
        
        if(o != NO_SUCH_KEY)          
            table[key].setElement(AVAIABLE);
        
        return o;
    }
    
    @Override
    public String toString(){
        
    }
}
