package Exercise2;

import java.util.HashMap;

public class PhoneBook {
    HashMap<String,String> DB = new HashMap<>();

    public void add(String name, String phone){
        if(DB.containsKey(name))
            {
                DB.put(name, DB.get(name) + "\n" + phone);
             }
        else
            {
                DB.put(name,phone);
            }
    }

    public void get(String name)
    {
        if( DB.containsKey(name))
        {
            System.out.println(name+":");
            System.out.println(DB.get(name)+"\n");
        }
        else
        {
            System.out.println(name+":");
            System.out.println("Нет записи с таким именем");
        }
    }
}
