package pl.softwareskill.example.cdc.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= WebEnvironment.NONE, classes = BasketServiceTest.TestConfig.class)
@AutoConfigureStubRunner(ids = {"pl.softwareskill.example.cdc:provider"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class BasketServiceTest {

    @Autowired
    BasketService basketService;

    @Test
    void createsNewBasket() {
        UUID newBasketId = basketService.createBasket();

        assertThat(newBasketId)
                .isNotNull();
    }

    @Configuration
    static class TestConfig {

        @StubRunnerPort("pl.softwareskill.example.cdc:provider")
        int basketServicePort;

        @Bean
        BasketService basketService() {
            return new BasketService("http://localhost:" + basketServicePort);
        }
    }
}
