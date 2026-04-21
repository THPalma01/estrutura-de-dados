
package TesteVetor;

public class Dado {
    private String chave;
    private String informacao;
    
    public Dado(String chave, String informacao){
        this.chave = chave;
        this.informacao = informacao
    }
    
    public String getChave(){
        return chave;
    }
    
    public void setChave(String chave){
        this.chave = chave;
    }
    
    public String getInformacao(){
        return informacao;
    }
    
    public void setInformacao(String informacao){
        this.informacao = informacao;
    }
    
    @Override
    public String toString(){
        return "Dado{chave=''' + chave + ''', informacao=''' + informacao +'''}";
    }
}
