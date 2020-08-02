package structural.flyweight.tree;

import java.util.List;

public class TreeFactory {
    List<TreeType> treeTypes;

    TreeType getTreeType(String name) {
        for (TreeType treeType : treeTypes) {
            if (treeType.getName().equals(name))
                return treeType;
        }
        return null;
    }
}
