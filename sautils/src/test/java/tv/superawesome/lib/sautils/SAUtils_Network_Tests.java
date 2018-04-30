package tv.superawesome.lib.sautils;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by gabriel.coman on 17/10/16.
 */
public class SAUtils_Network_Tests {

    @Test
    public void testGetCacheBuster () {
        // given
        int bound = 10;
        List<Integer> uniqueKeys = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            uniqueKeys.add(SAUtils.getCacheBuster());
        }

        // when
        boolean allUniques = true;
        for (int i = 0; i < bound; i++) {
            boolean hasFound = false;

            for (int j = 0; j < bound && j != i; j++) {
                int uniquei = uniqueKeys.get(i);
                int uniquej = uniqueKeys.get(j);
                if (uniquei == uniquej) {
                    hasFound = true;
                    break;
                }
            }

            if (hasFound) {
                allUniques = false;
                break;
            }
        }

        // then
        assertTrue(allUniques);
    }

    @Test
    public void testFormGetQueryFromDict () {
        // given
        JSONObject given1 = new JSONObject();
        try {
            given1.put("client_id", "client-111");
            given1.put("user_id", 321);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject given2 = new JSONObject();
        JSONObject given3 = null;

        // when
        String expected1 = "client_id=client-111&user_id=321";
        String expected2 = "";
        String expected3 = "";

        // then
        String result1 = SAUtils.formGetQueryFromDict(given1);
        String result2 = SAUtils.formGetQueryFromDict(given2);
        String result3 = SAUtils.formGetQueryFromDict(given3);

        assertTrue(result1.contains("client_id=client-11"));
        assertTrue(result1.contains("user_id=321"));
        assertEquals(result1.split("&").length, 2);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);

    }

    @Test
    public void testEncodeDictAsJsonDict () {
        // given
        JSONObject given1 = new JSONObject();
        try {
            given1.put("client_id", "client-111");
            given1.put("user_id", 321);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject given2 = new JSONObject();
        JSONObject given3 = null;

        // when
        String expected1 = "%7B%22client_id%22%3A%22client-111%22%2C%22user_id%22%3A321%7D";
        String expected2 = "%7B%7D";
        String expected3 = "%7B%7D";

        // then
        String result1 = SAUtils.encodeDictAsJsonDict(given1);
        String result2 = SAUtils.encodeDictAsJsonDict(given2);
        String result3 = SAUtils.encodeDictAsJsonDict(given3);

        assertTrue(result1.contains("%22client_id%22%3A%22client-111%22"));
        assertTrue(result1.contains("%22user_id%22%3A321"));
        assertEquals(result1.split("%2C").length, 2);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
    }

    @Test
    public void testIsJSONEmpty () {
        // given
        JSONObject given1 = new JSONObject();
        try {
            given1.put("client_id", "client-111");
            given1.put("user_id", 321);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject given2 = new JSONObject();
        JSONObject given3 = null;

        // then
        boolean result1 = SAUtils.isJSONEmpty(given1);
        boolean result2 = SAUtils.isJSONEmpty(given2);
        boolean result3 = SAUtils.isJSONEmpty(given3);

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    public void testIsValidURL () {
        // given
        String given1 = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/x7XkGy43vim5P1OpldlOUuxk2cuKsDSn.mp4";
        String given2 = "";
        String given3 = null;
        String given4 = "jkskjasa";
        String given5 = "https://google.com";

        // then
        boolean result1 = SAUtils.isValidURL(given1);
        boolean result2 = SAUtils.isValidURL(given2);
        boolean result3 = SAUtils.isValidURL(given3);
        boolean result4 = SAUtils.isValidURL(given4);
        boolean result5 = SAUtils.isValidURL(given5);

        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertTrue(result5);
    }

    @Test
    public void testEncodeURL () {
        // given
        String given1 = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/x7XkGy43vim5P1OpldlOUuxk2cuKsDSn.mp4";
        String given2 = "";
        String given3 = null;
        String given4 = "https:/klsa9922:skllsa/2100921091/saas///";

        // when
        String expected1 = "https%3A%2F%2Fs3-eu-west-1.amazonaws.com%2Fsb-ads-video-transcoded%2Fx7XkGy43vim5P1OpldlOUuxk2cuKsDSn.mp4";
        String expected2 = "";
        String expected3 = "";
        String expected4 = "https%3A%2Fklsa9922%3Askllsa%2F2100921091%2Fsaas%2F%2F%2F";

        // then
        String result1 = SAUtils.encodeURL(given1);
        String result2 = SAUtils.encodeURL(given2);
        String result3 = SAUtils.encodeURL(given3);
        String result4 = SAUtils.encodeURL(given4);

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
    }

    @Test
    public void testFindBaseURLFromResourceURL () {
        // given
        String given1 = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/x7XkGy43vim5P1OpldlOUuxk2cuKsDSn.mp4";
        String given2 = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String given3 = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String given4 = null;
        String given5 = "https:/klsa9922:skllsa/2100921091/saas///";

        // when
        String expected1 = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/";
        String expected2 = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/";
        String expected3 = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/";
        String expected4 = null;
        String expected5 = null;

        // then
        String result1 = SAUtils.findBaseURLFromResourceURL(given1);
        String result2 = SAUtils.findBaseURLFromResourceURL(given2);
        String result3 = SAUtils.findBaseURLFromResourceURL(given3);
        String result4 = SAUtils.findBaseURLFromResourceURL(given4);
        String result5 = SAUtils.findBaseURLFromResourceURL(given5);

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
        assertEquals(result5, expected5);
    }

    @Test
    public void testIsValidEmail () {
        // given
        String given1 = "dev.gabriel.coman@gmail.com";
        String given2 = "jsksls////";
        String given3 = null;
        String given4 = "";
        String given5 = "test@test.com";

        // then
        boolean result1 = SAUtils.isValidEmail(given1);
        boolean result2 = SAUtils.isValidEmail(given2);
        boolean result3 = SAUtils.isValidEmail(given3);
        boolean result4 = SAUtils.isValidEmail(given4);
        boolean result5 = SAUtils.isValidEmail(given5);

        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertTrue(result5);
    }
}
