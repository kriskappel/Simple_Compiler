class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			//CodeGen backend = new CodeGen();

			Interpretador backend = new Interpretador();

			int result = backend.Interpreta(arv);
			//String codigo = backend.geraCodigo(arv);
			System.out.println(result);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
