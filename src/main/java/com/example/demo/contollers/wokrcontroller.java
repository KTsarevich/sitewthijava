package com.example.demo.contollers;
import com.example.demo.mod.Doljnost;
import com.example.demo.mod.Rabotnik;
import com.example.demo.mod.Zakaz;
import com.example.demo.mod.Zakaz_rabotnik;
import com.example.demo.mod.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class wokrcontroller {

    @Autowired
    private doljnostRepository dolnhostrepository;

    @GetMapping("/work")
    public String doljMain(Model model) {
        Iterable<Doljnost> dol = dolnhostrepository.findAll();
        model.addAttribute("dol", dol);
        return "work-main";
    }
    @GetMapping("/work/add")
    public String doljAdd(Model model) {
        return "work-add";
    }

    @Autowired
    private rabotnikRepository rabotnikrep;

    @GetMapping("/sotr")
    public  String sotrMain(Model model) {
        Iterable<Rabotnik> rab = rabotnikrep.findAll();
        model.addAttribute("rab", rab);
        return "sotr";
    }
    @GetMapping("/sotr/add")
    public  String sotraddMain(Model model) {
        return "sotradd";
    }


    @Autowired
    private zakazRepository zakazrep;

    @GetMapping("/job")
    public  String zakazMain(Model model) {
        Iterable<Zakaz> zaka = zakazrep.findAll();
        model.addAttribute("zaka", zaka);
        return "job";
    }
    @GetMapping("/job/add")
    public  String zakazaddMain(Model model) {
        return "jobadd";
    }
}
