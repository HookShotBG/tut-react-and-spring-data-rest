package com.gools.rest;

import com.gools.data.Dep;
import com.gools.data.DepL;
import com.gools.repo.DepLReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepLController {

    @Autowired
    private DepLReporitory dr;

    @GetMapping(value = "/depI")
    public String x(){
        Iterable<DepL> d = dr.findAll();
        for (DepL a :d) {
            System.out.println(a.getId());
            System.out.println(a.getActive());
            System.out.println(a.getComments());
            System.out.println(a.getDep_date());
        }
        return "index";
    }

    @RequestMapping(value="/abcI")
    public String y(){
        Iterable<DepL> d = dr.findAll();
        for (DepL a :d) {
            System.out.println(a);
        }
        return String.valueOf(d);
    }

}
