package za.co.cloudmobile.demos.domain;

import lombok.Data;
import za.co.cloudmobile.demos.constants.Category;
import za.co.cloudmobile.demos.constants.Units;

import java.math.BigDecimal;

@Data
public class ConversionResponse {
    private final Units unit;
    private final Category category;
    private final BigDecimal value;
    private final Object result;

    public  ConversionResponse(Units unit, Category category, BigDecimal value,Object result) {
        this.unit = unit;
        this.category = category;
        this.value = value;
        this.result =  result;
    }




}
