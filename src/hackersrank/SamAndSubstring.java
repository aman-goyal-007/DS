package hackersrank;


public class SamAndSubstring {
    public static void main(String[] args) {
      String ss = "972698438521";
      long mod7 = 1000000007;
        long val = Integer.valueOf(ss.charAt(0)+"");
        long ans = Integer.valueOf(ss.charAt(0)+"");
      for(int i=1;i<ss.length();i++){
          val = 10*val+(Integer.valueOf(ss.charAt(i)+"")*(i+1));
            val = val%mod7;

          ans += val;
      }
        System.out.println(ans%mod7);

    }
}