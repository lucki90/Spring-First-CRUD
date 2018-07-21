package com.sda.spring.javaSpring1.controller;


import com.sda.spring.javaSpring1.model.Receipt;
import com.sda.spring.javaSpring1.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receipt create(@RequestBody Receipt receipt){
        return receiptService.created(receipt);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Receipt> getAll(){
        return receiptService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        receiptService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receipt getById(@PathVariable Long id){
        return receiptService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receipt update ( @PathVariable Long id,/*nr id ze sciezki url*/
                            @RequestBody Receipt receipt){
        return receiptService.update(id,receipt);
    }

}
