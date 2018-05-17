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
    //tabela
    Hash[] table;
    
    //variaveis auxiliares
    int i, p, size;
    Object NO_SUCH_KEY = "Nenhuma chave encontrada!";
    Object AVAILABLE = "Disponível";
    
    public HashTable(int tam){
        //cria a table acom o dobro de espaços para chaves
        table = new Hash[tam*2];
    }
    
    public void put(int key, Object element){
        
    }
    
    public Object find(int key){
        //variavel q percorre o array
        i = table[key].getKey();
        //variavel auxiliar para nao deixar que o array seja percorrido mais de uma vez
        p = 0;
        //enquanto o array nao for percorrido 
        while(p != size){
            //percorreu todo o array e nao achou a chave, para e retorna
            if(table[key] == null)
                return NO_SUCH_KEY;
            //achou a chave, retorna o elemento
            else if(i == key)
                return table[key].getElement();
            //nao achou a chave e o array n foi percorrido todo ainda, vai pro proximo espaço, aumenta a variavel auxiliar p
            else{
                i = (i + 1) % size;
                p++;
            }
        }
        return NO_SUCH_KEY;
    }
    
    public Object remove(int key){
        //pega o objeto
        Object o = find(key);
        
        //se existir objeto, substitui o elemento por AVAIABLE
        if(o != NO_SUCH_KEY)          
            table[key].setElement(AVAILABLE);
        
        //retorna o objeto substituído ou NO_SUCH_KEY
        return o;
    }
    
    @Override
    public String toString(){
        
    }
}
