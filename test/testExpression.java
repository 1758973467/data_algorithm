import com.company.Tree.ExpressionLinkedTree;
import org.junit.Test;

public class testExpression {
    @Test
    //TODO 有括号有时会计算错误
    public void test(){
        String expression,again;
        int result=0;
        //Scanner in=new Scanner(System.in);

        ExpressionLinkedTree expressionTree=new ExpressionLinkedTree();
        //System.out.print("Input a middleFix expression:and press ENTER");
        expression="1 +  6 * 3 * ( 5  - 4 )  ";//BUG
        expressionTree.build(expression);

        result=expressionTree.evaluate();
        System.out.print(result);

    }
}
