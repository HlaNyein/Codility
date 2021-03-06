/**
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).

https://app.codility.com/c/run/training9YWAD5-RZD/
*/
public class binaryGap{
    
    public int solution_v2(int N) {
        // write your code in Java SE 8
        int gap = 0;
        int count = 0;
        boolean found = false;
        while(N != 0) {
            if( (N & 1) == 0 ) {
                count ++;
            }else{
                
                if(!found) found = true;
                else
                    gap = Math.max(gap, count);
                count = 0;
            }
            N >>= 1;
        }
        return gap;
    }

	public int solution(int N) {
        
       if(isPowerOfTwo(N)) return 0;

        boolean found_one = false;
        int binaryGap = 0;
        for (int j = 0; N > 0; N /= 2) {
            if (N % 2 == 0) {
                j++;
            } else {
                if (j > binaryGap && found_one == true){
                    binaryGap = j;
                }
                found_one = true;
                j = 0;
            }
        }
    return binaryGap;
    }
    
    public boolean isPowerOfTwo(int i)
    {
       return (Math.ceil(logTwo(i)) == Math.floor(logTwo(i)));
    }
    
    public double logTwo(int i){
         return (Math.log(i) / Math.log(2));
    }
}