package com.enigma.tokonyadianotification.mail;

import com.enigma.tokonyadianotification.dto.PurchaseDto;

public interface MailSenderService {

    public void sendMail(PurchaseDto purchase);
}
