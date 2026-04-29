package org.example.hnk24cntt1lathephong_004.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hnk24cntt1lathephong_004.model.Spacecraft;
import org.example.hnk24cntt1lathephong_004.service.SpacecraftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class SpacecraftController {
    private final SpacecraftService spacecraftService;
    @GetMapping
    public String list(Model model) {
        model.addAttribute("spacecrafts", spacecraftService.getAll());
        return "spacecraft-list";
    }
    @GetMapping("/create")
    public String add(@Valid @ModelAttribute Spacecraft spacecraft, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "spacecraft-form";
        }
        spacecraftService.save(spacecraft);
        return "redirect:/";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Spacecraft spacecraft, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "spacecraft-form";
        }
        spacecraftService.save(spacecraft);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Spacecraft spacecraft = spacecraftService.findById(id);
        model.addAttribute("spacecraft", spacecraft);
        return "spacecraft-form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        spacecraftService.delete(id);
        return "redirect:/";
    }
}
