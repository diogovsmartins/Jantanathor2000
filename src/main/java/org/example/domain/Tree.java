package org.example.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.domain.Leaf;

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

    //create a method to get the list of responses and create a map of variables and set the respective response
    //to the answer in the value, later on this map will be used to decide which is the outcome of the users decision



}
