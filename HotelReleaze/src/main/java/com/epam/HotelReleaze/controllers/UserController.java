package com.epam.HotelReleaze.controllers;

import com.epam.HotelReleaze.dao.UserService;
import com.epam.HotelReleaze.models.User;
import com.epam.HotelReleaze.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Antoha12018 on 10.05.2017.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {

        model.addAttribute("LogForm", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@ModelAttribute("LogForm") User user, Model model) {
        User findUser = userService.findByUsername(user.getUsername());
        if (findUser != null) {
            if (findUser.getUsername().equals(user.getUsername()) &&
                    findUser.getPassword().equals(user.getPassword())) {
                if (findUser.getRole().equals("ROLE_ADMIN"))
                    return "mainAdmin";
                else
                    return "mainUser";

            }

        }
        model.addAttribute("error", "You entered data non correct.");
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration(Model model) {
        model.addAttribute("RegForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@ModelAttribute("RegForm") User user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setRole("ROLE_USER");
        userService.save(user);
        return "mainUser";
    }


}
