package br.com.monktec.hrpayroll.services;

import br.com.monktec.hrpayroll.entities.Payment;
import br.com.monktec.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {

        Map<String, String> urivariables = new HashMap<>();
        urivariables.put("id", String.valueOf(workerId));

        var worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, urivariables);

        var name = worker.getName();
        var dailyIncome = worker.getDailyIncome();

        return new Payment(name, dailyIncome, days);
    }
}
