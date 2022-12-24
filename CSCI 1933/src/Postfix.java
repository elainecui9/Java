public class Postfix {
    static double evaluate(String[] expression) throws StackException {
        Stack<String> S = new Stack<String>();
        try {
            for (int x = 0; x < expression.length; x++) {
                if (!expression[x].equals("+") &&
                        !expression[x].equals("-") &&
                        !expression[x].equals("*") &&
                        !expression[x].equals("/")){
                    S.push(expression[x]);
                } else {
                    double num1 = Double.parseDouble(S.pop());
                    double num2 = Double.parseDouble(S.pop());
                    if (expression[x].equals("+")) {
                        S.push(Double.toString(num1 + num2));
                    }
                    if (expression[x].equals("-")) {
                        S.push(Double.toString(num2-num1));
                    }
                    if (expression[x].equals("*")) {
                        S.push(Double.toString(num1 * num2));
                    }
                    if (expression[x].equals("/")) {
                        S.push(Double.toString(num2 / num1));
                    }
                }
            }
            return Double.parseDouble(S.pop());
        }catch (StackException e){
            throw e;
        } finally{
            System.out.println("Evaluation complete");
            return 0.0;
        }

    }
        public static void main(String[] args) throws StackException{
            String[] arr = new String[3];
            arr[0] = "5";
            arr[1] = "2";
            arr[2] = "+";
            double num = evaluate(arr);
            System.out.println(num);
        }

}
