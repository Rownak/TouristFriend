package useful;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Rownak
 */
public class RandomId {

    public static class RandomIdGenerator {

        private static SecureRandom random = new SecureRandom();

        public static BigInteger nextSessionId() {
            return new BigInteger(20, random);
        }
    }
}
