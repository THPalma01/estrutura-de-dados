package TesteVetor;

/
package javaapplication;


public class JavaApplication {

    public class Vetor{
        private Dado[] dados;
        private int tamanho;
        
        public Vetor(int capacidade){
            dados = new Dado[capacidade];
            tamanho = 0;
        }
        
        public boolean adicionar(Dado dado){
            if(tamanho<dados.length){
                dados[tamanho] = dado;
                tamanho++;
                return true;
            }
            return false;
        }
           public Dado pesquisar(String chave){
               for(int i = 0; i < tamanho; i++){
                   if(dados[i].getChave().equals(chave)){
                       return dados[i];
                   }
               }
               return null;
           }
           
           public boolean alterar(String chave, Dado novoDado){
               for(int i = 0; i < tamanho; i++){
                   if(dados[i].getChave().equals(chave)){
                       dados[i] = novoDado;
                       return true;
                   }
               }
               return false;
           }
           public boolean excluir(String chave){
               for(int i = 0; i < tamanho; i++){
                   if(dados[i].getChave().equals(chave)){
                       for(int j = 0; j < tamanho - 1; j++){
                           dados[j] = dados[j + 1];
                       }
                       dados[tamanho - 1] = null;
                       tamanho--;
                       return true;
                   }
               }
               return false;
           }
           public int getTamanho(){
               return tamanho;
           }
    }
    
}
