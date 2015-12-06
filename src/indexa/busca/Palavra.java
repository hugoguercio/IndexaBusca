/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EstruturasHashTable;

/**
 *
 * @author Qih
 */
public class Palavra {
    private String palavra;
    private int count;
    
    /*
    Construtor
    */
        
    public Palavra(String palavra, int count) {
        this.palavra = palavra;
        this.count = count;
    }
    
    /*
        Getters e Setters
    */
    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    //@Override para o metodo equals comparar somente a palavra, ignorando contagens
    
    public boolean equals(Palavra palavra){
        if(palavra == null){
            return false;
        }
        if (getClass() != palavra.getClass()) {
        return false;
        }
        final Palavra p = (Palavra) palavra;
        if ((this.palavra == null) ? (p.getPalavra() != null) : !this.palavra.equals(p.palavra)) {
            return false;
        }
        return true;
    }

    
}
