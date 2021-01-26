package io.github.patlego.datastructures.trees.avl;

public abstract class DuplicateAVLTree extends AVLTree {

    public DuplicateAVLTree(DuplicateAVLNode node) {
        super(node);
    }

    protected Boolean add(DuplicateAVLNode node) {
        if (exists(node)) {
            DuplicateAVLNode duplicate = (DuplicateAVLNode) get(node.getData());
            duplicate.addInstance();
            return Boolean.TRUE;
        }

        super.add(node);
        rebalance();
        return Boolean.TRUE;
    }

    protected Boolean delete(DuplicateAVLNode node) {
        if (exists(node)) {
            DuplicateAVLNode duplicate = (DuplicateAVLNode) get(node.getData());
            if (duplicate.getCount() == 1) {
                duplicate.removeInstance();
                if (super.delete(node)) {
                    rebalance();
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            duplicate.removeInstance();
        }
        return Boolean.TRUE;
    }

    @Override
    public Integer size() {
        return _size((DuplicateAVLNode) this.root, 0);
    }

    private Integer _size(DuplicateAVLNode node, Integer size) {
        if (node.hasChildren()) {
            if (node.getLeft() != null) {
                size = _size((DuplicateAVLNode) node.getLeft(), size);
            }

            if (node.getRight() != null) {
                size = _size((DuplicateAVLNode) node.getRight(), size);
            }
        }
        return size + node.getCount();
    }

}
