package com.coutomariel.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coutomariel.hrpayroll.entities.Payment;
import com.coutomariel.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + workerId);

		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, params);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
