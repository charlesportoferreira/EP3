/*

2014jun02
Fila de prioridade simplificada: implementacao por vetor.

*/

public class FilaPrioridade {
    int INF = 999999, NIL = -1;
    Vertice[] V; 

    public FilaPrioridade(Vertice V[]) { 
        int tam = V.length;
        this.V = new Vertice[tam+1];
        for (int i = 0; i < tam; i++)
            this.V[i] = (Vertice)V[i];
    }
    
    public boolean vazia() {
        for (int i = 0; i < V.length; i++)
            if (V[i] != null)
                return false;
        return true;
    }

    public Vertice ExtraiMinimo() {
        int minK = INF, min = NIL;
        for (int i = 0; i < V.length; i++)
            if (V[i] != null && V[i].d < minK) {
                minK = V[i].d;
                min = i;
            }
        Vertice v = V[min];
        V[min] = null;
        return v;
    }

    public boolean pertence(Vertice v) {
        for (int i = 0; i < V.length; i++)
            if (V[i] != null && V[i] == v)
                return true;
        return false;
    }

// exemplo de uso da fila de prioridade
    public static void main( String args[] ) {
        String fn = "grafo3a.txt";
        System.out.println("Entrada: "+fn);
        Grafo G = new Grafo(fn);
        G.imprime();
        int n = G.totV;
        FilaPrioridade Q = new FilaPrioridade(G.V);    
        System.out.println("\n\nOriginal:");
        for (int i = 0; i < n; i++) {
            Vertice v = (Vertice)G.V[i];
            v.d = n - i; // define prioridade
            System.out.print(v.nome+" ");
        }
        System.out.println("\n\nPrioridade:");
        while (!Q.vazia()) {
            Vertice u = Q.ExtraiMinimo();
            System.out.print(u.nome+" ");
        }
        System.out.println();
    }

}
