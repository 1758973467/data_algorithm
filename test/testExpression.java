import com.company.Tree.ExpressionLinkedTree;
import org.junit.Test;

public class testExpression {
    @Test
    public void test(){
        String expression,again;
        int result=0;
        //Scanner in=new Scanner(System.in);

        ExpressionLinkedTree expressionTree=new ExpressionLinkedTree();
        //System.out.print("Input a middleFix expression:and press ENTER");
        expression="1 + 3 - ( 5 - 4 ) ";
        expressionTree.build(expression);

        int size=expressionTree.size();
        result=expressionTree.evaluate();
        System.out.print(result);

    }
}
