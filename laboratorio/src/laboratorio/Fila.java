package laboratorio;

public class Fila {
    private String[] filaComum;
    private String[] filaPrioridade;
    private int inicioComum;
    private int fimComum;
    private int inicioPrioridade;
    private int fimPrioridade;
    private int capacidade;
    private int contadorPrioridade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.filaComum = new String[capacidade];
        this.filaPrioridade = new String[capacidade];
        this.inicioComum = 0;
        this.fimComum = 0;
        this.inicioPrioridade = 0;
        this.fimPrioridade = 0;
        this.contadorPrioridade = 0;
    }

    public void adicionarSenha(String tipo) {
        if (tipo.equals("c")) {
            if (fimComum < capacidade) {
                filaComum[fimComum++] = tipo;
            }
        } else if (tipo.equals("p")) {
            if (fimPrioridade < capacidade) {
                filaPrioridade[fimPrioridade++] = tipo;
            }
        }
    }

    public void excluirSenha(String tipo) {
        if (tipo.equals("c")) {
            if (inicioComum < fimComum) {
                inicioComum++;
            }
        } else if (tipo.equals("p")) {
            if (inicioPrioridade < fimPrioridade) {
                inicioPrioridade++;
            }
        }
    }

    public void listarSenhas() {
        System.out.println("Comum:");
        for (int i = inicioComum; i < fimComum; i++) {
            System.out.println(filaComum[i]);
        }

        System.out.println("Prioritarias:");
        for (int i = inicioPrioridade; i < fimPrioridade; i++) {
            System.out.println(filaPrioridade[i]);
        }
    }

    public String proximoAtendimento() {
        if (contadorPrioridade < 3 && inicioPrioridade < fimPrioridade) {
            contadorPrioridade++;
            String senha = filaPrioridade[inicioPrioridade];
            excluirSenha("p");
            return senha;
        } else if (inicioComum < fimComum) {
            contadorPrioridade = 0;
            String senha = filaComum[inicioComum];
            excluirSenha("c");
            return senha;
        } else if (inicioPrioridade < fimPrioridade) {
            contadorPrioridade++;
            String senha = filaPrioridade[inicioPrioridade];
            excluirSenha("p");
            return senha;
        } else {
            return "Nenhum paciente na fila.";
        }
    }

    public String visualizarProximo() {
        if (contadorPrioridade < 3 && inicioPrioridade < fimPrioridade) {
            return filaPrioridade[inicioPrioridade];
        } else if (inicioComum < fimComum) {
            return filaComum[inicioComum];
        } else if (inicioPrioridade < fimPrioridade) {
            return filaPrioridade[inicioPrioridade];
        } else {
            return "Nenhum paciente na fila.";
        }
    }
}