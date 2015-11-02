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
public class EntradaTabela {
    private ArrayList<NoPalavra> indiceInvertido;

    public EntradaTabela() {
        this.indiceInvertido = null;
    }


    public ArrayList<NoPalavra> getListaPalavras() {
        return indiceInvertido;
    }

    public void setListaPalavras(ArrayList<NoPalavra> listaPalavras) {
        this.indiceInvertido = listaPalavras;
    }
    
    public void addPar(String palavra, Par par){
        this.indiceInvertido.add(new NoPalavra(palavra, par));
    }
}
