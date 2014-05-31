/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.domain.Medico;
import com.domain.Secretaria;
import com.domain.Usuario;
import com.enums.Sexo;
import com.repository.UserRepository;
import java.awt.*;  
import java.awt.event.*;  
import java.util.*;  
import javax.swing.*;  
import javax.swing.table.*;  
   
public class TESTE   
{
   
    public static void main(String[] args)  
    {
        Class<TESTE> classe = TESTE.class;
        
        System.out.println(classe.getSimpleName());
        
        UserRepository userRepository = new UserRepository();
        
        Medico medico = new Medico();
        
        medico.setNome("Joao");
        medico.setCpf("0000000000");
        medico.setDataNascimento(new Date());
        medico.setSexo(Sexo.MASCULINO);
        medico.setUser("jao");
        medico.setPassword("a");
        
        Secretaria secretaria = new Secretaria();
                
        secretaria.setNome("Ariadine");
        secretaria.setCpf("0000000000");
        secretaria.setDataNascimento(new Date());
        secretaria.setSexo(Sexo.OUTROS);
        secretaria.setUser("ariadne");
        secretaria.setPassword("rihanna");
        
        userRepository.merge(medico);
        userRepository.merge(secretaria);
        
        System.out.println(medico.getId());
        
        for(Usuario u : userRepository.getAll())
            System.out.println(u.toString());
    }
}