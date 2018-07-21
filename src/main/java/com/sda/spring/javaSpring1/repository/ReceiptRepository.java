package com.sda.spring.javaSpring1.repository;

import com.sda.spring.javaSpring1.model.Receipt;
import com.sda.spring.javaSpring1.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

List<Receipt> findByClientContainingAndDateBetween(
        String client, LocalDateTime startDate, LocalDateTime endDate);

    List<Receipt> findByClientContainingAndDateBetweenAndStatus(
            String client, LocalDateTime startDate, LocalDateTime endDate, Status status);


}
