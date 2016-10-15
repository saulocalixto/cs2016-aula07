package com.github.saulocalixto.exercicios;

import org.junit.Test;

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
    Calendario calendariocerto = new Calendario("20160902", 2016, "20130430", 5);
    Calendario calendariodatagrande = new Calendario("520160902", 2016, "20130430", 5);
    Calendario calendariomesconhecidoerrado = new Calendario("20161502", 2016, "20131230", 5);
    Calendario calendariomesconhecido2errado = new Calendario("20160702", 2016, "20131530", 5);
    Calendario calendariodiaerrado = new Calendario("20170229", 2016, "20130430", 5);
    Calendario calendariobissextoerrado = new Calendario("20170229", -10, "20130430", 5);
    Calendario calendariodiacoerrado = new Calendario("20170229", 2017, "20130435", 5);

    @Test
    public void entradaValidaStringToInt () {
        Calendario.transformarStringemInt();
    }

    @Test
    public void entradaInvalidaStringToInt () {
        Calendario.transformarStringemInt();
    }
    
    @Test
    public void entradavalidaDiaSemana () {
        Calendario.diaSemana();
    }

    @Test
    public void entradaInvalidaDiaSemana () {
        Calendario.diaSemana();
    }

    @Test
    public void semExcessaotestarExcessoes () {
        Calendario.diaSemana();
    }
    
    @Test
    public void mesErradotestarExcessoes () {
        Calendario.diaSemana();
    }

    @Test
    public void mesErrado2testarExcessoes () {
        Calendario.diaSemana();
    }

    @Test
    public void diaErradotestarExcessoes () {
        Calendario.diaSemana();
    }

    @Test
    public void diaConhecidoErradotestarExcessoes () {
        Calendario.diaSemana();
    }

    @Test
    public void bissextoErradotestarExcessoes () {
        Calendario.diaSemana();
    }
}
