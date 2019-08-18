package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class HttpSessionConfig {

	@Bean
	public JedisConnectionFactory connectionFactory() {     // It will create filter for Redis store which will override default Tomcat Session
		return new JedisConnectionFactory();
	}

}
