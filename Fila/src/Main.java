
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
    public static void exibirFila(Object[] fila, int tamanho){
        System.out.print("\nFila: \n");
        
        for(int k = 0; k < tamanho; k++){
            if(fila[k] != null)
                System.out.print(fila[k] + " ");              
        }  
        
        System.out.print("\n");  
    }
    
    public static void main(String args[]) throws EFilaVazia{
        Scanner sc = new Scanner(System.in);
        int tamanho, fc, x = -1;
        
        System.out.println("Digite o tamanho da fila e o fator de crescimento");
        tamanho =  sc.nextInt();
        fc = sc.nextInt();
        ClassFila fila = new ClassFila(tamanho, fc);
        
        while(x != 0){
            System.out.println("\n0 - Sair \n1 - enfileirar \n2 - desenfileirar \n3 - inicio \n4 - tamanho\n");
            x =  sc.nextInt();
            switch(x){
                case 0:
                    break;
                case 1:
                    fila.enfileirar(sc.nextInt());
                    exibirFila(fila.getFila(), fila.tamanho());
                    break;
                case 2:
                    fila.desenfileirar();
                    exibirFila(fila.getFila(), fila.tamanho());
                    break;
                case 3:
                    System.out.println(fila.inicio());
                    break;
                case 4:
                    System.out.println(fila.tamanho());
                    break;
                default:
                    break;
            }
        }
    }
}
