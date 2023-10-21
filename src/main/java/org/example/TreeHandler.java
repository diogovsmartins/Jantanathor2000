package org.example;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeHandler {

    private Tree tree;
    private Leaf currentLeaf;
    
    
    
    public void startQuestions(Object answer){
        //traverse the tree until the last level is reached
        do {

            if (Objects.isNull(currentLeaf)){
                this.currentLeaf = this.tree.getFirstLeaf().answerQuestion(answer, this.tree);
            }
            //currentLeaf is not null, ask question
            this.currentLeaf = this.tree.getFirstLeaf().answerQuestion(answer, this.tree);

        }while (!Objects.isNull(currentLeaf.getLeftLeaf()) && !Objects.isNull(currentLeaf.getRightLeaf()));

        //no more leaf to iterate over, return and calculate results
        return;

    }


}
