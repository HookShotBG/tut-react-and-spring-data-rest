package com.com.gools.rest;

import com.com.gools.data.Dep;
import com.com.gools.repo.DepRepository;
import com.sun.deploy.config.VerboseDefaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Vector;

@Controller
public class DepController {

    @Autowired
    private DepRepository dr;

    @GetMapping(value = "/dep")
    public String x(){
        Iterable<Dep> d = dr.findAll();
        for (Dep a :d) {
            System.out.println(a);
        }
        return String.valueOf(d);
    }

    @RequestMapping(value="/abc")
    public String y(){
        Iterable<Dep> d = dr.findAll();
        for (Dep a :d) {
            System.out.println(a);
        }
        return String.valueOf(d);
    }

}
