import interfaces.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    private Wall wall;

    @BeforeEach
    void setUp() {
        List<Block> initialBlocks = Arrays.asList(
                new Block() {
                    @Override
                    public String getColor() {
                        return "red";
                    }

                    @Override
                    public String getMaterial() {
                        return "steel";
                    }
                },
                new Block() {
                    @Override
                    public String getColor() {
                        return "blue";
                    }

                    @Override
                    public String getMaterial() {
                        return "stone";
                    }
                },
                new Block() {
                    @Override
                    public String getColor() {
                        return "brown";
                    }

                    @Override
                    public String getMaterial() {
                        return "wood";
                    }
                }
        );
        wall = new Wall(initialBlocks);
    }

    @Test
    void findBlockByColor() {
        Optional<Block> foundBlock = wall.findBlockByColor("red");


        assertEquals("red", foundBlock.get().getColor());
        assertEquals("steel", foundBlock.get().getMaterial());
    }

    @Test
    void findBlocksByMaterial() {
        List<Block> woodBlocks = wall.findBlocksByMaterial("wood");


        assertTrue(woodBlocks.stream().allMatch(b -> b.getMaterial().equals("wood")));
    }

    @Test
    void count() {
        assertEquals(3, wall.count());
    }

    @Test
    void getBlocksShouldReturnAllBlocks(){
        List<Block> result = wall.getBlocks();
       assertEquals(3, result.size());

        assertTrue(result.stream().anyMatch(b -> b.getColor().equals("red") && b.getMaterial().equals("steel")));
    }
}