package exemplo_lista_duplamente_encadeada;
import java.util.Scanner;

public class Exemplo_Lista_Duplamente_Encadeada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();
        String elemento = null;
        String opcao = null;
        int posicao = 0;
        
        
        do{
            System.out.println("Escolha:");
            System.out.println("1 - adicionar elemento");
            System.out.println("1.1 - adicionar elemento na posicao especifica");
            System.out.println("2 - excluir elemento na posico especific");
            System.out.println("3 - excluir elemento");
            System.out.println("4 - exibir elemento anterior");
            System.out.println("5 - consultar a posicao de um elemento");
            System.out.println("6 - cosultar um elemento de uma posicao");
            System.out.println("7 - consultar tamanho da lista");
            System.out.println("8 - exibir o primeiro elemento da Lista");
            System.out.println("9 - exibir o ultimo elemento da lista");
            System.out.println("10 - exibir o maior elemento da lista");
            System.out.println("0 - exibir a list completa");
            System.out.println("s - sair da aplicacao");
            
            opcao = entrada.next();
            
            if(opcao.equals("1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.adicionar(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(opcao.equals("1.1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                System.out.println("\nInforme a posicao do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.adicionar(elemento, posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if(opcao.equals("2")) {
                System.out.println("\nIforme a posicao do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.removeIndex(posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }  
            }
            else if(opcao.equals("3")) {
                System.out.println("\nInforme o valor do elemnto");
                elemento = entrada.next();
                try {
                    lista.removeElemento(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
            else if(opcao.equals("4")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.antecessor(elemento);
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else if(opcao.equals("5")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.posicao(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(opcao.equals("6")) {
                System.out.println("\nInforme a posicao do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.BuscaPosicao(posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if (opcao.equals("7")) {
                try {
                    System.out.println("O tamanho e: " + lista.tamanhoLista());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if (opcao.equals("8")) {
                try {
                    lista.primeiroLista();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if (opcao.equals("9")) {
                try {
                    lista.ultimoLista();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if (opcao.equals("10")) {
                try {
                    lista.maior();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else if (opcao.equals("0")) {
                try {
                    lista.exibir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            else {
                System.out.println("Opcao invalida");
            }
        } 
        while(opcao != "s");
    }
}
