/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.controller;

import com.controller.AbstractController;
import com.domain.Usuario;

/**
 *
 * @author Gustavo
 */
abstract class AbstractViewController<Controller extends AbstractController> {

    private Controller controller;
    private Usuario sessionUser;

    public AbstractViewController(Controller controller, Usuario sessionUser) {
        this.controller = controller;
        this.sessionUser = sessionUser;
    }

    public Controller getController() {
        return this.controller;
    }

    public Usuario getSessionUser() {
        return sessionUser;
    }
}
