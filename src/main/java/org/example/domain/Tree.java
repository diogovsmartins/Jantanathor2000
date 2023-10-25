package org.example.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    @JsonProperty("firstLeaf")
    private Leaf firstLeaf;

    private Map<String, Object> response=new HashMap<>();

}
