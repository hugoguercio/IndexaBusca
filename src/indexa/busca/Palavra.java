/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package indexa.busca;

/**
 *
 * @author Qih
 */
public class Palavra {
    private String palavra;
    private String documento;
    private int count;
    
    /*
    Construtor
    */
        
    public Palavra(String palavra, String documento, int count) {
        this.palavra = palavra;
        this.documento = documento;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
