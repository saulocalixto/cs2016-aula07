/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.exercicios;

/**
 *
 * @author guest-fmra3o
 */
public class Calendario {

    private String[] diaSemana = {"Segunda", "Terça", "Quarta", "Quinta",
        "Sexta", "Sábado", "Domingo"};
    private String dataDesejada, dataConhecida, anoDesejado, diaDesejado,
            mesDesejado;
    private String anoConhecido, diaConhecido, mesConhecido;
    private int bissexto, semanaConhecida;

    public int diaSemana(String dataDesejada, String dataConhecida,
            int bissexto, int semanaConhecida) {
        
        this.dataDesejada = dataDesejada;
        this.dataConhecida = dataConhecida;
        this.bissexto = bissexto;
        this.semanaConhecida = semanaConhecida;
        
        transformarStringemInt();
        
        
    }

    public void transformarStringemInt() {
        ///////////Data desejada to INT//////////////////////////////
        anoDesejado = dataDesejada.substring(0, 4);
        char[] anoDesejadoArray = anoDesejado.toCharArray();
        int anoDesejado = Integer.parseInt(new String(anoDesejadoArray));

        diaDesejado = dataDesejada.substring(6, 8);
        char[] diaDesejadoArray = diaDesejado.toCharArray();
        int diaDesejado = Integer.parseInt(new String(diaDesejadoArray));

        mesDesejado = dataDesejada.substring(4, 6);
        char[] mesDesejadoArray = mesDesejado.toCharArray();
        int mesDesejado = Integer.parseInt(new String(mesDesejadoArray));
        
        ///////////Data conhecida to INT//////////////////////////////
        
        anoConhecido = dataConhecida.substring(0, 4);
        char[] anoConhecidoArray = anoConhecido.toCharArray();
        int anoConhecido = Integer.parseInt(new String(anoConhecidoArray));

        diaConhecido = dataConhecida.substring(6, 8);
        char[] diaConhecidoArray = diaConhecido.toCharArray();
        int diaConhecido = Integer.parseInt(new String(diaConhecidoArray));

        mesConhecido = dataConhecida.substring(4, 6);
        char[] mesConhecidoArray = mesConhecido.toCharArray();
        int mesConhecido = Integer.parseInt(new String(mesConhecidoArray));
    }

}
