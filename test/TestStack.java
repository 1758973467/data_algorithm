import com.company.Stack.StackADT;
import com.company.Stack.project.DropOutLinearStack;
import org.junit.Test;

public class TestStack {
    @Test
    public void testStack(){
        StackADT stackADT=new DropOutLinearStack(3);
        for(int i=0;i<5;++i){
            stackADT.push(i);
        }
        System.out.println(stackADT.size());
        int size=stackADT.size();
        for(int i=size;i>0;--i){
            System.out.println(stackADT.pop());
        }
    }


}
