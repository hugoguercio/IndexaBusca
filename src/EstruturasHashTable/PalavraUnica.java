/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasHashTable;

import java.util.ArrayList;

/**
 *
 * @author Qih
 */
public class PalavraUnica{
    private String palavra;
    private ArrayList<Par> pares;

    public PalavraUnica(String palavra, Par par) {
        this.palavra = palavra;
        this.pares = new ArrayList<Par>();
        this.pares.add(par);
        
    }

    public String getPalavra() {
        return palavra;
    }
    
    public void inserePar(Par par){
        this.pares.add(par);
    }

    public ArrayList<Par> getPares() {
        return pares;
    }

    public void setPares(ArrayList<Par> pares) {
        this.pares = pares;
    }

    
    
    
    
}
