package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private DateTimeService dateTimeService;

    public TravelCalculatePremiumServiceImpl(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

        @Override 
        public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
            TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
            response.setPersonFirstName(request.getPersonFirstName());
            response.setPersonLastName(request.getPersonLastName());
            response.setAgreementDateFrom(request.getAgreementDateFrom());
            response.setAgreementDateTo(request.getAgreementDateTo());
            long daysBetween = dateTimeService.calculateInsurancePeriodInDays(request.getAgreementDateFrom(), request.getAgreementDateTo());
            response.setAgreementPrice(new BigDecimal(daysBetween));

            return response;
        }


    }
