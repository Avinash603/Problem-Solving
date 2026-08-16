class Solution {
    public double myPow(double x, int n) {
        double halfsq;
        if(n==0){
            return 1;
        }
          if(n<0){
            x=1/x;
             halfsq=myPow(x,-(n/2));
        
        }else{
       
         halfsq=myPow(x,n/2);}
        halfsq= halfsq*halfsq;
        if(n%2!=0){
            halfsq=x*halfsq;
        }

       
        return halfsq;
        
    }
}