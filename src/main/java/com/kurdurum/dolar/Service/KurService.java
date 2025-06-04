package com.kurdurum.dolar.Service;

import com.kurdurum.dolar.Entities.Kur;
import com.kurdurum.dolar.Repository.KurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class KurService {

    @Autowired
    private KurRepository kurRepository;

    public Kur getAndSaveUsdToTryRate() {
        String apiUrl = "https://open.er-api.com/v6/latest";

        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

        if (response != null && response.getRates().containsKey("TRY")) {
            double rate = response.getRates().get("TRY");

            Kur kur = new Kur("USD", "TRY", rate, LocalDateTime.now());
            return kurRepository.save(kur);
        }

        return null;
    }

    public Kur getLastRate() {
        return kurRepository.findTopByOrderByCreatedAtDesc();
    }

    // JSON'dan mapleme için response sınıfı
    private static class ExchangeRateResponse {
        private String base;
        private java.util.Map<String, Double> rates;

        public String getBase() { return base; }
        public void setBase(String base) { this.base = base; }

        public java.util.Map<String, Double> getRates() { return rates; }
        public void setRates(java.util.Map<String, Double> rates) { this.rates = rates; }
    }
}
