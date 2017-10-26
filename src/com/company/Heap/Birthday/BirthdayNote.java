package com.company.Heap.Birthday;

import com.company.Heap.ArrayHeap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BirthdayNote {
    private ArrayHeap<human> arrayHeap;
    public void readHumanBirthday(String filename)throws FileNotFoundException{
        File file =new File(filename);
        Scanner scanner=new Scanner(file);
        String name;
        Calendar cal;
        int year,month,day;
        while(scanner.hasNext()){
            name=scanner.next();

            cal=new GregorianCalendar();
            year=scanner.nextInt();
            month=scanner.nextInt();
            day=scanner.nextInt();
            cal.set(year,month,day);
            arrayHeap.addElement(new human(cal,name));

        }
    }
    public List<human> getBirthdayHuman(){
        if(arrayHeap.isEmpty())return null;
        List<human>humanList=new ArrayList<>();
        human nowhuman=new human(Calendar.getInstance(),null);
        do{
            human temphuman=arrayHeap.removeMin();
            if(temphuman.compareTo(nowhuman)==0){
                humanList.add(temphuman);
            }else{
                arrayHeap.addElement(temphuman);
                break;
            }
        }while(!arrayHeap.isEmpty());
        return humanList;
    }
}
class human implements Comparable<human>{
    private Calendar birthday;
    private String name;

    public human(Calendar birthday, String name) {
        this.birthday = birthday;
        this.name = name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(human o) {
        int month,day,omonth,oday;
        month=birthday.get(Calendar.MONTH);
        day=birthday.get(Calendar.DATE);
        omonth=o.birthday.get(Calendar.MONTH);
        oday=o.birthday.get(Calendar.DATE);
        int result=0;
        if(month>omonth){
            result=1;
        }else if(month<omonth){
            result=-1;
        }else{
            if(day>oday){
                result=1;
            }else if(day<oday){
                result=-1;
            }
            else{
                result=0;
            }
        }
        return result;
    }
}