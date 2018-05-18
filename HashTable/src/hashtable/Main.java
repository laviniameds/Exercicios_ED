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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        HashTable table = new HashTable(20);
        
        table.put(5, "lavinia");
        table.put(9, "opaa");
        
        table.Mostrar();
        
        table.remove(5);
        
        table.Mostrar();
        
        table.put(5, "nossa");
        
        table.Mostrar();
        
        table.put(5, "eae");
        
        table.Mostrar();
        
        System.out.println(table.find(9));
    }
    
}
