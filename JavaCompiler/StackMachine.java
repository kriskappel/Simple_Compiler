class StackMachine {
	void Exec(String code) {
		String[] linha = string.split("\n");
		int i = 0;
		while(!linha.empty())
		{
			command = linha[i];
			linha = ArrayUtils.removeElement(linha, i);
			System.out.println(linha);
			i++;
		}
	}
}