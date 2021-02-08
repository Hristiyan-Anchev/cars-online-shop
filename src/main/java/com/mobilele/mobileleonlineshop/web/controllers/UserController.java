package com.mobilele.mobileleonlineshop.web.controllers;

import com.mobilele.mobileleonlineshop.entities.enums.Role;
import com.mobilele.mobileleonlineshop.repositories.UserRoleRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserRoleService;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserService;
import com.mobilele.mobileleonlineshop.web.models.UserRegisterModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    UserRoleService userRoleService;
    UserService userService;



    @GetMapping("/login")
    public String loginView(
            @RequestParam(defaultValue = "not present",name = "error") String error,
            Model model) {

            model.addAttribute("error",error.equals("true"));

        return "auth-login";
    }

   @GetMapping("/register")
   public String registerView(Model model){
       Map<String,String> humanReadableRoles =Map.of("ROLE_USER","USER", "ROLE_ADMIN","ADMIN");

        if(!model.containsAttribute("userRegModel")){
            model.addAttribute("userRegModel",new UserRegisterModel());
        }

        var roles = userRoleService.getNonAdminRoles().stream().map(r->humanReadableRoles.get(r.getAuthority())).collect(Collectors.toList());
        model.addAttribute("roles",roles);

        return "auth-register";
   }

//   @PostMapping("/login")
//   public String loginUser(){
//
//        return "redirect:/home";
//   }

   @PostMapping("/register")
   public String registerUser(@Valid
                                 @ModelAttribute("userRegModel") UserRegisterModel userRegModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){



        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegModel",userRegModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegModel",
                    bindingResult);

           return "redirect:/users/register";
        }



        if(userRegModel.getRole().equals("USER")){
            userService.registerUser(userRegModel);

        }




        return "redirect:/users/login";
   }

}
