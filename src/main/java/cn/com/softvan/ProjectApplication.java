package cn.com.softvan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("cn.com.softvan.project.mapper")
@ServletComponentScan
@EnableAutoConfiguration
public class ProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
