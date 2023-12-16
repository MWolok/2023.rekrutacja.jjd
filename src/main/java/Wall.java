import interfaces.Block;
import interfaces.CompositeBlock;
import interfaces.Structure;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block->block.getColor().equals(color))
                .findFirst();

    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
