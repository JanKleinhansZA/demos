package za.co.cloudmobile.demos.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cloudmobile.demos.constants.Category;
import za.co.cloudmobile.demos.constants.Units;
import za.co.cloudmobile.demos.domain.ConversionRequest;
import za.co.cloudmobile.demos.domain.ConversionResponse;
import za.co.cloudmobile.demos.services.ConversionService;


import java.math.BigDecimal;

import static za.co.cloudmobile.demos.constants.ConversionConstant.mathContext;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class ConversionController {


	private final ConversionService service;

	public ConversionController(ConversionService service) {
		this.service = service;
	}

	@GetMapping(value = "/convert/{type}/{toUnit}/{value}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConversionResponse> conversion(@PathVariable final String type, @PathVariable final String toUnit, @PathVariable final BigDecimal value) {
		log.info("Requesting conversion http request, type:{}, units:{}, value:{}",type,toUnit,value);
		final ConversionResponse conversionResponse = processConversionResponse(Category.valueOf(type.toUpperCase()), Units.valueOf(toUnit.toUpperCase()), value);
		return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
	}

	@PostMapping(value="/convert/post",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConversionResponse> conversion(@RequestBody ConversionRequest conversionRequest) {
		log.info("Requesting conversion http request, type:{}, units:{}, value:{}",conversionRequest.getCategory(),conversionRequest.getUnit(),conversionRequest.getValue());
		final ConversionResponse conversionResponse = processConversionResponse(conversionRequest.getCategory(),conversionRequest.getUnit(),  conversionRequest.getValue());
		return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
	}
	private  ConversionResponse processConversionResponse(Category category, Units unit, BigDecimal value){
		try {
			final BigDecimal result = service.getConversion(category, unit,  value.multiply(BigDecimal.valueOf(100.0)).divide(BigDecimal.valueOf(100.0), mathContext));
			log.info("Responding conversion conversion, type:{}, units:{}, value:{}, result:{}", category, unit, value, result);
			return new ConversionResponse(unit, category, value, result);
		}catch (Exception e){
			e.printStackTrace();
			log.error("Responding conversion conversion exception, type:{}, units:{}, value:{}, result:{}", category, unit, value, e.getMessage());
			return new ConversionResponse(unit, category, value, e.getMessage());
		}
		}
	
	
}