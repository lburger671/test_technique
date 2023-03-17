package fr.ormaes.testtechnique.rest;

import fr.ormaes.testtechnique.business.TestTechniqueService;
import fr.ormaes.testtechnique.utils.QRCodeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class TestTechniqueWS {

    private final TestTechniqueService testTechniqueService;

    @GetMapping("/age")
    Integer getAge(@PathVariable("birthday") LocalDate birthday) {
        //TODO : Gérer les erreurs (Date dans le futur)
        return testTechniqueService.calculateAge(birthday);
    }

    @GetMapping(value = "/infosystem", produces = MediaType.TEXT_HTML_VALUE)
    String infoSystem() {
        //TODO implémenter l'appel au service
        return "";
    }

    @GetMapping(value="/nombreJourDuMois/{localDate}")
    Long maxUnite(@PathVariable("localdate") LocalDate localDate) {
        //TODO implementer le service qui retourne le nombre maximum de jours du mois en fonction de la date et du champ field demandé
        // exemple : si la Date est en Décembre, alors l'algorithm doit retourer 31
        // Tips : attention au mois de février !
        return null;
    }

    @GetMapping(value = "/generateQRCode/{text}", produces = MediaType.IMAGE_PNG_VALUE)
    BufferedImage generateQrCode(@PathVariable("text") String text) throws Exception {
        return QRCodeUtils.generateEAN13BarcodeImage(text);
    }

}
