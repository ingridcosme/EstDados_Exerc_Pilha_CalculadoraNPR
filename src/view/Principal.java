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
			//Far� o procedimento at� a condi��o de parada ser digitada
			
			StringBuffer buffer = new StringBuffer();
	    	buffer.append("Calculadora Nota��o Polonesa Reversa\n");
	    	buffer.append("\n------------------------------------------------");
	    	buffer.append("\nInsira um VALOR \nOU\n");
	    	buffer.append("uma OPERA��O (  +   -   *   /  )\n");
	    	buffer.append("\n.:  digite 'F' para finalizar");
	    	entrada = JOptionPane.showInputDialog(buffer.toString());
	    	
	    	if(!entrada.equals("F")) {
	    		
	    		if(!entrada.equals("+") && !entrada.equals("-") && 
	    				!entrada.equals("*") && !entrada.equals("/")) {
	    			
	    			//Se a entrada for um valor, adiciona na pilha
	    			float valor = Float.valueOf(entrada).floatValue();
	    			nprCont.insereValor(p, valor);
	    			
	    		} else {
	    			//Se a entrada for uma opera��o, tenta faz�-la
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
