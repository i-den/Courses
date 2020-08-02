package structural.flyweight.tree;

public class Tree {
    String color;
    TreeType treeType;
    Tree(String color, TreeType treeType) {
        this.color = color;
        this.treeType = treeType;
    }
}
