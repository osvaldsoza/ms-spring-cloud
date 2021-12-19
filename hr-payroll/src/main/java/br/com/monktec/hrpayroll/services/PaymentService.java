package br.com.monktec.hrpayroll.services;

import br.com.monktec.hrpayroll.entities.Payment;
import br.com.monktec.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {

        var worker = workerFeignClient.findById(workerId).getBody();

        var name = "";
        var dailyIncome = 0.0;

        if( worker != null){
             name = worker.getName();
            dailyIncome = worker.getDailyIncome();
        }

        return new Payment(name, dailyIncome, days);
    }
}
