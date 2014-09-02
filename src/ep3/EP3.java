/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3;

import grafo.Arco;
import grafo.ComparatorVertice;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.LerGrafoTXT;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class EP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LerGrafoTXT leGrafo = new LerGrafoTXT();
        Grafo grafo = leGrafo.LerArquivo(args[0]);
        MST_Prim(grafo, grafo.getVertices().get(0));
        imprimeArvoraGeradoraMinima(grafo);
    }

    public static void MST_Prim(Grafo G, Vertice verticeInicial) {
        for (Vertice vertice : G.getVertices()) {
            vertice.setChave(Double.POSITIVE_INFINITY);
            vertice.setPai("NIL");
        }
        verticeInicial.setChave(0);
        List<Vertice> filaPrioridade = new ArrayList<>();
        filaPrioridade.addAll(G.getVertices());
        while (!filaPrioridade.isEmpty()) {
            Vertice u = Collections.min(filaPrioridade, new ComparatorVertice());
            filaPrioridade.remove(u);
            for (Arco arco : u.getArcos()) {
                Vertice v = arco.getVerticeDestino();
                if (filaPrioridade.contains(v) && arco.getPeso() < v.getChave()) {
                    v.setChave(arco.getPeso());
                    v.setPai(u.getNome());
                }
            }
        }
    }

    public static void imprimeArvoraGeradoraMinima(Grafo G) {
        double pesoTotal = 0;
        for (Vertice vertice : G.getVertices()) {
            System.out.printf(vertice.getNome() + "(" + vertice.getPai() + "); ");
            pesoTotal += vertice.getChave();
        }
        System.out.println("\nPeso = " + pesoTotal);
    }

}
