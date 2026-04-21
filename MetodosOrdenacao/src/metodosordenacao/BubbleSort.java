package metodosordenacao;

public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor = {7, 2, 5, 9, 0, 3, 4, 1, 6, 8, 10, 15, 11, 20, 18};
        int aux;
        for(int i = 0; i < vetor.length; i++) {
            for(int j = i + 1; j < vetor .length; j++) {
                if(vetor[i] > vetor[j]) {
                    aux = vetor [j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }
        
        System.out.println("Nosso vetor ordenado: ");
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}