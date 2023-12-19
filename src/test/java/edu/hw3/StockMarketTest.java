package edu.hw3;

import edu.hw3.task6.QueueStockMarket;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StockMarketTest {

    static Stock[] stocks = {
        new Stock(34, "Газпром"),
        new Stock(1000, "Транснефть"),
        new Stock(56, "Сбербанк"),
        new Stock(24, "Киви")
    };

    @Test
    void stockMarketTest() {
        StockMarket market = new QueueStockMarket();
        for (Stock stock : stocks) {
            market.add(stock);
        }
        assertThat(market.mostValuableStock().getValue()).isEqualTo(1000);
    }

    @Test
    void removeTest() {
        StockMarket market = new QueueStockMarket();
        for (Stock stock : stocks) {
            market.add(stock);
        }

        market.remove(stocks[1]);
        market.remove(stocks[0]);

        assertThat(market.mostValuableStock().getValue()).isEqualTo(56);
    }
}
