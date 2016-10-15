package com.github.saulocalixto.exercicios;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Só três operações são requisitadas: várias vezes o construtor;
 * o método estático transformarStringemInt e diaSemana. Curiosamente,
 * os dois últimos são repetições para o último objeto criado, já que são
 * métodos static(!!???). Isso é fruto do design "curioso" que empregou,
 * vamos melhorar...
 *
 * Em tempo, está incompatível com o que foi pedido!!!!!!!!
 *
 */
public class CalendarioTest {

    // 30/04/2013 é terça-feira, salvo engano, portanto, o dia da semana é 1 (em vez de 5)
    // Deixarei essa chamada abaixo apenas para você se lembrar!! Depois remova!
    Calendario calendariocerto = new Calendario("20160902", 2016, "20130430", 5);

    @Test
    public void DoisSetembro2016CaiNaSextaAssumindoQueArgsCorretos() {
        assertEquals(4, Calendario.diaSemana(20160902, 2016, 20130430, 1));
    }
}
