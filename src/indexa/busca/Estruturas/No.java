/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca.Estruturas;

/**
 *
 * @author Qih
 */
public class No {
    private No prox;
    private No ant;
    private Par par;

    public No(Par par) {
        this.prox = null;
        this.ant = null;
        this.par = par;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public Par getPar() {
        return par;
    }

    public void setPar(Par par) {
        this.par = par;
    }
    
    
    
}
