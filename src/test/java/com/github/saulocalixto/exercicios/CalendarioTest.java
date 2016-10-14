/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.saulocalixto.exercicios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saulocalixto
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
        calendariodatagrande.transformarStringemInt();
    }
    @Test
    public void entradaInvalidaStringToInt () {
        calendariocerto.transformarStringemInt();
    }
    
    @Test
    public void entradavalidaDiaSemana () {
        calendariocerto.diaSemana();
    }
    @Test
    public void entradaInvalidaDiaSemana () {
        calendariodatagrande.diaSemana();
    }
    @Test
    public void semExcessaotestarExcessoes () {
        calendariocerto.diaSemana();
    }
    
    @Test
    public void mesErradotestarExcessoes () {
        calendariomesconhecidoerrado.diaSemana();
    }
    @Test
    public void mesErrado2testarExcessoes () {
        calendariomesconhecido2errado.diaSemana();
    }
    @Test
    public void diaErradotestarExcessoes () {
        calendariodiaerrado.diaSemana();
    }
    @Test
    public void diaConhecidoErradotestarExcessoes () {
        calendariodiacoerrado.diaSemana();
    }
    @Test
    public void bissextoErradotestarExcessoes () {
        calendariobissextoerrado.diaSemana();
    }
    
}
