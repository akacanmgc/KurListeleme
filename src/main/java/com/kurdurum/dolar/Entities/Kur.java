package com.kurdurum.dolar.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "kur")
@AllArgsConstructor
public class Kur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baseCurrency;      // USD
    private String targetCurrency;    // TRY
    private Double rate;              // Örn: 32.10
    private LocalDateTime createdAt;  // Kaydedilme zamanı


    public Kur() {
    }

    public Kur(String baseCurrency, String targetCurrency, Double rate, LocalDateTime createdAt) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
        this.createdAt = createdAt;
    }
}
