package org.example;

import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeHandler {
    private Tree tree;

    public void startQuestions(){
        this.tree.getFirstLeaf().answerQuestion(this.tree);
        this.tree.getResponse().entrySet().stream().forEach(System.out::println);
        //call database, retrive list of objectives available and calculate resulting object comparing with user response
//        calculateObjective();
    }


    public void calculateObjective(final List<Objective> objectivesList ){
        Map<Boolean, List<Objective>> mapOfObjectives = objectivesList.stream()
                .collect(Collectors.groupingBy(this::isReachedObjective));

        if (CollectionUtils.isNotEmpty(mapOfObjectives.get(true))){
            JOptionPane.showMessageDialog(
                    null,
                    mapOfObjectives.get(true).get(0).getObjectiveDescription(),
                    "Resulting Objective", // Title
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Is not an Objective",
                    "Resulting Objective", // Title
                    JOptionPane.INFORMATION_MESSAGE
            );}
    }

    private boolean isReachedObjective(Objective objective) {
        return objective.getObjectivesMap().entrySet().stream()
                .allMatch(entry -> {
                    var key = entry.getKey();
                    var value1 = entry.getValue();
                    var value2 = this.tree.getResponse().get(key);
                    return Objects.equals(value1, value2);
                });
    }
}
