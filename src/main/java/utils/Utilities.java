package utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Utilities. Created on 07 Nov 2017 11:59:24 AM by siD.
 *
 * @author Matthew Van der Bijl
 * @sinse 07 Nov 2017
 */
public final class Utilities {

    @Deprecated
    private Utilities() {
    }

    /**
     *
     */
    public static final Random P_RNG = new Random(new SecureRandom().nextLong());

    public static int[] getRandomArrayOfInts(int length) {
        int[] rtn = new int[length];

        for (int i = 0; i < length; i++) {
            rtn[i] = P_RNG.nextInt(100);
        }

        return rtn;
    }
}
