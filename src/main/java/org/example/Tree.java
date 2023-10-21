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



}
