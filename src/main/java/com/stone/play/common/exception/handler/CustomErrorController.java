package com.stone.play.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public ModelAndView handleError(ModelAndView mav, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = null;
        String message = "N/A";

        if (status != null) {
            statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                message = "The page you requested was not found.";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                message = "The server was unable to complete your request.";
            }
        }

        mav.setViewName("/errors/error");
        mav.addObject("message", message);
        mav.addObject("statusCode", statusCode);

        return mav;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
