package exemplo_lista_duplamente_encadeada;

public class ListaDuplaEncadeada {
    private NoDuplo inicio;
    private NoDuplo fim;
    
    public ListaDuplaEncadeada (){
        
    }
    
    public ListaDuplaEncadeada (NoDuplo inicio, NoDuplo fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public NoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NoDuplo inicio) {
        this.inicio = inicio;
    }

    public NoDuplo getFim() {
        return fim;
    }

    public void setFim(NoDuplo fim) {
        this.fim = fim;
    }
    
    public void exibir() throws Exception {
        System.out.println("LISTA -> ");
        
        NoDuplo aux = inicio;
        
        while (aux != null) {
            System.out.println(aux.dado + " -> ");
            aux = aux.proximo;
        }
        System.out.println("NULL\n");
    }
    
    public int tamanhoLista() throws Exception {
        NoDuplo aux = inicio;
        int tamanho = 0;
        while (aux != null) {
            tamanho++;
            System.out.println(aux.dado + " -> ");
            aux = aux.proximo;
        }
        return tamanho;
    }
    
    public void adicionar(String s) throws Exception {
       NoDuplo novoElemento = new NoDuplo(s);
       NoDuplo aux = inicio;
       if(inicio == null) {
           novoElemento.proximo = null;
           novoElemento.anterior = null;
           
           inicio = novoElemento;
           fim = novoElemento;
       } else {
           while (aux.proximo != null) {
               if (aux.dado.equals(s)) {
                   throw new Exception("Elemento repetido");
               } else {
                   aux = aux.proximo;
               }
           }
           
           novoElemento.proximo = null;
           aux.proximo = novoElemento;
           novoElemento.anterior = aux;
           fim = novoElemento;
       }
    }
    
    public void adicionar (String s, int i) throws Exception {
        if(i > 0 || i > tamanhoLista()) {
            throw new Exception("Posicao Invalida");
        }
        
        NoDuplo novoElemento = new NoDuplo(s);
        NoDuplo aux = inicio;
        
        if(i == 0) {
            if(tamanhoLista() != 0) {
                novoElemento.proximo = aux;
                aux.anterior = novoElemento;
                inicio = novoElemento;
                novoElemento.anterior = null;
            } else {
                inicio = novoElemento;
            }
        } else {
            int contador = 1;
            while (contador < i) {
                aux.proximo = novoElemento;
                contador++;
                novoElemento.anterior = aux;
                fim = novoElemento;
            }
            
            novoElemento.proximo = aux.proximo;
            novoElemento.anterior = aux;
            aux.proximo = novoElemento;
        }
    } 
    
    public String removeIndex(int i) throws Exception {
        NoDuplo aux = inicio;
        NoDuplo lixo = null;
        
        if(i < 0 || i > tamanhoLista()) {
            throw new Exception("Indice Invalido na Lista!!");
        }
        if (tamanhoLista() == 0) {
            throw new Exception(" Lista Vazia!!");
        }
        if (i == 0) {
            lixo = aux;
            aux = aux.proximo;
            inicio = aux;
        } else {
            int contador = 0;
            
            while (contador < i) {
                aux = aux.proximo;
                contador ++;
            }
            lixo = aux;
            aux.anterior.proximo = aux.proximo;
            if (aux != fim)
                aux.proximo.anterior = aux.anterior;
            else
                fim = aux;
        }
        return lixo.dado;
    }
    
    public void removeElemento (String s) throws  Exception {
        if(tamanhoLista() == 0)
            throw new Exception("A Lista esta vazia!!");
        NoDuplo aux = inicio;
        
        boolean excluir = false;
        while (aux != null && aux.dado != s) {
            if (aux.dado.equals(s)) {
                if(aux == inicio) {
                    inicio = inicio.proximo;
                    excluir = true;
                } else {
                    aux.anterior.proximo = aux.proximo;
                    aux.proximo = aux.anterior;
                    excluir = true;
                }
            }
            aux = aux.proximo;
        }
        if (excluir == false)
            throw new Exception("O elemento não foi loclizado na Lista!!");
        
    }
    
    public String antecessor(String s) throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        NoDuplo aux = inicio;
        while(aux != null) {
            if(aux.dado.equals(s)) {
                if(aux == inicio) {
                    throw new Exception("Primeiro elemento da lista nao tem antecessor");
                } else {
                    return aux.anterior.dado;
                }
            }
            aux = aux.proximo;
        }
        throw new Exception("O elemento nao foi localixado na Lista!");
    } 
    
    public int posicao(String s) throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        NoDuplo aux = inicio;
        int contador = 0;
        while(aux != null) {
            if(aux.dado.equals(s)) {
                return contador;
            } else {
                aux = aux.proximo;
                contador ++;
            }
        }
        throw new Exception ("O elemento nao foi encontrado na lista!!");
    }
    
    public String BuscaPosicao(int i) throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        if(i < 0 || i > tamanhoLista())
            throw new Exception("Indice Ivalido na Lista");
        NoDuplo aux = inicio;
        int contador = 0;
        
        while(contador <= i) {
            if(contador == i) {
                return aux.dado;
            } else {
                aux = aux.proximo;
                contador ++;
            }
        }
        return aux.dado;
    }
    
    public String primeiroLista() throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        if(tamanhoLista() != 0)
            return inicio.dado;
        return null;
    }
    
     public String ultimoLista() throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        if(tamanhoLista() != 0)
            return fim.dado;
        return null;
    }
     
     public String maior() throws Exception {
        if(tamanhoLista() == 0) 
            throw new Exception("A lista esta vazia!!");
        NoDuplo aux = inicio;
        String maior = aux.dado;
        
        while(aux != null) {
            if(aux.dado.compareTo(maior) > 0) {
                maior = aux.dado;
            } else {
                aux = aux.proximo;
            }
        }
        return maior;
     }
}