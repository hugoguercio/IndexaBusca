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
public class Estatistica {
    public double media(int sum, int count){
        return sum/count;
    }
    
    public double variancia(double somaQuadrados, int tamanho)
    {
        return somaQuadrados/tamanho;
    }
}
