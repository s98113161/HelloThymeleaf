//package com.kang.HelloThymeleaf.test;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.messaging.core.MessageSendingOperations;
//import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RandomDataGenerator implements ApplicationListener<BrokerAvailabilityEvent> {
//
//	private final MessageSendingOperations<String> messagingTemplate;
//
//	@Autowired
//	public RandomDataGenerator(final MessageSendingOperations<String> messagingTemplate) {
//		this.messagingTemplate = messagingTemplate;
//	}
//
//	@Override
//	public void onApplicationEvent(final BrokerAvailabilityEvent event) {
//	}
//
//	@Scheduled(fixedDelay = 5000)
//	public void sendDataUpdates() {
//		Result result = new Result(String.valueOf(new Random().nextInt(100))); 
//		this.messagingTemplate.convertAndSend("/topic/showResult", result);
//
//	}
//}