package reDive.front;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@MapperScan("reDive.front.mapper")
@SpringBootApplication // 告诉系统这是启动类，并且是springboot的入口
public class Boot {
	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}
}
