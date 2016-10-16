/*
 * Copyright (c) 2016. Engenharia de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.saulocalixto.exercicios;

/**
 *
 * @author Saulo Calixto
 * Algoritmo que pega uma data desejada e uma data conhecida e retorna o dia
 * da semana correspondente a data desejada, 0 (segunda) à 6 (domingo).
 */
public class Calendario {

    private static final int[][] DIAMES = {{31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    private static int dataDesejada, dataConhecida;
    private static int bissexto, semanaConhecida;
    private static int anoDesejadoi, diaDesejadoi, mesDesejadoi;
    private static int anoConhecidoi, diaConhecidoi, mesConhecidoi;
    private static int semanaDesejada;
    
     /**
     * Obtém do dia da semana para uma dada data, um ano assumido como bissexto e
     * uma data cujo dia da semana é conhecio.
     *
     * @param data Data cujo dia da semana é desejado.
     *
     * @param bissexto Um ano assumido como bissexto.
     *
     * @param conhecida Uma data cujo dia da semana é conhecido.
     *
     * @param ds Dia da semana da data fornecida acima.
     *
     * @return O dia da semana. Zero é segunda-feira, um é terça-feira até
     * 6, que representa um domingo.
     */
    public static int diaSemana(int data, int bissexto, int conhecida, int ds) {
        
        Calendario.dataDesejada = data;
        Calendario.dataConhecida = conhecida;
        Calendario.bissexto = bissexto;
        Calendario.semanaConhecida = ds;
        
        separarDatas(dataDesejada, dataConhecida);

        return obterSemana();
    }

    /**
     *Conforme solicitação do cliente capturamos a data no formado aammdd.
     *Agora para podermos fazer os cálculos separamos a data em ano, mês e dia
     *O Método separarDatas faz esse serviço.
     * @param dataDesejada Data da qual deseja-se saber o dia da semana
     * @param dataConhecida Data da qual sabemos o dia da semana
     */
    
    public static void separarDatas(int dataDesejada, int dataConhecida) {
        
        int aux;
        
        aux = dataDesejada / 100;
        anoDesejadoi = aux / 100;
        mesDesejadoi = aux % 100;
        diaDesejadoi = dataDesejada % 100;
        
        aux = dataConhecida / 100;
        anoConhecidoi = aux / 100;
        mesConhecidoi = aux % 100;
        diaConhecidoi = dataConhecida % 100;
    }

    /**
     *
     * @return Retorna o dia da semana da dataDesejada.
     * O método incrementa ou decrementa a data conhecida, até chegar na data
     * desejada e assim obter o dia da semana
     */
    public static int obterSemana() {

        if (testarExcessoes() == -1) {
            return testarExcessoes();
        }
        semanaDesejada = semanaConhecida;
        if (dataDesejada > dataConhecida) {
            while (anoDesejadoi != anoConhecidoi || diaDesejadoi != diaConhecidoi
                    || mesDesejadoi != mesConhecidoi) {
                incrementarData();
            }
        } else if (dataDesejada < dataConhecida) {
            while (anoDesejadoi != anoConhecidoi || diaDesejadoi != diaConhecidoi
                    || mesDesejadoi != mesConhecidoi) {
                decrementarData();
            }
        }

        return semanaDesejada;
    }

    /**
     *
     * @return Retorna 1 caso não retorne excessão.
     * Retorna -1 caso retorne excessão.
     */
    public static int testarExcessoes() {
        
        int excessao = 1;
        
        if (dataDesejada > 99999999) {
            excessao =  -1;
        }
        if(dataDesejada < 10000000) {
            excessao = -1;
        }
        if (dataConhecida > 99999999) {
            excessao = -1;
        }
        if (dataConhecida < 10000000) {
            excessao = -1;
        }
        if(mesConhecidoi > 12) {
            excessao = -1;
        }else if (mesDesejadoi > 12){
            excessao = -1;
        }else if (diaDesejadoi > DIAMES[verificarBissexto
        (anoDesejadoi)][mesDesejadoi - 1]) {
            excessao = -1;
        }else if (diaConhecidoi > DIAMES[verificarBissexto
        (anoConhecidoi)][mesConhecidoi - 1]) {
            excessao = -1;
        }else if (semanaConhecida < 0 || semanaConhecida > 6) {
            excessao = -1;
        }else if (bissexto <= 0) {
            excessao = -1;
        }
        
        return (excessao);
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
        
        if (diaConhecidoi > DIAMES[verificarBissexto
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
                diaConhecidoi = DIAMES[verificarBissexto(anoConhecidoi)]
                        [mesConhecidoi - 1];
            } else {
                diaConhecidoi = DIAMES[verificarBissexto(anoConhecidoi)]
                        [mesConhecidoi];
            }
        }
        if (mesConhecidoi < 1) {
            mesConhecidoi = 12;
            anoConhecidoi--;
            diaConhecidoi = DIAMES[verificarBissexto(anoConhecidoi)]
                    [mesConhecidoi - 1];
        }
        if (semanaDesejada < 0) {
            semanaDesejada = 6;
        }
    }
}
