package adt.stack.parenthesis;

import java.util.Stack;

/**
 * @author Cláudio Campelo
 * Ver comentários na interface LongestValidParenthesisSubstring.
 *
 */
public class LongestValidParenthesisSubstringImpl implements LongestValidParenthesisSubstring {

    /* (non-Javadoc)
     * @see adt.stack.parenthesis.LongestValidParenthesisSubstring#findLongest(java.lang.String)
     */
    public String findLongest(String parenthesis) {
		
    	Stack<String> stack = new Stack<String>();
    	
    	String[] aux = parenthesis.split("");
    	String maior = "";
    	boolean flag = true;
    	
    	for(int i = 0; i < aux.length; i++) {
    		if(aux[i].equals("(")) {
    			int cont = 1;
    			String aux2 = "";
    			String verifica = "";
    			while(aux[cont].equals("(")) {
    				aux2 += aux[cont];
    				cont++;
    			}
    			for(int j = 0; j < cont; j++) {
    				if(aux[cont].equals("("))
    					verifica += ")";
    			}
    			if(verifica.length() == aux2.length()) {
    				String res = parenthesisMirror(aux2);
    				if(aux2.equals(res)) {
    					String auxiliar = aux2 + verifica;
    					if(maior.length() < auxiliar.length()) {
    						if(flag)
    							maior += aux2 + verifica;
    						else	
    							maior = aux2 + verifica;
    						flag = true;
    					}
    				} 
    			} else {
					flag = false;
				}
    		}
    	}
    	
    	return maior;
    }
    
    /*
     * Este é um método utilitário que calcula o "espelho" de uma String.
     * Ou seja, é uma espécie de flip horizontal. Veja os exemplos abaixo
     * para entender como o método deve ser comportar.
     * 
     * A implementação deste método não é obrigatória, porém, é fortemente
     * recomendada, visto que pode ser muito útil para a implementação
     * do findLongest.
     * 
     * Neste método, implemente uma solução baseada em PILHA. 
     * 
     * Exemplo 1:
     * input		   = ((()
     * expected_output = ()))
     * 
     * Exemplo 2:
     * input		   = ()()
     * expected_output = ()()
     * 
     * Exemplo 2:
     * input		   = (((((
     * expected_output = )))))
     */
    private String parenthesisMirror(String str){
        
    	Stack<String> stack = new Stack<String>();
    	String mirrorStr = ""; 
    	String[] parenteses = str.split("");
    	
    	for(String p : parenteses) {
    		if(p.equals("(")) {
    			stack.push(")");
    		} else if(p.equals(")")){
    			stack.push("(");
    		}
    	}
    	
    	for(String p : stack) {
    		mirrorStr = p + mirrorStr;
    	}
    	System.out.println(mirrorStr);
    	return mirrorStr;
    	
    }

}
