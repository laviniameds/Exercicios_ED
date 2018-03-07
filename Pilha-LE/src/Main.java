
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
    
    private static void listarPilha(ClassPilha pilha) throws EPilhaVazia{
        ClassNo aux = pilha.top();
        
        System.out.print("\nPilha: ");
        while(aux != null){
            System.out.print(aux.getElemento() + " ");
            aux = aux.getProximo();
        }
        System.out.print("\n");
    }
    
    public static void main(String args[]) throws EPilhaVazia{
        Scanner sc = new Scanner(System.in);
        int x = -1;
        ClassPilha pilha = new ClassPilha();
               
        while(x != 0){
            System.out.println("\n0 - Sair \n1 - push \n2 - pop \n3 - top \n4 - size\n");
            x =  sc.nextInt();
            switch(x){
                case 0:
                    break;
                case 1:
                    pilha.push(sc.nextInt());
                    listarPilha(pilha);
                    break;
                case 2:
                    System.out.println("Removido: " + pilha.pop().getElemento());
                    listarPilha(pilha);
                    break;
                case 3:
                    System.out.println("Topo: " +pilha.top().getElemento());
                    break;
                case 4:
                    System.out.println("Tamanho da pilha: " +pilha.getSize());
                    break;
                default:
                    break;
            }
        }
    }
}
