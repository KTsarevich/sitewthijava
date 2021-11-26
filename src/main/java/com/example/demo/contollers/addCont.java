package com.example.demo.contollers;

import com.example.demo.mod.Doljnost;
import com.example.demo.mod.Rabotnik;
import com.example.demo.mod.Zakaz;
import com.example.demo.repo.doljnostRepository;
import com.example.demo.repo.rabotnikRepository;
import com.example.demo.repo.zakazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class addCont {
    @Autowired
    private doljnostRepository dolnhostrepository;
    @RequestMapping(method = RequestMethod.POST, value = "/work/add")
    public String newDolj(@RequestParam Integer key_dolj , @RequestParam String name , Model model){
        Doljnost dolj = new Doljnost(key_dolj, name);
        dolnhostrepository.save(dolj);
        return "redirect:/work";
    }

    @Autowired
    private rabotnikRepository rabotnikrep;
    @RequestMapping(method = RequestMethod.POST, value = "/sotr/add")
    public String addsotr(@RequestParam String fio, @RequestParam Integer zarpalta, @RequestParam Integer staj, @ModelAttribute Doljnost key_doljFK, @RequestParam Integer key_rabotnika, Model model){
        Rabotnik sotr = new Rabotnik(fio, zarpalta, staj, key_doljFK, key_rabotnika);
        rabotnikrep.save(sotr);
        return "redirect:/sotr";
    }
    @Autowired
    private zakazRepository zakazrep;
    @RequestMapping(method = RequestMethod.POST, value = "/job/add")
    public String addjob(@RequestParam int key_zakaz, @RequestParam String adress,Model model){
        Zakaz zakaz = new Zakaz(key_zakaz,adress);
        zakazrep.save(zakaz);
        return "redirect:/job";
    }

}