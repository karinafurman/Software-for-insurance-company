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

}
