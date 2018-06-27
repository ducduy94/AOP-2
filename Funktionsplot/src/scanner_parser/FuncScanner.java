package scanner_parser;

public class FuncScanner {
	private String line;
	private int pos = 0;
	private String yytext;
	public FuncScanner(String line) {
		this.line = line + '\0';
	}
	public Token nextToken() {
		yytext = new String();
		while (pos < line.length()) { 		
			if ((('A' <= line.charAt(pos))&& (line.charAt(pos) <= 'Z')) ||
				(('a' <= line.charAt(pos))&& (line.charAt(pos) <= 'z'))	) {
				yytext += line.charAt(pos++);
				while ((('A' <= line.charAt(pos))&& (line.charAt(pos) <= 'Z')) ||
					   (('a' <= line.charAt(pos))&& (line.charAt(pos) <= 'z')) ||
				   	   (('0' <= line.charAt(pos))&& (line.charAt(pos) <= '9')) ) {
					yytext += line.charAt(pos++);
				}
				return new Token(Token.Identifier,yytext);
			}
			if ((('0' <= line.charAt(pos))&& (line.charAt(pos) <= '9')) ||
				('.' == line.charAt(pos))) {			
				boolean komma = line.charAt(pos)=='.';
				yytext += line.charAt(pos++);
				while ((('0' <= line.charAt(pos))&& (line.charAt(pos) <= '9')) ||
					   (('.' == line.charAt(pos))&& !komma) ) {
					komma = komma || line.charAt(pos)=='.';
					yytext += line.charAt(pos++);
				}
				if (line.charAt(pos) == '.') {
					System.out.println("Error: Illegal character \'" + line.charAt(pos) + "\' at column " + ((pos++)+1));
				}
				return new Token(komma?Token.Number:Token.Ganzzahl,yytext);
			}
			switch (line.charAt(pos)) {
				case '+' : pos++;
						   return new Token(Token.Plus,"+");
				case '-' : pos++;
						   return new Token(Token.Minus,"-");
				case '*' : pos++;
						   return new Token(Token.Mult,"*");
				case '/' : pos++;
					       return new Token(Token.Div,"/");
				case '^' : pos++;
					       return new Token(Token.Hoch,"^");
				case '(' : pos++;
			       		   return new Token(Token.LKlamm,"/");
				case ')' : pos++;
			       		   return new Token(Token.RKlamm,"^");
				case '\0' : return new Token(Token.EOF,"$");
				case ' ' : pos++;
						   break;
				default:
					System.out.println("Error: Illegal character \'" + line.charAt(pos) + "\'at column " + ((pos++)+1));
			}
		}
		return null; // weil der Java-Editor abgrundtief d�mlich ist
	}
}
