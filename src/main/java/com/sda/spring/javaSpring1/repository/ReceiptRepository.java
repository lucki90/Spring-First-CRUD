package com.sda.spring.javaSpring1.repository;

import com.sda.spring.javaSpring1.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {


}
