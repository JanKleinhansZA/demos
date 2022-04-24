package za.co.cloudmobile.demos.convert;

import za.co.cloudmobile.demos.services.UnitConversion;

import java.math.BigDecimal;

import static za.co.cloudmobile.demos.constants.ConversionConstant.mathContext;

public class ConversionVolume implements UnitConversion {
    @Override
    public BigDecimal convertToMetrics(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(3.785));
    }

    @Override
    public BigDecimal convertToImperials(BigDecimal value) {
        return value.divide(BigDecimal.valueOf(3.785),mathContext);
    }
}
