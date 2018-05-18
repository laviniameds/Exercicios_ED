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
    int i, p, size, tam;
    Object NO_SUCH_KEY = "Nenhuma chave encontrada!";
    Object AVAILABLE = "Disponível";
    
    public HashTable(int tam){
        //cria a table com os espaços para chaves
        table = new Hash[tam];
        this.tam = tam;
        size = 0;
        
        for(int x = 0;x<tam;x++)
            table[x] = new Hash(null, null);
    }
    
    public void put(int key, Object element) throws Exception{
        if(size == tam)
            throw new Exception("Tabela cheia!");
        
        i = key;
        p = 0;
        while(p != tam){

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
        //variavel q percorre o array
        i = key;
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
        //pega o objeto
        Object o = find(key);
        
        //se existir objeto, substitui o elemento por AVAIABLE, diminui o tamanho
        if(o != NO_SUCH_KEY)          
            table[key].setElement(AVAILABLE);
        size--;
        
        //retorna o objeto substituído ou NO_SUCH_KEY
        return o;
    }

    public void Mostrar(){
        for(int x = 0; x<tam; x++){
            if(table[x].getKey() != null && table[x].getElement() !=  AVAILABLE)
                System.out.println("Chave: " + table[x].getKey() + " - Valor: " + table[x].getElement());
        }
        System.out.println(size);
    }
}
