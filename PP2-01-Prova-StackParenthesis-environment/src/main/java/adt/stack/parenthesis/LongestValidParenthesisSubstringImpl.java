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
		// TODO Implement this method.
		throw new UnsupportedOperationException("Not implemented yet!");
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
    	
    	//adicione seu código aqui
    	
		return mirrorStr;
    	

    }

}
