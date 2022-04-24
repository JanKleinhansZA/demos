package za.co.cloudmobile.demos.convert;



import za.co.cloudmobile.demos.services.UnitConversion;

import java.math.BigDecimal;

import static za.co.cloudmobile.demos.constants.ConversionConstant.mathContext;

public class ConversionArea implements UnitConversion {
    @Override
    public BigDecimal convertToMetrics(BigDecimal value) {
        return value.divide(BigDecimal.valueOf(2.471),mathContext);
    }

    @Override
    public BigDecimal convertToImperials(BigDecimal value) {

            return value.multiply(BigDecimal.valueOf(2.471));
    }
}
