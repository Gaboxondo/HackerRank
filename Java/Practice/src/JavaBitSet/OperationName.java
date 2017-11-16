package JavaBitSet;

public enum OperationName{
	
	AND,
	OR,
	XOR,
	FLIP,
	SET;
	
	public static OperationName fromString(String s) {
		
		OperationName result = null;
		switch (s) {
		case "AND":
			result = OperationName.AND;
			break;
		case "OR":
			result = OperationName.OR;
			break;
		case "XOR":
			result = OperationName.XOR;
			break;
		case "FLIP":
			result = OperationName.FLIP;
			break;
		case "SET":
			result = OperationName.SET;
			break;
		}
		return result;
	}
}