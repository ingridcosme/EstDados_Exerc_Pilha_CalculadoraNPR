/*
 * Esse projeto deve implementar uma solu��o para uma calculadora em Nota��o 
 * Polonesa Reversa (NPR), tamb�m conhecida como posfixa.
 * O projeto deve ter uma classe de controle (NPRController) que inicializa uma
 * nova Pilha e deve ter duas opera��es:
 * �Opera��oinsereValor(Pilhap, int valor):void, faz um push() na pilha
 * �Opera��onpr(Pilhap, Stringop):int.O m�todo deve verificar se a String se 
 * trata de uma opera��o (+, -,*,/), verifica se � poss�vel fazer 2 pop() e, em 
 * sendo poss�vel, fazer os 2 pop(), fazer a opera��o, gravar em uma vari�vel
 * resultado (que � o retorno da opera��o) e fazer o push() do resultado.
 * A classe view Principal, deve inicializar a pilha e solicitar dados (n�mero ou  
 * opera��o) ao usu�rio at� alguma condi��o de encerramento, definido por voc�.
 */

package controller;

import br.edu.fateczl.ingridcosme.pilhafloat.Pilha;

public class NPRController {

	float valor1;
	float valor2;
	
	public NPRController() {
		super();
	}
	
	public void insereValor(Pilha p, float valor) {
		p.push(valor);  //Empilha o valor recebido na pilha recebida
	}
	
	public float npr(Pilha p, String op) throws Exception {
		float resultado = 0;
		
		if(p.size() < 2) {
			//Caso a pilha n�o tenho pelo menos 2 valores
			throw new Exception("N�o h� valores suficientes para fazer a opera��o!");
		} else {
			//Caso seja poss�vel realizar a opera��o
			valor1 = p.pop();  //Recebe o �ltimo valor digitado
			valor2 = p.pop();  //Recebe o pen�ltimo valor digitado
			
			switch(op) {
				case "+": resultado = valor2 + valor1;
						break;
				case "-": resultado = valor2 - valor1;
						break;
				case "*": resultado = valor2 * valor1;
						break;
				case "/": resultado = valor2 / valor1;
						break;
			}
			
			p.push(resultado);  //Insere o resultado na pilha
			return resultado;
		}
	}

}
