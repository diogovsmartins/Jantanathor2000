package org.example.domain.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Objective {

    @JsonProperty("objectivesMap")
    private Map<String, Object> objectivesMap;
    @JsonProperty("objectiveDescription")
    private String objectiveDescription;

}
