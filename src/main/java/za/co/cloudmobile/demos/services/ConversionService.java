package za.co.cloudmobile.demos.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import za.co.cloudmobile.demos.constants.Category;
import za.co.cloudmobile.demos.constants.Units;


import java.math.BigDecimal;

@Service
@Slf4j
public class ConversionService {


	private final ConversionFactory factory;

	public ConversionService(ConversionFactory factory) {
		this.factory = factory;
	}

	public BigDecimal getConversion(Category type, Units toUnit, BigDecimal value) {
		log.info("Requesting conversion service, type:{}, units:{}, value:{}",type,toUnit,value);
		UnitConversion conversion =	factory.getConversion(type);
		switch (toUnit){
			case IMPERIAL:return conversion.convertToImperials(value);
			case METRIC: return conversion.convertToMetrics(value);

			default:
				log.error("Error requesting conversion, error: {}, type:{}, units:{}, value:{}","Conversion request error: Can only request IMPERIAL or METRIC",type,toUnit,value);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Conversion System <" + toUnit + ">");
		}

	}
}
