package org.example;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tree {

    private Leaf firstLeaf;
    private List<Object> response;


    //create a method to get the list of responses and create a map of variables and set the respective response
    //to the answer in the value, later on this map will be used to decide which is the outcome of the users decision



}
