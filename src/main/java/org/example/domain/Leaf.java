package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.swing.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Leaf {

    @JsonProperty("rightLeaf")
    private Leaf rightLeaf;
    @JsonProperty("leftLeaf")
    private Leaf leftLeaf;
    @JsonProperty("question")
    private String question;

    public void answerQuestion(Tree tree, JFrame jFrame){
        //get user choice and save to list of responses
        Boolean answer = JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
                jFrame,
                question,
                "Make your choice", // Title
                JOptionPane.YES_NO_OPTION
        );

        tree.getResponse().put(question, answer);

        //return which leaf the user should traverse to, false goes to left leaf and true goes to right leaf
        if (Boolean.FALSE.equals(answer) && Objects.nonNull(this.leftLeaf)) {
            this.leftLeaf.answerQuestion(tree, jFrame);
        } else if (Boolean.TRUE.equals(answer) && Objects.nonNull(this.leftLeaf)) {
            this.rightLeaf.answerQuestion(tree, jFrame);
        }
    }
}
