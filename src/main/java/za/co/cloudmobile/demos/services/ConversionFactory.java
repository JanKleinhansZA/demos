package za.co.cloudmobile.demos.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import za.co.cloudmobile.demos.constants.Category;
import za.co.cloudmobile.demos.convert.*;


@Service

public class ConversionFactory {

    public UnitConversion getConversion(Category type) {
        switch (type) {
            case TEMPERATURE:
                return new ConversionTemperature();
            case LENGTH:
                return new ConversionLength();
            case AREA:
                return new ConversionArea();
            case VOLUME:
                return new ConversionVolume();
            case WEIGHT:
                return new ConversionWeight();

            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Category of Conversion <" + type + ">");
        }

    }
}
