package com.rendShow.paymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rendShow.paymentService.pojo.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
