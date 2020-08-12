package codesignal.trials;

public class TestReverse {

    
    public static void main(String args[]) {
    	String testStr = "foo(bar)baz(blim)";
    	System.out.println("Final =" + new TestReverse().reverseInParentheses(testStr));
    }

    String reverseInParentheses(String inputString) {
        int lParenIdx = inputString.indexOf("(");
        int rParenIdx = inputString.indexOf(")");
        
 
        System.out.println("top: inputString = " + inputString + " lParentIdx, rParenIdx=" + lParenIdx + ", " + rParenIdx);
      
        if (lParenIdx == 0) {
            StringBuilder sb1 = new StringBuilder(inputString.substring(1, rParenIdx));
            sb1.reverse();
            System.out.println("\tsb1 = " + sb1.toString());
            return sb1.toString();

        }
        if (lParenIdx > 0) {
        
            /*
            while (inputString.substring(nextLparenIdx, rParenIdx).indexOf("(") > nextLparenIdx) {
                rParenIdx = inputString.indexOf(")", rParenIdx + 1);
            }
            */
       System.out.println("\tFind Enclosure: inputString = " + inputString + " lParentIdx, rParenIdx=" + lParenIdx + ", " + rParenIdx);
 
            int nextLparenIdx = inputString.substring(lParenIdx+1, rParenIdx).lastIndexOf("(");
            int nextrParenIdx = rParenIdx;
            System.out.println("\tFind Enclosure: rparen index = " + rParenIdx + " nextLParen =" + nextLparenIdx + " " + inputString.substring(lParenIdx, rParenIdx+1));
            nextrParenIdx = inputString.indexOf(")", rParenIdx +1);
            if (nextrParenIdx > rParenIdx) {
                rParenIdx = nextrParenIdx;
            }
            //rParenIdx++;
            
            return inputString.substring(0, lParenIdx) +
                reverseInParentheses(inputString.substring(lParenIdx, rParenIdx+1)) +
                 reverseInParentheses(inputString.substring(rParenIdx+1));
        }
        
        return inputString;
    }

}
