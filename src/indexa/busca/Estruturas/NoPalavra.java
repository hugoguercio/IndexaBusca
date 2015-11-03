/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca.Estruturas;

import java.util.ArrayList;

/**
 *
 * @author Qih
 */
public class NoPalavra {
    private String palavra;
    private ListaPares pares;
    private NoPalavra prox;

    public NoPalavra(String palavra, Par par) {
        this.palavra = palavra;
        ListaPares lp = new ListaPares();
        this.pares = lp;
        this.pares.insereOrdenado(par);
        this.prox = null;
    }
    
    public NoPalavra proximo(NoPalavra np){
        return this.prox;
    }
    
    public void setProximo(NoPalavra np){
        this.prox = np;
    }
    
    public int tamanhoFilhos(){
        int tamanho=0;
        //Se tem filho
        if(this.prox != null){
            tamanho = 1 +this.prox.tamanhoFilhos();
        }
        
        return tamanho;
    }
    
}
