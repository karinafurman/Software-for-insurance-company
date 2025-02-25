package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());

      LocalDate date1 = request.getAgreementDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      LocalDate date2 = request.getAgreementDateTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        //long differenceMilliseconds = request.getAgreementDateFrom().getTime() - request.getAgreementDateTo().getTime();
        //var daysBetween = TimeUnit.DAYS.convert(differenceMilliseconds, TimeUnit.MILLISECONDS);
        response.setAgreementPrice(new BigDecimal(daysBetween));

        return response;
    }

}
