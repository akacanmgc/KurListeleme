package com.kurdurum.dolar.Controller;

import com.kurdurum.dolar.Entities.Kur;
import com.kurdurum.dolar.Service.KurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/kur")

public class KurController {


    @Autowired
    private  KurService kurService;

    @GetMapping("/usd-to-try")
    public Kur getAndSaveRate() {
        return kurService.getAndSaveUsdToTryRate();
    }

    @GetMapping(path = "/son-kur")
    public Kur getLastSavedRate() {
        return kurService.getLastRate();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test başarılı!";
    }

}
