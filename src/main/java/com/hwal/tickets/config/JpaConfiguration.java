package com.hwal.tickets.config;

// we use this to enable lastmodified and lastcreated vars/attributes in our classses


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {


}
