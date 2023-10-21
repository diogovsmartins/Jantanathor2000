package org.example;

import lombok.*;

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

    private Leaf rightLeaf;
    private Leaf leftLeaf;
    private String question;
    private List<Object> possibleAnswers;

    public Leaf answerQuestion(Object answer, Tree tree){
        Boolean userChoice= !possibleAnswers.get(0).equals(answer);
        tree.getResponse().add(userChoice);

        return userChoice.equals(Boolean.FALSE)
                ? this.leftLeaf
                : this.rightLeaf;
    }

}
