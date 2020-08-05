package pl.softwareskill.example.cdc.basket.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "pl.softwareskill.example.cdc.basket.rest.controller")
public class RestConfig {
}
