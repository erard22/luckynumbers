package ch.erard22.luckynumbers;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by michel on 04.12.16.
 */
public class Main {

    public static void main(String... args) throws Exception {

        Random r = new Random();
        cheatMyRandom(r, Long.parseLong(args[0]));
        r.ints(0, 42).distinct().limit(6).forEach(System.out::println);
    }

    public static void cheatMyRandom(Random r, long seed) throws Exception {
        Field field = r.getClass().getDeclaredField("seed");
        field.setAccessible(true);
        AtomicLong newSeed = new AtomicLong(seed);
        field.set(r, newSeed);
    }


}