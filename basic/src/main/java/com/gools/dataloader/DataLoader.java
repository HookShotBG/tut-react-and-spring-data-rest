package com.gools.dataloader;

import com.gools.data.*;
import com.gools.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DepRepository dr;

    @Autowired
    private DepTaskRepository dtr;

    @Autowired private EnvironmentRepository er;
    @Autowired private LocationRepository lr;
    @Autowired private ReleaseRepository rr;
    @Autowired private TaskOrderRepository tor;
    @Autowired private TaskStatusRepository tsr;

    @Autowired
    private DepLReporitory asdf;

    @Override
    public void run(String... args) throws Exception {

        TaskStatus ts = new TaskStatus(100, "open", "FFFFFF", 0);
        this.tsr.save(ts);
        this.tsr.save(new TaskStatus(200, "pending", "FFCFCF", 0));
        this.tsr.save(new TaskStatus(300, "done", "CFCFCF", 1));
        this.tsr.save(new TaskStatus(400, "not needed", "CFCFCF", 1));
        this.tsr.save(new TaskStatus(3000, "asdf", "asdf", 1));

        TaskOrder to = new TaskOrder("Pre", 100, "Pre Tasks");
        this.tor.save(to);
        this.tor.save(new TaskOrder("Inter", 200, "Inter Tasks"));
        this.tor.save(new TaskOrder("Post", 300, "Post Tasks"));

        Release r = new Release("16.1.0", 400, "GEAR Release 16.1.0", 1);
        this.rr.save(r);
        this.rr.save(new Release("16.0.0", 300, "GEAR Release 16.0.0", 1));
        this.rr.save(new Release("15.5.5", 200, "GEAR Release 15.5.5", 1));
        this.rr.save(new Release("15.7.5", 100, "GEAR Release 15.7.5", 0));

        Location l = new Location("CH", "GEAR Switzerland", "data/flags/switzerland.gif");
        this.lr.save(l);
        this.lr.save(new Location("US", "GEAR US", "data/flags/us.gif"));
        this.lr.save(new Location("DE", "GEAR Germany", "data/flags/de.gif"));
        this.lr.save(new Location("GRDA", "GEAR GRDA", "data/flags/grda.gif"));
        this.lr.save(new Location("EU", "GEAR Europe", "data/flags/eu.gif"));
        this.lr.save(new Location("APAC", "GEAR APAC", "data/flags/apac.gif"));

        Environment e = new Environment("INT", "GEAR", "Integration Testing", l, r, 1, 1);
        this.er.save(e);
        e.setName("ST");
        this.er.save(e);
        l.setName("US");
        e.setLocation(l);
        e.setName("AT");
        this.er.save(e);

        this.dtr.save(new DepTask("Short desc", "Long desc", 1, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc2", "Long desc", 2, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc3", "Long desc", 3, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc4", "Long desc", 4, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc5", "Long desc", 5, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc6", "Long desc", 6, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc7", "Long desc", 7, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc8", "Long desc", 8, to, ts, "FFFFFF", 1));
        this.dtr.save(new DepTask("Short desc9", "Long desc", 9, to, ts, "saskdl", 1));
        this.dtr.save(new DepTask("Short desc00", "Long desc", 10, to, ts, "ASDFGS", 1));

        List<DepTask> ab = (List<DepTask>) dtr.findAll();
        Date x = new Date(System.currentTimeMillis());
        Date y = new Date(System.currentTimeMillis()-15);
        Date z = new Date(System.currentTimeMillis()+15);
       this.dr.save(new Dep(x, y, z, "comments yeet", "notes hehe", 1, r, l, e, ab));

       this.asdf.save(new DepL("asdf", "penis", "dickhead", "", "", 1, "16.1", "gehg", "sdf", "asdf"));
    }

}
