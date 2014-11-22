package org.demo.web.controller;

import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class AddThankyouController extends AbstractController {

    private static Logger logger = Logger.getLogger(AddThankyouController.class);

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        return new ModelAndView("addThankyou");
    }



}
