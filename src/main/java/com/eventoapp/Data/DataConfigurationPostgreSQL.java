package com.eventoapp.Data;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("prod")
public class DataConfigurationPostgreSQL{

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/eventosapp");
        dataSource.setUsername("postgres");
        dataSource.setPassword("toor");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;

	// @Bean
    // public BasicDataSource dataSource() throws URISyntaxException {
    //     URI dbUri = new URI(System.getenv("DATABASE_URL"));

    //     String username = dbUri.getUserInfo().split(":")[0];
    //     String password = dbUri.getUserInfo().split(":")[1];
    //     String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

    //     BasicDataSource basicDataSource = new BasicDataSource();
    //     basicDataSource.setUrl(dbUrl);
    //     basicDataSource.setUsername(username);
    //     basicDataSource.setPassword(password);

    //     return basicDataSource;
    }
}