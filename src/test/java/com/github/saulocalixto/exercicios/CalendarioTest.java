package com.github.saulocalixto.exercicios;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Só três operações são requisitadas: várias vezes o construtor; o método
 * estático transformarStringemInt e diaSemana. Curiosamente, os dois últimos
 * são repetições para o último objeto criado, já que são métodos static(!!???).
 * Isso é fruto do design "curioso" que empregou, vamos melhorar...
 *
 * Em tempo, está incompatível com o que foi pedido!!!!!!!!
 *
 */
public class CalendarioTest {

    /**
     *
     */
    @Test
    public void DoisSetembro2016Quarta() {
        assertEquals(4, Calendario.diaSemana(20160902, 2016, 20130430, 1));
    }

    /**
     *
     */
    @Test
    public void TrintaAbril2013Terca() {
        assertEquals(1, Calendario.diaSemana(20130430, 2016, 20160902, 4));
    }
    
    /**
     *
     */
    @Test
    public void DataIgual() {
        assertEquals(4, Calendario.diaSemana(20160902, 5, 20160902, 4));
    }
    
    /**
     *
     */
    @Test
    public void Bissexto100() {
        assertEquals(1, Calendario.diaSemana(11990902, 5, 11000902, 4));
    }
    
    /**
     *
     */
    @Test
    public void BissextoUsuario() {
        assertEquals(2, Calendario.diaSemana(12990902, 1300, 13000902, 4));
    }
    
    /**
     *
     */
    @Test
    public void Bissexto400() {
        assertEquals(2, Calendario.diaSemana(19990902, 5, 20000902, 4));
    }

    /**
     *
     */
    @Test
    public void ExcessaoMesDesejadoMaior12() {
        assertEquals(-1, Calendario.diaSemana(20131530, 2016, 20161202, 4));
    }

    /**
     *
     */
    @Test
    public void ExcessaoMesConhecidoMaior12() {
        assertEquals(-1, Calendario.diaSemana(20131230, 2016, 20161602, 4));
    }

    /**
     *
     */
    @Test
    public void ExcessaoSemanaMenor0() {
        assertEquals(-1, Calendario.diaSemana(20131230, 2016, 20161202, -4));
    }

    /**
     *
     */
    @Test
    public void ExcessaoSemanaMaior6() {
        assertEquals(-1, Calendario.diaSemana(20121230, 2016, 20161202, 7));
    }

    /**
     *
     */
    @Test
    public void ExcessaoBissextoMenor0() {
        assertEquals(-1, Calendario.diaSemana(20130430, -10, 20160902, 4));
    }
    
    /**
     *
     */
    @Test
    public void ExcessaoDataPequenaD() {
        assertEquals(-1, Calendario.diaSemana(2010430, 10, 20160902, 4));
    }
    
    /**
     *
     */
    @Test
    public void ExcessaoDataPequenaC() {
        assertEquals(-1, Calendario.diaSemana(20160430, 10, 2010902, 4));
    }
    
    /**
     *
     */
    @Test
    public void ExcessaoDataGrandeD() {
        assertEquals(-1, Calendario.diaSemana(2010353430, 2015, 20160902, 4));
    }
    
    /**
     *
     */
    @Test
    public void ExcessaoDataGrandeC() {
        assertEquals(-1, Calendario.diaSemana(20160902, 2015, 2014055902, 4));
    }

    /**
     *
     */
    @Test
    public void DiaConhecidoGrandeD() {
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20130430, 1));
    }
    
    /**
     *
     */
    @Test
    public void DiaConhecidoGrandeC() {
        assertEquals(-1, Calendario.diaSemana(20160930, 2016, 20130435, 1));
    }
}
