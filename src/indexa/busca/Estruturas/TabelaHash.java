/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca.Estruturas;


import indexa.busca.FuncoesHash;
import java.util.Vector;

/**
 *
 * @author Qih
 */
public class TabelaHash {
    //TEM QUE MUDAR ESSE VALOR, QUAL SERIA O VALOR DE S ?!
    private NoPalavra[] tabela;    
    private int S = 4000000;
    private int posicoesUtilizadas = 0;
    private int paresInseridos=0;
    private int colisoes = 0;

    
    public TabelaHash() {
        this.posicoesUtilizadas = 0;
        this.S = 40000000;
        this.colisoes = 0;
        this.tabela = new NoPalavra[S];
    }
    
     
    public int getPosicoesUsadas(){
        return this.posicoesUtilizadas;
    }
    public int getColisoes(){
        return this.colisoes;
    }    
    public NoPalavra getPosicao(int i){
        return this.tabela[i];
    }
    public NoPalavra[] getTabela() {
        return tabela;
    }
    public int getS() {
        return S;
    }
    public int getPosicoesUtilizadas() {
        return posicoesUtilizadas;
    }
    public int getParesInseridos() {
        return paresInseridos;
    }    
    
    public void insere(String palavra, Par par){        
        /*
        -identifica a posição fazendo hash da palavra
        -insere na posição o par
        */
        FuncoesHash funcoes = new FuncoesHash();
        int posicaoIdentificada = funcoes.hash1(palavra,S);
        if(posicaoIdentificada <0){
            posicaoIdentificada = -posicaoIdentificada;            
        }
        posicaoIdentificada = posicaoIdentificada % 4000000;
        
        NoPalavra noPalavra = new NoPalavra(palavra, par);
        //posição era vazia
        if(tabela[posicaoIdentificada] == null){
            tabela[posicaoIdentificada] = noPalavra;
            posicoesUtilizadas++;            
        }else{
            NoPalavra aux = tabela[posicaoIdentificada];
            while(aux.proximo(aux)!=null){
                aux = aux.proximo(aux);
            }
            aux.setProximo(noPalavra);
            
        }
        paresInseridos++;
    }
   
    
}
