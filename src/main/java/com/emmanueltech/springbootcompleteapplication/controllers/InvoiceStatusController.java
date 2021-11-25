package com.emmanueltech.springbootcompleteapplication.controllers;

import com.emmanueltech.springbootcompleteapplication.models.InvoiceStatus;
import com.emmanueltech.springbootcompleteapplication.services.InvoiceStatusService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
    @Autowired
    InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoice_status")
    public String getInvoiceStatus(Model model){
        List<InvoiceStatus> invoiceStatus = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatus",invoiceStatus);

        return "invoice_status";
    }

    @GetMapping("/invoice_status/find")
    @ResponseBody
    public Optional<InvoiceStatus> getSingleInvoiceStatus(@PathParam("id") Integer id){
        Optional<InvoiceStatus> invoice_status = invoiceStatusService.getSingleInvoiceStatus(id);
        return invoice_status;
    }


    @PostMapping("/invoice_status/add_invoice_status")
    public String addInvoiceStatus(InvoiceStatus invoice_status){
        invoiceStatusService.addInvoiceStatus(invoice_status);
        return "redirect:/invoice_status";
    }

    @RequestMapping(value = "/invoice_status/edit_invoice_status",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editInvoiceStatus(InvoiceStatus InvoiceStatus) throws NotFoundException {
        invoiceStatusService.addInvoiceStatus(InvoiceStatus);
        return "redirect:/invoice_status";
    }

    @RequestMapping(value = "/invoice_status/delete_invoice_status",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoiceStatus(Integer id){
        invoiceStatusService.deleteInvoiceStatus(id);
        return "redirect:/invoice_status";
    }
}
