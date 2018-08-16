package com.blogspot.hasanthebagpacker.demo.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class hello {
    @GetMapping
    @ResponseBody
    public String Hello(HttpServletRequest request){
        String user = request.getParameter("name");
        return "Hello "+ user;
    }

    @RequestMapping(value="/person")
    @ResponseBody
    public String person(String name){
        return "Hello "+ name;
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html ="<form method='post'>"+
                "<input type='text' name='name'/>"+
                "<input type='submit' value='Greet me'/>"+
                "</form>";
        return html;
    }
    @RequestMapping(value = "form",method = RequestMethod.POST)
    @ResponseBody
    public String formPost(HttpServletRequest request){
        String user = request.getParameter("name");
         return "hello "+ user;
    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable  String name){
        return "Hello "+ name;
    }
    @RequestMapping(value = "goodBye")
    public String goodB(){
        return ("redirect:/form");
    }
}
