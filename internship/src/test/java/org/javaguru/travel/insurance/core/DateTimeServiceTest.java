package org.javaguru.travel.insurance.core;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateTimeServiceTest {
    private DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void InsurancePeriodMustBeZero() {
        Date startDate = new Date(2025, 3, 1);
        Date endDate = new Date(2025, 3, 1);
        var daysBetween = dateTimeService.calculateInsurancePeriodInDays(startDate, endDate);
        assertTrue(daysBetween == 0);
    }

    @Test
    public void InsurancePeriodMustBePositive() {
        Date startDate = new Date(2025, 3, 1);
        Date endDate = new Date(2025, 3, 10);
        var daysBetween = dateTimeService.calculateInsurancePeriodInDays(startDate, endDate);
        assertTrue(daysBetween > 0);
    }

    @Test
    public void InsurancePeriodMustBeNegative() {
        Date startDate = new Date(2025, 3, 10);
        Date endDate = new Date(2025, 3, 1);
        var daysBetween = dateTimeService.calculateInsurancePeriodInDays(startDate, endDate);
        assertTrue(daysBetween < 0);
    }
}
