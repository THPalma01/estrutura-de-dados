package agenda;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vetor vetor = new Vetor(10);
        
        while(true) {
            System.out.println("Escolha uma das opcoes abaixo: ");
            System.out.println("1.Incluir");
            System.out.println("2.Pesquisar");
            System.out.println("3.Pesquisar por data");
            System.out.println("4.Alterar");
            System.out.println("5.Excluir");
            System.out.println("6.Listar");
            System.out.println("7.Sair");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Digite a descricao do compromisso: ");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite a data do compromisso: ");
                    String data = scanner.nextLine();
                    System.out.println("Digite o horario do compromisso: ");
                    String hora = scanner.nextLine();
                    Agenda agenda = new Agenda(descricao, data, hora);
                    try {
                        vetor.adiciona(agenda.toString());
                        System.out.println("Compromisso adicionado ");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.println("Digite a descricao do compromisso a ser pesquisado: ");
                    String descricaoPesquisa = scanner.nextLine();
                    int posicao = vetor.busca(descricaoPesquisa);
                    if (posicao != -1) {
                        try {
                            System.out.println("Compromisso encontrado: " + vetor.busca(posicao));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Compromisso não encontrado.");
                    }
                    break;
                  
                case 3:
                    System.out.println("Digite a data do compromisso a ser pesquisado (dd/mm/yyyy):");
                        String dataPesquisa = scanner.nextLine();
                        String[] compromissos = vetor.buscaPorData(dataPesquisa);
                        if (compromissos.length > 0) {
                            for (String c : compromissos) {
                                System.out.println("Compromisso encontrado: " + c);
                            }
                        } else {
                            System.out.println("Nenhum compromisso encontrado");
                        }
                        break;

                case 4:
                    System.out.println("Digite a descrição do compromisso a ser alterado:");
                    String descricaoAlterar = scanner.nextLine();
                    int posicaoAlterar = vetor.busca(descricaoAlterar);
                    if (posicaoAlterar != -1) {
                        try {
                            System.out.println("Digite a nova descrição:");
                            String novaDescricao = scanner.nextLine();
                            System.out.println("Digite a nova data (dd/mm/yyyy):");
                            String novaData = scanner.nextLine();
                            System.out.println("Digite a nova hora (hh:mm):");
                            String novaHora = scanner.nextLine();
                            Agenda agendaAlterado = new Agenda(novaDescricao, novaData, novaHora);
                            vetor.remove(posicaoAlterar);
                            vetor.adiciona(agendaAlterado.toString());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Compromisso não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Digite a descrição do compromisso a ser excluído:");
                    String descricaoExcluir = scanner.nextLine();
                    int posicaoExcluir = vetor.busca(descricaoExcluir);
                    if (posicaoExcluir != -1) {
                        try {
                            vetor.remove(posicaoExcluir);
                            System.out.println("Compromisso excluído com sucesso.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Compromisso não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Lista de Compromissos:");
                    System.out.println(vetor.toString());
                    break;

                case 7:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                   
                default:
                    System.out.println("Opcao invalida. Tente novsmente");
                    
            }
        }
    }
    
}