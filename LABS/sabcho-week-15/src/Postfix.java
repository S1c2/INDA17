/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Sabrina Chowdhury
 * @version 2018-01-02
 */
public class Postfix {
	public static class ExpressionException extends Exception {
		public ExpressionException(String message) {
			super(message);
		}
	}

	/**
	 * Evaluates the given postfix expression.
	 *
	 * @param expression  Arithmetic expression in postfix notation
	 * @return      The value of the evaluated expression
	 * @throws      ExpressionException if the expression is wrong
	 */
	public static int evaluate(String expression) throws ExpressionException {
        //Remove whitespace on both sides of string
        expression = expression.trim();
        //Split expression string into bits of only one operand/operator
        String[] bits = expression.split("\\s+");

        //if the expression only contains one operator +,-,* or / we must throw an exception
        if(bits.length == 1){
            if(bits[0] == "+" || bits[0] == "-" || bits[0] == "*" || bits[0] == "/"){
                throw new Postfix.ExpressionException("ERROR, only one operator");
            }
        }

        //create a stack that holds objects of type Integer
        LinkedListStack<Integer> integerStack = new LinkedListStack<>();
        //we go through each bit/character whatever you want to call it, in the string expression
        for(String bit: bits) {
            //when this bit is an integer/operand:
            if(isInteger(bit)) {
                //it is technically a string, so we must make it an integer
                int number = Integer.parseInt(bit);
                //we add it to the top of our stack
                integerStack.push(number);
            }
            //when we meet an operator
            else if(isOperator(bit)) {
                //there should always be one more operand than operators
                //so when we see an operator we check that we do not have less than 2 operands for it
                if(integerStack.size()<2){
                    //but if that is the case, we throw an exception
                    throw new Postfix.ExpressionException("ERROR; too few operands");
                }

                String operator = bit;
                //1st operand in stack
                int b = integerStack.pop();
                //2nd operand in stack
                int a = integerStack.pop();
                //which case is executed depends on what case the operator fits
                switch(operator) {
                    case "+":
                        integerStack.push(a+b);
                        break;
                    case "-":
                        integerStack.push(a-b);
                        break;
                    case "*":
                        integerStack.push(a*b);
                        break;
                    case "/":
                        //we have to make sure that we do not divide by zero
                        if(b!=0){
                        integerStack.push(a/b);
                        break;
                        }
                        else{
                            throw new Postfix.ExpressionException("ERROR, cannot divide by zero");
                        }
                }
            }
            else {
                throw new Postfix.ExpressionException("ERROR: can only take in operands and operators");
            }
        }
        //now there is only one number left in the stack, and it is our result
        int evaluation = integerStack.pop();
        //if there are still stuff left in the stack in the final step, we throw and exception
        if(!integerStack.isEmpty()) {
            throw new Postfix.ExpressionException("ERROR : Stack was not empty in final step");
        }
        return evaluation;
    }

	/**
	 * Returns true if s is an operator.
	 *
	 * A word of caution on using the String.matches method: it returns true
	 * if and only if the whole given string matches the regex. Therefore
	 * using the regex "[0-9]" is equivalent to "^[0-9]$".
	 *
	 * An operator is one of '+', '-', '*', '/'.
	 */
	private static boolean isOperator(String s) {
        return s.matches("^[-/*+]$");
    }
    //^start of string
    //$end of string
    //[...] we´re looking for one of the characters inside the brackets


	/**
	 * Returns true if s is an integer.
	 *
	 * A word of caution on using the String.matches method: it returns true
	 * if and only if the whole given string matches the regex. Therefore
	 * using the regex "[0-9]" is equivalent to "^[0-9]$".
	 *
	 * We accept two types of integers:
	 *
	 * - the first type consists of an optional '-'
	 *   followed by a non-zero digit
	 *   followed by zero or more digits,
	 *
	 * - the second type consists of an optional '-'
	 *   followed by a single '0'.
	 */
	private static boolean isInteger(String s) {
        boolean nonZeroNumber = s.matches("-?[1-9]\\d*");
        boolean zeroNumber = s.matches("-?0");
        return nonZeroNumber || zeroNumber;
    }
    // ? can happen one or zero times, e.g. -? means - can occur one or zero times
    // [1-9] one of these numbers should be in the string
    // \ e.g. ] is a special character and must be followed by a \
    // \d means any number between 0-9
    // * means zero or more times
}
