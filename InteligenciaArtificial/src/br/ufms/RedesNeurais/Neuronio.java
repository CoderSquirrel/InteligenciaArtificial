/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.RedesNeurais;

public class Neuronio {

    double bias;
    double[] pesos;
    double[] entrada;
    double saida;
    double[] erros;
    double neta = 0.25;

    public Neuronio(int tamanho) {
        erros = new double[tamanho];
        pesos = new double[tamanho];
        bias = Math.random();
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = Math.random();
        }
    }

    public double forward(double[] input) {
        double s = 0;
        entrada = input; //guardando na memoria
        for (int c = 0; c < input.length; c++) {
            s = s + (entrada[c] * pesos[c]);
        }
        s += bias;
        saida = 1 / (1 + Math.exp(-s));
        return saida;
    }

    public double[] backward(double e) {
        //double e = Y - saida[l];
        double d = saida * (1 - saida);  //derivada
        bias = bias + neta * e * d;

        //bias = bias + neta * e;
        for (int c = 0; c < pesos.length; c++) {
            pesos[c] = pesos[c] + neta * e * d * entrada[c];
            erros[c] += pesos[c] * neta * e * d * entrada[c];
        }
        return erros;
    }
}