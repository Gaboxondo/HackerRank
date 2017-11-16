package JavaBitSet;

public class Operation {

	private OperationName operationName;
	private Integer val1;
	private Integer val2;

	public Operation(OperationName operationName, Integer val1, Integer val2) {
		super();
		this.operationName = operationName;
		this.val1 = val1;
		this.val2 = val2;
	}

	public OperationName getOperationName() {
		return operationName;
	}

	public void setOperationName(OperationName operationName) {
		this.operationName = operationName;
	}

	public Integer getVal1() {
		return val1;
	}

	public void setVal1(Integer val1) {
		this.val1 = val1;
	}

	public Integer getVal2() {
		return val2;
	}

	public void setVal2(Integer val2) {
		this.val2 = val2;
	}

}
