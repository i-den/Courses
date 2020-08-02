package structural.flyweight.tree;

import java.util.List;

public class Forest {
    List<Tree> trees;

    void plantTree(String color, String treeTypeName) {
        TreeFactory factory = new TreeFactory();
        Tree tree = new Tree(color, factory.getTreeType(treeTypeName));
        //
    }
}
