package VisitorPattern;

import java.util.ArrayList;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    
    Integer result = 0;
    
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
      	//No debe hacer nada si lo recibe un nodo
    }

    public void visitLeaf(TreeLeaf leaf) {
      	result = result + leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    
    Integer result = 1;
    private final int M = 1000000007;
    
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
      	if(node.getColor().equals(Color.RED)){
            result = (result*node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	if(leaf.getColor().equals(Color.RED)){
            result = (result*leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    
    Integer resultFirstParameter = 0;
    Integer resultSecondParameter = 0;
    
    public int getResult() {
    	
      	//implement this
    	
        return 0;
    }

    public void visitNode(TreeNode node) {
    	if((node.getDepth()%2) == 0 || node.getDepth() == 0){
            resultFirstParameter += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.GREEN)){
            resultSecondParameter += leaf.getValue();
        }
    }
}

public class Solution {
  
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
    	//debe construir un arbol como un nodo que en su ArrayList de hijos tenga los hijos directos
    	//si en estos hijos hay algun otro nodo, este tendra en su interior sus hijos correspondientes, El nodo inicial por lo tanto
    	//no tendra todo el arbol completo en su hijos, solo los directos.
    	//Una vez creado esta estructura de nodo con sus hijos en el array list el metodo debe devolver el nodo inicial
        return ;
        
    }   
    
    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
