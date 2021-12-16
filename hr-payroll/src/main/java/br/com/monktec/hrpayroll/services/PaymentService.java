package br.com.monktec.hrpayroll.services;

import br.com.monktec.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Bob", 200.00, days);
    }
}
