package com.asynchrony.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class LoggingApplication implements ApplicationRunner {
    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("WTF?");
		SpringApplication.run(LoggingApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Your application started with option names: {}", args.getOptionNames());
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        for(Level level : Level.values()){
            LOG.log(level, "Log Level {}", level);
        }
    }
}
