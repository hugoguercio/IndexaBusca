/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca.Estruturas;



import FuncoesHash.FuncaoHashFactory;
import FuncoesHash.InterfaceHash;
import indexa.busca.FuncoesHash;
import java.util.ArrayList;
import java.util.Collections;

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
    private int posicoesDistintasDeColisao=1;
    private int quantidadeDocumentos=0;
    
    
    /*
        Construtor
    */
    
    public TabelaHash(int S) {
        this.posicoesUtilizadas = 0;
        this.colisoes = 0;
        this.tabela = new ArrayList[S];
    }
    /*
        Getters and Setters
    */
    public int getQuantidadeDocumentos() {
        return quantidadeDocumentos;
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
    public void addDocumentosInseridos() {
        quantidadeDocumentos++;
    }
    
    /*
        Métodos
    */
    
    /*
        Esse método insere um Par associado a uma palavra na tabela.        
    */
    public void insere(String palavra, Par par){        
        FuncaoHashFactory.Funcao tipo = FuncaoHashFactory.Funcao.FUNCAOHASHJAVA;
        InterfaceHash funcaoHash = FuncaoHashFactory.criaHash(tipo);
        int posicaoIdentificada = funcaoHash.hash(palavra, this.tabela.length);
        
        //Identifica a posição
//        FuncoesHash funcoes = new FuncoesHash();
//        int posicaoIdentificada = funcoes.hash1(palavra,this.tabela.length);
//        if(posicaoIdentificada <0){
//            posicaoIdentificada = -posicaoIdentificada;            
//        }
//        posicaoIdentificada = posicaoIdentificada % this.tabela.length;

        
        PalavraUnica pAux = new PalavraUnica(palavra, par);
        //Primeira palavra na posição
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
            //Se não tem a palavra, insere na lista da posição
            if(palavraNova){
                tabela[posicaoIdentificada].add(pAux);
                this.palavraNova++;
                
            }
            colisoes++;
        }        
        paresInseridos++;
    }   
   
    /*
        Esse método deve retornar uma lista de pares ordenados pelo idf do par
    */
    public void busca(String chave){
        //Identifica a posição
        FuncaoHashFactory.Funcao tipo = FuncaoHashFactory.Funcao.FUNCAOHASHJAVA;
        InterfaceHash funcaoHash = FuncaoHashFactory.criaHash(tipo);
        int posicaoIdentificada = funcaoHash.hash(chave, this.tabela.length);
//        FuncoesHash funcoes = new FuncoesHash();
//        int posicaoIdentificada = funcoes.hash1(chave,tabela.length);
//        if(posicaoIdentificada <0){
//            posicaoIdentificada = -posicaoIdentificada;            
//        }
//        posicaoIdentificada = posicaoIdentificada % tabela.length; 
        
        ArrayList<PalavraUnica> listaPalavrasNaPosicao = this.getPosicao(posicaoIdentificada);        
        if(listaPalavrasNaPosicao == null){
            System.out.println("Palavra não encontrada em nenhum documento!");
            return;
        }else{
            Par parAux;
            for(int i=0 ;i<listaPalavrasNaPosicao.size();i++){
                PalavraUnica pTeste = listaPalavrasNaPosicao.get(i);
                //Achou a lista de pares da palavra buscada
                if(pTeste.getPalavra().equals(chave)){
                    //Para cada par calcula o idf                     
                    ArrayList<Par> listaPares = pTeste.getPares();
                    for (int j = 0; j < listaPares.size();j++) {
                    //esta calculando o mesmo idf para todos
                        parAux = pTeste.getPares().get(j);
                        parAux.setIdf(calculaIdf(listaPares.get(j).getCount(), this.getQuantidadeDocumentos(), listaPares.size()));
                    }
                    Collections.sort(listaPares);
                    pTeste.setPares(listaPares);
                    System.out.println("print de teste do doc_id da busca: "+listaPares.get(0).getDoc_id());
                }
            }
        }
    }
    
    /*
        Esse método calcula o idf para um par
    */
    public double calculaIdf(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        double d= count * ((Math.log((double)totalDocumentos)/ Math.log(2))/ (double)totalDocumentosComPalavra);
        return d;
    }
    
    /*
        Esse método retorna uma posicao da tabela
    */
    public int identificaPosicao(String chave){
        FuncoesHash funcoes = new FuncoesHash();
        int posicaoIdentificada = funcoes.hash1(chave,tabela.length);
        if(posicaoIdentificada <0){
            posicaoIdentificada = -posicaoIdentificada;            
        }
        posicaoIdentificada = posicaoIdentificada % tabela.length; 
        return posicaoIdentificada;
    }
    
    
}

