package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Country;
import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.models.State;
import com.emmanueltech.springbootcompleteapplication.services.CountryService;
import com.emmanueltech.springbootcompleteapplication.services.ClientService;
import com.emmanueltech.springbootcompleteapplication.services.StateService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    StateService stateService;

    @Autowired
    CountryService countryService;

    @GetMapping("/client")
    public String getClient(Model model){
        List<Client> clientList = clientService.getClient();
        model.addAttribute("clients",clientList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);

        return "client";
    }

    @GetMapping("/client/find")
    @ResponseBody
    public Optional<Client> getSingleClient(@PathParam("id") Integer id){
        Optional<Client> client = clientService.getSingleClient(id);
        return client;
    }


    @PostMapping("/client/add_client")
    public String addClient(Client client){
        clientService.addClient(client);
        return "redirect:/client";
    }

    @RequestMapping(value = "/client/edit_client",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editClient(Client Client) throws NotFoundException {
        clientService.addClient(Client);
        return "redirect:/client";
    }

    @RequestMapping(value = "/client/delete_client",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteClient(Integer id){
        clientService.deleteClient(id);
        return "redirect:/client";
    }
    
}
