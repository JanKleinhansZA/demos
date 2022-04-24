package za.co.cloudmobile.demos.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface UnitConversion {

    BigDecimal convertToMetrics(BigDecimal value);
    BigDecimal convertToImperials(BigDecimal value);
}
