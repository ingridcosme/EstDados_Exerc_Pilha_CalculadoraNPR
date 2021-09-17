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

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.pilhafloat.Pilha;
import controller.NPRController;

public class Principal {

	public static void main(String[] args) {
		Pilha p = new Pilha();
		NPRController nprCont = new NPRController();
		
		String entrada = "";
		
		while(!entrada.equals("F")) {
			//Fará o procedimento até a condição de parada ser digitada
			
			StringBuffer buffer = new StringBuffer();
	    	buffer.append("Calculadora Notação Polonesa Reversa\n");
	    	buffer.append("\n------------------------------------------------");
	    	buffer.append("\nInsira um VALOR \nOU\n");
	    	buffer.append("uma OPERAÇÃO (  +   -   *   /  )\n");
	    	buffer.append("\n.:  digite 'F' para finalizar");
	    	entrada = JOptionPane.showInputDialog(buffer.toString());
	    	
	    	if(!entrada.equals("F")) {
	    		
	    		if(!entrada.equals("+") && !entrada.equals("-") && 
	    				!entrada.equals("*") && !entrada.equals("/")) {
	    			
	    			//Se a entrada for um valor, adiciona na pilha
	    			float valor = Float.valueOf(entrada).floatValue();
	    			nprCont.insereValor(p, valor);
	    			
	    		} else {
	    			//Se a entrada for uma operação, tenta fazê-la
	    			try {
						float resultado = nprCont.npr(p, entrada);						
						System.out.println(resultado);
					} catch (Exception e) {
						e.printStackTrace();
					}
	    		}
	    	}
		}
    	
    	
        	
            
	}

}
