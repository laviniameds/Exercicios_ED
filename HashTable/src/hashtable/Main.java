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
        HashTable table = new HashTable(23, 7);
        
        table.insertElement(50, "lavinia");
        table.insertElement(68, "mvdsnavndf");
        table.insertElement(500, "opaa");
        
        table.Mostrar();
        
        table.remove(500);
        
        table.Mostrar();       
        
        table.insertElement(86, "eae");
        
        table.Mostrar();
        
        System.out.println("\n\n" + table.find(50));
    }
    
}
