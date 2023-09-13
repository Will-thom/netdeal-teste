package com.netdeal.processo.seletivo.infra.security;

public class ForcaSenha {
	//TODO: implementacao parcial da força de senha. Faltam mais algumas regras.
//	public static void main(String[] args){
//		String userPassword = "@abcdAEA";
//		System.out.println(scoreAcesso(userPassword));
//	}

	public int scoreAcesso(String password){
		int score = 0;
		int length = password.length();
		
		if (length >= 8 && length <= 10)
		{
			score +=1;
		}
		else if (length >= 11 && length <=15)
		{
			score += 2;
		}
		else if (length >= 16)
		{
			score += 3;
		}

		if (password.matches("(?=.*[a-z]).*"))
		{
			score++;
		}
		if (password.matches("(?=.*[A-Z]).*"))
		{
			score++;
		}
		if (password.matches("(?=.*[0-9]).*")){
			score++;
		}
		if (password.matches("(?=.*[!@#$%^&*]).*")){
			score++;
		}
	
		return score * 10;	

	}	

}