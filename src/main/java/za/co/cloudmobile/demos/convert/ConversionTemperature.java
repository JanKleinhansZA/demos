package za.co.cloudmobile.demos.convert;



import za.co.cloudmobile.demos.services.UnitConversion;

import java.math.BigDecimal;

import static za.co.cloudmobile.demos.constants.ConversionConstant.mathContext;

public class ConversionTemperature implements UnitConversion {




    @Override
    public BigDecimal convertToMetrics(BigDecimal value) {


        return value.subtract(BigDecimal.valueOf(32)).multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(9),mathContext);
    }

    @Override
    public BigDecimal convertToImperials(BigDecimal value) {
        return ((value.multiply(BigDecimal.valueOf(9))).divide(BigDecimal.valueOf(5),mathContext)).add(BigDecimal.valueOf(32));
    }
}
