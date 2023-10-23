package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.example.domain.data.Objective;
import org.example.domain.data.ObjectiveList;
import org.example.domain.Tree;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
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
    private ObjectMapper jsonObjectMapper;
    private List<Objective> objectivesList;

    public void startQuestions(final JFrame jFrame) {
        fillTreeAndObjectives();
        this.tree.getFirstLeaf().answerQuestion(this.tree, jFrame);
        this.tree.getResponse().entrySet().stream().forEach(System.out::println);
        //call database, retrive list of objectives available and calculate resulting object comparing with user response
        calculateObjective(jFrame);
    }


    public void calculateObjective(final JFrame jFrame) {
        Map<Boolean, List<Objective>> mapOfObjectives = objectivesList.stream()
                .collect(Collectors.groupingBy(this::isReachedObjective));

        if (CollectionUtils.isNotEmpty(mapOfObjectives.get(true))) {
            JOptionPane.showMessageDialog(
                    jFrame,
                    mapOfObjectives.get(true).get(0).getObjectiveDescription(),
                    "Resulting Objective",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Is not an Objective",
                    "Resulting Objective", // Title
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
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

    private void fillTreeAndObjectives() {
        try {
            this.tree = jsonObjectMapper.readValue(new File("src/main/resources/tree.json"), Tree.class);
            this.objectivesList = jsonObjectMapper.readValue(new File("src/main/resources/objectives.json"), ObjectiveList.class).getObjectiveList();
        } catch (IOException ioException) {

            System.out.println("Something went wrong while generating the tree.");
        }

    }

    public void addObjecttiveToTheList(final JFrame jFrame) {
        this.tree.getFirstLeaf().answerQuestion(this.tree, jFrame);
    }

}
