package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public void answerQuestion(Tree tree){
        //get user choice and save to list of responses
        Boolean answer = JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
                null,
                question,
                "Make your choice", // Title
                JOptionPane.YES_NO_OPTION
        );

        tree.getResponse().put(question, answer);

        //return which leaf the user should traverse to, false goes to left leaf and true goes to right leaf
        if (Boolean.FALSE.equals(answer) && Objects.nonNull(this.leftLeaf)) {
                this.leftLeaf.answerQuestion(tree);
        } else if (Boolean.TRUE.equals(answer) && Objects.nonNull(this.leftLeaf)) {
            this.rightLeaf.answerQuestion(tree);
        }
    }
}
