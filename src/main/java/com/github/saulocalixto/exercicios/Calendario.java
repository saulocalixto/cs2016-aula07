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
public final class Calendario {

    /**
     * Construtor privado para atender ao Checkstyle.
     */
    private Calendario() {
        // Segue recomendação de Checkstyle.
    }

    /**
     * Contém a quantidade máxima de dias do mês dependendo do ano.
     */
    private static final int[][] DIAMES = {{31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    /**
     * Salva a data desejada pelo usuário e a data conhecida inserida por ele.
     */
    private static int dataDesejada, dataConhecida;

    /**
     * bissexto salva o ano bissexto inserido pelo usuário. A semana conhecida
     * salva o dia da semana inserida pelo usuário.
     */
    private static int bissexto, semanaConhecida;

    /**
     * Salva o ano, dia e mes desejados obtidos de dataDesejada.
     */
    private static int anoDesejado, diaDesejado, mesDesejado;

    /**
     * Salva o ano, dia e mes conhecidos obtidos de dataConhecida.
     */
    private static int anoConhecido, diaConhecido, mesConhecido;

    /**
     * Quantidade máxima de meses.
     */
    private static final int QTDMAXMES = 12;

    /**
     * Quantidade máxima de semanas.
     */
    private static final int QTDMAXSEMANA = 6;

    /**
     * Número usado para poder separar a data. Usado também no método
     * verificarBissexto(), compreende um período de 100 anos.
     */
    private static final int SEPARADOR = 100;

    /**
     * Tamanho máximo para a data.
     */
    private static final int SIZEMAX = 99999999;

    /**
     * Tamanho mínimo para a data.
     */
    private static final int SIZEMIN = 10000000;

    /**
     * Constante para se usar no método verificarBissexto() eliminando números
     * mágicos.
     */
    private static final int QUADRIENIO = 4;

        /**
     * Constante para se usar no método verificarBissexto() eliminando números
     * mágicos.
     */
    private static final int QUATROSECULOS = 400;

    /**
     * semanaDesejada é a variável que irá guardar a semana que o usuário
     * solicitou.
     */
    private static int semanaDesejada;

     /**
     * Obtém do dia da semana para uma dada data, um ano assumido como bissexto
     * e uma data cujo dia da semana é conhecio.
     *
     * @param data Data cujo dia da semana é desejado.
     *
     * @param bi Um ano assumido como bissexto.
     *
     * @param conhecida Uma data cujo dia da semana é conhecido.
     *
     * @param ds Dia da semana da data fornecida acima.
     *
     * @return O dia da semana. Zero é segunda-feira, um é terça-feira até
     * 6, que representa um domingo.
     */
    public static int diaSemana(final int data, final int bi,
            final int conhecida, final int ds) {
        Calendario.dataDesejada = data;
        Calendario.dataConhecida = conhecida;
        Calendario.bissexto = bi;
        Calendario.semanaConhecida = ds;
        separarDatas(dataDesejada, dataConhecida);

        return obterSemana();
    }

    /**
     *Conforme solicitação do cliente capturamos a data no formado aammdd.
     *Agora para podermos fazer os cálculos separamos a data em ano, mês e dia
     *O Método separarDatas faz esse serviço.
     * @param dDesejada Data da qual deseja-se saber o dia da semana
     * @param dConhecida Data da qual sabemos o dia da semana
     */
    public static void separarDatas(final int dDesejada,
            final int dConhecida) {
        int aux;
        aux = dDesejada / SEPARADOR;
        anoDesejado = aux / SEPARADOR;
        mesDesejado = aux % SEPARADOR;
        diaDesejado = dDesejada % SEPARADOR;

        aux = dConhecida / SEPARADOR;
        anoConhecido = aux / SEPARADOR;
        mesConhecido = aux % SEPARADOR;
        diaConhecido = dConhecida % SEPARADOR;
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
            while (anoDesejado != anoConhecido || diaDesejado != diaConhecido
                    || mesDesejado != mesConhecido) {
                incrementarData();
            }
        } else if (dataDesejada < dataConhecida) {
            while (anoDesejado != anoConhecido || diaDesejado != diaConhecido
                    || mesDesejado != mesConhecido) {
                decrementarData();
            }
        }

        return semanaDesejada;
    }

    /**
     *Testa todas as excessões exigidas pelo cliente, retornado -1 caso elas
     * ocorram.
     * @return Retorna 1 caso não retorne excessão.
     * Retorna -1 caso retorne excessão.
     */
    public static int testarExcessoes() {

        int excessao = 1;

        if (dataDesejada > SIZEMAX) {
            excessao =  -1;
        }
        if (dataDesejada < SIZEMIN) {
            excessao = -1;
        }
        if (dataConhecida > SIZEMAX) {
            excessao = -1;
        }
        if (dataConhecida < SIZEMIN) {
            excessao = -1;
        }
        if (mesConhecido > QTDMAXMES) {
            excessao = -1;
        } else if (mesDesejado > QTDMAXMES) {
            excessao = -1;
        } else if (diaDesejado > DIAMES[verificarBissexto(anoDesejado)]
                [mesDesejado - 1]) {
            excessao = -1;
        } else if (diaConhecido > DIAMES[verificarBissexto(anoConhecido)]
                [mesConhecido - 1]) {
            excessao = -1;
        } else if (semanaConhecida < 0 || semanaConhecida > QTDMAXSEMANA) {
            excessao = -1;
        } else if (bissexto <= 0) {
            excessao = -1;
        }

        return (excessao);
    }

    /**
     *
     * @param ano Ano o qual quer verificar se é bissexto ou não
     * @return retorna 1 caso o ano seja bissextou ou 0 caso não seja
     */
    public static int verificarBissexto(final int ano) {

        if ((ano % QUADRIENIO == 0 && ano % SEPARADOR != 0)
                || ano % QUATROSECULOS == 0 || ano == bissexto) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     *incrementarData() : Incrementa dataConhecida para descobrir o dia da
     * semana desejada.
     */
    public static void incrementarData() {

        diaConhecido++;
        semanaDesejada++;

        if (diaConhecido > DIAMES[verificarBissexto(anoConhecido)]
                [mesConhecido - 1]) {
            diaConhecido = 1;
            mesConhecido++;
        }
        if (mesConhecido > QTDMAXMES) {
            diaConhecido = 1;
            mesConhecido = 1;
            anoConhecido++;
        }
        if (semanaDesejada > QTDMAXSEMANA) {
            semanaDesejada = 0;
        }
    }

    /**
     *decrementarData() : Decrementa dataConhecida para descobrir o dia da
     * semana da dataDesejada.
     */
    public static void decrementarData() {

        diaConhecido--;
        semanaDesejada--;

        if (diaConhecido < 1) {
            mesConhecido--;
            if (mesConhecido != 0) {
                diaConhecido = DIAMES[verificarBissexto(anoConhecido)]
                        [mesConhecido - 1];
            } else {
                diaConhecido = DIAMES[verificarBissexto(anoConhecido)]
                        [mesConhecido];
            }
        }
        if (mesConhecido < 1) {
            mesConhecido = QTDMAXMES;
            anoConhecido--;
            diaConhecido = DIAMES[verificarBissexto(anoConhecido)]
                    [mesConhecido - 1];
        }
        if (semanaDesejada < 0) {
            semanaDesejada = QTDMAXSEMANA;
        }
    }
}
