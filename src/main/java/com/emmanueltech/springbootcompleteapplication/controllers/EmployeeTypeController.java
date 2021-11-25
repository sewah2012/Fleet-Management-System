package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.EmployeeType;
import com.emmanueltech.springbootcompleteapplication.services.EmployeeTypeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    EmployeeTypeService employeeTypeService;

    @GetMapping("/employee_type")
    public String getEmployeeType(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes",employeeTypeList);

        return "employee_type";
    }

    @GetMapping("/employee_type/find")
    @ResponseBody
    public Optional<EmployeeType> getSingleEmployeeType(@PathParam("id") Integer id){
        Optional<EmployeeType> employee_type = employeeTypeService.getSingleEmployeeType(id);
        return employee_type;
    }


    @PostMapping("/employee_type/add_employee_type")
    public String addEmployeeType(EmployeeType employee_type){
        employeeTypeService.addEmployeeType(employee_type);
        return "redirect:/employee_type";
    }

    @RequestMapping(value = "/employee_type/edit_employee_type",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editEmployeeType(EmployeeType EmployeeType) throws NotFoundException {
        employeeTypeService.addEmployeeType(EmployeeType);
        return "redirect:/employee_type";
    }

    @RequestMapping(value = "/employee_type/delete_employee_type",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteEmployeeType(Integer id){
        employeeTypeService.deleteEmployeeType(id);
        return "redirect:/employee_type";
    }
}
