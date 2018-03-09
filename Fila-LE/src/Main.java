
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lavinia
 */
public class Main {
    
        private static void listarFila(ClassFila fila) throws EFilaVazia{
        ClassNo aux = fila.inicio();
        
        System.out.print("\nFila: ");
        while(aux != null){
            System.out.print(aux.getElemento() + " ");
            aux = aux.getProximo();
        }
        System.out.print("\n");
    }
    
    public static void main(String args[]) throws EFilaVazia{
        Scanner sc = new Scanner(System.in);
        int x = -1;
        ClassFila fila = new ClassFila();
               
        while(x != 0){
            System.out.println("\n0 - Sair \n1 - enfileirar \n2 - desenfileirar \n3 - inicio \n4 - tamanho\n");
            x =  sc.nextInt();
            switch(x){
                case 0:
                    break;
                case 1:
                    fila.enfileirar(sc.nextInt());
                    listarFila(fila);
                    break;
                case 2:
                    System.out.println("Removido: " + fila.desenfileirar().getElemento());
                    listarFila(fila);
                    break;
                case 3:
                    System.out.println("Inicio: " +fila.inicio().getElemento());
                    break;
                case 4:
                    System.out.println("Tamanho da fila: " +fila.tamanho());
                    break;
                default:
                    break;
            }
        }
    }
    
}
