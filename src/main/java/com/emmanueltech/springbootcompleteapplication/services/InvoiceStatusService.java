package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.InvoiceStatus;
import com.emmanueltech.springbootcompleteapplication.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;


    public List<InvoiceStatus> getInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }

    public void addInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> getSingleInvoiceStatus(Integer id) {
        Optional<InvoiceStatus> InvoiceStatus = invoiceStatusRepository.findById(id);
        return InvoiceStatus;

    }



    public void deleteInvoiceStatus(Integer id){
        invoiceStatusRepository.deleteById(id);
    }
}
