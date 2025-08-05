package Java_with_dsa.BackTracking;

public class Printsubstring {

    public static void printSubstrings(String str, String ans, int i){

        // base case
        if (i==str.length()){
            System.out.println(ans);
            return;
        }

        printSubstrings(str, ans+str.charAt(i),i+1);
        printSubstrings(str,ans,i+1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubstrings(str,"",0);
    }
}


// output
// abc
// ab
// ac
// a
// bc
// b
// c