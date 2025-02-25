package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TravelCalculatePremiumServiceImplTest {

    private TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();

    @Test
    public void responseCorrectnessPersonFirstName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Ivan");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void responseCorrectnessPersonLastName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonLastName("Ivanov");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void responseCorrectnessAgreementDateFrom() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateFrom(new Date());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(), request.getAgreementDateFrom());
    }

    @Test
    public void responseCorrectnessAgreementDateTo() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateTo(new Date());
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(), request.getAgreementDateTo());
    }

    @Test
    public void responseCorrectnessAgreementPrice() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        LocalDate startDate = LocalDate.of(2025, 3, 1);
        LocalDate endDate = LocalDate.of(2025, 3, 10);
        request.setAgreementDateFrom(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        request.setAgreementDateTo(Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal expectedPrice = new BigDecimal(9); // 10 - 1 = 9 дней
        assertEquals(response.getAgreementPrice(), expectedPrice);
    }
/*
    @Test
    public void shouldPopulateAgreementPrice() {
        var request = createRequestWithAllFields();
        var response = service.calculatePremium(request);
        assertNotNull(response.getAgreementPrice());
    }

    private TravelCalculatePremiumRequest createRequestWithAllFields() {
        var request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Ivan");
        request.setPersonLastName("Ivanov");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }
 */

}