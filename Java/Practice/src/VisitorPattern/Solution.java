package VisitorPattern;

import java.util.ArrayList;
import java.util.Scanner;

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

class Conection{
	
	private int conectorNode1;
	private int conectorNode2;
	
	public Conection(int a, int b) {
		setConector1(a);
		setConector2(b);
		
	}
	
	public void setConector1(int i) {
		conectorNode1 = i;
	}
	public void setConector2(int j) {
		conectorNode2 = j;
	}
	
	public int getConector1() {
		return conectorNode1;
	}
	
	public int getConector2() {
		return conectorNode2;
	}
}
public class Solution {
  
    public static Tree solve() {
    	
    	Scanner reader = new Scanner(System.in);
    	
    	int n = reader.nextInt();
    	int[] dephts = new int[n];
    	Color[] EnumColors = new Color[n];
    	Conection[] conexions = new Conection[n-1];
    	for(int i = 0; i<n-1;i++) {
    		conexions[i] = new Conection(0,0);
    	}
    	
    	Tree[] nodes = new Tree[n];
    	
    	
    	for (int i = 0; i<n; i++) {
    		dephts[i] = reader.nextInt();
    	}
    	//reader.nextLine();
    	for (int i = 0; i<n; i++) {
    		int value = reader.nextInt();
    		if(value == 0) {
    			EnumColors[i] = Color.RED;
    		}
    		else {
    			EnumColors[i] = Color.GREEN;
    		}
    		
    	}
    	//reader.nextLine();
    	
    	for(int i = 0;i<(n-1);i++) {
			conexions[i].setConector1(reader.nextInt());
    		conexions[i].setConector2(reader.nextInt());
    	}
    	
    	for(int i = 0; i<n;i++) {
    		
    		boolean isLeaf = true;
    		
    		for(int j = 0; j<n-1;j++) {
    			int conextionNumber = conexions[j].getConector1();
    			if(conextionNumber == i) {
    				isLeaf = false;
    			}
    		}
    		if(isLeaf) {
    			nodes[i] = new TreeLeaf(i,EnumColors[i], dephts[i]);
    			System.out.println("\t\tCreated a treeNode in nodes[" + i + "]");
    		}
    		else {
    			nodes[i] = new TreeNode(i,EnumColors[i], dephts[i]);
    			System.out.println("\t\tCreated a treeLeaf in nodes[" + i + "]");
    		}
    	}
    	
    	for(int i = 0; i <n-1 ; i++) {
    		
    		((TreeNode)nodes[(conexions[i].getConector1())-1]).addChild(nodes[(conexions[i].getConector2())-1]);
    		
    	}

        return nodes[0];
        
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
