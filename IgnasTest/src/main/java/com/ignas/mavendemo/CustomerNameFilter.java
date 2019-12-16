package com.ignas.mavendemo;

public class CustomerNameFilter {

    public static String[] filterNames(String[] Names){
        String[] fNames = new String [5];
        int k=0;
        for (int i=0; i <5; i++){
            if (Names[i].length() > 5){

                fNames[k] = Names[i];
                k++;
            }
        }
        return fNames;
    }


}
