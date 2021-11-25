package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.Invoice;
import com.emmanueltech.springbootcompleteapplication.models.InvoiceStatus;
import com.emmanueltech.springbootcompleteapplication.models.Client;
import com.emmanueltech.springbootcompleteapplication.repositories.InvoiceRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.InvoiceStatusRepository;
import com.emmanueltech.springbootcompleteapplication.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<InvoiceStatus> getCountries(){
        return invoiceStatusRepository.findAll();
    }
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public List<Invoice> getInvoice(){
        return invoiceRepository.findAll();
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getSingleInvoice(Integer id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice;

    }



    public void deleteInvoice(Integer id){
        invoiceRepository.deleteById(id);
    }
}
