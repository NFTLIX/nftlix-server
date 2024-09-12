package skku.nftlix_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NftlixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NftlixServerApplication.class, args);
	}

}
