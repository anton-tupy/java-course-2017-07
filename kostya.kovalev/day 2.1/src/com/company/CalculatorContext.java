package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Natalya on 20.07.2017.
 */
public class CalculatorContext {
    private Stack<Float> stack= new Stack<>();
    private Map<String, Float> values= new HashMap<>();//map интерфейс позволяющий хранить ассоциированные значения.(соответствия)
                                                       //

    public void push(float value){
        stack.push(value);
    }
    public float pop(){                           //достает удаляя
        return stack.pop();
    }
    public float peek(){                          //показывает не удаляя
        return stack.peek();
    }

   // public float sqrt(float value){
     //   return value*value;
    //}

    public void defineValue(String name,float value){  //задает значения параметру
        values.put(name,value);

    }
    public boolean isValue(String name){
        return values.get(name) !=null;
    }
    public float getValue(String name){               //выдает значение
        return values.get(name);
    }
}
// надо создать метод определена ли такая перенная уже или нет