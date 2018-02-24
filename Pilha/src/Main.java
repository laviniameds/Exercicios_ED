/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author lavinia
 */
public class Main {
    
    public static void exibirPilha(Object[] pilha, int size){
        System.out.print("\nPilha: \n");
        
        for(int i = 0; i < size; i++)
            if(pilha[i] != null)
                System.out.print(pilha[i] + " ");  
        
        System.out.print("\n");  
    }
    
    public static void main(String args[]) throws EPilhaVazia{
        Scanner sc = new Scanner(System.in);
        int tamanho, fc, x = -1;
        
        System.out.println("Digite o tamanho da pilha e o fator de crescimento");
        tamanho =  sc.nextInt();
        fc = sc.nextInt();
        ClassPilha pilha = new ClassPilha(tamanho, fc);
        
        while(x != 0){
            System.out.println("\n0 - Sair \n1 - push \n2 - pop \n3 - top \n4 - size\n");
            x =  sc.nextInt();
            switch(x){
                case 0:
                    break;
                case 1:
                    pilha.push(sc.nextInt());
                    exibirPilha(pilha.getPilha(), pilha.size());
                    break;
                case 2:
                    pilha.pop();
                    exibirPilha(pilha.getPilha(), pilha.size());
                    break;
                case 3:
                    System.out.println(pilha.top());
                    break;
                case 4:
                    System.out.println(pilha.size());
                    break;
                default:
                    break;
            }
        }
    }
}
