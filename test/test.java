import org.junit.Test;

class Solution {
    public boolean isPerfectSquare(int num) {
        //num>0
       boolean result=false;
       long start=0,end=num;
       long middle;
       while(start<=end){
           //OverFlow 会导致error
           middle=(start+end)/2;
           System.out.println(middle);
           if(middle*middle==num){
               result=true;
               break;
           }else if(middle*middle>num){
               end=middle-1;
           }else{
               start=middle+1;
           }
       }
       return result;
    }
    /*
    private boolean calc(int start,int end,int target){
        boolean result=false;
        if(start<end){
            int middle=(start+end)/2;
            if(middle*middle==target){
                result=true;
            }else if(middle*middle>target){
                result=calc(start,middle-1,target);
            }else{
                result=calc(middle+1,end,target);
            }
        }
        return result;
    }*/
}
public class test {
    @Test
    public void test(){
        Solution solution=new Solution();
        System.out.println(Long.MAX_VALUE);
        //System.out.println(solution.isPerfectSquare(2147483647));
    }
}
