/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasHashTable;



import indexa.busca.Par;
import indexa.busca.Documento;
import indexa.busca.PalavraUnica;
import FuncoesHash.FuncaoHashFactory;
import FuncoesHash.InterfaceHash;
import indexa.busca.Construtor;
import indexa.busca.DocumentoRelevante;
import indexa.busca.Palavra;
//import indexa.busca.FuncoesHash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Qih
 */
public class TabelaHash {
    private ArrayList<PalavraUnica>[] tabela;    
    
    private int posicoesUtilizadas = 0;
    private int paresInseridos=0;
    private int colisoes = 0;
    private int palavraNova=0;
    private int posicoesDistintasDeColisao=1;
    private int quantidadeDocumentos=0;
    private ArrayList<Documento> documentos;
    
    
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
    public Documento getIndex(int i){
        return this.documentos.get(i);
    }
 
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    public ArrayList getArrayTamanhoBaldes(){
         TabelaHash table = this;
         ArrayList<Integer> tamanhoDosBaldes = new ArrayList<Integer>();
        // para cada posicao da tabela
        for (int l=0;l<table.getTabela().length;l++){
            //se nao esta vazia
            if(table.getPosicao(l) !=null){               
                if(table.tamanhoBalde(l)>1){
                    //System.out.println("Tamanho do balde da posição"+l+": "+table.getPosicao(l).size());
                    tamanhoDosBaldes.add(table.tamanhoBalde(l));
                    
                }
            }   
        }
        table.setPosicoesDistintasDeColisao(tamanhoDosBaldes.size());
        return tamanhoDosBaldes;
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
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }
    
    
    public int getContagemPalavraUnicaDoDoc(int doc_id){
        for (int i=0; i<documentos.size();i++){
            if(doc_id== documentos.get(i).getDoc_id()){
                return documentos.get(i).getPalavrasDistintas();
            }
        }        
        
        return 0; 
   }
    
    
    /*
        Métodos
    */
    
    /*
        Esse método insere um Par associado a uma palavra na tabela.        
    */
    public void insere(String palavra, Par par){        
        //Identifica a posição
        int posicaoIdentificada = this.identificaPosicao(palavra);
                
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
    public ArrayList<Par> busca(String chave){
        //Identifica a posição
        int posicaoIdentificada = this.identificaPosicao(chave);
 
        ArrayList<PalavraUnica> listaPalavrasNaPosicao = this.getPosicao(posicaoIdentificada);      
        ArrayList<Par> listaPares=null;
        if(listaPalavrasNaPosicao == null){
            //System.out.println("Palavra não encontrada em nenhum documento!");
            return listaPares;
        }else{
            Par parAux;
            for(int i=0 ;i<listaPalavrasNaPosicao.size();i++){
                PalavraUnica pTeste = listaPalavrasNaPosicao.get(i);
                //Achou a lista de pares da palavra buscada
                if(pTeste.getPalavra().equals(chave)){
                    //Para cada par calcula o idf                     
                    listaPares = pTeste.getPares();
                    for (int j = 0; j < listaPares.size();j++) {
                    //esta calculando o mesmo idf para todos
                        parAux = pTeste.getPares().get(j);
                        parAux.setIdf(calculaPeso(listaPares.get(j).getCount(), this.getQuantidadeDocumentos(), listaPares.size()));
                    }
                    Collections.sort(listaPares);
                    pTeste.setPares(listaPares);
                 //   System.out.println("print de teste do doc_id da busca: "+listaPares.get(0).getDoc_id());
                }
            }
            return listaPares;
        }
    }
    
    /*
        Esse método calcula o idf para um par
    */
    public double calculaPeso(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        double d= count * ((Math.log((double)totalDocumentos)/ Math.log(2))/ (double)totalDocumentosComPalavra);
        return d;
    }
    
    /*
        Método para calcular TF-IDF
    
    */
    public ArrayList<Par> buscaMultiplas(String[] chave){        
        ArrayList<Par> listaParesUnificados = new ArrayList<Par>();
        ArrayList<Par> listaParAux =new ArrayList<Par>();
        ArrayList<Par> listaParUnificadoSemDuplicados =new ArrayList<Par>();
        double idfTotal=0;
        //Para cada palavra pega o TF
        for(int i =0;i<chave.length;i++){
            listaParAux = this.busca(chave[i]);
            //Adiciona todos os pares na lista unificada
            if(listaParAux!=null){
                for(int k=0; k<listaParAux.size();k++){
                    listaParesUnificados.add(listaParAux.get(k));
                }
            }
        }        
        
        Collections.sort(listaParesUnificados);        
        if(listaParesUnificados.size()==0){
            return listaParesUnificados;
        }
        idfTotal=listaParesUnificados.get(0).getIdf();
        for(int l=1;l<listaParesUnificados.size();l++){
            if(listaParesUnificados.get(l-1).getDoc_id()==listaParesUnificados.get(l).getDoc_id()){
                idfTotal += listaParesUnificados.get(l).getIdf(); 
           }else{
                //insere na lista o par com valor de tfidf
                listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l-1).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l-1).getDoc_id()))*idfTotal)));
            }
            
            //trata o ultimo elemento
            if((l+1)==listaParesUnificados.size() ){
                //é diferente
                if(listaParesUnificados.get(l-1).getDoc_id()!=listaParesUnificados.get(l).getDoc_id()){
                    listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l).getDoc_id()))*listaParesUnificados.get(l).getIdf())));
                }else{
                    listaParUnificadoSemDuplicados.add(new Par(listaParesUnificados.get(l-1).getDoc_id(), ((1/this.getContagemPalavraUnicaDoDoc(listaParesUnificados.get(l-1).getDoc_id()))*idfTotal)));
                }
                
            }
        }
        
        Collections.sort(listaParUnificadoSemDuplicados);
        return listaParUnificadoSemDuplicados;
    }
    
    /*
        Esse método retorna uma posicao da tabela
    */
    public int identificaPosicao(String chave){
        
        FuncaoHashFactory.Funcao tipo = FuncaoHashFactory.Funcao.FNV;
        InterfaceHash funcaoHash = FuncaoHashFactory.criaHash(tipo);
        int posicaoIdentificada = funcaoHash.hash(chave, this.tabela.length);
        return posicaoIdentificada;
    }
    
    public void getPalavrasAleatorias(){
        Construtor c = new Construtor();
        int aleatorio=0;
        for(int i=0;i<100;i++){
            aleatorio = c.randInt(1, 300000);
            if(tabela[aleatorio]==null){
                //diminui pq nao achou, senao nao temos 100 palavras no final.
                i--;
            }else{
                
                String palavraAleatoria = tabela[aleatorio].get(0).getPalavra();
                System.out.println(palavraAleatoria);
            }
        }
        
    }
    
    
}

