package exemplo_grafo;
import java.util.ArrayList;
import java.util.List;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO dado) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                return this.vertices.get(i);
            }
        }
        return null;
    }

    public List<TIPO> getNomesVertices() {
        List<TIPO> nomes = new ArrayList<TIPO>();
        for (Vertice<TIPO> v : vertices) {
            nomes.add(v.getDado());
        }
        return nomes;
    }

    public List<Caminho<TIPO>> encontrarMenoresCaminhos(TIPO inicio, TIPO fim, int maxOpcoes) {
        List<Caminho<TIPO>> caminhos = new ArrayList<Caminho<TIPO>>();
        Caminho<TIPO> menor = encontrarMenorCaminho(inicio, fim, null);
        if (menor != null) caminhos.add(menor);
        if (menor != null && menor.vertices.size() > 1) {
            for (int i = 0; i < menor.vertices.size() - 1 && caminhos.size() < maxOpcoes; i++) {
                Vertice<TIPO> from = this.getVertice(menor.vertices.get(i));
                Vertice<TIPO> to = this.getVertice(menor.vertices.get(i + 1));
                Aresta<TIPO> removida = null;
                int idxRemover = -1;
                for (int j = 0; j < from.getArestasSaida().size(); j++) {
                    Aresta<TIPO> ar = from.getArestasSaida().get(j);
                    if (ar.getFim().equals(to)) {
                        removida = ar;
                        idxRemover = j;
                        break;
                    }
                }
                if (removida != null) from.getArestasSaida().remove(idxRemover);
                Caminho<TIPO> novo = encontrarMenorCaminho(inicio, fim, caminhos);
                boolean jaExiste = false;
                if (novo != null) {
                    for (Caminho<TIPO> c : caminhos) {
                        if (c.toString().equals(novo.toString())) {
                            jaExiste = true;
                            break;
                        }
                    }
                    if (!jaExiste) caminhos.add(novo);
                }
                if (removida != null) from.getArestasSaida().add(idxRemover, removida);
            }
        }
        for (int i = 0; i < caminhos.size() - 1; i++) {
            for (int j = i + 1; j < caminhos.size(); j++) {
                if (caminhos.get(i).distancia > caminhos.get(j).distancia) {
                    Caminho<TIPO> temp = caminhos.get(i);
                    caminhos.set(i, caminhos.get(j));
                    caminhos.set(j, temp);
                }
            }
        }
        List<Caminho<TIPO>> resposta = new ArrayList<Caminho<TIPO>>();
        for (int i = 0; i < caminhos.size() && i < maxOpcoes; i++) {
            resposta.add(caminhos.get(i));
        }
        return resposta;
    }

    private Caminho<TIPO> encontrarMenorCaminho(TIPO inicio, TIPO fim, List<Caminho<TIPO>> jaExistentes) {
        int n = vertices.size();
        double[] dist = new double[n];
        int[] prev = new int[n];
        boolean[] visitado = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            prev[i] = -1;
            visitado[i] = false;
        }
        int idxInicio = getIndiceVertice(inicio);
        int idxFim = getIndiceVertice(fim);
        if (idxInicio == -1 || idxFim == -1) return null;
        dist[idxInicio] = 0;
        for (int count = 0; count < n; count++) {
            double menorDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visitado[i] && dist[i] < menorDist) {
                    menorDist = dist[i];
                    u = i;
                }
            }
            if (u == -1) break;
            visitado[u] = true;
            Vertice<TIPO> vertAtual = vertices.get(u);
            for (int k = 0; k < vertAtual.getArestasSaida().size(); k++) {
                Aresta<TIPO> aresta = vertAtual.getArestasSaida().get(k);
                int idxVizinho = getIndiceVertice(aresta.getFim().getDado());
                if (!visitado[idxVizinho]) {
                    double novaDist = dist[u] + aresta.getPeso();
                    if (novaDist < dist[idxVizinho]) {
                        dist[idxVizinho] = novaDist;
                        prev[idxVizinho] = u;
                    }
                }
            }
        }
        ArrayList<Integer> caminhoIndices = new ArrayList<Integer>();
        int atual = idxFim;
        if (dist[atual] == Double.POSITIVE_INFINITY) return null;
        while (atual != -1) {
            caminhoIndices.add(0, atual);
            atual = prev[atual];
        }
        List<TIPO> caminho = new ArrayList<TIPO>();
        for (int i = 0; i < caminhoIndices.size(); i++) {
            caminho.add(vertices.get(caminhoIndices.get(i)).getDado());
        }
        Caminho<TIPO> caminhoAtual = new Caminho<TIPO>(caminho, dist[idxFim]);
        if (jaExistentes != null) {
            for (Caminho<TIPO> c : jaExistentes) {
                if (c.toString().equals(caminhoAtual.toString())) return null;
            }
        }
        return caminhoAtual;
    }

    private int getIndiceVertice(TIPO dado) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getDado().equals(dado)) return i;
        }
        return -1;
    }

    public static class Caminho<TIPO> {
        List<TIPO> vertices;
        double distancia;
        public Caminho(List<TIPO> vertices, double distancia) {
            this.vertices = vertices;
            this.distancia = distancia;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < vertices.size(); i++) {
                sb.append(vertices.get(i));
                if (i < vertices.size() - 1) sb.append(" -> ");
            }
            return sb.toString();
        }
        public double getDistancia() {
            return distancia;
        }
    }
}