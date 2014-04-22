/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.RedesNeurais;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class Camada {
    private Neuronio[] neuronio;
    private double[] out;
    private double[] erroprop;
    public Camada(int qtdEntradas, int qtdSaidas){
        out = new double[qtdSaidas];
        erroprop = new double[qtdEntradas];
        neuronio = new Neuronio[qtdSaidas];
        for(int i=0;i<qtdSaidas;i++){
            neuronio[i]=new Neuronio(qtdEntradas);
            neuronio[i].erros = erroprop;
        }
    }    
    
    public double[] forward(double[] input){
        for(int i=0;i<neuronio.length;i++)
            out[i] = neuronio[i].forward(input);
        return out;
    }
    public double[] backward(double[] err){
        Arrays.fill(erroprop, 0);
        for(int i=0;i<neuronio.length;i++)
            neuronio[i].backward(err[i]);
        return erroprop;
    }
}
