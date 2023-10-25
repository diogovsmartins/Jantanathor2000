package org.example.domain.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectiveList {
    @JsonProperty("objectiveList")
    private List<Objective> objectiveList;
}
