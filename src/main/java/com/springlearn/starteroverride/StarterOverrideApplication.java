package com.springlearn.starteroverride;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@SpringBootApplication(exclude = DiskSpaceHealthContributorAutoConfiguration.class)
public class StarterOverrideApplication {

	private final DataSource dataSource;

	@Autowired
	public StarterOverrideApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(StarterOverrideApplication.class, args);
	}

	@GetMapping
	@ResponseBody
	public Map getDbName(){
		Map dbProps = new HashMap<String,String>();

		try {
			DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
			dbProps.put("dbName",metaData.getDatabaseProductName());
			dbProps.put("url",metaData.getURL());
			dbProps.put("userName",metaData.getUserName());
			dbProps.put("driverName",metaData.getDriverName());

			//return dataSource.getConnection().getMetaData().getDatabaseProductName();
		} catch (SQLException sqlException) {
			log.error("Got exception while checking dbName : {}", sqlException.getMessage());
		} finally {
			return dbProps;
		}
	}

}
