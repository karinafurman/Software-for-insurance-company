package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeService {
    long calculateInsurancePeriodInDays(Date startDate, Date endDate) {
        long difference = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }
}
