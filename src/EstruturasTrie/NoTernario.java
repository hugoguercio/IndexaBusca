/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasTrie;

import indexa.busca.PalavraUnica;
import indexa.busca.Par;

/**
 *
 * @author Qih
 */
public class NoTernario {
    char letra;
    NoTernario esquerda,meio, direita;
    boolean folha;
    PalavraUnica listaDocumentosComPalavra;
    /*
        Construtores    
    */
    public NoTernario() {
        
    }
    
   
    
    public NoTernario(char val) {
        this.letra = val;
    }

    public PalavraUnica getListaDocumentosComPalavra() {
        return listaDocumentosComPalavra;
    }

    public void setListaDocumentosComPalavra(PalavraUnica listaDocumentosComPalavra) {
        this.listaDocumentosComPalavra = listaDocumentosComPalavra;
    }
    
    public void inserePar(String palavra,Par par){
        this.listaDocumentosComPalavra.inserePar(par);
    }
    
    public void inserePrimeiroPar(String Palavra, Par par){
        listaDocumentosComPalavra = new PalavraUnica(Palavra, par);
    }
}