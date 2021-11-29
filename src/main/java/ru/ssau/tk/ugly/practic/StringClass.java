package ru.ssau.tk.ugly.practic;

import java.nio.charset.StandardCharsets;

public class StringClass {
    private boolean b;

    public void string (String string){
        for(int i = 0; i<string.length(); i++){
            System.out.println(string.charAt(i));
        }


    }

    public void stringt(String string){
        byte[] bytesOfString = string.getBytes();
        for (byte b : bytesOfString );
        System.out.println(b);
    }

    public void stringr(){
        String literal = "day";
        String string = new String(literal);
        System.out.println(string == literal);
        System.out.println(literal.equals(string));
    }

    public boolean stringf(String string){
        boolean result = true;
        for(int i=0; i<(string.length()/2); i++){
            if( string.charAt(i) !=string.charAt(string.length()-1)){
                result = false;
            }
        }
        return result;

    }

    public boolean sringb(String string ,String stringf){
        if(string==null || stringf==null ){
            return false;
        }
        return ((string.equals(stringf)) || (string.equalsIgnoreCase(stringf)));

    }
    }

