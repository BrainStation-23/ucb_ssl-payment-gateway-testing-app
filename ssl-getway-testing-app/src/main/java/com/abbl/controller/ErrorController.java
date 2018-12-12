package com.abbl.controller;

/*
   * User: Nasir
   * Date: 12/20/17
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String exception(Model model, Exception ex) {
        model.addAttribute("exceptionMsg", ex.getClass() + ":: -> " + ex.getMessage() + " -> " + ex.getCause());
        return "error";
    }

}
