package ZeroBase.StockDividend.scraper;

import ZeroBase.StockDividend.model.Company;
import ZeroBase.StockDividend.model.ScrapedResult;

public interface Scraper {
  Company scrapCompanyByTicker(String ticker);

  ScrapedResult scrap(Company company);
}
