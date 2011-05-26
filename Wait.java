public class Wait{
  
  public static void wait (int n){
        
        long t0, t1;

        t0 =  System.currentTimeMillis();

        do{
            t1 = System.currentTimeMillis();
        }
        while (t1 - t0 < n);
    }
}