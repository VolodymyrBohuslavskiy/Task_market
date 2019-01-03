package com.example.market.controllers;

import com.example.market.models.Towar;
import com.example.market.services.TowarServise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private TowarServise towarServise;

    @GetMapping("/")
    public String home(Model model) {
        List<Towar> all = towarServise.all();
        model.addAttribute("all", all);
        return "index";
    }

    @PostMapping("/add")
    public String addTowar(Towar towar) {
      if (towar!=null)towarServise.save(towar);
        return "redirect:/";
    }

    @GetMapping("/towar-{id}")
    public String seeThis(@PathVariable int id, Model model) {
        final Towar towar = towarServise.findById(id);
        model.addAttribute("towar", towar);
        return "towar";
    }

    @GetMapping("/one")
    public String one(Model model) {
        final List<Towar> all = towarServise.findAllWithPriceHig(1000);
        model.addAttribute("all", all);
        return "index";
    }

    @GetMapping("/two")
    public String two(Model model) {
        final List<Towar> all = towarServise.findAllWithPriceHig(2000);
        model.addAttribute("all", all);
        return "index";
    }

    @GetMapping("/ten")
    public String ten(Model model) {
        final List<Towar> all = towarServise.ten();
        model.addAttribute("all", all);
        return "index";
    }

    @GetMapping("/abc")
    public String abc(Model model) {
        final List<Towar> all = towarServise.allABC();
        model.addAttribute("all", all);
        return "index";
    }
    //    <a href="/abc">По алфавіту</a>


}
