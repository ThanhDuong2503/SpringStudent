package de.neuefische.studentspring.api;

import de.neuefische.studentspring.model.ApiData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Covid19api {


    public int numberOfActiveInfections(){

        RestTemplate restTemplate = new RestTemplate();

        LocalDate currentDate = LocalDate.now();
        String currentDayFormatted = currentDate.atStartOfDay().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String dayBeforeFormatted = currentDate.minusDays(1).atStartOfDay().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);


        String url = "https://api.covid19api.com/total/country/germany?from=" + dayBeforeFormatted + "&to=" + currentDayFormatted;

        ResponseEntity<ApiData[]> responseEntity = restTemplate.getForEntity(url, ApiData[].class);

        ApiData[] covidData = responseEntity.getBody();


        if(covidData.length > 0){
            return covidData[0].getActive();
        }
        throw new IllegalStateException("No data form covid api");
    }

}
