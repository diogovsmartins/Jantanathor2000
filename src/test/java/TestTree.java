import com.fasterxml.jackson.databind.ObjectMapper;
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
        TreeHandler treeHandler= TreeHandler.builder().jsonObjectMapper(new ObjectMapper()).build();

        treeHandler.startQuestions();

        assertNotNull(treeHandler);
    }
}
