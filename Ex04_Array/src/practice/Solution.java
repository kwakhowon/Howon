package practice;

public class Solution {
	public int solution(int n) {
	      int answer = 0;
	      for(int i=2; i<=n; i++) {
	    	  for(int j = 2; j<i; j++) {
	    		  if(i%j==0) {
		    		  continue;  
	    	  }
	    	  answer++;
	    	  }
	      }
	      return answer;
	  }
}
