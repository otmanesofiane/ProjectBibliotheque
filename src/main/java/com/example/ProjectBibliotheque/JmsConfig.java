package com.example.ProjectBibliotheque;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.backoff.ExponentialBackOff;
import org.springframework.util.backoff.FixedBackOff;

import javax.jms.ConnectionFactory;

@Configuration
//enableJMS pour pouvoir use JMSLISTENER
@EnableJms
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            @Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory) throws Exception {

        ExponentialBackOff test = new ExponentialBackOff();
        FixedBackOff test2 = new FixedBackOff();
        test2.setInterval(5000);
        test.setMaxInterval(5000);


        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        // min-max de consumer
        factory.setConcurrency("5-10");
        return factory;
    }
}
