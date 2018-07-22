package com.sda.spring.javaSpring1.repository;

import com.sda.spring.javaSpring1.model.Receipt;
import com.sda.spring.javaSpring1.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findByClientContainingAndDateBetween(
            String client, LocalDateTime startDate, LocalDateTime endDate);

    List<Receipt> findByClientContainingAndDateBetweenAndStatus(
            String client, LocalDateTime startDate, LocalDateTime endDate, Status status);

    List<Receipt> findByClientContainingAndDateBetweenAndStatusIn(
            String client, LocalDateTime startDate, LocalDateTime endDate, Set<Status> status);

    @Query(value = "select * from receipt as r where r.client like %?1% ",
    nativeQuery = true)
    List<Receipt> search(String name);
}
