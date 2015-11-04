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
    private int doc_id;
    private int count;

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Par(int doc_id, int count) {
        this.doc_id = doc_id;
        this.count = count;
    }
}
