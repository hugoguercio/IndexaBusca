/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;


import java.util.Vector;

/**
 *
 * @author Qih
 */
public class TabelaHash {
    //TEM QUE MUDAR ESSE VALOR, QUAL SERIA O VALOR DE S ?!
    private int S = 4000000;
    private int quantidadeInseridos = 0;
    //private EntradaTabela[] posicao = new EntradaTabela[S];
    private Vector<EntradaTabela> posicao = new Vector<EntradaTabela>(S);
    
    
    public void insere(String palavra, Par par){        
        /*
        -identifica a posição fazendo hash da palavra
        -insere na posição o par
        */
        int posicaoIdentificada = 0;
        NoPalavra noPalavra = new NoPalavra(palavra, par);
        EntradaTabela entrada = new EntradaTabela();
        entrada.addPar(palavra, par);
        this.posicao.add(posicaoIdentificada, entrada);
        quantidadeInseridos++;
    }
    public int getInseridos(){
        return this.quantidadeInseridos;
    }

    public TabelaHash() {
    }
    
    
}
