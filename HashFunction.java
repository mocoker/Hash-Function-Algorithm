public class HashFunction {
    
    public HashFunction () {
        
    }
      //Letters from A . . . Z to use for encryption
       String[] setOfLetters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
       
       String toHash = "";
     
       String hashed = hashFunction(setOfLetters, toHash);
  
    //THE HASH-FUNCTION METHOD
    public String hashFunction(String[] a, String q)  {
      
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] hashCode = new int [q.length()]; 
        int code = 0;
        int count = 0;
        int addSpecialChar = 0;
        String toCheck1 = "";
        String toCheck2 = "";
        String hash;
      
        for (int i = 0; i < q.length(); i++)   {
            toCheck1 = Character.toString(q.charAt(i));
            for (int j = 0; j < a.length; j++)  {
                toCheck2 = a[j];

                if (toCheck1.equalsIgnoreCase(toCheck2)) {
               
                    code = ((19 * j) + 2) % 26;
                    
                    hashCode[count] = code;
                    count++;
                }
            }
            code = 0;
        }
        
        if (count != q.length()) {
            for (int i = count; i < hashCode.length; i++)  {
            
               hashCode[i] = 26 + addSpecialChar;
               addSpecialChar++;
            }
        } 
        
        hash = hashCodeFunction(hashCode);
        return hash;
    }

    
    //HASH CODE FUNCTION METHOD CALLED IN THE HASH FUNCTION METHOD
    private String hashCodeFunction (int[] a)  {
        
        String hash = "";
        int num1 = 0;
        int num2 = 0;
        int hashCode = 0;
        int idx = 0;
        
        for (idx = 0; idx < a.length; idx++)  {
            
            num1 = a[idx];
            if (idx < a.length - 1) {
               idx++;
               num2 = a[idx];
            }
            
            hashCode = (num1 + num2) % 8;
            hash = hash + hashCode;
            
            num1 = 0;
            num2 = 0;
        }
        
        return hash;
    }    

    //MAIN METHOD
    public static void main(String[] args) {
        HashFunctionGUI hashed = new HashFunctionGUI();
    }
}
