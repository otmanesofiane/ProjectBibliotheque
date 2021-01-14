package com.example.ProjectBibliotheque;

import com.example.ProjectBibliotheque.model.Livre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    // écoute les messages de la queue
    @JmsListener(destination = "Bibliotheque-queue")
    public void messageListener(Livre livre) {
        LOGGER.info("Message received! {}", livre);


    }

}
