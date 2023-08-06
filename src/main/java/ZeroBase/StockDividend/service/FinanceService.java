package ZeroBase.StockDividend.service;

import ZeroBase.StockDividend.exception.impl.NoCompanyException;
import ZeroBase.StockDividend.model.Company;
import ZeroBase.StockDividend.model.Dividend;
import ZeroBase.StockDividend.model.ScrapedResult;
import ZeroBase.StockDividend.persist.CompanyRepository;
import ZeroBase.StockDividend.persist.DividendRepository;
import ZeroBase.StockDividend.persist.entity.CompanyEntity;
import ZeroBase.StockDividend.persist.entity.DividendEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    @Cacheable(key = "#companyName", value = "finance")
    public ScrapedResult getDividendByCompanyName(String companyName) {
      log.info("search company -> " + companyName);

        // 1. 회사명을 기준으로 회사정보를 조회
        CompanyEntity company = this.companyRepository.findByName(companyName)
                .orElseThrow(() -> new NoCompanyException());

        // 2. 조회 된 회사 ID 로 배당금 조회
        List<DividendEntity> dividendEntities = this.dividendRepository.findAllByCompanyId(company.getId());


        // 3. 결과 확인
        List<Dividend> dividends = dividendEntities.stream()
                .map(e -> new Dividend(e.getDate(),e.getDividend()))
                        .collect(Collectors.toList());

        return new ScrapedResult(new Company(company.getTicker(), company.getName()),dividends);
    }
}
