package com.enigma.tokonyadianotification.listener;

import com.enigma.tokonyadianotification.dto.PurchaseDto;
import com.enigma.tokonyadianotification.mail.MailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MailSenderService mailSenderService;

    Logger logger = LoggerFactory.getLogger(EmailNotificationListener.class);

    @KafkaListener(id = "email-notif", topics = "tokonyadia-notification")
    public void listen(String message) throws JsonProcessingException {
        PurchaseDto purchaseDto = objectMapper.readValue(message, PurchaseDto.class);
        logger.info(purchaseDto.getEmailTo());
        mailSenderService.sendMail(purchaseDto);
    }
}
