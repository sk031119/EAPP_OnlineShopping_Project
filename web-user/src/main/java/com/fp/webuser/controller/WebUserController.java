package com.fp.webuser.controller;

import com.fp.webuser.model.UserState;
import com.fp.webuser.model.WebUser;
import com.fp.webuser.service.WebUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebUserController {

    private final WebUserService webUserService;

    public WebUserController(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    @GetMapping("/webuser")
    public String showForm(Model model) {
        model.addAttribute("webUser", new WebUser());
        model.addAttribute("states", UserState.values());
        return "webuser-form";
    }

    @PostMapping("/webuser")
    public String saveUser(@ModelAttribute WebUser webUser,
                           RedirectAttributes redirectAttributes) {
        webUserService.saveWebUser(webUser);
        redirectAttributes.addFlashAttribute("success", "User saved successfully!");
        return "redirect:/webuser";
    }
}
