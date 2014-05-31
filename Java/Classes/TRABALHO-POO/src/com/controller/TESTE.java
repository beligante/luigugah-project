/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.domain.Paciente;
import com.domain.Prontuario;
import com.repository.Repository;

public class TESTE { 

    public static void main(String[] args) {
        Paciente p = new Paciente();

        p.setNome("B");
        p.addAlergias("a");

        p.addCirurgias("c");

        ProntuarioController prontuarioController = new ProntuarioController();
        prontuarioController.setRepository(new Repository<Prontuario>(Prontuario.class));
        
        PacienteController pacienteController = new PacienteController(prontuarioController);
        pacienteController.setRepository(new Repository<Paciente>(Paciente.class));
        
        pacienteController.save(p);
        
    }
}
