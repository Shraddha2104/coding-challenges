package sk.loffay.codeeval.hard;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StringPermutationsTest {

    @Test
    public void test() {
        Assert.assertEquals(strToSet("a"), StringPermutations.permutations("a"));
        Assert.assertEquals(strToSet("aht,ath,hat,hta,tah,tha"), StringPermutations.permutations("hat"));
        Assert.assertEquals(strToSet("abc,acb,bac,bca,cab,cba"), StringPermutations.permutations("abc"));
        Assert.assertEquals(strToSet("6Zu,6uZ,Z6u,Zu6,u6Z,uZ6"), StringPermutations.permutations("Zu6"));

        System.out.println(strToSet("6Zu,6uZ,Z6u,Zu6,u6Z,uZ6").toString().replace(" ", "").replace("[", "").replace
                ("]", ""));
    }


    public static Set<String> strToSet(String str) {
        return new TreeSet<>(Arrays.asList(str.split(",")));
    }
}
