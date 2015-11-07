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
public class Par implements Comparable<Par> {
    private int doc_id;
    private int count;
    private double idf;

    
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

    public double getIdf() {
        return idf;
    }

    public void setIdf(double idf) {
        this.idf = idf;
    }
    
    

    public Par(int doc_id, int count) {
        this.doc_id = doc_id;
        this.count = count;
        this.idf = -1;
    }

    @Override
    public int compareTo(Par o) {
        //Ordenando de forma descendente
        return  Double.valueOf(o.getIdf()).compareTo(this.idf);  
    }
}
