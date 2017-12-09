import com.company.MultiwayTree.Tree234;
import org.junit.Test;

import java.util.Scanner;

public class testMultiWayTree {
    @Test
    public void testMultiWayTree(){
        long value;
        Tree234 tree234=new Tree234();
        tree234.insert(50);
        tree234.insert(40);
        tree234.insert(60);
        tree234.insert(30);
        tree234.insert(70);
        tree234.displayTree();
        /*
        while(true){
            System.out.print("Enter first letter of");
            System.out.print("show ,insert , find , or exit:");
            char choice=getChar();
            switch(choice){
                case 's':
                    tree234.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert:");
                    value=getInt();
                    tree234.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find:");
                    value=getInt();
                    int found=tree234.find(value);
                    if(found!=-1){
                        System.out.println("Found "+value);
                    }else{
                        System.out.println("Could not find "+value);
                    }
                    break;
                case 'e':
                    return;
                default:
                      System.out.println("Invalid entry");
            }
        }*/

    }
    public static String getString(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();

    }
    public static int getInt() {
        return Integer.parseInt(getString());
    }

    public static  char getChar() {
        return getString().charAt(0);
    }


}
