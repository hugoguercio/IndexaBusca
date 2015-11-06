/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca.Estruturas;


import indexa.busca.FuncoesHash;
import java.util.ArrayList;

/**
 *
 * @author Qih
 */
public class TabelaHash {
    //TEM QUE MUDAR ESSE VALOR, QUAL SERIA O VALOR DE S ?!
    private ArrayList<PalavraUnica>[] tabela;    
    
    private int posicoesUtilizadas = 0;
    private int paresInseridos=0;
    private int colisoes = 0;
    private int palavraNova=0;
    private int posicoesDistintasDeColisao=0;
    //ta errado o colisoes

    
    public TabelaHash(int S) {
        this.posicoesUtilizadas = 0;
        this.colisoes = 0;
        this.tabela = new ArrayList[S];
    }
    
     
    public int getPosicoesUsadas(){
        return this.posicoesUtilizadas;
    }
    public int getColisoes(){
        return this.colisoes;
    }    
    public ArrayList getPosicao(int i){
        return this.tabela[i];
    }
    public ArrayList[] getTabela() {
        return tabela;
    }

    public int getPosicoesUtilizadas() {
        return posicoesUtilizadas;
    }
    public int getParesInseridos() {
        return paresInseridos;
    }    
    public int getPalavrasNovas(){
        return palavraNova;
    }
    
    public int tamanhoBalde(int i){
        return tabela[i].size();
    }

    public int getPosicoesDistintasDeColisao() {
        return posicoesDistintasDeColisao;
    }

    public void addPosicoesDistintasDeColisao() {
        posicoesDistintasDeColisao+=1;
    }
    
    public void setPosicoesDistintasDeColisao(int x) {
        posicoesDistintasDeColisao=x;
    }
    
    
    public void insere(String palavra, Par par){        
        /*
        -identifica a posição fazendo hash da palavra
        -insere na posição o par
        */
        FuncoesHash funcoes = new FuncoesHash();
        int posicaoIdentificada = funcoes.hash1(palavra,this.tabela.length);
        if(posicaoIdentificada <0){
            posicaoIdentificada = -posicaoIdentificada;            
        }
        posicaoIdentificada = posicaoIdentificada % this.tabela.length;
        

        PalavraUnica pAux = new PalavraUnica(palavra, par);
        if(tabela[posicaoIdentificada] == null){                        
            tabela[posicaoIdentificada] = new ArrayList<PalavraUnica>();
            tabela[posicaoIdentificada].add(pAux);
            posicoesUtilizadas++;
        }else{
            //Ver se no arraylist da tabela de hash tem alguma palavraUnica com string = palavra
            boolean palavraNova = true;
            for(int i=0 ;i<tabela[posicaoIdentificada].size();i++){
                PalavraUnica pTeste = tabela[posicaoIdentificada].get(i);
                //Ja tem, então insere o par.
                if(pTeste.getPalavra().equals(palavra)){
                    tabela[posicaoIdentificada].get(i).inserePar(par);
                    palavraNova=false;
                    
                }
            }
            if(palavraNova){
//                tabela[posicaoIdentificada] = new ArrayList<PalavraUnica>();
                tabela[posicaoIdentificada].add(pAux);
                this.palavraNova++;
                
            }
            colisoes++;
        }
        
        paresInseridos++;
    }
   
    
}

