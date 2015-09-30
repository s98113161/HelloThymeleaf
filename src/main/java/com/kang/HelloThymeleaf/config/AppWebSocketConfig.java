package com.kang.HelloThymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class AppWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 廣播
		config.enableSimpleBroker("/broadcast","/queue");
		// 接收
		config.setApplicationDestinationPrefixes("/receive");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/test").withSockJS();
	}

	@Override
	public void configureClientInboundChannel(final ChannelRegistration registration) {
	}

	@Override
	public void configureClientOutboundChannel(final ChannelRegistration registration) {
	}

}
