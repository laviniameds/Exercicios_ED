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
    int i, p, size, tam, primo;
    Object NO_SUCH_KEY = "Nenhuma chave encontrada!";
    Object AVAILABLE = "Disponível";
    
    public HashTable(int tam, int primo){
        //cria a table com os espaços para chaves
        table = new Hash[tam];
        this.tam = tam;
        size = 0;
        this.primo = primo;
        
        for(int x = 0;x<tam;x++)
            table[x] = new Hash(null, null);
    }
    
    private int doubleHash(int key){
        return primo - key % primo;
    }
    
    public void insertElement(int key, Object element) throws Exception{
        int hash = key % tam;
        put(key, hash, element);     
    }
    
    private void put(int key, int hash, Object element) throws Exception{
        if(size == tam)
            throw new Exception("Tabela cheia!");
        
        int d = doubleHash(key);
        p = 0;
        while(p != tam){
            i = (hash + p * d)%tam;
            if(table[i].getKey() == null || table[i].getElement() == AVAILABLE){
                table[i].setKey(key);
                table[i].setElement(element);
                size++;
                break;
            }            
            else {
                i = (i + 1) % tam;
                p++;
            }
        }
    }
    
    public Object find(int key){
        int hash = key%tam;
        //variavel q percorre o array
        i = hash;
        //variavel auxiliar para nao deixar que o array seja percorrido mais de uma vez
        p = 0;
        //enquanto o array nao for percorrido 
        while(p != tam){
            //percorreu todo o array e nao achou a chave, para e retorna
            if(table[i].getKey() == null)
                return NO_SUCH_KEY;
            //achou a chave, retorna o elemento
            else if(table[i].getKey() == key)
                return table[i].getElement();
            //nao achou a chave e o array n foi percorrido todo ainda, vai pro proximo espaço, aumenta a variavel auxiliar p
            else{
                i = (i + 1) % tam;
                p++;
            }
        }
        return NO_SUCH_KEY;
    }
    
    public Object remove(int key){
        int hash = key%tam;
        //pega o objeto
        Object o = find(key);
        
        //se existir objeto, substitui o elemento por AVAIABLE, diminui o tamanho
        if(o != NO_SUCH_KEY)          
            table[hash].setElement(AVAILABLE);
        size--;
        
        //retorna o objeto substituído ou NO_SUCH_KEY
        return o;
    }

    public void Mostrar(){
        System.out.println("\n\n\n");
        for(int x = 0; x<tam; x++){
            if(table[x].getKey() != null && table[x].getElement() !=  AVAILABLE)
                System.out.println("Hash: " + x  + " - Chave: " + table[x].getKey() + " - Valor: " + table[x].getElement());
        }
    }
}
