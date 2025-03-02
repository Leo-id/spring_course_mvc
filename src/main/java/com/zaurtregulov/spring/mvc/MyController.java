package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;


@Controller
//@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){

        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails(Model model){
        Employee emp=new Employee();
        emp.setName("Ivan");
        emp.setSurname("Ivanov");
        emp.setEmail("Ivanov@abc.com");
        emp.setPhoneNumber("999-99-99");
        emp.setSurname("000");
        model.addAttribute("employee", emp);
        return "ask-emp-details-view";
    }

    @PostMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult) {
//String name=employee.getName();
//employee.setName("MR. "+name);
       if(bindingResult.hasErrors()){
           return "ask-emp-details-view";
       }
else {
            return "show-emp-details-view";}
        }

    }


