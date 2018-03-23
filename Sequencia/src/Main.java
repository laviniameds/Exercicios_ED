
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
    public static void exibirSeq(ClassSeq sequencia, int size){
        System.out.print("\nSequencia: \n");
        
        for(int i = 0; i <= size+1; i++)
            if(sequencia.atRank(i).getElemento() != null)
                System.out.print(sequencia.atRank(i).getElemento() + " ");  
        
        System.out.print("\n");  
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tamanho, x = -1, rank, rank2;
        Object obj;
        
        System.out.println("Digite o tamanho da sequencia:");
        tamanho =  sc.nextInt();
        ClassSeq sequencia = new ClassSeq(tamanho);
        
        while(x != 0){
            System.out.println("\n0 - Sair \n1 - size \n2 - isEmpty \n3 - elemAtRank"
                    + " \n4 - replaceAtRank\n5 - insertAtRank\n6 - removeAtRank"
                    + "\n7 - first\n8 - last\n9 - before"
                    + "\n10 - after\n11 - replaceElement\n12 - swapElements"
                    + "\n13 - insertBefore\n14 - insertAfter\n15 - insertFirst\n"
                    + "16 - insertLast\n17 - remove\n");
            x =  sc.nextInt();
            switch(x){
                case 0:
                    break;
                case 1:
                    System.out.println("tamanho: " + sequencia.size());
                    break;
                case 2:
                    System.out.println("vazia: " + sequencia.isEmpty());
                    break;
                case 3:
                    rank = sc.nextInt();
                    System.out.println("elemento: " + sequencia.elemAtRank(rank));
                    exibirSeq(sequencia, sequencia.size());
                    break;
                case 4:
                    rank = sc.nextInt();
                    obj = sc.nextInt();
                    sequencia.replaceAtRank(rank, obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                
                case 5:
                    rank = sc.nextInt();
                    obj = sc.nextInt();
                    sequencia.insertAtRank(rank, obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;               
                case 6:
                    rank = sc.nextInt();
                    sequencia.removeAtRank(rank);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                                 
                case 7:
                    System.out.println("primeiro: " + sequencia.first());
                    break;                           
                case 8:
                    System.out.println("ultimo: " + sequencia.last());
                    break;                            
                case 9:
                    rank = sc.nextInt();
                    System.out.println("antes: " + sequencia.before(sequencia.atRank(rank-1)));
                    break;                                                                                  
                case 10:
                    rank = sc.nextInt();
                    System.out.println("depois: " + sequencia.before(sequencia.atRank(rank+1)));
                    break;                                                       
                case 11:
                    rank = sc.nextInt();
                    obj = sc.nextInt();
                    sequencia.replaceElement(sequencia.atRank(rank), obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                           
                case 12:
                    rank = sc.nextInt();
                    rank2 = sc.nextInt();
                    sequencia.swapElements(sequencia.atRank(rank), sequencia.atRank(rank2));
                    exibirSeq(sequencia, sequencia.size());;
                    break;                                                                          
                case 13:
                    rank = sc.nextInt();
                    obj = sc.nextInt();
                    sequencia.insertBefore(sequencia.atRank(rank), obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                           
                case 14:
                    rank = sc.nextInt();
                    obj = sc.nextInt();
                    sequencia.insertAfter(sequencia.atRank(rank), obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                          
                case 15:
                    obj = sc.nextInt();
                    sequencia.insertFirst(obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                          
                case 16:
                    obj = sc.nextInt();
                    sequencia.insertLast(obj);
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                           
                case 17:
                    rank = sc.nextInt();
                    sequencia.remove(sequencia.atRank(rank));
                    exibirSeq(sequencia, sequencia.size());
                    break;                                                                                                                                                  
                default:
                    break;
            }
        }
    }
}
