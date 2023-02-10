package com.manasbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.manasbi.*")
public class ManasbiChautaariApiApplicationClass {
  public static void main(String[] args) {
    SpringApplication.run(ManasbiChautaariApiApplicationClass.class, args);
  }
}
