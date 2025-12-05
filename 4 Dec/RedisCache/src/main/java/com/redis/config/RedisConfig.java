package com.redis.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class RedisConfig {

	@Value("${redis.host}")
	private String redisHost;

	@Value("${redis.port}")
	private int redisPort;

	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisHost, redisPort);
		return new LettuceConnectionFactory(config);
	}

	@Bean
	public RedisCacheManager cacheManager() {

		RedisCacheConfiguration defaultConfig = buildCacheConfig(Duration.ofMinutes(10)).disableCachingNullValues();

		return RedisCacheManager.builder(redisConnectionFactory()).cacheDefaults(defaultConfig)
				.withCacheConfiguration("tutorials", buildCacheConfig(Duration.ofMinutes(5)))
				.withCacheConfiguration("tutorial", buildCacheConfig(Duration.ofMinutes(1)))
				.withCacheConfiguration("published_tutorials", buildCacheConfig(Duration.ofMinutes(3))).build();
	}

	private RedisCacheConfiguration buildCacheConfig(Duration ttl) {
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(ttl).serializeValuesWith(
				SerializationPair.fromSerializer(org.springframework.data.redis.serializer.RedisSerializer.json()));
	}

}
