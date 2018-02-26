package com.company;
import java.util.function.*;

public class PowerUps {
    static Function<Integer, Integer> bSquared = e -> e * e;
    static Function<Integer, Integer> test = a -> a * 2;

    public static Function[] arrayOfFunctions  = {bSquared, test};
}
