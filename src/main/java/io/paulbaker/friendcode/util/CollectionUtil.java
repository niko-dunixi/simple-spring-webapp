package io.paulbaker.friendcode.util;

import java.util.List;
import java.util.Random;

/**
 * Created by paulbaker on 12/23/16.
 */
public class CollectionUtil {

    private static final Random RANDOM = new Random();

    private CollectionUtil() {
    }

    public static <T> T RandomElement(List<T> list) {
        return RandomElement(list, RANDOM);
    }

    public static <T> T RandomElement(List<T> list, Random random) {
        return list.get(random.nextInt(list.size()));
    }
}
