/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasTrie;

import indexa.busca.Documento;
import indexa.busca.PalavraUnica;
import indexa.busca.Par;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Qih
 */
public class Trie {
    /*
        Atributos
    */
    private NoTernario raiz;
    private ArrayList<Documento> documentos;
    
    /*
        Getters e Setters
    */
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }        
    public Documento getIndex(int i){
        return this.documentos.get(i);
    }
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    
    /*
        Construtor
    */
    public Trie() {
        raiz = new NoTernario();
    }

    /*
        Métodos
    */
    
    /*
        Métodos de inserção
    */
    public void insere(String palavra) {
        if (palavra != null && !palavra.isEmpty()){
            //chama o insere passando a raiz
            insere(palavra, 0, raiz);
        }
    }

    private NoTernario insere(String palavra, int posicao, NoTernario no) {
        char ch = palavra.charAt(posicao);
        //Nó não existe
        if (no == null){
            no = new NoTernario(ch);
        }
        
        if (ch < no.letra){
            no.esquerda = insere(palavra, posicao, no.esquerda);
        }
        else if (ch > no.letra){
            no.direita = insere(palavra, posicao, no.direita);
        }
        else if (posicao < palavra.length() - 1){
            no.meio = insere(palavra, posicao + 1, no.meio);
        }
        else{
            no.folha = true;
        }
        return no;
    }
    
    public void insereComPar(String palavra, Par par) {
        if (palavra != null && !palavra.isEmpty()){
            //chama o insere passando a raiz
            insereComPar(palavra, 0, raiz, par);
        }
    }
    
    private NoTernario insereComPar(String palavra, int posicao, NoTernario no, Par par) {
        char ch = palavra.charAt(posicao);
        //Nó não existe
        if (no == null){
            no = new NoTernario(ch);
        }
        
        if (ch < no.letra){
            no.esquerda = insereComPar(palavra, posicao, no.esquerda, par);
        }
        else if (ch > no.letra){
            no.direita = insereComPar(palavra, posicao, no.direita, par);
        }
        else if (posicao < palavra.length() - 1){
            no.meio = insereComPar(palavra, posicao + 1, no.meio, par);
        }
        else{
            if(no.folha == false){
                no.inserePrimeiroPar(palavra, par);
            }
            
            no.folha = true;
            no.inserePar(palavra, par);
        }
        return no;
    }
    
    /*
        Método de contido
    */
    public boolean contido(String palavra) {
        //Palavra vazia ou null
        if (palavra == null || palavra.isEmpty()){
            return false;
        }
        
        return contido(palavra, 0, raiz);
    }

    private boolean contido(String word, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = word.charAt(index);
        if (ch < node.letra){
            return contido(word, index, node.esquerda);
        }
        if (ch > node.letra){
            return contido(word, index, node.direita);
        }
        if (index < word.length() - 1){
            return contido(word, index + 1, node.meio);
        }
        return node.folha;
    }

    /*
        Método de busca
    */
    
    public NoTernario buscar(String palavra){
        //Palavra vazia ou null
        if (palavra == null || palavra.isEmpty()){
            return new NoTernario();
            
        }
        return buscar(palavra, 0, raiz);
        
        
    }

    private NoTernario buscar(String word, int index, NoTernario node)  {
        if (node == null){
            return raiz;
        }
        char ch = word.charAt(index);
        if (ch < node.letra){
            return buscar(word, index, node.esquerda);
        }
        if (ch > node.letra){
            return buscar(word, index, node.direita);
        }
        if (index < word.length() - 1){
            return buscar(word, index + 1, node.meio);
        }
        return node;
    }

    /*
        Calcula o Wij
    */
    public double calculaPeso(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        double d= count * ((Math.log((double)totalDocumentos)/ Math.log(2))/ (double)totalDocumentosComPalavra);
        return d;
    }
    
    public ArrayList<Par> busca(String chave){
        ArrayList<Par> listaPares=null;
        if(this.contido(chave)==false){
            return listaPares;            
        }
        else{
            listaPares = this.buscar(chave).getListaDocumentosComPalavra().getPares();
            
            
        }

        if(this.contido(chave)){
            //System.out.println("Palavra não encontrada em nenhum documento!");
            return listaPares;
        }else{
            Par parAux;
            PalavraUnica pTeste = null;
            pTeste = this.buscar(chave).getListaDocumentosComPalavra();
                    //Para cada par calcula o idf                     
                    listaPares = pTeste.getPares();
                    for (int j = 0; j < listaPares.size();j++) {
                    //esta calculando o mesmo idf para todos
                        parAux = pTeste.getPares().get(j);
                        parAux.setIdf(calculaPeso(listaPares.get(j).getCount(), this.getDocumentos().size(), listaPares.size()));
                    }
                    Collections.sort(listaPares);
                    pTeste.setPares(listaPares);
                 //   System.out.println("print de teste do doc_id da busca: "+listaPares.get(0).getDoc_id());

            return listaPares;
        }
    }  

    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()){
            return false;
        }
        return startsWith(prefix, 0, raiz);
    }

    private boolean startsWith(String prefix, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = prefix.charAt(index);
        if (ch < node.letra){
            return startsWith(prefix, index, node.esquerda);
        }
        if (ch > node.letra){
            return startsWith(prefix, index, node.direita);
        }
        if (index == prefix.length() - 1){
            return true;
        }
        return startsWith(prefix, index + 1, node.meio);
    }
}

