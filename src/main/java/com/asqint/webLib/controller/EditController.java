package com.asqint.webLib.controller;

import com.asqint.webLib.domain.User;
import com.asqint.webLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class EditController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getUser(Map<String, Object> model, @AuthenticationPrincipal User user) {
        model.put("username",user.getUsername());
        model.put("email",user.getEmail());
        return "profile";
    }

    @PostMapping("/profile")
    public String editUserInfo(User user,
                               Map<String, Object> model,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String password2 ) {

        boolean edit = true;

        if(user.getEmail().equals(email)) {
            model.put("passMessage", "Change email");
            edit = false;
        }
        if(password.length()<4) {
            model.put("passMessage", "Password is too short");
            edit = false;
        }
        if(!password2.equals(password)) {
            model.put("pass2Message", "Password mismatch");
            edit = false;
        }
        if(edit) {
            userService.updateProfile(user, password, email);

            model.put("messageGood", "Successful! Please check your email to activate the account.");

            return "redirect:/logout";
        }
        else return  "profile";
    }
}