/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view.controller;

import com.controller.ProntuarioController;
import com.domain.Usuario;

/**
 *
 * @author Gustavo
 */
public class ProntuarioViewController extends AbstractViewController<ProntuarioController>{

    public ProntuarioViewController(ProntuarioController controller, Usuario sessionUser) {
        super(controller, sessionUser);
    }
}
