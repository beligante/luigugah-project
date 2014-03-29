/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.ConsultaController;
import com.controller.PacienteController;
import com.controller.ProntuarioController;
import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Paciente;
import com.domain.Prontuario;
import com.domain.Secretaria;
import com.domain.Usuario;
import com.enums.Sexo;
import com.repository.Repository;
import com.repository.UserRepository;
import com.security.UserManager;
import com.view.controller.ConsultaViewController;
import com.view.controller.PacienteViewController;
import com.view.controller.ProntuarioViewController;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Gustavo
 */
public class Application {
    
    private static UserRepository generateUserRepositoy(){
    
        UserRepository userRepository = new UserRepository();
        
        Medico medico = new Medico();
        
        medico.setNome("Joao");
        medico.setCpf("0000000000");
        medico.setDataNascimento(new Date());
        medico.setSexo(Sexo.OUTROS);
        medico.setUser("jao");
        medico.setPassword("batata");
        
        Secretaria secretaria = new Secretaria();
                
        secretaria.setNome("Ariadine");
        secretaria.setCpf("0000000000");
        secretaria.setDataNascimento(new Date());
        secretaria.setSexo(Sexo.MASCULINO);
        secretaria.setUser("ari");
        secretaria.setPassword("rihana");
        
        userRepository.merge(medico);
        userRepository.merge(secretaria);
        
        return userRepository;
    }
    
    public static void main(String[] args){
        
        UserManager userManager = new UserManager();
        userManager.setRepository(generateUserRepositoy());
        
        Login login = new Login(userManager);
        login.setVisible(true);
        
    }
    
    public static void buildLoggedScreen(Usuario sessionUser, UserManager userManager){
    
        PacienteController pacienteController = new PacienteController();
        ProntuarioController prontuarioController = new ProntuarioController();
        ConsultaController consultaController = new ConsultaController();
        
        pacienteController.setRepository(new Repository<Paciente>());
        prontuarioController.setRepository(new Repository<Prontuario>());
        consultaController.setRepository(new Repository<Consulta>());

        PacienteViewController pacienteViewController = 
                new PacienteViewController(pacienteController, sessionUser);
        
        ProntuarioViewController prontuarioViewController = 
                new ProntuarioViewController(prontuarioController, sessionUser);
        
        ConsultaViewController  consultaViewController = 
                new ConsultaViewController(consultaController, sessionUser);
        
        Principal principal = new Principal();
        
        principal.setConsultaViewController(consultaViewController);
        principal.setPacienteViewController(pacienteViewController);
        principal.setProntuarioViewController(prontuarioViewController);
        principal.setUserManager(userManager);
        
        principal.setVisible(true);
    }
}
