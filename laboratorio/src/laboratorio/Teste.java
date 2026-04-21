package laboratorio;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Fila fila = new Fila(100);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma das opcoes abaixo: ");
            System.out.println("1. Solicitar nova senha (Comum ou Prioridade)");
            System.out.println("2. Excluir uma senha");
            System.out.println("3. Listar todas as senhas");
            System.out.println("4. Visualizar quem é o proximo a ser atendido");
            System.out.println("5. Chamar o proximo a ser atendido");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.println("Digite o tipo de senha (comum/prioridade): ");
                String tipo = scanner.nextLine();
                fila.adicionarSenha(tipo);
            } else if (opcao == 2) {
                System.out.println("Digite o tipo de senha a ser excluida (comum/prioridade): ");
                String tipoExcluir = scanner.nextLine();
                fila.excluirSenha(tipoExcluir);
            } else if (opcao == 3) {
                fila.listarSenhas();
            } else if (opcao == 4) {
                System.out.println("Proximo a ser atendido: " + fila.visualizarProximo());
            } else if (opcao == 5) {
                System.out.println("Chamando próximo a ser atendido: " + fila.proximoAtendimento());
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}