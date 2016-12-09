import java.io.*;


 class myCode  
 
{   
    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    
    private String helper(int number) {
        String soFar;
        
        //Handle the edge test case 0 and 1000;
        if (number == 0) return " zero";
        if (number == 1000) return " one thousand";
        if (number > 1000 || number < 0) return "error";

        //If the number contains numNames, put it into soFar, and 
        // use "number" to record the hundreds' digit
        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;

        }
        //Otherwise it contains a value in tensName. First of all, 
        // we record the unit's digit, and then we find and insert
        // the correct tensName into soFar
        else {
            soFar = numNames[number % 10];
            number /= 10;
            
            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
       
       //if the number only has two digits, we just reutrn soFar,
        //else we return the hundred's digit
        if (number == 0){
            return soFar;
        } else {
            return numNames[number] + " hundred" + soFar;
        }
        
    }


    private String[] numberRange(int start, int end){
        String[] res = new String[end - start + 1];
        //if start equals to end, we only record the start value
        if (start == end) {
            res[0] = helper(start);            
        } else if (start > end){
            throw new NegativeArraySizeException("INPUT ERROR!");            
        } else {
            //use an array of strings to record all the numbers
            for(int i = 0; i < res.length; i++){
                res[i] = helper(start + i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        myCode obj = new myCode();

        //helper function test cases
        System.out.println("*** " + obj.helper(0));
        System.out.println("*** " + obj.helper(1000));
        System.out.println("*** " + obj.helper(678));
        System.out.println("*** " + obj.helper(66));
        System.out.println("*** " + obj.helper(20));
        System.out.println("*** " + obj.helper(11));
        
        //Test cases
        String[] test01 = obj.numberRange(1,10);
        for (String word: test01) {
            System.out.println(word);
        }
        
        String[] test02 = obj.numberRange(990,1000);
        for (String word: test02) {
            System.out.println(word);
        }
        
        String[] test03 = obj.numberRange(20,21);
        for (String word: test03) {
            System.out.println(word);
        }
        
        String[] test04 = obj.numberRange(21,1);
        for (String word: test04) {
            System.out.println(word);
        }
        
        /*String[] greeting = obj.numberRange(1,1000);
        for (String word: greeting) {
            System.out.println(word);
        }
        */
    }
}