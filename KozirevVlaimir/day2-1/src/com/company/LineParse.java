package com.company;

import java.util.ArrayList;

class LineParse {
     public ParseResauit parse(String line){
         if (line == null || line.isEmpty()){
             return null;
         }
        String[] items = line.split(" ");

         if (items.length == 0){
             return null;
         }
         String comandName = items[0];
         ArrayList<String> argyments = new ArrayList<>();
         for (int i = 1; i < items.length; i++){
             argyments.add(items[i]);
         }
         return new ParseResauit(comandName,argyments);
     }
}
