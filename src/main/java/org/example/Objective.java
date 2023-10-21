package org.example;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Objective {

    private Map<String, Object> objectivesMap;
    private String objectiveDescription;

}
