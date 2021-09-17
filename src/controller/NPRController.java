/*
 * Esse projeto deve implementar uma solução para uma calculadora em Notação 
 * Polonesa Reversa (NPR), também conhecida como posfixa.
 * O projeto deve ter uma classe de controle (NPRController) que inicializa uma
 * nova Pilha e deve ter duas operações:
 * •OperaçãoinsereValor(Pilhap, int valor):void, faz um push() na pilha
 * •Operaçãonpr(Pilhap, Stringop):int.O método deve verificar se a String se 
 * trata de uma operação (+, -,*,/), verifica se é possível fazer 2 pop() e, em 
 * sendo possível, fazer os 2 pop(), fazer a operação, gravar em uma variável
 * resultado (que é o retorno da operação) e fazer o push() do resultado.
 * A classe view Principal, deve inicializar a pilha e solicitar dados (número ou  
 * operação) ao usuário até alguma condição de encerramento, definido por você.
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
			//Caso a pilha não tenho pelo menos 2 valores
			throw new Exception("Não há valores suficientes para fazer a operação!");
		} else {
			//Caso seja possível realizar a operação
			valor1 = p.pop();  //Recebe o último valor digitado
			valor2 = p.pop();  //Recebe o penúltimo valor digitado
			
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
