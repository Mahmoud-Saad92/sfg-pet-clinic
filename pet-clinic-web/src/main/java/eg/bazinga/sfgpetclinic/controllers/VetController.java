package eg.bazinga.sfgpetclinic.controllers;

import eg.bazinga.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetServiceMap;

    @Autowired
    public VetController(VetService vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetServiceMap.findAll());

        return "vets/index";
    }
}
