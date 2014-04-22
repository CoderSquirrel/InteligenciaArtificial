/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.RedesNeurais;

/**
 *
 * @author User
 */
public class MLP {

    Camada[] camada;

    public MLP(int... x) {
        if (x.length > 1) {
            camada = new Camada[x.length-1];
            for (int i = 0; i < x.length-1; i++) {
                camada[i] = new Camada(x[i], x[i+1]);
            }
        }
    }

    public double[] forward(double[] input) {
        for (int i = 0; i < camada.length; i++) {
            input = camada[i].forward(input);
        }
        return input;
    }

    public void backward(double[] err) {
        for (int i = camada.length-1; i>=0; i--) {
            err = camada[i].backward(err);
        }
    }

    public double ciclo(double[][] input, double[][] output) {
        double mse = 0;
        double[] e = new double[output[0].length];
        for (int i = 0; i < input.length; i++) {
            double[] y = forward(input[i]);
            for (int k = 0; k < e.length; k++) {
                e[k] = output[i][k] - y[k];
                mse += e[k] * e[k];
            }
            backward(e);
        }
        mse /= input.length;
        return mse;
    }

    public void train(double[][] input, double[][] output, int maxIteracoes, double errMinimo) {
        int k = 0;
        double mse = 99;
        while (k < maxIteracoes && mse > errMinimo) {
            mse = ciclo(input, output);
            k++;
            System.out.println(k + " " + mse);
        }
    }
}
