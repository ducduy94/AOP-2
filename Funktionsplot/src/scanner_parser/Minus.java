package scanner_parser;

public class Minus extends Knoten {
	private Knoten op;
	public void setOp(Knoten op) {
		this.op = op; 
	}
	@Override
	public void print() {
		System.out.println("Knoten " + num + " Minus ");
		System.out.println("Operrand: " + op.getNum());
		System.out.println();
		op.print();
	}
}
