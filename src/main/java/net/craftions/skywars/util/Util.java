package net.craftions.skywars.util;

public class Util {

    public static Boolean isEven(int i){
        return String.valueOf(i).endsWith("0") || String.valueOf(i).endsWith("2") || String.valueOf(i).endsWith("4") || String.valueOf(i).endsWith("6") || String.valueOf(i).endsWith("8");
    }
}
