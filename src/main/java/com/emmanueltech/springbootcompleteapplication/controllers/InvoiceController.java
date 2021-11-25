package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.Invoice;
import com.emmanueltech.springbootcompleteapplication.models.InvoiceStatus;
import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.services.InvoiceService;
import com.emmanueltech.springbootcompleteapplication.services.InvoiceStatusService;
import com.emmanueltech.springbootcompleteapplication.services.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ClientService clientService;

    @Autowired
    InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoice")
    public String getInvoice(Model model){
        List<Invoice> invoiceList = invoiceService.getInvoice();
        model.addAttribute("invoices",invoiceList);

        List<Client> clientList = clientService.getClient();
        model.addAttribute("clients",clientList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatus",invoiceStatusList);

        return "invoice";
    }

    @GetMapping("/invoice/find")
    @ResponseBody
    public Optional<Invoice> getSingleInvoice(@PathParam("id") Integer id){
        Optional<Invoice> invoice = invoiceService.getSingleInvoice(id);
        return invoice;
    }


    @PostMapping("/invoice/add_invoice")
    public String addInvoice(Invoice invoice){
        invoiceService.addInvoice(invoice);
        return "redirect:/invoice";
    }

    @RequestMapping(value = "/invoice/edit_invoice",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editInvoice(Invoice Invoice) throws NotFoundException {
        invoiceService.addInvoice(Invoice);
        return "redirect:/invoice";
    }

    @RequestMapping(value = "/invoice/delete_invoice",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoice(Integer id){
        invoiceService.deleteInvoice(id);
        return "redirect:/invoice";
    }
}
