package com.csc340sp23.controller;



import com.csc340sp23.domain.Hyperlink;
import com.csc340sp23.service.HyperlinkService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HyperlinkController {

    @Autowired
    private HyperlinkService hyperlinkService;

    @GetMapping("/hyperlinks/add")
    //@PreAuthorize("hasAuthority('ADMIN','MODERATOR')")
    public String addHyperlinkForm(Model model) {
        Hyperlink hyperlink = new Hyperlink();
        model.addAttribute("hyperlink", hyperlink);
        return "addHyperlinkForm";
    }

    @PostMapping("/hyperlinks/add")
    //@PreAuthorize("hasAuthority('ADMIN','MODERATOR')")
    public String addHyperlink(@ModelAttribute("hyperlink") Hyperlink hyperlink) {
        System.out.println("Adding hyperlink: " + hyperlink);
        hyperlinkService.save(hyperlink);
        return "redirect:/";
    }

    @GetMapping("/hyperlinks/edit/{id}")
    //@PreAuthorize("hasAuthority('ADMIN','MODERATOR')")
    public String editHyperlinkForm(@PathVariable("id") Long id, Model model) {
        Hyperlink hyperlink = hyperlinkService.findById(id);
        model.addAttribute("hyperlink", hyperlink);
        return "editHyperLinkForm";
    }

    @PostMapping("/hyperlinks/edit/{id}")
    //@PreAuthorize("hasAuthority('ADMIN','MODERATOR')")
    public String editHyperlink(@PathVariable("id") Long id, @ModelAttribute("hyperlink") Hyperlink hyperlink) {
        hyperlinkService.save(hyperlink);
        return "redirect:/";
    }

    @GetMapping("/hyperlinks/delete/{id}")
    //@PreAuthorize("hasAuthority('ADMIN','MODERATOR')")
    public String deleteHyperlink(@PathVariable("id") Long id) {
        hyperlinkService.delete(id);
        return "redirect:/";
    }

}