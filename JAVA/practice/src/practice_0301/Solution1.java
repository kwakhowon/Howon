package practice_0301;

class Solution1 {
    boolean solution(String s) {
        boolean answer = true;
        int pcount = 0;
        int ycount = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.toLowerCase().charAt(i)=='p') {
                pcount++;
            }else if(s.toLowerCase().charAt(i)=='y') {
                ycount++;
            }
        }
        if(pcount == ycount) {
            answer = true;
        }else if(pcount==0 && ycount==0) {
            answer= true;
        }else
            answer = false;
        return answer;
    }
}