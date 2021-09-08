package com.oreilly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
* Annotation made up of another annotation
*
*  @SpringBootConfiguration - @JavaConfig approach
*  @EnableAutoConfiguration - Detects class on classpath and configure it automatically.
*  @ComponentScan - Telling Spring to start here. Looking for classes annotated with @Component & telling spring to manage this classes.
* 					That's why every class is a descendant package to com.oreilly.demo
*
* */

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
