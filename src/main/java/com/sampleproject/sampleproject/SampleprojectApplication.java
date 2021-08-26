package com.sampleproject.sampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SampleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleprojectApplication.class, args);
	}

	@KafkaListener(id = "kafka", topics = "pesan-saya")
	public void kafkakonsumer(String in) {
		System.out.println("Data yang ditarik : " + in);
	}
}
