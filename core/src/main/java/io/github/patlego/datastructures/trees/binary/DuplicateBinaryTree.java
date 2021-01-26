package io.github.patlego.datastructures.trees.binary;

public abstract class DuplicateBinaryTree extends BinaryTree {

    public DuplicateBinaryTree(DuplicateBinaryNode node) {
        super(node);
    }

    protected Boolean add(DuplicateBinaryNode node) {
        if (exists(node)) {
            ((DuplicateBinaryNode) get(node.getData())).addInstance();
            return Boolean.TRUE;
        }

        return super.add(node);
    }

    protected Boolean delete(DuplicateBinaryNode node) {
        if (exists(node)) {
            DuplicateBinaryNode instance = ((DuplicateBinaryNode) get(node.getData()));
            if (instance.getCount() == 1) {
                instance.removeInstance();
                return delete(instance);
            } 
            instance.removeInstance();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
    @Override
    public Integer size() {
        return _size((DuplicateBinaryNode) this.root, 0);
    }

    private Integer _size(DuplicateBinaryNode node, Integer size) {
        if (node.hasChildren()) {
            if (node.getLeft() != null) {
                size = _size((DuplicateBinaryNode) node.getLeft(), size);
            }

            if (node.getRight() != null) {
                size = _size((DuplicateBinaryNode) node.getRight(), size);
            }
        }
        return size + node.getCount();
    }
}
