import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.TreeHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestTree {

    @Test
    void testTreeStructure(){
        TreeHandler treeHandler= TreeHandler.builder().jsonObjectMapper(new ObjectMapper()).build();

//        treeHandler.startQuestions();

        assertNotNull(treeHandler);
    }
}
