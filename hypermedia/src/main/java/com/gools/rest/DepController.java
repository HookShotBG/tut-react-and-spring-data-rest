package com.gools.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gools.data.Dep;
import com.gools.repo.DepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepController {

    @Autowired
    private DepRepository dr;

    @GetMapping(value = "/dep")
    public String x(){
        Iterable<Dep> d = dr.findAll();
        for (Dep a :d) {
            System.out.println(a.getId());
            System.out.println(a.getActive());
            System.out.println(a.getComments());
            System.out.println(a.getDep_date());
            System.out.println(a.getEnvironment().getName());
            System.out.println(a.getLocation().getName());
        }
        return "index";
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
