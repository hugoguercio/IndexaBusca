/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

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
        this.pares.insereOrdenado(par);
        this.prox = null;
    }
    
    
}
