package com.ipvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
//@EntityScan("com.ipvc.entity")
public class DemoWeek3Application {

    @Autowired
    private ClienteRepository clienterepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoWeek3Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner1(ClienteRepository clienterepository)
    {
        return (args -> {
            Cliente1 cli = new Cliente1();
            cli.setName("Albatrofina");
            cli.setAddress("Rua ondelamora, 321");
            cli.setNif("192833455");
            cli.setPostalCode("4900-987");
            clienterepository.save(cli);
        });
    }


    @Bean
    public CommandLineRunner commandLineRunner2(ClienteRepository clienterepository)
    {
        return (args -> {
            Cliente1 cli = clienterepository.findById(10L).get();
            System.out.println(cli.getName());
        });
    }


    @Bean
    public CommandLineRunner commandLineRunner3(ProdutoRepository produtoRepository)
    {
        return (args -> {
            Produto prod = new Produto();
            prod.setId(Long.valueOf(1));
            prod.setNome("Batatas");
            prod.setPrice(new BigDecimal(4.5));
            produtoRepository.save(prod);
        });
    }

}
