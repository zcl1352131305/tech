package cn.com.softvan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("cn.com.softvan.project.mapper")
@ServletComponentScan
@EnableAutoConfiguration
public class ProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//允许上传的文件最大值
		factory.setMaxFileSize("200MB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("200MB");
		return factory.createMultipartConfig();
	}

}
