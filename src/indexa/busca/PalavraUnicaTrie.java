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
public class PalavraUnicaTrie {
    private ArrayList<Par> pares;

    public PalavraUnicaTrie(Par par) {
        this.pares = new ArrayList<Par>();
        this.pares.add(par);
        
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
