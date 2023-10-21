import org.example.Leaf;
import org.example.Tree;
import org.example.TreeHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTree {

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
                .question("Is Age Bigger than 15? ")
                .possibleAnswers(List.of(Boolean.FALSE, Boolean.TRUE))
                .leftLeaf(leftLeaf)
                .rightLeaf(rightLeaf).build();


        TreeHandler treeHandler=
                TreeHandler
                        .builder()
                        .tree(
                                Tree.builder().firstLeaf(firstLeaf).build())
                        .build();

        treeHandler.getTree().getFirstLeaf().answerQuestion(false);

        assertNotNull(treeHandler);
    }
}
