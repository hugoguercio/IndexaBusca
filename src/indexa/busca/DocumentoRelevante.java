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
public class DocumentoRelevante implements Comparable<DocumentoRelevante>{
    private int doc_id;
    private double relevancia;

    public DocumentoRelevante(int doc_id, double relevancia) {
        this.doc_id = doc_id;
        this.relevancia = relevancia;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public double getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(double relevancia) {
        this.relevancia = relevancia;
    }
    
      @Override
    public int compareTo(DocumentoRelevante o) {
        //Ordenando de forma descendente

//        return  Double.valueOf(o.getRelevancia()).compareTo(this.relevancia);  
        return o.getDoc_id()-this.doc_id;
        
    }
}
