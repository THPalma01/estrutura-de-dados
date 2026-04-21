package agenda;

public class Agenda {
    private String descricao;
    private String data;
    private String hora;
    
    public Agenda (String descricao, String data, String hora) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return "Compromisso{" +
                "descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora +'\'' +
                '}';
    }
}