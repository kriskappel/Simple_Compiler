import java.io.*;

enum TokenType{ NUM,SOMA, MULT, SUB, DIV, APar,FPar, EOF}

class Token{
  char lexema;
  int lexemaNum;
  TokenType token;

 Token (char l, TokenType t)
 	{ lexema=l;token = t;}	
 	Token (int l, TokenType t)
 	{ lexemaNum=l;token = t;}	

}

class AnaliseLexica {
	//Vector natural = new Vector();
	static char lastChar;
	static boolean flag = false;
	String natural = "";
	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				if(flag)
				{
					currchar = lastChar;
					currchar1 = (int) currchar;
					flag = false;
				}
				else{
					currchar1 =  arquivo.read();
					currchar = (char) currchar1;
				}
				/*if(!natural.isEmpty())
				{
					System.out.println("oi");
					String aux = natural;
					natural = "";
					return (new Token (aux, TokenType.NUM));
				}*/
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{		
	
				if (currchar >= '0' && currchar <= '9')
				{
					while(currchar >= '0' && currchar <= '9')
					{
						natural = natural + currchar;
						
						System.out.println("natural " + natural);
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
	
					}
					lastChar = currchar;
					flag = true	;

					int numNat = Integer.parseInt(natural);

					natural = "";

					return (new Token (numNat, TokenType.NUM));
					//return (new Token (currchar, TokenType.NUM));
				}
				else
				{
					/*if(!natural.isEmpty())
					{
						System.out.println("oi");
						String aux = natural;
						natural = "";
						return (new Token (natural, TokenType.NUM));
					}*/

					switch (currchar){
						case '(':
							System.out.println(currchar);
							return (new Token (currchar,TokenType.APar));
						case ')':
							System.out.println(currchar);
							return (new Token (currchar,TokenType.FPar));
						case '+':
							System.out.println(currchar);
							return (new Token (currchar,TokenType.SOMA));
						case '*':
							System.out.println(currchar);
							return (new Token (currchar,TokenType.MULT));
						case '-':
							System.out.println(currchar);
							return (new Token (currchar, TokenType.SUB));
						case '%':
							System.out.println(currchar);
							return (new Token (currchar, TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
				}
			}

			arquivo.close();
			
		
		return (new Token(currchar,TokenType.EOF));
		
	}
}
