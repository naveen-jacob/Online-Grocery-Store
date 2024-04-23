package org.ogms.productsmicroservice.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${ogms.db.url}")
    private String dbUrl;

    @Value("${ogms.db.name}")
    private String dbName;

    @Value("${ogms.db.username}")
    private String dbUsername;

    @Value("${ogms.db.password}")
    private String dbPassword;

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl+"/"+dbName);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setMaximumPoolSize(10);
        return dataSource;
    }
}