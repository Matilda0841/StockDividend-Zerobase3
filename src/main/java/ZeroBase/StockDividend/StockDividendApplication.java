package ZeroBase.StockDividend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class StockDividendApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockDividendApplication.class, args);

    System.out.println("Main -> " + Thread.currentThread().getName());
  }

}