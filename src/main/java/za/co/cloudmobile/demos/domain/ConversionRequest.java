package za.co.cloudmobile.demos.domain;

import lombok.Data;
import za.co.cloudmobile.demos.constants.Category;
import za.co.cloudmobile.demos.constants.Units;

import java.math.BigDecimal;

@Data
public class ConversionRequest {
    private final Units unit;
    private final Category category;
    private final BigDecimal value;

    public ConversionRequest(Units unit, String category, BigDecimal value) {
        this.unit = unit;
        this.category = Category.valueOf(category.toUpperCase());
        this.value = value;
    }


}
