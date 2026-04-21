package estruturaestatica;

public class TesteFila {
    public static void main(String[] args) {
        
        Fila<Integer> fila = new Fila<Integer>();
            fila.enfileira(1);
            fila.enfileira(2);
            fila.enfileira(3);
            
            //vamos visualizar a fila
            System.out.println(fila.toString());
            
            //Vamos desenfileirar um elemento
            System.out.println(fila.desenfileira());
            
            //Vamos visualizar a fila novamente apos remover um elemento
            System.out.println(fila.toString());
            
            //Vamos espiar a fila
//            System.out.println(fila.espiar());
            
            //Podemos criar uma estrutura de decisao com retorno do metodo

//            if(fila.espiar() == null) {
//                System.out.println("Ninguem na fila");
//            } else {
//                System.out.println("O elemento da primeira posicao e: " + fila.espiar());
//            }
           
            
            
            //Vamos verificar se a fila esta vazia, nesse caso sera false
            //System.out.println("A fila esta vazia? " + fila.estaVazia());
            
            //Vamos verificar o tamanho da fila apos enfileirar
            //System.out.println("Qual o tamanho da fila: " + fila.tamanho());
            
            //Vamos visualizar os elementos da fila
            //System.out.println(fila.toString());
    }
    
    
}
