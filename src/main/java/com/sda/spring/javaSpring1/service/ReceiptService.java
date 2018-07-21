package com.sda.spring.javaSpring1.service;

import com.sda.spring.javaSpring1.exception.NotFoundException;
import com.sda.spring.javaSpring1.model.Product;
import com.sda.spring.javaSpring1.model.Receipt;
import com.sda.spring.javaSpring1.model.Status;
import com.sda.spring.javaSpring1.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt created(Receipt receipt){
        return receiptRepository.save(receipt);
    }

    public List<Receipt> getAll(){
        return receiptRepository.findAll();
    }

    public List<Receipt> search(String client, LocalDate startDate, LocalDate endDate, Status status) {
        if (startDate==null){
            startDate = LocalDate.of(2000,1,1);
        }
        if (endDate==null){
            endDate = LocalDate.of(2020,1,1);
        }
        if (status == null){
            return receiptRepository.findByClientContainingAndDateBetween(
                    client,startDate.atStartOfDay(),
                    endDate.atTime(LocalTime.MAX));
        }
        return receiptRepository.findByClientContainingAndDateBetweenAndStatus(
                client,startDate.atStartOfDay(),
                endDate.atTime(LocalTime.MAX), status);
    }

    public void delete(Long id) {
        if(!receiptRepository.existsById(id)){
            throw new NotFoundException(String.format("Receipt with id=%s does not exist", id));
        }
        receiptRepository.deleteById(id);
    }

    public Receipt getById(Long id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        if(!receipt.isPresent()){
            throw new NotFoundException(String.format("Receipt with id=%s does not exist", id));
        }
        return receipt.get();
    }

    public Receipt update(Long id, Receipt receipt) {
        if(!receiptRepository.existsById(id)){
            throw new NotFoundException(String.format("Receipt with id=%s does not exist", id));
        }
        receipt.setId(id);
        return receiptRepository.save(receipt);
    }
}
