package org.ogms.productsmicroservice.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:8001/ogms_products");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        dataSource.setMaximumPoolSize(10);
        return dataSource;
    }
}