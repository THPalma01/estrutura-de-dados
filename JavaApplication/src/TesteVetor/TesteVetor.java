
package TesteVetor;
import java.util.Scanner;

public class TesteVetor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Vetor vetor = new Vetor(10);
        
        while(true){
            System.out.println("Escolha uma opçao:");
                System.out.println("1. Incluir");
                System.out.println("2. Pesquisar");
                System.out.println("3. Alterar");
                System.out.println("4. Excluir");
                System.out.println("5. Sair");
                
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcao){
                    case 1:
                        System.out.println("Digite a chave");
                        String chaveIncluir = scanner.nextLine();
                        System.out.println("Digite a informaçao");
                        String informacaoIncluir = scanner.nextLine();
                        vetor.adicionar(new Dado(chaveIncluir, informacaoIncluir));
                        break;
                    case 2:
                        System.out.println("Digite a chave para pesquisar: ");
                        String chavePesquisar = scanner.nextLine();
                        Dado resultadoPesquisa = vetor.pesquisar(chavePesquisar);    
                        System.out.println(resultadoPesquisa != null ? resultadoPesquisa : "Dado não encontrado");
                        break;
                    case 3:
                        System.out.println("Digite a chave para alterar");
                        String chaveAlterar = scanner.nextLine();
                        System.out.println("Digite a nova informaçao");
                        String informacaoAlterar = scanner.nextLine();
                        vetor.alterar(chaveAlterar, new Dado(chaveAlterar, informacaoAlterar));
                        break;
                    case 4:
                        System.out.println("Digite a chave par excluir");
                        String chaveExcluir = scanner.nextLine();
                        vetor.excluir(chaveExcluir);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opçao inavlida...");   
            }
        }
    }
}
