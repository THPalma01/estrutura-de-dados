package agenda;

public class Vetor {
    private String [] elementos;
    private int tamanho;
    
    public Vetor(int capacidade) {
        this.elementos = new String [capacidade];
        this.tamanho = 0;
    }
    
    public void adiciona(String elemento) throws Exception {
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("O vetor está cheio");
        }
    }
    
    public String busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        }else {
            throw new Exception ("Posição inválida");
        }
    } 
    
    public int busca(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].contains(elemento)) {
                return i;
            }
        }
        return -1;
    }
    
    public void remove (int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.tamanho--;
        }else {
            throw new Exception ("Posição inválida");
        }
    }
    
    public int tamanho() {
        return this.tamanho;
    }
    
    public String[] buscaPorData(String data) {
        String[] resultados = new String[this.tamanho];
        int contador = 0;
        
        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i].contains(data)) {
                resultados[contador] = this.elementos[i];
                contador++;
            }
        }
        
        String[] resultadosFiltrados = new String[contador];
        System.arraycopy(resultados, 0, resultadosFiltrados, 0, contador);
        return resultadosFiltrados;  
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i <  this.tamanho -1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        
        s.append("]");
        return s.toString();
    }
    
    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[1];
            }
            this.elementos = elementosNovos;
        }
    }
}