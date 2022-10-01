package com.accenture.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.accenture.entity.BankAccountDetails;
import com.accenture.util.KafkaConstants;

@Configuration
@EnableKafka
public class KafkaListenerConfig {
	
	@Bean
	public ConsumerFactory<String, BankAccountDetails> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(BankAccountDetails.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, BankAccountDetails> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, BankAccountDetails> factory = new ConcurrentKafkaListenerContainerFactory<String, BankAccountDetails>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}


}
