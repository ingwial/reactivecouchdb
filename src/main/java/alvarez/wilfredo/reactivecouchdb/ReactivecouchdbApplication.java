package alvarez.wilfredo.reactivecouchdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ReactivecouchdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivecouchdbApplication.class, args);
	}

}
