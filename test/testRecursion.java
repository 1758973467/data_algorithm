import com.company.Recursion.EightQueue;
import com.company.Recursion.LanguageGenerator;
import com.company.Recursion.PascalTri;
import com.company.Recursion.TowerOfHanoi;
import org.junit.Test;

import java.util.List;

public class testRecursion {
    @Test
    public void testHanoi(){
        TowerOfHanoi towerOfHanoi=new TowerOfHanoi(8);
        towerOfHanoi.solve();
    }

    public long Fibonacci(long x){
        if(x==0)return 0;
        else if(x==1)return 1;
        else return Fibonacci(x-1)+Fibonacci(x-2);
    }
    @Test
    public void testFib(){
         System.out.println(Fibonacci(3));
    }
    public long sum(long x){
        return _sum(1,x);
    }
    public long _sum(long a,long b){

        if(a>=b){
            return a;
        }else{
            return _sum(a,b/2)+_sum(b/2+a,b);
        }
    }
    @Test
    public void testSum(){
        System.out.println(sum(3));
    }
    public long multi(long a,long b){
        if(a==0)return 0;
        else if(a==1)return b;
        else return multi(a-1,b)+b;
    }
    @Test
    public void testMulti(){
        System.out.println(multi(5,3));
        System.out.println(multi(6,0));
    }
    //计算最大公约数
    public int gcd(int num1,int num2){
        if(num1<=num2)return gcd(num2,num1);
        else {
            if(num1%num2==0)return num2;
            else return gcd(num2,num1%num2);
        }
    }
    @Test
    public void testGcd(){
        System.out.println(gcd(5,3));
        System.out.println(gcd(5,15));
    }
    @Test
    public void testEightQueue(){
        EightQueue eightQueue=new EightQueue();
        eightQueue.solve();
        System.out.println(eightQueue.getCount());
    }
    @Test
    public void testLanguageGenerator(){
        LanguageGenerator languageGenerator=new LanguageGenerator();
        System.out.println(languageGenerator.generatorBlurb());
    }
    @Test
    public void testPascalTriangle(){
        PascalTri pascalTri=new PascalTri();
        System.out.println(pascalTri.calcOne(5,3));
        List<Integer>array=pascalTri.clacRow(5);
        for(int a :array){
            System.out.print(a+" ");
        }
    }
}
