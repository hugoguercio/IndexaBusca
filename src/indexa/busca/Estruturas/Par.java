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
public class Par {
    private String doc_id;
    private int count;

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Par(String doc_id, int count) {
        this.doc_id = doc_id;
        this.count = count;
    }
}
