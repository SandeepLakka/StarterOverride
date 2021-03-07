package com.springlearn.starteroverride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DiskSpaceHealthContributorAutoConfiguration.class)
public class StarterOverrideApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterOverrideApplication.class, args);
	}

}
