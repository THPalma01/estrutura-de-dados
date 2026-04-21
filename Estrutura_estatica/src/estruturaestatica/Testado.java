package estruturaestatica;
import java.util.Queue;
import java.util.LinkedList;

public class Testado {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<Integer>();
        
        fila.add(1);
        fila.add(2);
        fila.add(3);
        fila.add(4);
        
        System.out.println(fila.toString()); //exibe
        
        System.out.println(fila.peek());
        
        //recupera, mas nao remove, o cabeçalho desta fila ou retorna nulo
        //se a fila estiver vazia ou seja nosso metodo espiar
        
        System.out.println(fila.remove());
        //remove elemento da fila ou desenfileira, por conta da classe Queue
        //FIFO -  First In, First Out (Primeiro a entrar, primeiro a sair
    }
}
