package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumServiceImplAIEachFieldTest {
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    void testCalculatePremium() {
        // Подготовка входных данных
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        request.setAgreementDateFrom(new Date(2023, 10, 1));
        request.setAgreementDateTo(new Date(2023, 10, 10));


        TravelCalculatePremiumResponse response = service.calculatePremium(request);


        assertNotNull(response);
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(new Date(2023, 10, 1), response.getAgreementDateFrom());
        assertEquals(new Date(2023, 10, 10), response.getAgreementDateTo());
    }

    @Test
    void testCalculatePremiumWithNullValues() {
        // Подготовка входных данных с null значениями
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName(null);
        request.setPersonLastName(null);
        request.setAgreementDateFrom(null);
        request.setAgreementDateTo(null);


        TravelCalculatePremiumResponse response = service.calculatePremium(request);


        assertNotNull(response);
        assertNull(response.getPersonFirstName());
        assertNull(response.getPersonLastName());
        assertNull(response.getAgreementDateFrom());
        assertNull(response.getAgreementDateTo());
    }

}
