/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.exercicios;

/**
 *
 * @author Saulo Calixto
 * Algoritmo que pega uma data desejada e uma data conhecida e retorna o dia
 * da semana correspondente a data desejada, 0 (segunda) à 6 (domingo).
 */
public class Calendario {

    private static int[][] diaMes = {{31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    private static String dataDesejada, dataConhecida, anoDesejado, diaDesejado,
            mesDesejado;
    private static String anoConhecido, diaConhecido, mesConhecido;
    private static int bissexto, semanaConhecida;
    private static int anoDesejadoi, diaDesejadoi, mesDesejadoi;
    private static int anoConhecidoi, diaConhecidoi, mesConhecidoi;
    private static int semanaDesejada;
    private static int dataDesejadai, dataConhecidai;

    /**
     *
     * @param dataDesejada Pega data a qual se deseja saber o dia da semana
     * @param dataConhecida Pega uma data a qual se conhece o dia da semana
     * @param bissexto Pega um ano bissexto inserido pelo usuário
     * @param semanaConhecida dia da semana da data conhecida
     */
    public Calendario(String dataDesejada, int bissexto,
            String dataConhecida, int semanaConhecida) {

        this.dataDesejada = dataDesejada;
        this.dataConhecida = dataConhecida;
        this.bissexto = bissexto;
        this.semanaConhecida = semanaConhecida;
        
        transformarStringemInt();
    }

    /**
     *Capturamos a dataDesejada e a dataConhecida em String e agora convertemos
     * para int
     */
    
    public static void transformarStringemInt() {
        
        ///////////dataDesejada to INT//////////////////////////////
        
        if(dataConhecida.length() == 8 && dataDesejada.length() == 8) {

            char[] dataDesejadaArray = dataDesejada.toCharArray();
            dataDesejadai = Integer.parseInt(new String(dataDesejadaArray));

            anoDesejado = dataDesejada.substring(0, 4);
            char[] anoDesejadoArray = anoDesejado.toCharArray();
            anoDesejadoi = Integer.parseInt(new String(anoDesejadoArray));

            diaDesejado = dataDesejada.substring(6, 8);
            char[] diaDesejadoArray = diaDesejado.toCharArray();
            diaDesejadoi = Integer.parseInt(new String(diaDesejadoArray));

            mesDesejado = dataDesejada.substring(4, 6);
            char[] mesDesejadoArray = mesDesejado.toCharArray();
            mesDesejadoi = Integer.parseInt(new String(mesDesejadoArray));

            ///////////dataConhecida to INT//////////////////////////////
            char[] dataConhecidaArray = dataConhecida.toCharArray();
            dataConhecidai = Integer.parseInt(new String(dataConhecidaArray));

            anoConhecido = dataConhecida.substring(0, 4);
            char[] anoConhecidoArray = anoConhecido.toCharArray();
            anoConhecidoi = Integer.parseInt(new String(anoConhecidoArray));

            diaConhecido = dataConhecida.substring(6, 8);
            char[] diaConhecidoArray = diaConhecido.toCharArray();
            diaConhecidoi = Integer.parseInt(new String(diaConhecidoArray));

            mesConhecido = dataConhecida.substring(4, 6);
            char[] mesConhecidoArray = mesConhecido.toCharArray();
            mesConhecidoi = Integer.parseInt(new String(mesConhecidoArray));
        } else {
            dataDesejadai = -1;
            anoDesejadoi = -1;
            diaDesejadoi = -1;
            mesDesejadoi = 12;
            
            dataConhecidai = 0;
            anoConhecidoi = 0;
            diaConhecidoi = 0;
            mesConhecidoi = 12;
        }
    }

    /**
     *
     * @return Retorna o dia da semana da dataDesejada.
     */
    public static int diaSemana() {

        if (testarExcessoes() == -1) {
            return testarExcessoes();
        }
        semanaDesejada = semanaConhecida;
        if (dataDesejadai > dataConhecidai) {
            while (anoDesejadoi != anoConhecidoi || diaDesejadoi != diaConhecidoi
                    || mesDesejadoi != mesConhecidoi) {
                incrementarData();
            }
        } else if (dataDesejadai < dataConhecidai) {
            while (anoDesejadoi != anoConhecidoi || diaDesejadoi != diaConhecidoi
                    || mesDesejadoi != mesConhecidoi) {
                decrementarData();
            }
        }

        return semanaDesejada;
    }

    /**
     *
     * @return Retorna 1 caso não retorne excessão, retorna -1 caso retorne
     * excessão.
     */
    public static int testarExcessoes() {

        if(mesConhecidoi > 12) {
            return - 1;
        } else if (mesDesejadoi > 12){
            return -1;
        } else if (diaDesejadoi > diaMes[verificarBissexto
        (anoDesejadoi)][mesDesejadoi - 1]) {
            return -1;
        } else if (diaConhecidoi > diaMes[verificarBissexto
        (anoConhecidoi)][mesConhecidoi - 1]) {
            return -1;
        } else if (semanaConhecida < 0 || semanaConhecida > 6) {
            return -1;
        } else if (bissexto <= 0) {
            return -1;
        } else if(dataConhecida.length() < 8){
            return -1;
        } else if(dataDesejada.length() < 8) {
            return -1;
        } else {
            return 1;
        }

    }

    /**
     *
     * @param ano Ano o qual quer verificar se é bissexto ou não
     * @return retorna 1 caso o ano seja bissextou ou 0 caso não seja
     */
    public static int verificarBissexto(int ano) {

        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0
                || ano == bissexto) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     *incrementarData() : Incrementa dataConhecida para descobrir o dia da
     * semana desejada
     */
    public static void incrementarData() {

        diaConhecidoi++;
        semanaDesejada++;
        
        if (diaConhecidoi > diaMes[verificarBissexto
        (anoConhecidoi)][mesConhecidoi - 1]) {
            diaConhecidoi = 1;
            mesConhecidoi++;
        }
        if (mesConhecidoi > 12) {
            diaConhecidoi = 1;
            mesConhecidoi = 1;
            anoConhecidoi++;
        }
        if (semanaDesejada > 6) {
            semanaDesejada = 0;
        }

    }

    /**
     *decrementarData() : Decrementa dataConhecida para descobrir o dia da
     * semana da dataDesejada.
     */
    public static void decrementarData() {

        diaConhecidoi--;
        semanaDesejada--;
        
        if (diaConhecidoi < 1) {
            mesConhecidoi--;
            if(mesConhecidoi != 0) {
                diaConhecidoi = diaMes[verificarBissexto(anoConhecidoi)]
                        [mesConhecidoi - 1];
            } else {
                diaConhecidoi = diaMes[verificarBissexto(anoConhecidoi)]
                        [mesConhecidoi];
            }
        }
        if (mesConhecidoi < 1) {
            mesConhecidoi = 12;
            anoConhecidoi--;
            diaConhecidoi = diaMes[verificarBissexto(anoConhecidoi)]
                    [mesConhecidoi - 1];
        }
        if (semanaDesejada < 0) {
            semanaDesejada = 6;
        }

    }
}
