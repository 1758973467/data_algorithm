package com.company.Recursion;

import java.util.Random;

//Blurb
public class LanguageGenerator {
    Random random=new Random();
    private String generatorWhatzit(){
        StringBuffer buffer=new StringBuffer();
        int rand=Math.abs(random.nextInt())%10;
        buffer.append("q");
        if(rand%2==0)
            buffer.append("V");
        else
            buffer.append("d");
        return buffer.toString()+generatorWhoozit();

    }

    private String generatorWhoozit() {
        StringBuffer buffer=new StringBuffer();

        int rand=Math.abs(random.nextInt())%10;
        buffer.append("x");
        for(int i=0;i<rand;++i){
            buffer.append("y");
        }
        return buffer.toString();
    }
    public String generatorBlurb(){
        StringBuffer buffer=new StringBuffer();
        buffer.append("Blurb");
        int rand=Math.abs(random.nextInt())%10;
        for(int i=0;i<rand;++i){
            buffer.append(generatorWhatzit());
        }
        buffer.append(generatorWhoozit());
        return buffer.toString();
    }
}
