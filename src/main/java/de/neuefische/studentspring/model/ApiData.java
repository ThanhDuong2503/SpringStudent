package de.neuefische.studentspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiData {

    @JsonProperty("Active")
    private int active;

    @JsonProperty("Date")
    private String date;
}
