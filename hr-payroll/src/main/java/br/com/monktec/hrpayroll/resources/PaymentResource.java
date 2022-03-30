package br.com.monktec.hrpayroll.resources;

import br.com.monktec.hrpayroll.entities.Payment;
import br.com.monktec.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {


    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPayment2")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        var payment = paymentService.getPayment(workerId, days);

        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPayment2(@PathVariable Long workerId, @PathVariable Integer days){
        var payment = new Payment("Soza", 500.0,days);

        return ResponseEntity.ok(payment);
    }


}
