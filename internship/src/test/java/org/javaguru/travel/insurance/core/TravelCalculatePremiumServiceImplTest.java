package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock
    private DateTimeService dateTimeService;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;
    private TravelCalculatePremiumRequest request;

    @BeforeEach
    public void setUp() {
        request = createRequestWithAllFields();
        when(dateTimeService.calculateInsurancePeriodInDays(request.getAgreementDateFrom(), request.getAgreementDateTo())).thenReturn(0L);
    }
    

    @Test
    public void responseCorrectnessPersonFirstName() {
        var response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void responseCorrectnessPersonLastName() {
        var response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void responseCorrectnessAgreementDateFrom() {
        var response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(), request.getAgreementDateFrom());
    }

    @Test
    public void responseCorrectnessAgreementDateTo() {
        var response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(), request.getAgreementDateTo());
    }

    @Test
    public void responseCorrectnessAgreementPrice() {
        var response = service.calculatePremium(request);
        assertNotNull(response.getAgreementPrice());
    }

    private TravelCalculatePremiumRequest createRequestWithAllFields() {
        var request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Peterson");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }


}


