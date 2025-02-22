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
class TravelCalculatePremiumServiceImplAIOneTest {
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    void testCalculatePremium_AllProperties() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        request.setAgreementDateFrom(new Date(2023, 10, 1));
        request.setAgreementDateTo(new Date(2023, 10, 10));


        TravelCalculatePremiumResponse response = service.calculatePremium(request);


        assertAll(
                () -> assertEquals("John", response.getPersonFirstName(), "First name should match"),
                () -> assertEquals("Doe", response.getPersonLastName(), "Last name should match"),
                () -> assertEquals(new Date(2023, 10, 1), response.getAgreementDateFrom(), "Agreement date from should match"),
                () -> assertEquals(new Date(2023, 10, 10), response.getAgreementDateTo(), "Agreement date to should match")
        );
    }

}
