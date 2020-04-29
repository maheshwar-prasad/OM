package com.dcs.balaji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dcs.common.file.prop.CommonFileStorageProperties;

/**
 * 
 * @author deepakdubey
 * @since 26 December 2019
 * @version 1.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableTransactionManagement
@EnableJpaRepositories
@RefreshScope
@ComponentScan({ "com.dcs.balaji", "com.dcs.common", "com.dcs.datasource", "com.dcs.encryption", "com.dcs.validation",
		"com.dcs.logging" })
@EnableConfigurationProperties(CommonFileStorageProperties.class)
public class DCSSalesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DCSSalesServiceApplication.class, args);
	}

}
