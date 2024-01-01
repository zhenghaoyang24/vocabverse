package com.zheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String error404() {
        //pages下有个error包
        return "page_404";
    }

    @RequestMapping("/500")
    public String error500() {
        return "page_500";
    }

    @RequestMapping("/403")
    public String error403() {
        return "page_403";
    }
}