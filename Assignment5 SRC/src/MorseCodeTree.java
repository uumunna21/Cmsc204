import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * A binary tree to represent the Morse Code translation map.
 * Implements LinkedConverterTreeInterface<String> for converting Morse code to English.
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    /** The root. */
    private TreeNode<String> root;

    /**
     * Instantiates a new morse code tree.
     */
    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root.
     *
     * @param newNode the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }

    /**
     * Insert.
     *
     * @param code the code
     * @param letter the letter
     */
    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    /**
     * Adds the node.
     *
     * @param node the node
     * @param code the code
     * @param letter the letter
     */
    @Override
    public void addNode(TreeNode<String> node, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                node.setLeft(new TreeNode<>(letter));
            } else if (code.equals("-")) {
                node.setRight(new TreeNode<>(letter));
            }
        } else {
            if (code.charAt(0) == '.') {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode<>(""));
                }
                addNode(node.getLeft(), code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode<>(""));
                }
                addNode(node.getRight(), code.substring(1), letter);
            }
        }
    }

    /**
     * Fetch.
     *
     * @param code the code
     * @return the string
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * Fetch node.
     *
     * @param node the node
     * @param code the code
     * @return the string
     */
    @Override
    public String fetchNode(TreeNode<String> node, String code) {
        if (code.length() == 0) {
            return node.getData();
        }

        if (code.charAt(0) == '.') {
            return fetchNode(node.getLeft(), code.substring(1));
        } else {
            return fetchNode(node.getRight(), code.substring(1));
        }
    }

    /**
     * Delete.
     *
     * @param data the data
     * @return the linked converter tree interface
     * @throws UnsupportedOperationException the unsupported operation exception
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }

    /**
     * Update.
     *
     * @return the linked converter tree interface
     * @throws UnsupportedOperationException the unsupported operation exception
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported.");
    }

    /**
     * Builds the tree.
     */
    @Override
    public void buildTree() {
        root = new TreeNode<>("");

        // Level 1
        insert(".", "e");
        insert("-", "t");

        // Level 2
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        // Level 3
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        // Level 4
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * To array list.
     *
     * @return the array list
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    /**
     * LN routput traversal.
     *
     * @param node the node
     * @param list the list
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> node, ArrayList<String> list) {
        if (node != null) {
            LNRoutputTraversal(node.getLeft(), list);
            if (!node.getData().equals("")) {
                list.add(node.getData());
            }
            LNRoutputTraversal(node.getRight(), list);
        }
    }
}
