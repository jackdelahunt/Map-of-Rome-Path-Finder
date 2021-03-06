import Models.GraphNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphNodeTest {

    GraphNode<Integer> node01;
    GraphNode<Integer> node02;

    @BeforeEach
    void setup() {
        node01 = new GraphNode<>(100);
        node02 = new GraphNode<>(150);
    }

    @Test
    void basicConstructorTest() {
        assertEquals(100, node01.getData());
    }

    @Test
    void setNameCorrectly() {
        node01.setName("Wexford");
        assertEquals("Wexford", node01.getName());
    }

    @Test
    void setNameTestIncorrectly() {
        node01.setName("12345678901234567890123457868686876");
        assertNull(node01.getName());
    }

    @Test
    void setXCorrectly() {
        node01.setX(100);
        assertEquals(100, node01.getX());
    }

    @Test
    void setXIncorrectly() {
        node01.setX(-100);
        assertEquals(0, node01.getX());
    }

    @Test
    void setYCorrectly() {
        node01.setY(100);
        assertEquals(100, node01.getY());
    }

    @Test
    void setYIncorrectly() {
        node01.setY(-100);
        assertEquals(0, node01.getY());
    }

    @Test
    void connectNodeDirectedTest() {
        node01.connectToNodeDirected(node02, 100);

        assertEquals(node01.getAdjList().get(0).getDestinationNode(), node02);
    }

    @Test
    void connectNodeUnDirectedTest() {
        node01.connectToNodeUndirected(node02, 100);

        assertEquals(node02.getAdjList().get(0).getDestinationNode(), node01);
    }

    @Test
    void setDataTest() {
        node01.setData(-928374);
        assertEquals(-928374, node01.getData());
    }

}
