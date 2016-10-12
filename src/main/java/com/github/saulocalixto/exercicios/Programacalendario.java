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
public class Programacalendario {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Calendario calen = new Calendario("20170917", "20160929", 5, 4);
   
        int opcao = calen.diaSemana();
        System.out.println("Resultado = " + opcao);
    }
}
