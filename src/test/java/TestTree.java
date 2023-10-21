import org.example.Leaf;
import org.example.Objective;
import org.example.Tree;
import org.example.TreeHandler;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestTree {

    @Test
    void testTreeStructure(){
        Leaf leftLeaf= Leaf.builder()
                .question("Is Male?")
                .possibleAnswers(List.of(Boolean.FALSE, Boolean.TRUE))
                .build();

        Leaf rightLeaf=
                Leaf.builder()
                        .question("Has a job?")
                .possibleAnswers(List.of(Boolean.FALSE, Boolean.TRUE))
                .build();

        Leaf firstLeaf= Leaf.builder()
                .question("Is Age Bigger than 15?")
                .possibleAnswers(List.of(Boolean.FALSE, Boolean.TRUE))
                .leftLeaf(leftLeaf)
                .rightLeaf(rightLeaf).build();


        TreeHandler treeHandler=
                TreeHandler
                        .builder()
                        .tree(Tree.builder()
                                .firstLeaf(firstLeaf)
                                .response(new HashMap<>())
                                .build())
                        .build();

        treeHandler.startQuestions();
        Objective objective1 = Objective.builder()
                .objectivesMap(Map.of("Is Age Bigger than 15?",false, "Is Male?", true))
                .objectiveDescription("The objective given the user responses is a male under 15 years old")
                .build();
        Objective objective2 = Objective.builder()
                .objectivesMap(Map.of("Is Age Bigger than 15?",true, "Has a job?", true))
                .objectiveDescription("The objective given the user responses is a male over 15 years old")
                .build();


        treeHandler.calculateObjective(List.of(objective1, objective2));

        assertNotNull(treeHandler);
    }
}
