package com.example.batch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.batch.dao.shop", sqlSessionTemplateRef = "shopSessionTemplate")
public class ShopDBConfig {

  @Bean(name = "shopDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.shopdb")
  public DataSource externalDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "shopSessionFactory")
  public SqlSessionFactory externalSessionFactory(@Qualifier("shopDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
    sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mapper/config/mybatisConfig.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean(name = "shopTransactionManager")
  public DataSourceTransactionManager externalTransactionManager(@Qualifier("shopDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "shopSessionTemplate")
  public SqlSessionTemplate externalSessionTemplate(@Qualifier("shopSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
