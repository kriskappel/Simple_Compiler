import java.util.Stack;

class StackMachine {
	void Exec(String code) {

		String[] splitCode = code.split("\n");

		Stack<Integer> machine = new Stack<>();

		int result = 0;
		//List<String> linha = Arrays.asList(splitCode)

		for(int i = 0; i < splitCode.length; i++)
		{
			String[] linha = splitCode[i].split(" ");
			
			if(linha[0].equals("PUSH"))
			{
				machine.push(Integer.parseInt(linha[1]));
				//System.out.println(machine.peek());
			}

			else if(linha[0].equals("PRINT"))
			{
				System.out.println(machine.peek());
			}

			else
			{
				int number1, number2;
				number1 = machine.peek();
				machine.pop();
				number2 = machine.peek();
				machine.pop();
				if(linha[0].equals("DIV"))
				{
					int op = number2 / number1;
					machine.push(op);
					//System.out.println("div");
				}
				else if(linha[0].equals("SUM"))
				{
					int op = number2 + number1;
					machine.push(op);
					//System.out.println("add");
				}
				else if(linha[0].equals("MULT"))
				{
					int op = number2 * number1;
					machine.push(op);
					//System.out.println("mult");
				}
				else if(linha[0].equals("SUB"))
				{
					int op = number2 - number1;
					machine.push(op);
					//System.out.println("sub");
				}
			}
		}
	}
}