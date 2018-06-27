package scanner_parser;

public abstract class DyadOp extends Knoten{
	protected Knoten leftOp;
	protected Knoten rightOp;
	public void setLeftOp(Knoten leftOp) {
		this.leftOp = leftOp;
	}
	public void setRightOp(Knoten rightOp) {
		this.rightOp = rightOp;
	}
}
