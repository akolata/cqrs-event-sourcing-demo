package pl.akolata.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.akolata"})
class SpringEnableConfiguration {
}
