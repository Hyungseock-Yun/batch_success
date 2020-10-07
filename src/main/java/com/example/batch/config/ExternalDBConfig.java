package com.example.batch.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.batch.dao.external", sqlSessionTemplateRef = "externalSessionTemplate")
public class ExternalDBConfig {

  @Bean(name = "externalDataSource")
  //  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.externaldb")
  public DataSource externalDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "externalSessionFactory")
//  @Primary
  public SqlSessionFactory externalSessionFactory(@Qualifier("externalDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
    sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mapper/config/mybatisConfig.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean(name = "externalTransactionManager")
//  @Primary
  public DataSourceTransactionManager externalTransactionManager(@Qualifier("externalDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "externalSessionTemplate")
//  @Primary
  public SqlSessionTemplate externalSessionTemplate(@Qualifier("externalSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
