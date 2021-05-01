package com.enigma.tokonyadianotification.mail;

import com.enigma.tokonyadianotification.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomMailSenderService implements MailSenderService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendMail(PurchaseDto purchase) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(sender);
        message.setTo(purchase.getEmailTo());
        message.setSubject("TOKONYADIA INVOICE");
        message.setText("SELAMAT PEMBELIAN BERHASIL!!");
        javaMailSender.send(message);

    }
}
