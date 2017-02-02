/**
 * @Copyright:   SuperAwesome Trading Limited 2017
 * @Author:      Gabriel Coman (gabriel.coman@superawesome.tv)
 */
package tv.superawesome.lib.sautils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import java.io.File;

import static android.graphics.Bitmap.createScaledBitmap;
import static android.graphics.BitmapFactory.decodeByteArray;

public class SAImageUtils {

    public static Bitmap createBitmap (Context context, String filename, int width, int height) {
        File file = new File(context.getFilesDir(), filename);
        if (file.exists()) {
            String fileUrl = file.toString();
            Bitmap bitmap = BitmapFactory.decodeFile(fileUrl);
            return createScaledBitmap(bitmap, width, height, true);
        } else {
            return null;
        }
    }

    public static Bitmap createBitmap (int width, int height, int color, float radius) {
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, output.getWidth(), output.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, radius, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(output, rect, rect, paint);

        return output;
    }

    public static Bitmap createBitmap (int width, int height, int color) {
        return createBitmap(width, height, color, 0);
    }

    public static Bitmap createBitmap (int color) {
        return createBitmap(1, 1, color);
    }

    public static Drawable createDrawable (Context context, String fileName, int width, int height, float radius) {
        return createDrawable(createBitmap(context, fileName, width, height), radius);
    }

    public static Drawable createDrawable (Context context, String fileName, int width, int height) {
        return createDrawable(context, fileName, width, height, 0);
    }

    public static Drawable createDrawable (int width, int height, int color, float radius) {
        return new SADrawabale(createBitmap(width, height, color), radius, 0);
    }

    public static Drawable createDrawable (int width, int height, int color) {
        return createDrawable(width, height, color, 0);
    }

    public static Drawable createDrawable (int color) {
        return createDrawable(1, 1, color);
    }

    public static Drawable createDrawable (Bitmap bitmap, float radius) {
        return new SADrawabale(bitmap, radius, 0);
    }

    public static Drawable createDrawable (Bitmap bitmap) {
        return createDrawable(bitmap, 0);
    }

    public static Bitmap createCloseButtonBitmap () {

        String imageString = "";

        imageString += "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAAAXNSR0IArs4c6QAA";
        imageString += "ABxpRE9UAAAAAgAAAAAAAABAAAAAKAAAAEAAAABAAAADNgS9T/UAAAMCSURBVHgB";
        imageString += "7JlLbhNREEUtkBCLADLhtwgWwAJYmj2xLcufkdeDGJIw4bOAMIgU5VGFXFGpcQd/";
        imageString += "+nXqdt1BqTuO0uV+59R9dmdUShmx8q4B4ScfAApAAfLGH7e+MmICMAGYAJmTgAnA";
        imageString += "BGACMAGSTwEFoABpt8K0N5556v29U4Dk6UcBKAC/BfhIzHbOBGACMAGyTb2/XyYA";
        imageString += "E4AJ4Cci2zkTgAnABMg29f5+mQBMACaAn4hs50wAJgATINvU+/tlAjABmAB+IrKd";
        imageString += "MwGYAEyAbFPv75cJwARgAviJyHbOBGACMAGyTb2/XyYAE4AJ4Cci2/kgEmA8Hj/t";
        imageString += "G5z0fNZ3zxr94AUQEC+kvkh9rLFA+66pvaSupN7v+z3Sa9ACCACF/1WqSN1IVZdA";
        imageString += "e+x6ac9fUtASwAogC38PfzqdKozqEkiPe/iup0rwDmnq/XuFFEAW/KXU38mfz+dl";
        imageString += "u92W9XpdVQIPX3tpz8ViYT1/okoAJ8AO/qUci8FXGFqr1cqAdLod7INvPdElgBLg";
        imageString += "IfgGpGsJHoJvPRsSvPURG/0cRoBD4BuQriQ4BL71dBL8kL+DkQBCAFnQV1J7Y98A";
        imageString += "NI/nSnAMfOuNKEF4AXbwr+T4z55vC992PFWCU+Dbe2hI8IZbwBnP2s+Bb0COleAc";
        imageString += "+NYTSYKwCSAgLqROmnwDYcdDJegCvvV0EnyX64ZNgpAC7OB/k+PRsW8Amsf/SeDg";
        imageString += "39n3/OY1jv25IcHriNtBOAFqwDdwbRLUgG89o0sQSoCa8A1IU4Ka8K1nZAnCCCAg";
        imageString += "nkh9lir6nN0Wr8axIYE+News9tve72w2s6eUurU9j7IdhBFAF0QW5oPUtVRZLpd9";
        imageString += "SVAd/mazKZPJ5E7u61bqUxT4+j5CCfAYEnT1ga9t8iPDDylA3xK0gevi9ejwwwow";
        imageString += "BAkQ4IcWoCmBfnDrYir7uAYK/PACIEqABB9CACQJ0ODDCIAgASJ8KAEiS4AKH06A";
        imageString += "iBIgw4cUIJIE6PBhBYggwRDgQwvwmBIMBT68AE6C3/oPpD4eFg0Jvq7fHwAAAP//";
        imageString += "lVBvPwAAAx9JREFU7ZlLbttQDEWDFii6iLaZ9LeILiALyNLsiW0Y/oy8nqLDfib9";
        imageString += "LCAdFCiiXhZi8SCEhi3puaR4B8RzXhBR5D28Up6vmqa5ihyz2ewW8Xs+n9/v9/vm";
        imageString += "cDhUje122yCfxE/Eu8i9k3un+D2AKSC4iw5BWADQ+FvExSa/6yxTgSAkAP9bfIVh";
        imageString += "ChCEA8CL+FOBIBQA3sSfAgRhAPAqfnQIQgDgXfzIELgHIIr4USFwDUA08SNC4BaA";
        imageString += "qOIrBJvNRk8M71CL2xNDlwBEFz8SBO4AuKT4u92ukcMcFazG6t0JXAFwafGR7x6R";
        imageString += "GgI3AECIp4gvIshyuaw6lTL5yCPi/2qjOgSLxULfCd4j5yMv3yK6AUAagsa8RHxF";
        imageString += "NOv1ugoEHfFvkEtCQKgGwWq1UvEF8Gsv4st9uAKgNgRd8VWImhB4Ft8lALUgsMSv";
        imageString += "CYF38d0C0ELwCpM5yuOgFV9sWKz+RkXvrmM6QSH+Z1z3upvLy8/uHgFlY9A4geAb";
        imageString += "ovc7wania17kGvxO0BH/hV7b4+oaAGnYEAjOFV8FGgJBJPGlXvcAtBC8hihnOUFf";
        imageString += "8YdAUIj/CffrevK1zhAAnAvBUPG1Oec4QUf853oN72sYAAoIvkMY851gLPFVuFMg";
        imageString += "iCq+1BgKgBaCNxDlQQjGFv8UCCKLHxIAC4Ja4j8EgeSSL44K8T8CyjC2rzWFBaCA";
        imageString += "4Ic8Dopz9qP/55eF9/lcPg6KnCL+sz7X8/A34R4BZdPQ+LeIvxBgrSq+5kWef+cE";
        imageString += "+BxafKkpNABSAEQQCOS0zTzhU/HGWiUX4gMi7ORrL8ID0ELwRAu61ArxH18qV808";
        imageString += "kwCgZoOmfm0CgMfI1EU+Vl/q4o81JsvvCAAdILcFZpl0q046AB2ADmBNR4Z9OgAd";
        imageString += "gA6QYdKtGukAdAA6gDUdGfbpAHQAOkCGSbdqpAPQAegA1nRk2KcD0AHoABkm3aqR";
        imageString += "DkAHoANY05Fhnw5AB6ADZJh0q0Y6AB2ADmBNR4Z9OgAdgA6QYdKtGukAdAA6gDUd";
        imageString += "GfbpAHQAOkCGSbdqpAPQAegA1nRk2KcD0AHoABkm3aqRDpDcAf4AbuAOWc2aNWwA";
        imageString += "AAAASUVORK5CYII=";

        try {
            byte [] encodeByte = Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createCloseButtonDrawable () {
        return createDrawable(createCloseButtonBitmap());
    }

    public static Bitmap createPadlockBitmap () {

        String imageString = "iVBORw0KGgoAAAANSUhEUgAAAHwAAAAuCAYAAADqWH1CAAAAAXNSR0IArs4c6QAA" +
                "ABxpRE9UAAAAAgAAAAAAAAAXAAAAKAAAABcAAAAXAAAJktlsfygAAAleSURBVHgB" +
                "7Fp5TJRJFvdAR1TU1RgP3KjjHVA8WUVpxSvqH94IuBqdhBg84jWBqKgxA+MZcI2O" +
                "xGXkWBzGceM/ooDEXWOi44rKgERmNA6H8vVJNw19091f7Xtl1+fXH7TdYvsHSVdS" +
                "1FdVr169er96r15V040QIg/krqsDs9lcu27duqRly5aN7NatW3fIH08BsLsu2DzP" +
                "c39PSDi+ZMmSaYCyd7BxKwQA77KAqx4+fFiyaNGiFfPmzQv+uFmLegOAd03ANRpN" +
                "zcSJE7eCdQ8Twen9MwB4lwRclZqa+n1MTEzYiRMnenhHWUTxGYBzDQ0NqsOHDxsW" +
                "LFhgnTRpkn3+/Pm2lJQUQ21trQr4cp/BOxBIeg6mFdevX/95zpw5S1auXPmVCErf" +
                "PjsBCnf//v2miIgI24ABA8im2FiS9t13fNYPPzjS09L4uE2byMCBA0lYeHjbvXv3" +
                "mgLA+9eD6HS6PyAi374yOnqobwhLqD4V8H379hmBBflnVpYTxhLC84Q4HB8y1iHl" +
                "/vijE+l27txphGrAYv2jA8WaNWsOyWSyKaBb36JyCd6fEqVzGzduNI8YPpw36PW8" +
                "ADSFF/4g6CzhNwBvbGnhR4WG8iCkBboCLv7zQFeWlpTchKh8aadcOQMegPDJ+m7c" +
                "uKEL6tWLmFpbBXD//csv/PSICIKWHBISwmM5depU8nNh4XszB+BtZjPp06cPyc/P" +
                "b/Z1rgBde0w4jquaNm1aPETlQxh2nSp9VC4XFBTEV1ZU8MT53pMfS03l+/bty18r" +
                "KGgBHo2Q0YIbIaBo6d+/P5+SnPwedKB/+eIF37NnT6wHrNxHAwNdCYaIDyw7EhNT" +
                "ISqfBCB3zpWz3SFm7On74sWLethd0A0JALySlUUtWq/XK6FFEIx9GwwGxeDBg53n" +
                "MzIoPQ77W2QkOXfuHG6OdvSBto/qRJWbm5sni4qSxcbG9ma4dbr0Rdlz5861fZ+e" +
                "zrNzOhhcdPWLFxiBewTv95qapt69ewMJJHDtAD4PkX0b1DyOcfVxTU1Nqrt372pV" +
                "kKDNo1d48+aNuqysTOtwONrxvHPnjhZ5iPODBw8EmZ1Op6K4uNitH2ldN4t2/MRy" +
                "Nzc3K5HWarUqxO34/ezZMw2bs6KiQmO325HG4xqk46V1cOWV8JK2Ga6+f+k0yOKB" +
                "0gk6qo8YMcL+v19/pYBXV1XxUMcIzdsiuNGjRzt+e/6cjntWXs4PGTIEx3lUJoAg" +
                "X716tQ3ko3EBljNnzrR78CTchAkTHEjz8uVLtYSvQsyDfeN1ERIeP3L40UHF2qWl" +
                "hFc7eY8dO2bAMTk5OVKPxUVFRbVJ+a1du9YKm7hDb+hlLgUEyinLZLIJwPPzXDkw" +
                "oMnLhHSx/UNCHG/r6ihw1wsLyYLoaBuM8wo43Bdt/8rPp2698e1bHoI3DADaKZC1" +
                "7dixwwxCEbA8HR4LJSUlOgz4Bg0a5JRaEzzuqJEW86lTpwwSeSjge/bsMdpsNgXy" +
                "wmw0GgWLBMCVOPby5ct61s9KJo+HsnE43FRw7Lhx43A9Yj1wCxcupBsWvQ48fypx" +
                "U/To0YOMHDlSSutRD655FXkwOCY6euGsWbN6wXz+SR4W5SZMv379HO/q6ynghT/9" +
                "RHBRkoW60bt4citWrLDm5eZSwOXv3vFfeQF82LBhzrCwMPQC71w85K9evVI/efJE" +
                "cMWsff/+/UZQuGPDhg0WeACSBoQU8AMHDuAbgBgQQU4G+NWrVz/p9gAuuwk0Tx49" +
                "eqTF8vXr1xomE87FABfPW1VVRcdcunQJrjieN7yoT1FfX/8cXHksXMMG+QdpFxfR" +
                "JIIyJG0cRN1ugEO0yABHZXrKjatWrXID3JuFp6WlUVeZmJhoqays1LisukPAYGPY" +
                "4+PjLXV1ddTSAQDxpqCA79692wjAKvBIEFs3ro8Bfvbs2RZQrgr4YMjg1e1u3brV" +
                "PHnyZDseP3gVPX78OHoXprsOAUcd4fEzffp0X2IYeVtb21vwjvsWL148zq9gIzOR" +
                "sExoocRFwXnVimSChV+7Rt1ocHAw8ZZxHLNwDiwc6/j23lGQxeTIzMyk8yEt5l27" +
                "dplRYawfS3TT2Pf06dMmlHHo0KFO2CQmEQ3t7969O8GMtHFxcVZRvwA49jG65cuX" +
                "u9GI6dk3xC/OgwcP0tdDuLnYIRC1Qx+TzyPgs2fPbhszZsxHYxjXHOq8vLwcADvK" +
                "r64cFkoTW4i0rK6uVuPVKic7m/xRU0McNjBqiLbx4aX+zz9JfW2t9wx08NpGx+H4" +
                "V8AnH1w88oUIVhposY3GYWRbXl6uOXLkCH3GHTVqlNNkMgnnb3JyshHeAAhYphoC" +
                "Nk1kZGTb2LFjUZlM8RRwfOG7deuW9ubNm1rkJ14js/BDhw4ZMHrHDGt2oxHT4ze6" +
                "AFAaAZ7NOG96ejr1SK2trcwzeAQ8PDzcPn78eK+A19TUPJoxY8aGpUuXDnRB5N9C" +
                "uihXHSNsO31owbdxANpvGfjhQ0xoaKgYIAo2RttKpRKvYgL4RUVFOlQyXMFoO24G" +
                "BBvbpBndu2ssBdzfZzhEzFbpnFgH74JeCGX2BLgc6cAziL0QW6NQgrfC/2D5FsD+" +
                "Guj9E5UDI7ckUq4wMd4l4+PioAuSP8FmvIDtN9u3k8ePHwsWZbFYEEh+ypQpDli4" +
                "Al015oKCgmaMcuE+SgHHn15hAQRlBDZM5kaM5hMSEvDNHtt8Bjw7O1uPR4w4i/gy" +
                "/nKMJ1COK1eu4FWMeRJu/fr1Vojana5jyg1wlB+PHwi+6FUN5eqIN2uD37YvwA8j" +
                "URCoBbmB5M8Km0xcZmRktPwjM/PLgO0C/SocFadPn3a7x+Lv6wgcAoruDxWJ33v3" +
                "7jXB8yIqnztz5gw948XyYjsEUxZ80sUgDeo+Aw53cyfOwzJ6HrVazVy0ADgGkSgL" +
                "HnXiuXHDYLtWq8UxAuDw3yh2PGbw8Qn7S0tLdeJxkm8FbOQnMTLZevhhZADQf7kk" +
                "mZguEJ9AL1648AFwIGpsaCClxcXkTlERzcVQwmMK9EASWa5TpSaWsv8SS/HdD7ns" +
                "P8SpRD19oIU7Jjl58mSH1xS4G7ds2bLFdPToUaMr+hYsCq9j58+fF1sZlRnpAHQT" +
                "voLBLHL4T05zYWGhRyVDJKzEX/9wHnHetm2bCaL6dpZ4+/Zt3ebNm82ujSdsBIzs" +
                "kQ+TE9fE+CUlJZngKq0HedrxQxlZhk1aNzcyMmm5TPbXL4f0e87/BwAA///nJKzt" +
                "AAAEnElEQVTtmX1IVFkUwEdnGkNstNCFMbCPZ0HRkqyihoofqIXLWIxj7Uhtu6st" +
                "tEtbjUFEFBYxGDKLthEsibv/xNIqgVQQ/SP7h+y6smEzukprpNPoaIMt6+zC+mby" +
                "dO5t3vN9TFP28QK7F87c9+597577zu/ec8+9owOASaW0tLT8811bG0A4TOXnq1dB" +
                "p9NFlc/278fXMeGzc7/2wbhuGXgNKeBdJpcxnRHmfvtdbPPHjg5wOp2z+KZK/3tW" +
                "Nv09prKystza2lo92vntpmjGlQGfn4dMjosKG3tGyx+MjgI8eQL+3GLwJqyiMq43" +
                "wUPTaiC5UObPLmTAFQO8t7f3dk5W1s6SkpKkt0s60voLgeMDK1NSKFi9Xg/Xu7vB" +
                "PTAAKcnJ4iDo6uykwCe4D5/BNa6E0NAwvgnADw6DF+8J9In1WxhwCfBQKPTQarUe" +
                "Ki8vz9AENlGCTFQuVTbD8YFkk4nCNRgM4Pf5CEfIy82F1NRUWJGUBNe6uiLAt4jA" +
                "ec8Qhct7BheAr93MgC/Y2+9wOM6XFBTkaOLKhRGF7BYPHNfr8NwclRDm86EQAx7F" +
                "jtFsGynzezyeX0pLS6s1c+WLAh5x3/Hx8dB++TJ168S1/9Hfj/3HRII7XMMnODbD" +
                "0RqqCaQsm52dHS3Iz28oKioyI4c4gYUmubIz5F7m0jFoM5vN4nqNnZJd79i+HV/B" +
                "pAAeGh6hxfyfI8ylywfB1LmzZ10YlX+kqSsXRhNSUY1IGXCcvbaaGhlkJfRO3LbJ" +
                "gGOA5vtgHfjMmTQXovQJtob7e3p6buTl5FRZLJZEgYGm+csAJzAvXbwIn+7bB3t2" +
                "74Y6ux1MkUCOwD/W2KgCLkCW5u878GAweB/X7S8rKirSNYUsVYbAp5XicrmC0oMX" +
                "rFelAw0N4qw/euSICvjkpmzwZ20DkgvQlcCbm5uD2PAUiqoPS7Ds0TGHw4nAtzY1" +
                "NcVLGWh6bbfbTytlA8fdFIHjGl5jtQJZqz+uqoLHgQCF/zmesGFHqaiA476bdw8C" +
                "YPTOuz1R1/Af8KSN47hbe+vqTin1L8V7m812ori4uAKj8uWaAlYqw+CBk0plZeW6" +
                "xMTEMyJwxJuEe20Cl0TpgSkyIQEa6usXgB8+LJ/hBPgL9uEEOOpxEn1S/Uvxuryw" +
                "cD1+1xrNt2BK2DHuD0mBp6WlUbhxcXFw4vhxuIDn7GsyMkTgp06eXDRwcpaO+h0x" +
                "+sCqNLTANyJwDNjy8/JEuNgH1fWQ2/2qwBs1/CamKoYFFoDjtoy48WqLBQx4li4F" +
                "np6eDj9duUJdPInkZ+q/gsCuTyCwcw+Ex8bpgUz4wRi9J+UzXxyUHa1iWwx4DAha" +
                "Vn3d1toqwqEnac+wRv8lJ21EpAmDPVpGcmmKPNvR3k4Gz1EtP4rper4FttbabDzl" +
                "JMB8kzk2jHv6/1F99vO7wGq0tsBQf1/fY+Kq6Ux9U8CxvYE7d/7Gj/lL6w9i+mJY" +
                "ICEhYSNWT37rcoXx/2/+/r17/46OjPz3qkLe99y9y19obQ1jtD9lNBo3x1DPqt6h" +
                "BZpQtxeFzMrXFR+2cQ6FJWYBZgFmAWYBZgFmgdezwFMA4mTa7r3DKwAAAABJRU5E" +
                "rkJggg==";
        

        try {
            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createPadlockDrawable () {
        return createDrawable(createPadlockBitmap());
    }

    public static Bitmap createAppWallCloseButtonBitmap () {

        String imageString = "";

        imageString += "iVBORw0KGgoAAAANSUhEUgAAAEIAAABCCAQAAABJXchjAAAACXBIWXMAACE4AAAh";
        imageString += "OAFFljFgAAAAHGlET1QAAAACAAAAAAAAACEAAAAoAAAAIQAAACEAAAGYHOz0zwAA";
        imageString += "AWRJREFUaAW01sEVgjAMBuCcmMFFdAllDndjBU5M4vPpyQV8vfCbKlaLpbRJzEUQ";
        imageString += "ST5K2ko0BVp04wUON/Q4onl/b/mJhjP3XMFxpQ5tlBsbDIhiPGEb/cTgBDvOGseA";
        imageString += "zZSYCef42vPsjoNB5ZACB9wTVc4TYz4K4afOjsEEF/LGBwM7uReWw2EfHkVxgP0i";
        imageString += "wdduiRskFwaMFQLQEa45A19TMlYJGC+UHaiXT8HI9MLn2R3xrF0PIWN9FJ6lb8SL";
        imageString += "R0kIGIUEoCdew8qicsIWvYhX5SOhGU9lipoWLR4FcHW/RWCbXMtSssKXUk7gyu/t";
        imageString += "oeKmAoY4m/jGn3VUlUl1c6Cos6gTkD6Db9H8RvPdqokJWzEp850lZ5gR/KuVMUwJ";
        imageString += "MoY5oZ7xF0I1Y+mP23cj++N8O/qy86jojXmx9Hk9wZNMGTKCKUNOMGPoCCYMPUHN";
        imageString += "sCGoGHYEMcOWIGLYE6oZia3e50jHAwAA//8afchFAAABSklEQVSt1sGNwkAMBVCf";
        imageString += "si3QSGgCqIPaSAs5pZIIcaOBMJf52IBWASXwPWMjISQc+8lMTETowB4JbCTs6cJ8";
        imageString += "ootg1HiGmxDPKCLEMooJcYwqQgyjmlDPCCHUMcII5YxQQhnDQbjRe9S3vhyEhJ2+";
        imageString += "2HXOM3wEW/zhDD8hnFFGCGWUE8IYdYQQhutw7azlUriqfD72uC5eJRjLVWnOqP8h";
        imageString += "5lMpYqDFZHuVCF1N83Zrnx2MCVsbX5NHor2lkASj8Yw84k9wjCf4GDgKegrhmIIR";
        imageString += "LOhp9IIrgSggOBhXIf4BCwk0I0m+/JhEBYFj5Ivk01dEJYFidILDF0QAgWAcNAfD";
        imageString += "CiOI8IMx2PeCDc4LjInbjo8SxJvesEt7+YzN62JlfEwjj2iJyq4UtFr1PYZ/wrOS";
        imageString += "no1O75Ske6PXLdq46pPJaLRyrx2SdupgZ+ERd9cPp9mkreL2AAAAAElFTkSuQmCC";
        
        try {
            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createAppWallCloseButtonDrawable () {
        return createDrawable(createAppWallCloseButtonBitmap());
    }

    public static Bitmap createAppWallTitleBitmap () {

        String imageString =
                "iVBORw0KGgoAAAANSUhEUgAAAJYAAAAeCAYAAADO4udXAAAAAXNSR0IArs4c6QAA" +
                "ABxpRE9UAAAAAgAAAAAAAAAPAAAAKAAAAA8AAAAPAAANKVd6OuEAAAz1SURBVHgB" +
                "nFkJWFPHFr5q1dan1lparXVpn359z9ZXP59tX1trH351qa1abUVUeEjZlFJrEaUg" +
                "xcaKK9ZqFTWyKIsgYZEAYVMUJYRdTcImoEJAJIIsgQQSlvvOXL1xcu8E0fN9kzkz" +
                "c84/S87MnDmXoggkpKjhETY2i+M2OKyIt3e0inXaaCt2dNkgdtzkIHb+wRklyUbX" +
                "TacWLJlNUGeqhHPnDhcuXPiyyN19fLrA/3WRn9+bUT5+U0QCwVSRj9+bVwQCizMr" +
                "7ccdnjz5JVAYYg6HrT9jafnimZUrx8V7e7+a7u//epxAMBlhIUzJwYMTkzwEFqi/" +
                "zRQ1ktV53tySol5AyQXWwYqiRggepRchH0o9J0V9t0aU4r6tI/lnj8oU9+2FEvft" +
                "F1M8tovjXH44AJA83PDVaz+NsXP6Js7OaXWco+v6eGb9nY3rn+rk6hL2zZol5oYj" +
                "XL58VLyb26siR/fxbELlZFfXVwQCAa8/Ls4jfW+ePsIQEMbL1SeWAz6e921rrYru" +
                "UD+gO5ua6O7WVlrfrqF7OjroXq2WSbReT8uOn8okAcCfMSz38BH3mqvZhXX5hVX3" +
                "btxsvK9QtkPSMkmuaKu/fqNeJcuVV6VmJBYEBu+LcXZdClijSHioLv94QESdLFdR" +
                "X1R8t+GmvAlwNI2KUl2jQtnZIFe01Bdfr6nJzimsSEgSSU+c8g5atHSeOayB6oO/" +
                "WvGBIjzyrDIyOqQkLj60NCEhoiJJcr46LU0csdp68UC6A7UpYuPLaQLVSHPUFhQ1" +
                "BtcFa3njbraUWXu0/roWtP7ttAFb//7ubrrqUqYa9EhrNjT7gP9vtTLZbVVBwS1V" +
                "QVElyuuLiqpLYuNvRG7ZMgHvj8QnbHTbee/6jVpVQeFj/aLKuqLi6jsZmXWC0aPf" +
                "Jek8tS7t153HCWvAq7p7TVoLYKO5gOjUKE8Qx/T39vJ0uBX9fX10T1cXbdBouqrT" +
                "06tPL/rSnosH5SFV6Rc1XF1Sua+nhzbodP261taO66HhuV6jxs0h4JmtCl68zIaG" +
                "8fQaDHQfSoCHEqKkn7fuZRVFlNWw8BWrFkWss/vhnLWta8Qam01hVmsdzy5bbXfy" +
                "84VrPC0sTIylNCH5LgPC+SmJj5ezmGx+ar7l6j6djiPJL+rU6lb/t2e9z+ph+bDi" +
                "8IiAXtj8XEIbO8rHZwomS2RTvXcQbaCz4T4tGDP+U6LS0yrlIlEhd0Ckcrf6AUzs" +
                "H7yJPTYsEfuHkHTN1fW0tdNZBw4Jt02Y8DdsnEOq0jLazOkMVN8ol9OxTi5uGNaA" +
                "rPdLr8zTNaqJkBlePidZZZGj43g4Qe/Q/f00k2CD0GgjGXro1tt36Ehb25WsLMor" +
                "09KbSaAFgSEZuBziM7x9jpFkuXX6Tm130s8eq7n6UB5adDbsaA+calwCw+oYjGGl" +
                "bPP8k6uLypr6e/TvY8Z/Quhz4KoVFDVBrSxpJIFy6/RabXfy1u1w85kSMqyyC+Lo" +
                "5zEs1Ie+sxOu2YBgDHUI/DGt3P4HW+6430hn7t4Dw3q6L2dLUTPUZcRbi87aeyCS" +
                "HVOEp2Byg0LRThpDP5x0qVs9vVlZyEfeuZLVRZK97Lc/CJNjWLkoZlAbG05mWno6" +
                "aCdXH8pD88+ePdzTRTAscEOQj0vQMalKcttyiDTeVpWK9h0+9kMT4cEUzixZMl/f" +
                "1mZy7aDrStvcTKMcJzSxHGHgb1xc5PCWxCdEPa9hoT76YFEi19ltZbErUtKIOx4f" +
                "z0B8w42bHadXrXqHxRsgH1uTl/fo7uMA5gmDklm9UDu7jx7CyWSOrv117DwrC/nY" +
                "WlkeUTTazkGAyVGwdhPBb+QdmZ1NzcYrmQVC61uRkHgebWQcA/ghBSFn/ZGLwaX7" +
                "cuWgDCvewXk/VxeVn9uwLu476AAnkcnCGsBhl0fH6GGgcO4/ITSxMnFiNHdijGHF" +
                "kQ3rpjhJ/cvH887tXr7yguTQ4dK2+vou5ip5Amvk6gsK71lS1Di0aOYMK9lvb82P" +
                "s+aE/rH+fxJpaMRdbVOzWcfu2v5DIQjraVQmTm4xDgJjrkdFZbG68S4/bdC1EMUY" +
                "jeLQ8ApWdj1FTWtQKjGkxyxcm0GLlzqwcigPXrj8M0O7xmRj98EVK4+J1Xe1t5us" +
                "P0Kpy82/LrKyehnHAH5IblDIAaJhKRQa9KLmyPOK8Q5Oe/gDhquwrp4WvDT2Y57C" +
                "UyqGFoZF/Mm9m7s7OvTJnt75cEXxvEFVTu5NFDbAcQcyLKVEkj+ComaB/ExI85ZO" +
                "nbqz4lIm8UrpQVeth+e3CNucYcEiJUIzOtrfg7TI+6tlIe0NDSYbg10geDX2gMwY" +
                "SAPSjYgoghXQtFKcWMwqZgr8iD4I29ftrKs6kGVOEt/hw2c/vMM/3XQPHtB735rx" +
                "XxYT5Zn79jlxNzb8H31pO3fldz1s0bL4bN5wU6GJ2spzxofkBYXsJRvW4HysOHsH" +
                "AdsHnmvuNdB+z+q8CyZNGnX30qUU7gkCL7Y24RdLfPU6nclOQh3elys6Ijg7wKxh" +
                "gaOrypZeCbC0RC9JFLsaBmn0xvnz/TshtMEltDCFZ0L3gIxZw8o+cvQcagdCeC9A" +
                "mhq7e3cxFwuVezQd9JF/zl6GhAei3OMBEpJ+ZXpGFeihPqjCoOBsXIZ5ASNH/jE1" +
                "36qinSmKuXr3TJy2QNfEn98D8OWsKWo6NhbY2GG8jW3Q6vRh363b1VxZxQNpgxME" +
                "Yo5fYBgMCyfW7h4d4SocpPMeY+fgy84Fz5/LeUfBL4hb8LZWU3l5ox1FfdKpqmvC" +
                "O0F8O1hwhLXNYnxiAxrWteysx4ZlVHG3sppRLcvl7Ub03C8Vi8ORYIUk7SG3b1TG" +
                "DMuI5zVnrgcNuiSKc96IO9VGHZxJ3+ErJOlCeOUeyDFxo4rEZONjAvmeDQolEzZh" +
                "9Xp1WvrkvAVrEO6fs2Z/20/4k2tkub1w1BtPe7Sxb2dcTOf6snqNpmPHtOkLytMy" +
                "qlh8NmceCp47BKgfnMD3FRgIfd5XlmiDfHym4bIkXmRj78X2gedatZr2e23K5yQd" +
                "s3VhTk4zYReZeuiAWpKYVAZKI6oyL9fgnTA8+Flp3j67cNBnNawL9vbjamSyMi42" +
                "WuDq9EsJCPtZDOsnipqrUdVx4ZhyurfvUXysJF6yzdMbPR64BA8A9SqKevUbiprS" +
                "qCwxNqN4Ub4wyNDV1vbkyILWBNfNzGl79uvljkZhjCkVJzbh/ae5C8bXFxTdxUQY" +
                "tqWyqnkSRVlIj51K5rahct6pwKs4DuJlwkBfFM/jyt9XKnWDMazotbbbuLqorIVQ" +
                "jN9rbzybYcU5uqzXNfMPhiv+h2PQYHODgi+TOssPNJ3YgIYllV7lnljoU01tTq6C" +
                "i40M687FzCTUd4UklT8wUMg+diwKteP0I0X9q72mlgvHlC/6CgJwWRIfY++8VgsR" +
                "by61VFU3w0Nl8tEP/vNVD0TCWTJ0dfWm+e4qAOfa5O7JOX5CjPBjXTYRd39hSGgJ" +
                "3n/Ixo3vPqi4xdvY5ckp6AqmYlzdiA41bPhOaGauaBYPTiwfkmE1lpYOyrDOW9tu" +
                "ZeeH5zpwWXZPnGzJ9jOoPNNvTyAOwvLh6+12IIALm8mxDfi0oIVm48SQYZXFXogk" +
                "hRtU0pzs4BUrTBxo9J0PPtXwLAHp30pJYZ7t5ZJU/j8NA4R4VzR3coff//eX6DMU" +
                "iZK2eOzmynPLIVZW/20lGKauobHVC+Jcsd8778SxwQfqirS2OahvaTN5JpYlSZQI" +
                "O8VzBzEmJDtxAj08jBT7vZMtOOg4NMNfPRrAhDn2/33m1z3waY1L7XA6w7jmGIGA" +
                "kQqFXiTDUpeU6gO3/fo2LkviI1dbb+b2g8rdDx/SB96cyvPpSBjGOnnU+VtcMC28" +
                "XHZaTFyAhI58OM+a9KkBTcyHGv4BC8ScWGbiWCqpTMo1rNC1a+eQYkLodVoUfu4P" +
                "hGvuKswJOMmcpmzfKJd4eR/lzgOV0fe1vz76bB0uS+JPu7m911RZyQtb6Fvb2n1H" +
                "jH5PBn3i+IbOTs2+6TOtH96qNIk/NcoVjYA/6vLve0JxeZa/KPA7hveftW9/MNuG" +
                "5+e/d2ZcjYXwMIHvrniTkY9ct8EDx5KeNGtYBuH27dNxWRIf/p31j0ZwjDHAht03" +
                "ZYaJT03SN9aBub92r6gYg3jE1ubl0eh+R4LwgnlHXV7Ok0EV0RscjBNjDMtMHKsu" +
                "J08WsdRmrLFjYPJOCIlXLDy7DZIdvvZI1ly4QXbydDxqZ8mdGjmjqbTU5A9mB6wq" +
                "LKLhmYZCEwOSWCCYBB9gn9x1jwFgPB1+M+d8XpaSanJta2pUzZ/B2tzOumbig3Y3" +
                "NbX+OvLl6bIjx5PYMbB5Hxh58tZtv+ADkUfH8jY2+iP3T38XfaBnqEScSAwUywJO" +
                "XGBlUH7tuHA7nFi8a1VdWtob4OU1A5cl8WGr1myi+3guGo1cgINvTf+SpIPX/R8A" +
                "AP//UWharAAADRxJREFU1VkJWFRHEn6uJiYxJoaArkn8gGjwvnJsDrMGL1Qw3BBE" +
                "8ATjhSiiggQX0aAGUZH7EDmEkUu5BMIZQVBBEVQQRDTcIMg1DDOcvVWjj+/NmzcI" +
                "Zne/b+v76ut+PVX/q1dd3VXdQ1Ev6eycz9f0dXQQNhVGRNXQMtCOKk1KlhYCpevn" +
                "POJoOQOKevNBdAyvv7eXDUeqsnNvhuoaK162dpjobWDwbb63b4aU0MuBxuKS5h8p" +
                "agbiliYmN3PJ5Xr6xDlQSm+F/Prr5ND167XKU1LLB/r7uUTJ1eMncmgbh2rj9+2T" +
                "r76VV8kG6enqEnh//8OmxvsP6pm/VVy7Vgl4Y4oiovKZ492dnV2B2vrLCi9FZDLH" +
                "sd/Z3Ewub7NYR9uxkKIUavLvsMVIbcFdokpRn9ByOe5eaVJCMFCemvYEZMbSctc8" +
                "vK3BXilHPCsuGXC3slKh5WS1gdoGWwmHHwc6BcRZeQZMyzAp+aCtC5fBWafPRjEh" +
                "cnz8s7nkKjIy8cPeQtmhAqujrk5UmZP7Z83tgoaWp0+5oF6MdfcQFxPTi/S7ZQVW" +
                "U2lZ55/ZuU/qCoued9RJzLcEdl1xCdnxzSJdGm+oNsLA4P2qm3lSswwTJQw32eDc" +
                "3dLaygTPD74oDthsV/dI5jjI90bb2Owojr9awBzHfmtlJQkxMVGl7XBb+KVmL5/P" +
                "FiP3omPqaRlsE23tjpC+Pim5zpralqMfTp5Jy2Z7elvJCCziaXlgOi0nqw3R0jUj" +
                "vdLvIV1dxHnaLC1ZelLjd8N4N9nWDsCOE7lpa+AxhY++P/mx4hLH8R8sitm+O4ot" +
                "h8+dtXWtjpMmzUXgoQKLS5drLMrxWBlATaMNlRVYXLrssb6eHuJtaRmtQFHv0nhD" +
                "tc6TJo17mpaeQgYGJKB6BILuq1b7U0R8fhfzh5RfHPwRL9bC8hRzvK+7m6Q6ObmV" +
                "p6VXMMex31T2iJzbvHk+bUfSwYPn2DL4nH7yVIEd9fY36P9Tk5UX+y1baS941iQl" +
                "2s3nC+N37tah8bLcPfdwBtbDUuKxZ89gANLy7DZkjdYm0iOdcYhIRM7NmT+sBYqB" +
                "oFB3t7CBbS26taullXQ9ewbcRLoaoW1rY4uJn7sFAmGc1X49NPCvBBZMHsn0938k" +
                "P3asxHb7uoEFeANBBw5eA7MGJ5HtRPazBaSUhzHxEexUDqmtP8fNswowJTweqKO3" +
                "FzGCtXW3MHeTgb5+csPDJ+3PnNxnbKc13H/QHmBnN4V+dyEv4gZbBp9FUJ4I0O/o" +
                "f+TnzyHeWREPchBEAzlefnY03jU3D0sYk9pymsrKiM+uXeINgJblaoM0NDcQWJBS" +
                "BJnE7atFP3HpSI35r1ixqLutjbN2kgKWMdDTJSQ3ff0PI/jrBFZvB5+U5+Y+d92+" +
                "M16eojQB5k2moSMNrM6GBnI7JrbaSl3jAuB8SREyiok3VB/sH10YyvPCHYdJMFHk" +
                "YUJify+sWpq6GhqJw7sKixHPfoL8D0JYhEwqiY0rry+6L7Uaq/PyajP3OcCnUhRs" +
                "MxMbiu41MvVG2sdFUHol7hIuCsRMP+exq0cgHVjN5eXkgrn5ApQZinxXr1k3wPjO" +
                "QXtgF/NavGywNhwKg8p0Ormlu1NyFQ4CDbMzAHm/LC4hHD8MueRKbDh7xSNUr1BI" +
                "OqEWaq+sIg1F90lxQhI/5qjTPQvVpX7TJ07cDoZ+AfwG2+BHySkSdQ1tFqQAwq+t" +
                "Ja1Qr9Xk3yYFEdEtIVYHrhvOX3B64nvvmQCOEvCwg4p+b46v/1EMJCbh97RWVRPm" +
                "4aD6TgGBwvsj1IOAVK6//4CpQp5mXRc8Ky2T2OFQoDL31oNQY+MPUM9fTX2xqL1d" +
                "usCSQHr1Q1XOjcIL2hsnIKY4sDh2rObyx8R3797ZKDMUnZcVWOCDgBWr1g6lS/82" +
                "uiD4oitzFb76E7glqnJvFV3YuHECBtbDmFhIJVI7MSlOTmlePUHeceHfxtiAVzGQ" +
                "cFtdDoyr6D1gLhpVnpwiterRikx3zyo44tjOoaj9EI3moIz5XxUY64jBUxL0R0SZ" +
                "rm6WkPKkTlXsLy+OiWtiAI9+nJouZMo8r3hC+KxdDGu3quycPzxUVcU1X5bzWXN2" +
                "emViDLdff+9+Z8zL9Cprx2qrriExOy0ORZpu1OVpGmhe0tZfHaqntzJIT295qKHh" +
                "klBdwyU+qqry/uo/GnPuWGB7tNk2T57JBk2erpFmqJaeevBL/WADg6UXjYyWeamq" +
                "KlHO8+aNq0jNSGUXqpjG64qLu4pT0xuK09IbH6ZlNJakZzSVZfzxvLGsTMSR5gms" +
                "VkHovn2KGFil4hpFOrAqsq5Xqc2di1cIk4EnAr8PPAZ4KMLAaudy8O3QsGJQRJy/" +
                "AysAjwce8Q4FOhKU6uBoDLu4ZC7kMOCGj282UxGuHB4zxfDggLs5k3DHK09IinF4" +
                "cYoeXcDjubHTLsq3VFZ1l6S98D/OAfq/NCOzuepuoaCfhYnyeCq+tG79arQn46zb" +
                "Dq5USKBwFsKhFg8A/PoG0lFbR9pragkGXBvsxi1PnpBbAQHHPFSX6fdDecNF4rrv" +
                "pX77S/32mhf6WILE7tidRaXZOn1YfftOFRugVygifvaHk6eMn7DpUzmFzcjK8vJm" +
                "ynJy5t52dsmY0tgEVwnk0vpNa7ZCKiuNi49iOxTl4RhfnQn3RMzJGEZ/dEVKaif7" +
                "ffj84EosBtZ/nHhGRhqQZiVzIYcByYfsvZgvz3H3SOEQkxjCYLsfHhmEfsKF/STz" +
                "Whp7YeNzhn9A4Sw5ObHvGf43s9PTPy/s6JCMVnwDHBbSDjs4oT3prq7bXmcX7IW6" +
                "siAy0tFj8RLdPsErP1/iu+iHxD3WmdRFOCE0PSqnxwZbOOX1JRw7uQdsxLupd17y" +
                "OGjHRdnZ74YTklTdgM74/dDh30BmlKzAqrl9py7R1hZ3lpGQzMB6mJiE1xJ/GwnY" +
                "cGQ9VZd/093axrlL0k4Swc8xOyx+ZuKlOBzxpn+X1WLZcTskxAXtvmxtPbE6L7+W" +
                "LYsTfCMwyA8chemS6f93TixdulrU1sa50PL9zt9Ce9Jd3V4vsNC2SxGH/0pgJVhZ" +
                "X6Xidlrs4boI6xN1i65s3a6NRrIpUP8nNVjNArYz8Dk/MCgf5R8nXI1mFrm0bG1h" +
                "UWOOszOmrpHQmMdpkrULjQd3RI8B6M2RgA1H1nbseBVhdc2QJ2Xc/oPXrv2BiRe/" +
                "d79lL1yZDEV4NZDl6XMI9UK3WfyjvbpaSrwfdrXrnr62TGy6v5OiFFselXP+E/Ek" +
                "K7sb5N7I8vCCuq1LevFLvUlyQBz0vHB7DCxZqVBSQ/opft/+OCrMeKPLnfCI9rzQ" +
                "sKb8MF5zQXhES1H0FX4hL7z+9LeL59Ifw2z3U2M/41dWPpeGJORpTm4fyL7zFGoI" +
                "IoISBRnTJp6woK29lSeIdXAQn6KYmK/oj3mcmPzidYiHuR/xwPllicnPQPftV+iP" +
                "+GcDwDxjYHzB++ftGf7bLbJD99vkXXE6fi/Z9VzZHz5+lTdDwhqz3LyqXYyMBu+i" +
                "8CU8XQNN/hD/AOBHQIrqy3Q5K97pgvUMV94MCAL/85qQ71yKaLkbdbm9KPJyW5iM" +
                "hQ2veaMs6XfpNAPYeNdlLyf37Q0fH7MB8M+ICeq/wujoo+6Llxhy3mMNA/Cq9cFU" +
                "9AVus3CVQuE1PTL28aJTA3g0MBe9XRyfUCHkd4oEbW1CJrdCWnWa9MnXZjPnrFg/" +
                "a66b4bTPzugpf+qi/bHiKWCXdYpT921UUhL/9cMFLGtsy+y5e9fNnOX109TpZ3Wm" +
                "KDprfaLorD1F6YzpVBUoVf5rNBuQ8Y4KeQkwnl5XAaNv0FfLgCWuRs6bmn7ZWPKQ" +
                "9MAiwp0JSooBvFiFgrcP6qLervaOnrb6en6SjQ3Erpjw4IIFN2YH2v94skWWdUqm" +
                "Mk67Jojgopbp+86WFqEI3hW5ydx665wvptosVwuyVVMLtV+pEW6/Uj3cfpVGuKOG" +
                "ZqTjGq2oEzp6Mcd19WN/0zeIP224LsnVeEOK52azdN9tuzLdjYx0bKdNU7BZviLs" +
                "kJoaz34V6KI+4Azqa+teOa6jH3NS3zBBrL/WJMV9s3m6345duWdWqW8E28UnMszj" +
                "TMaTlfgojAJcpK2iYqo/f+EJzemzHX+cMevIGpUZDhrTVI4YzJlnV77aAo/5iKEM" +
                "rASsyGBMg69zakO9T4GVgGk87MsB/y8I6zgMAky7zLpT4ltsNDQ+cDYzC3TZbXn5" +
                "5M6dEQ5bzHm/rDMNPqCjG2C5St37Z9WlZ02//vqoiaIinoqREHccMNv/GFQya0cN" +
                "ZeV/Gi5Y4Kw984X/NcH/6tNU/qUzc/axY98tRf/gpvAZsArwdAbPgD7yTOBZwLh4" +
                "5gBjdpoHjNc+OHdIqM/UxT5bn4kxH37/HBj989qEjsAiHCeWyeJLv9dG/f9XxAld" +
                "CPwd8FfA6GycRFwUOOEfA+MikRk08NtwCAMccT4Epv2PvsdnZqbBwB8uo03I9GIZ" +
                "rh4tN6j/bxTPl+r45xLFAAAAAElFTkSuQmCC";

        
        
        try {
            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createAppWallTitleDrawable () {
        return createDrawable(createAppWallTitleBitmap());
    }

    public static Bitmap createAppWallBackgroundBitmap () {

        String imageString =
                "iVBORw0KGgoAAAANSUhEUgAAAHgAAADVCAYAAACc5jTiAAAAAXNSR0IArs4c6QAA" +
                "ABxpRE9UAAAAAgAAAAAAAABrAAAAKAAAAGsAAABqAABoDrpKSDwAAEAASURBVHgB" +
                "jL1ncxtZtq7Z/3Bu+7LypETvvZOXKIny3lap2p2JG/MT5nSVKNGTIEAPgBYeCVDn" +
                "040YREfO867MDYLquubDigQpUtWtB+/ye+M3H77r+R8fvu2tfPi+pzKJfTzRXfl0" +
                "guf3wXP6dH9ltm6wMoPNYfPYQj2vT/ZUPv22obJYP1SJNo9WlpvHKtGW0Uq0abgS" +
                "bRioRL7vqCx9315Z/q6tsswzeqK9shJajOfqyY7Kel1vZaO+r7LZOmwWbx2pxNuG" +
                "K0lst32kkmwdqsTPtFcSZzqwtkr8u8bK9vdHttfUU9nvHKrsdw1VDrqGKwfdWHt/" +
                "Jd05WEm19VXSrX2VTEtvJdXaw+vuSrqtp5Ix665k27oq2faeSq5noJLv6a/ke7G+" +
                "gUqhrx/rq+QbGiu5lpZKcXS4xoYqhcFefra9UuhsPLKuhkpB1s33unn2XODnWiqF" +
                "4dZK8XJXpXi1p+Jd6w7selfFuxFYYZSfG6mrFEbPVfJDJyr5ge8r+cHveH5byY+c" +
                "qBRvt1W8O62BTbRVCneaK/nbjZX8rYZK/ub5Sv56faVQY/o6f62uaoWbDf/fbybP" +
                "DFQmT/X7kyd6fCD7k993+wD2P2J6Tp3q8afP9Pmz9YNm8/VDvlndgD/1hyZ/5k8t" +
                "/nLTmB9tCWy5acRfbhj0oxcG/MiJdh+4gfEasH7sZIc9V051+Gv1vf76+R5/80Kf" +
                "v9U26gPXDMB+sn3ET7YN+fFz7WYJPU+3+IkTjX7i+0Y/ie039/oHHYP+ftew2UH3" +
                "kJ/qGPAP2vp8IPvpLoxnpp2vW7t9APsA9tPt3Xyv28/q2dHt53oH/DyW6+PZ32+W" +
                "a27ycxcu+IXebr94cdgvjmE880O9fn64zy/0tfv5zkY/34V111jPBT8vG2zxAezn" +
                "R3he7vQBbFa8zusbXX7xZodfGD3Pn9fxPMfzDL/znZ8bCiw/dtLP32n1i3dasFbf" +
                "m2jzvbutfuFmPd9vOrJx/lvX+d4XlrtW5wP7X7+ZPDtY+Xh20P90Djsz4H881Qdc" +
                "IJ8MAZ/s9aewmTP9BngO0AKMiv2pPzX5039o9Oe+a/ejrRcNcqx51I8KMBZrGPCX" +
                "T3T4kZP8Oc8ozxUAm9UA3hDkxn4/3h4ATgiurHXwCG5dh5+sazfASSAnTzb6ey19" +
                "AAYoEAW3ai09BjrTDWAs2zPkZ7sH/HRHL2D5s/YuA5sGbqYTwAa5PwDc1+8XgJxr" +
                "a/GzjRf8XEOdXxzurwIuAFeA88O9wAegIFcBN/BGkQlwcxVwfhRIVzv94nXAfgEY" +
                "BRvgwpggn/JzIeT8pdN+AbCF280B5Lv8HQJ8m79//DzPJv68BvQtvn+DN8xx0ADG" +
                "5X6sG/Q/CjCqlE0J3tl+gywFm4pP9/qzKHnufKjg84P+zFct/vSfGs0Wz/b4MSCv" +
                "tI6agmONAJYJsgCHFgOs1Ltyur2qYAMM5C0gC26iY9gs2TZQVbDBBXDyXJtfBYxS" +
                "9zsH/BSAZQc9w36qF+N7B629wB3wBTkD/KyBRqU9+prvd6LkEHCmE+AYLtrPD6Bg" +
                "LNfZYYCzjfV+rrXB1OtdHPGLI6h3BLiyUdTc1xIC5h8Y5eb6ePah/KFmPz/KGwDL" +
                "oeL8KKCqcAMF50fr+XtCBQvwxTN+bviEqTh/+UwIWCD5XQB7gnyPv+sm6nSQAX1M" +
                "0fr6ZlXV//rNB2LsJFA/1sIF8DQgzc71m4uePo2rxmbO9vnzFwb9BWzm21Z/5o+N" +
                "/ixKnv1zkx/FPcfacNWAjTYN+LGmQX9FBmQBFlwHePU0LvpCj79+ATeNbWCbfB1v" +
                "HgBuADnZiqpxzQnUm6jHRdcDl2fydLOfPNXk77X1+3u1gHHJBwIMaAFOYRnUG5iU" +
                "LMADfhZ3HFg/sPkZVJztCizfhzoFua/XzzacBzKAG4HQ1eYXL4+i5AGU6QD3ALkb" +
                "d80/ek8AON/f6Of6UdKwAyy4AeD8RSCZe+7yvZudfmEMwKPAkos2wGcDyCPf+vmr" +
                "51Ap7l1wscIEz3u47Pt87zZvoHF+FzVLxaZmKbpW1bfxLOMNACahmgTarwMGIkqd" +
                "BbaeM+f6cNU9/vzZXn+hYcifPdVl6p1FxbL5r5oAfNGUG20GMibAq81D/mpDvx89" +
                "FUCWemWKvw5uFTCQE60DfrITFQuw4KJcg3seuDIgb59p9veIrftANfWiYLnjlKx3" +
                "BNeN+26VOwYgCs4AVubA5noDlxzEXcVfgApydzcxGMiD/YGLbq7zc01AbgLyYE8A" +
                "uKrgEPAYSu5HOcDN9zfwdwmwoErBwBnj9UWAX+RnLqPCmyj4hmJwCHgMyBcDBecv" +
                "CTLxlxiq2GtgQ8D2WoDvNgaABfkOkCcCd10LWqoG/r9+88vJbpIskiopWK5ZBszp" +
                "0GaAK8BzF3hicyRP8/UD/kJdP0/U/ccLJFoN/tyficXY0tluwA75MeBKwYIswGs8" +
                "13DBK6fa/JUz7f7qmQ5T7XoD6jUjDjegYKm4sYcYPOgniLHxujaD69S7bZDbfD33" +
                "O/sNsCAfAFaAzVCtgSbeHiip6uwDLK45BCyoAdjB6jM/gHseDF10L8BQcbaFRMvg" +
                "njPAuZbzuOpBc8/F0T5gCziQL8p4YwwAsR/3KJOCx9qOAS5c4nuXAX4FJY938feQ" +
                "HJl6A8AFwb18lqQM90w8dYANLO45eKJkQb7FG06Ab9XjvoEpyA50qOribQB/oNz5" +
                "AOBJYuxHoH6qgSvIAjxjYAV30EzueR7Qc2e6/fnTnf48rneB5GkRN7x4sg0XjUsO" +
                "4cZaBBi4LUP+OrbW0OfHgCvA6wDdAKjAbgJVz62mAHC8qdtP8jrR0OUnG7GmLn+7" +
                "udvfwXZJonZxv6Zgqbi93z/oIhbLlEmbinkqoSKxClQMMCBnjyl3EBihATgn1wzk" +
                "wgAK7uvxc90duF6y5W4lU8DBlFgF8TeAa5AvAfgSgC/3AFkqrgGMWy5gpuAQsEG+" +
                "yt93iZ+7jF1B8Vdxu9d4fZ0E6gavcbGFcdRJ8lS40+gXgVfETRcE865ico2KDTJ/" +
                "5iCHoA3wR2raD8TWSewj7vcT8KZwv9NAFVjZLBnxHN+b4zkNxI9/PO9/+l2dP/X7" +
                "On+pdcRfahn2l1tGyKKH/SjlziLxdbkeJZ/vJckCKPF4rRXA2AaZ8VpjL4BJsgQY" +
                "9RpgYG4CdbOh09+s7/C3cMvb7QNARc0tgAWqs11UKdsD5H5bb9Wk1gOptgOwnYBF" +
                "uemuPgOd5nuZnj5TbLYfV40FcAPV5oYUo8mqmxr9zPlzfubcaeK13KhKpMHAUK+U" +
                "m+/lH3Oog+waGyU7Rr3Fy5RBmJ75QeLxCADlog0ukAX3IlAojaTcwiXeCNf43jXc" +
                "9nV+3gzAyoQBXCR7tixZyRQA81hOz9uh3eHvuKs3gFMyv2PgBT+AzZsiUPBU8xjK" +
                "HfI/EYvNgDzdGAIm7k6d7vIncb8f/q+z/uR/O+t//O05s6k/XTC4ESBHBLd1mBg8" +
                "YipeIsZGSZxigkysXUGpq8Bca+qvQl5v6CYGd/kb5wW13d8Eqp5bAny+w9/pHPK3" +
                "Ueq2g0tM3cEMLiD3BZiM2CCH7tgAO+W2kh0PjfmZwVE/3dOPq0aVKNgAD+CeibWK" +
                "uZmWFj9VV+enzp7xU/Vn/IwZJUs/CdSooA74HnBlxYu8Sdr5RxXgoXbfG2knsw5t" +
                "rMP3LgH8Mu5XidVYEIPzwwAcBtQwUARXmfM1PMFNvIMDfIOfAawy4AK1rQGWYkmk" +
                "ArCAvy0TYFz6LZKwe6j6IW/Ce7xZ+H7hjoOskkq/e+Ffv/n5u47KFLXrDI0Ks6ZR" +
                "YvCQP/ldh//z7+r9n//bObNfeNbCFeTpr4i5gI0AVhalQSHAkZOt/sK3DX4UFccE" +
                "Gbiy1RCy4q5sDbjrQN0AqrNNwAq0uWgSp23qXAFOCq5TLomTIKvu3afs2e8iFqNQ" +
                "mdyxuWW55tZOYnKfnxm+5GdHxvzs8KifHUSp3fwcTYzUubN++izGM1PHE0thmfOC" +
                "rJpUpRBgpeBLDjIKbiMh6uIfMwTrIHujZNoyYm/xYhtJGVCHADYEGADnQ8BWHt0C" +
                "DJa/joqdgkO4AmzZMyVRgdibv+Xg1gAW5Bsn/eIj3mgPeYOZ8d+dIIu/eoL/v3/w";
        String imageString2 =
                "s0O/B/C37ZXJMzQyqGEFeLaFJ8B/+abV/ydqNcDA/ADgX357pF4Bnvm22V8igVrG" +
                "BHhZgKljlwww8E8046JRb42t4p7XiLfrcsnUueskUVW4UjHJ0+Z5yiFq3CTJ0za2" +
                "o9cA3q4BvAdAwT0Q4F6aHEq4BFhgzXjd1uWnmtuAClgBlo2OWs2bOi/FCvAZAOOS" +
                "BbY+tBBwngZHfkRNDiADuHgZQ8EGWCoeoGxx6uUpwLKCAF9VEkW8DAEXR4CmpMrc" +
                "M3X1eAC4MI6KBbhGvaZgKVB1rwATdwP1OtDAFeCbJ3kjkGRVAbebqnNXvuXN/Dtq" +
                "6t/96zf//K69AmR/qnEYyKhYhnv+ROPiI675Z+LsL78DMHA/8HTu+ROvZwG5SBK1" +
                "hAmuA7x4EvDfNZktn6P2FeBQvauAXaPFKNuizbjZ2I2LDhQsuFvAFeAEyg0AD+Cq" +
                "UTFwZVLxHirdI76aegVZgEmg9gF7gBuWyR2n2jr9VEsbryl/RmsA9xCPcc3pUMXm" +
                "lkPAWeJvVoDPn8bFknCNAvgiJgUDuHCxFxdNVt3BP3An/7ijKMjg8jTl8o+s5xVK" +
                "IXWvhlE6VggBF4nBxSuADxVsKr6BizX1AvoWPysXPYF61dSQipU1o0yD6ly0KfgU" +
                "v3fKLz5GwbJH/LdJvvRzOdRdBfwL7njydHcV8DQJlQBPneulfdntfyDWCu6kTPH3" +
                "9+f8T9gcmbAD7BQc7Rj1F04EcBfpFy9934B77vZXUa1ZCHidEkiAt6TiCwDGNW9c" +
                "aPO3eL11gbYk8VW2TWa8w3MHqIKr5y5K3SN5CsAKLhmzjPJHcFNdmJ4dKLilHVfd" +
                "jnpH/Zwgj6FmACuh0jPTqvgroGcBi5L1vHDGrCDAI9gYgAVXRlkkwHkUnOtExXSu" +
                "PCB7o/wDh4DlnovX1JbERsmAQ8AGl9q3eB2lA7h4GxXfAco4sboKGMhqYKDcY4CB" +
                "nL9LjJ7AC0zw5pKhYLnpwh1q5if8fU+kYP0+f4YVxs/iopn6CPAv37fjmkf8GRoV" +
                "05RAU+cCwII8U0cJ9ecGA2wKDgHP13WZeqXgSPuQH8U9RztJsgC8YHAFuNGPMCRY" +
                "AazU6xS83irADBOwzcbOQMUA3gRwvIWyyACjXMENTXHXAd6lpt3vIwZjqT41N9yz" +
                "PwAsyALcBmAsw+vc2EUgCzBwGSLomesFcid/jnvOAjdzIQCcayKJUewlwToOWL1r" +
                "4HaQ1aLgfOc5Ei2AXhRgTM+LuG7rO5NVX+MfXgkWCnaAPQYNBhi4xdCsJKIskoKZ" +
                "Fplyq+qVgs2I1wAu3AXeXf7b4wC+eQLI36Ne/psAzpNZVwHfZtjw84mOyj+/BzCT" +
                "ng8nO/3Z9kskWQLMkEGQ67r96boefxabOtEKZDLpPwQKnj/ffQSY8idKi1GAF74P" +
                "AC8yFIgIMBajnl2l5FkjYZJtULtukSVv4X7j2AZueT1UcAL3u012LPVu44Jlu7jg" +
                "HVzwLso0A/AecPdQrQEGcrp/yCxFOZTuUpnURaOj3SwtFZNg1QIWXFlWNW9PJ63J" +
                "OgAH6s22oDQ1NaRiFFy4hIqv8JrWpAEGrhSc70LNPfpZQBpcYF/CQsDeDTJxOlhV" +
                "wBcvABfXHSrYAbapkWpeQdZA4T6qdu5ZcB9gD4nL91UHCzB265SZgb5z1i8+xSNI" +
                "5U7BAgzYys/ANcA8Z2hQTJ3vB2wAeLqe/jNw7UnJM0P9+vFP9dTCdTQ7egxwhPo2" +
                "0gZgpkGxTurgXwEcQdVScQCY0kjumSw5ThIl22zmew0kWFhSUFGtg6vnjgAD1QHe" +
                "A6hsX25ZCq4FTAmU7hHgToObau8IVNyNikdH/AzqlWUdXIHuA9wAsFsuAPos0yQU" +
                "Vwt4jM6VAFP7CmxgyqaB3E33aYh/eFMwcC+jTACr72y952t87RRMg8PgCvAdWahi" +
                "xoFFAMs8mhzqO8tFB8oNAT8AsEEmTtcADkCTUT/WmwLAJF553HbBAf5g6iUO0436" +
                "eKYLwNS+1K4yga3C5etZVDtH+fPxq3p/vrGPRgfuGbiyZdx0zBTcgJtuNFviuXyy" +
                "wY+cavSjTILWTMXdBleATcEATqBiwd1s7gwAh8o1sIKLScW7KHOXpEnq3acLJTtA" +
                "uQc8UwLLM01XKk0jI9VFkiW47bhpLN2BijUpElgHdwDQ1Ls5nnkAy3JdLQCkKUFy" +
                "5ax4iSnSFb42wFIviZbBDQDne8/xhhBc4usVwNUANshjqFPxl6y5Cvg2ShbgCX7+" +
                "Lr+r2a8AqxOFgtWStLakc9EPQxULMi7aKbj6vEOL8x7hAPjmyifqyaK/ba38/E0L" +
                "ZVGz//M3Tf7P1LYfzzEPphslm6INOUU7cuZsB8bzHG68jvZkfRcJ1kAVsOAuS8WK" +
                "wSRWArx0kmQLE9zlUw3+8ulG3HQnHS1akkDdwgXrKQUnqGm3aEfGibOmYFPtUKBc" +
                "Bxiou0yC9nDTDq4BHgBwaIKcEWAshWIP1MRoaQ6suYlhfysZdEcQd7sAzussHStZ" +
                "rpcnluunPh1k2nOJNiauWeYBuGiA26vqrQIGbr4XFQ+c5+cARfbs3aSzJQVrsGDD" +
                "BWXXoXsWWGc1gD1BlnopkYoAlnqLDwCNFZx6BfcBb74HKPXmd9i3ZMzfBHb9axIu" +
                "IIeuu3DrtMqk1sp/AvWfXzUY3J+/bmToAOBzXQz/24FMCWWQ2xgbtpvJTc8CfAEF" +
                "R5jdLjtTosVrARbYRQcYsFHZGZof2DrtxU2AmmvGFW9hCdxvgrgbp8WYBGjglo8A" +
                "7wquYi4A94ix+wYU9VafvGbUd8D4L03yJDPAjU3+Ae1HWQrLADjXT2IFXFmWMaA9" +
                "u9voPVMz60n/uTCs2CmoJFq45uLlPpRJHKZ7Fbhl3HR3YFKvWR8qHqW7RAat2Ft1" +
                "0YwGvXGgXmczw2JvDWBTLyq+KwOwjQUBLKg1gItALeJ+i/dQ7j0UihlYoOacXfsK" +
                "9ZIcEo8FuXjrFEnWyfbKP79u8v8JWFPwNwB27hklTwmwrAbu9Nl2fw4VLzb3+4tN" +
                "fVXAUm+MxClCwyJC2ROlrtVrPWP1rbQssfoW3HSXv0ljwoxyZ5OkaguwWyRRcdZo" +
                "4rjhBN9PdvcTi/uIvf1B/EW9u8RcJVb7KHQfoPtMfvYpdw5qLIX7laW7UDCqPQLc" +
                "hHKBCGAlVgKbB7CgZoEqE9xcL4DVcx4GhOBeHWLdhjr4Kq/pPbNvhaEk2RBqGsaG" +
                "cMG0JAuqe5VgXdOaDs0Pxd9rgFNr8iqKpP9cvIkqKY2KtzBmvsUJnjJKI21tePf4" +
                "GTOgTvD3TVA743bNAFwErqxwi+WA63/GvgohC3CQgOXvsBFy66QAd1T+81sAA/bn" +
                "bwP7SPI0hU3TZpzCJQvuFFCl4BkaF7I5ZdDUsEvUtyqRlpnfRrsA3K2drC4GDzQ3" +
                "iLcx3LFsVdkzT9k6cDeUObfR5KBvvBnaFs+tlk5/CzceB3YC6Nu4421Knh1lz4q/" +
                "FoN5TdmzT8vR2QFJ1QGqPXBwBRgXnWprOwLc3Mj3UKySKcVexd0QsIGtAqYbJdc8" +
                "wpYHVrwWAhbkK6ha3asx4MuUPV8K7TLfJwaXxnv5OcViYGHFqxiAiyRYhUsAukYy" +
                "dROljwPyVhNJFa9vNVpypcmRBggB2BCuABtYwcXu8+cyIOZvSsEO8lembKnbQN/B" +
                "Rf+Cgn+h/PnZAOOmv2sEbq/BnWYYMCPQqHWazQrZLHBl8029/hIz2yUy4yVALlPP" +
                "BoABTQm0TG0bA2qMZTcBXuFpcHHP68TeDTYvNukhO8BS7xYNjC0GBFtNHdTC1MO0" +
                "GpMkVAJsYHG/u3SgzEia9jrIkg0sKgaoqZjsuKrgHgCzenPQgopRcsoA45oBK8sy" +
                "wM8NkFn3yC2H1scTc02N/CgtR+a93nXgCjDPwhBKuxgCBq53CaXKrgD4artfutVn" +
                "kAW2ILjOrqH8yyRBlwFwFWgGuNkAW+assSAD/KImRDcpe6h5i5Q9xbtfAq73vRBw" +
                "4db31MGAdaYEC8sBGdAAPt3OuLC9CvgXAaa1KPVO04ES4AByhwGWemdR8wJbF4so" +
                "d4mWY0RGZyrKdmOse9hf6WHgILcsFRvgbn+F5GkNs/hLArXZN+xvYZvEXinY4Aow" +
                "UKuAgZyg3egA7zi4ehpgIAugqTYAe4Dr/RJwuq01gNxCDFYiBdhaM8i9AVjBzQ1Q" +
                "T6prdYnBP4Dz1L7Fq6hSkLHiKCAZ6BtkAJdQrkyAPRobpVu9oTEzDt2zKVhu+jLQ" +
                "rmBXiaXXeI5LuaGKaUdqWFBkaiTAhVtn+FrumJ+rMe8+Xz+QSqmD76ibdQRY3zf3" +
                "/SXgX060mHp/oYadZtIzLbCAdjar16zPmKFkwV2kll2kI2WABZnRngO83MhMmLJH" +
                "gFcxAV6tASy4zuLEVgFWgrVFDN5iQBCnQRFvZV2HBkUCmDsoeReXLPXuEW93KXn2" +
                "QtvnKfcssAZYkImzaRSc7qY8ItamgJtqafAzfZ2MEFHuEArG9DQja84DOQ/gPN8z" +
                "wLjjAm44j+npXRNk9aX5mthrrckvAJcMcI9fvg1kzLsDZFqTBvg6yke5BQHGBJi9" +
                "Zgb8fG37VAKMgjEDPB5kxEWSJu/+cRV7Bpg25V0Aj38dQMZdB+6bZO8+Hbb755gH" +
                "s1j+gYx4klUauecPTICmiKtTuOdpB5ivBXgOtzzDrHYWWyTmLuKWl3DHSy1ScTdD" +
                "/x6y6AFTcFRf05mK4m4dXAOseEtb0eD2j/hb/azKUscKsgGWqxZg4MbbAAzcJLBl" +
                "2zQuBHePxGqXGtcB1vMAS8klCy6WHiCb7g0BAznVhotuJQbjkh3gKlxBHqYGZsYr" +
                "wAWaGg6w4Brgi8RirHRDrpo/t+SK2EkMNuVKvViJ0kgKFuDybVz7HbJpzCAbYFyu" +
                "g+sACzKbkkU6WKZgEiuptwDg4u3TgU3gslFlUepFzd4DsmXgGuA7uOlxVDz+jSlb" +
                "cI8An+0IAON2f0a9H5gECbDgThNfZ/Sa5yxwZ1GpIM+xebFIk8IAA3SJGLsE3AhP" +
                "2Qo7UTGW3qIoOIqSYyRNqwwJVlHnGrYJ2A3AblHixHkmBkKjGxVn8W1L8VeApeAa" +
                "wEmaFrvtbf6uIJNAOcD79JKdOcgCnKL9mJKCZZ2tAG4IkiuASr1ZSiGZgeZpSRVl" +
                "kMElYy5c7WcLAxctBVdjLiXQOKXTMHDZ2iiwVOcAl67inql/Tb13iMOo1wEuTQB6" +
                "HCXf4PcMMEoWWGcANsjMfk3Bcs+3gRoCLigrvnMqiL1ywzWAAxWTQd/6BvCCXxeY" +
                "FDwJ4EmmQpMA/sBQ4MMpdp0FNQRrkA0wCgbwPJuOi8TaRcqhJSBHALyIaxZYKdhU" +
                "jEoFeZnBQbSxjS1LdrAUgwUYNyy4mwMjGEoW5EEAY8lBlt2pc7dQrrloVJsgC062" +
                "aj4sa2XDo8VsTwruxnjudxGHnSkm8/2UAPceAc7QyEij4NyggBKDQ7gGeITvKWMe" +
                "1W4V3aqrw7hR+tAOsCCHCi5eAjAKVuZcALJmvkXWckokVx5WHneAA/dcmujxA+v2" +
                "S3cxlUdh/DW4bE8WrqPGG8Tc60C8QVwdR7VKsO6gRNW0E8AOARcmqG/v8f0aF21K" +
                "vk3T49a3xwCXHpBk4Z4rk8TUSUogPQVZcE25NeqdA+wCLnlBUHtG/UjvmAEWZLlo" +
                "qXjZQQZmjNpWyo01kmwBeKWJTUrAO8ABZOCi3i3gCnIytIRU3NDAIjzHVEJLNjXZ" +
                "6yTNiiTf26fleDBIYwN3vI8dEHMPKH8Ue1P0lVN9uGsApwU2tFRnE8lVoNhawHkt" +
                "sCupEtRrwzQo2H++hkoBXNAiHXALgJV5HENRDPau8WYQXCl5lETpcqtBLuGWSxOo" +
                "d4IYbBYCvqtnALnAqYXiRUBeIn7KLmNXmApdxdVeYyf6Fsp9yBuB0Z9ir8VfxWDU" +
                "ae73AX+OG3Yu2p646QKQaxVsgCfrtLLDXnR9pz/JqszkWTpWKNaUS2Y8S607TzJl" +
                "hmoXsOW+i2aRvgCykqsI5U8EsFEZIKMkVoq/yw0tqBjIAkyNu66suVa9ir+oVpbg" +
                "dXIQGwI6QOPHAANWcLEdVLqHQg+GaXYAeR+wMgMs5bJqk8YOms+zrsNkiT9Te1Ju" +
                "OmvqRcEjJFrE2pzqXeA6wMXrLNmNj+JOgXwdyFd6ARrA1VP7VgaZvnNec95R4uYY" +
                "yRETI9W+JblmAb4jBQfx17vD74RWvo/bZrFOcAuADewEby7MAH8HXJKxB7xxGAE6" +
                "wIUHAoza5Z4f8vsC+gglP8bN3+PNcpffv/0tf8abIPyZ4uPGf/3mP7+pr0wBcRp1" +
                "TgP0E3tS02TGc9S4ZsCdwwRWtkgZFAkBG+h+1EyiFQDuRcWdQA0y6GhTmx+pY1xY" +
                "T5uynqX4883+Op2pTQYCsi3MwTXABnfE3x7GZQMxDsyEDNBScJI6VoD3WJbbk2JZ" +
                "qTlgIL8PTAPMU3APKINSrLoeMNtNq+Yd4+gKk6EMCVaWZCp3kRXZEGqOTpUDnFfX" +
                "SuoVXKx0U5DJmuWepV4t1LFIVwhjr9Zx8gP8ow/yjzzEPzywDextEi2siDmwnqmX" +
                "799DyfeI6ZcA4gCzQ1UwY67LMp2p9z7qfULMfgRo1GuABU/2iGHHtd/7ufE/+sXn" +
                "lGuyx/wMoIuPSeKe8TtmzQD+qq7ygSnPNPBmADltsAWVNVlsnu8LsJ4LDAWWgBvp" +
                "DxQc7b/kL/eP+ctkxUu44cWGNp6cJiS5kgnw8gVOHzrAwN5AqYq9Bljx1qkXuAmU" +
                "mxwmDmPbI7htYDpLhHC3WznRMEI/WoDlogFsZmABjEJlB4z9DhrO+fsM7jPAzTE4" +
                "yF7GWMHJXRo6ghqCNgXLLYdwi7cCFXu3OI9EgqWTgkqqaq0wxq4UcPNDAB4EzCUA" +
                "36VnrazZ4ErBAWRzz6i3fB83/UAJF6WQVHwFCwEXr51Afc38Od6AvrPH+K/wBHuE" +
                "h0C1BhfAebLn3I3f+9nrvwMqY0IH9Cne5Ck/G37tPWNtVoD/3z+f9T+h3mlAzrCL" +
                "PKVsmdcOsODKFrsACVzZMhYdEGgUzOBgmUHBMvvLS7jlCJCVPUdxy9FmYEu9oYI3" +
                "gSizuCvQIWC55oSDy3MHwEmyZYGNYwaY5y5L6XsoVy5ayk0BO8XmY0qgQwWnBmlj" +
                "Np4zwAeNbEp2N/tZB5hjJznGgLnLR65ZypUVcM+FmwAV5FtjDAZGrO71bmjYDzTU" +
                "6wArey4CuDCi/jMqHqbuvEEWPdGPHc+eLYNGuYIr8wBcus+b5gquFcDFazLg3jgN" +
                "VMou1FtiWuShXg/Axaf8tx4BL1SwSqLcjT9gLNYBuiiwgqonLtsB5kkv+s91lX9+" +
                "Vef/zEhPChbgaZKmGbnpULlVwPSZpd6lgTF7Rmg3RpgERehMLYcW5Rmlx6zseRm4" +
                "MSza2MrAgYE/5c8GIGshS8EJwQ0BG2TgCvDOMPG5heQqBLzd3oJ6mQMPBYD3cMUH";
        String imageString3 =
                "rNSkWa0R5DSu+AAXfNBBEgbg/aazxGFA88wCNVAwgBV/XewlscpTEuWVUDn12hPQ" +
                "1rliVCg3DWTvJqbkaozySKZNDZkUDOAgqVIMlhsmySKxkoIFuHyfujiE6z3gew9x" +
                "4SqNQsAFAHtMkLzH9LDlnmUPAQ3g0hNi8lPsEe73oaZIuOcqYFQ8QdyWm5Z6HxEq" +
                "nqB2gAcK/vqcAf7Pr8+acmfIiqfoLQuyEqy5UL2m4F7UCuAIgJc4wbcUwj0GmFFf" +
                "lKZFjAlQjHO4BphuVPRCo7/GgGAjVLCpGKVu8XXcwR3hVKFslIV3ThTssH2RpAxK" +
                "NDVwuqGJiRLdLAOMioFrgJVEAbZqrLnutQC3+ayZAQZyqp1NjSscQiNjzlIOZWk/" +
                "WuyVcgWXhKqAW5ZrLqLiglqSIVjBrQIGcmkcN0zN63GgrHAJwMx5iwzzS3elXgDf" +
                "BSYmyBZ7Tb3/Drj0EBXjnk3BN0P1WmIlwCj4Ac+nQBdczHvGk2Qqb4AFWQrGrv/W" +
                "LyjZeh4CFmTUbID/+W195T+/Puf/81vsmzpU7BRMqUTZM8fXgrsATLnmAC6uuhYu" +
                "MVhx2MAys43RsJCtkEStcpg61k651NxKBk0N7Fw0idQWFgdofHTU36I7lZRbBqzZ" +
                "GHEYwLs8E6GKdxV7Uewep+wFd5/nvgEO1Ju6CGjia4rT96kekiygOsB6ZoboYnES" +
                "MAPgjHrMDBHMNaupcSPInos3hiiV5K6VcAVga+F6wLVhggYKmHedSRIHyoqXUds9" +
                "we3zy1Kv7D5fy1jNKd2Ta0bRcs8PUTgKLj1SfMatykUzVPAeU0uTQQcuOnTToXq9" +
                "Zyj5hRSOOom7hQnKqXHc9HgAOX/7K1QM4Ce4aJlc9VOy6MkLnZUPlEcfzjb7v7Ba" +
                "85Hlt2nKHsGVzbbR3GD6s0DjQq55UU9MqnVmcAEbrYEbQ8UrlESrnJhfY0C/Qi95" +
                "fYjGBuurW6yvyuJsOSYv8pSSOb65QRNjC4vTtEgSa6Xi3Yuj/jYTom3ajnso2wA7" +
                "uAKMpeSiAZu+MuKnr46QSatlCWQ2M9L9PHvZ6qAGTnXSyWKIn2X1NTtGPYzlGSgI" +
                "aHFcLjmAK9dsFrrl4k3ak7JxXLSg0or0GAmqa+XR2PCuA+YWsO4NADS0Bzyx8gMA" +
                "A7fIcnvxCokYh8s8RoSl+7Q1HwP7ESq+fpJ4y99hgOmMWQyWiwb6E7lewD7HXlKG" +
                "veDr+7whHpAxy+5TLt39hkW7P6FiGiJPeQOEkL0nrOxMnqfRwXD+I7vIH+k8TXLI" +
                "+hOjvilsurkLyN0GebGPbUlUuwjsRea5S/SMl2g/LhJvlyiNlqhxl4i3SyRWEXrJ" +
                "y8RbxeAo7nmF7cZ1Yu2GVBvCdYDj7CkLcFzwUfEWrcgtYq6zBBsYO2TMUu/u/wrw" +
                "leEjwGxBpgSWqVBakAdoVQ4wBx7UqJDhPj3n7EgnC3iMCjUOvEpnSi5arloDBmrf" +
                "AklVgZrXBguMAgvUvQWSLM9qXv6Rcc+qfaVe75ZiLcAfDNYY7lqAib2lB9gdYqsO" +
                "lOloqJIrat7iNQAxWPA4Y2RwAVxiJafE9oYlWQJMBl16AdiX/JkZSddDGiUPgPww" +
                "NL2WAbv4kL/zEaAfMaB4TCerFvBkXQsdLXayAP0Jm8KmAT+LkhfpHy9IycBdAO4C" +
                "Y73FZtZ2ALpIOSSwS4Bd4iSBwVXcZdQnBRtcAR6kRKqqFxVLvbhhuekEao2zoRGn" +
                "K5Wgh7zF9EcWbyXJooe8S+a8SyK1pxgbKtdcNJ2p/T4W6yiFnIIzxNoDATa4nGwA" +
                "rEHuYVzY14yrZidrkLHgUGCFm2TPcssOLkdB1XvOMxYsjFCmhMdRBLnIKUFn3g06" +
                "WtbQCNqSnuKug/xQgFG84OKaS0qwWKorMTUqXie5UuxFufnrPOlceU/4u5RBG1xc" +
                "rcEltt+na/XofAhXoHmTqcERQi08oobGivdpckzgph1sA85Gx+SFQMEf6lr9X84w" +
                "bBBgqZhmhWxWpc/QJX9pEPdM1ryIa5YtkUxFcMkRYm2E1ZoIGxcRYm2EAUGEoUCU" +
                "0d4KZdAqYA0wcAV4Q0q9eNGPC67UG8IV4AQJVJyuU7KfeMymY7ytGQNwG90r5rh7" +
                "xFgBFliDDNw9XLEAC2hakHHRWXrJadQrwKZiVJsCbtqMtR0GCplhlIxVkytctLlq" +
                "F3dxyUUNFW5I3WTOV3Cl9J+LOqGvTQ25abpWR4ABqexZLlqQDTA/A2DFXou7rMZ6" +
                "HEnRbTnFm+xxAdh6z0A2BT9xgHHnAqye8z21JZWAkcTJRQvwU+KrgcQTCPAD+tB3" +
                "v8ZVCzCwQ8jeEw0bGjq5o4OtyrNNWGOgYPamPlHHTnPCYGmQsgi4BhgVC2wVrpIr" +
                "AC+TTMmiMvalomxeRHHLMSCvsr66TpZscEPIWyRVBrhGvQKs5CpO8yIhyNg2lujk" +
                "6iQAJ9q5k0OAQ7h7oXL3ALvbz1oOT1OtYiz95PQwcRjXnBJcbsFJdTcwPgwgZ1Fu" +
                "BssroSJrtuz59igwgapSqBpzBVnlE8nWLV5jWqbTaQXbt2JbsgpY6gVwmUSr/HCI" +
                "2CsF8waoBUzt63EdQwCZJ8c9CzcAhHkstJcokeSeBTfYuzoDZAHm+QC3+5BS7BVv" +
                "EsuWGUw8kqsm2QKuM8E2RT/jDfG2nY2O+paKg/uBjcdJ7OM5bs5BuQtDF/1FTHAj" +
                "PGVLAK0CDhVcBYw7lnJlMTLmKNMgWQxFrzFAWCORWier3kTFArxlgFGu1BsCTqLi" +
                "BO3FJInUjkADdJtdKUHeI2MOMmjKJVQr5QrwHiAdYFMypVCaRCrVTyYNWMGtKriv" +
                "kYEDbpeulYMbAB4DIJl0LWCp+BYqNrhARsl2Uw7qNSUr/nKQrMgqjsdpwRKrsEHN" +
                "S+xFwYdKsB4C3rJmVPyIWK2lOlMxv8Niu+JvYZy4yaK6pxKJ0simRZrp3gOqXHQI" +
                "2CADtfSSMEGsLdwD5r0/A1fGPBgr3Gdk+JQ3wjtitgB/bO6qfGpi2R21TpNQmZE8" +
                "zZEpz8s1c4B6EXOAI1Jz1T0HLnoZ1UYAugxEB3gFtcb0NfPcGMP4FRmvV+gxr/F6" +
                "A9ibQwweuGAsjhlglUSXeE2rUYC3ZbyW7dBH3unvpJPVBVxUi8uWcvelXNyxbH8Q" +
                "lywbYorECDBNIuUsQ8ac4SR+Vms4rMAWlDWj2sLtMQz18vTu8DVuWQoujgeZs8G9" +
                "iZuuXmSGapVUMdD3uGtDJwW9q0DCvKuUNteYLDHzLd1uPwa4/Ig6GPMeoGIBNrjh" +
                "k/akVnOUYGlz0lxzLWBNj1Cw95DnY8Vr4AOxaE9lznzvOZ2059S/KNd7xRvvbQh4" +
                "sqmjMgPMWTNu1CG+mpFMTZM4zTIdmhdQKXj4UvBk6mOxVwqmHFpiKS4CzOWqehV/" +
                "KZEEGZgO8GpHAFeAN4mzG5Q+a8TZTZ4JsuTkJRobAE5S9iRDsAZXgOkh72JyzXt0" +
                "q/ZldKRkByg2hR1Q30q5ZrjoNOd3MwDNUv5kUayeObLlHK9znAjMaVtDGTRJVnFi" +
                "1AAXbxOLgVtVrlQruNdV6pBVa5l9XFmzamBKmyv8YwJXG5MG9zou9jqAJxhMXKMk" +
                "ukkWfJc5cQi4/IjSiGMpngy3rBVZj3NHpSfseam58ZA3CG1J77GMr6l7vSc8n2LP" +
                "Lvil53z9nBj8iKz5CWDf8PvOXvP3veZN8oJS6THLAc8pkz6cb638UsceFvNbgZ2j" +
                "FJpzT743Q1/ZQBOTF9ibijCUN5OrplsluEsh3IgA0z+OYQaYey9WyYwNMMo19bJ9" +
                "sYZtkC3HcccCvUa2vMa+1BbxNk4SJcjbuGODy8Vju9S4u5RBe5fpbrH9uE8/2YEV" +
                "3MBwyXLLIeAUO81pMuV0L3tYI5RFIWQDDOS8QLP+miPRynE6MM/1C6p3BdrgCjJt" +
                "yeAKQsAKbhUwwOlYefSdBbZYA7gIYE+A1b26x+9cRVVXUZ8M5ZYfq02JulBwCeUq" +
                "cy49A/pz/k6Lv4AVYLMQrAFW+5HYjHnP+Dsfk6Ddx0UTg73X/PwxyLzh+BnvMVn0";
        String imageString4 =
                "xwaOjxJzP2BTDAoMLmrWc54kaoY6V4BnqGlnKYNk86yrLnBL3CKl0BLtxwiLcFG5" +
                "aAFm8a0W8Jog02JcAaoDvF4DWJC3iLWCvEGc3cTinVx0phgcghVcA0yGvIMr3htg" +
                "iyNU7hFghvwhYHtSCqXIltP9LX6aM7wZltWzqDV/A7A0MvTMs0QnuDnKIVmecijP" +
                "AbLCVZVJWp0Feqhe7zqu1RlXIAWAgXxbSReQZabeQMFlmhs2ObrPz7KW410TZLJh" +
                "Pbn+qPykyy8/7fIPnwH8+ZEVJ5QxS72BlaRczMCi3qIMl1x8Qtx+Shwm5hbvf82f" +
                "8/e+5U0DaDOp+ekZZdGUSYz0BHiScd5HMuhZlDkHXLnmeZQ6S+kzDdgZmhdz2Dy1" +
                "7hLZ8RzHQhYamvx5bLG5hUV4mhucJogCfJWNC8E142oiwT0OmK0NlUW45gQueYvE" +
                "aoNMeaMdwDKUunNtzMAGcIFM+bN3mT41F4DuV5WrTpbc9JeAic0CPIz1cSaJ5EqW" +
                "4xacnODKbgoygwcDLLiBFTh6UlBzg7s1dFJBJxa0lqOVHIOs7NkULBXLxWtrUoD5" +
                "RyX+epzY12BfY0EbDRpk3KngGuhTuGQA18Atv+AN8QK3rsSKfSsBLqmfXANYrteT" +
                "+33Kz4SAi49obgiw7BEbHa8JCQ7yG+bBHxs7Kh9xw5OM8wQ4gMxkie7UPDF2AcDz" +
                "xFnBNcCodp4dqUXq2yUUO9/ADXcCbbA5UchwfpHhfEyQQ8DrTIXWKX9WOjhdiHoD" +
                "BbP/LMD0lgVYFifWSsFbHWxzAHnn2kVsxN8TWGd8vd3DVImrjPYBK3PKTXO9Qpr+" +
                "cpqESupNCS4uOI16M9xElwKwnpkhjllSEuVxyYq3eQb5Dq6eBe7XUHJld2xoHIhp" +
                "mF+1y0C8E7rpcKhQ1MZkLWAUbHBd75nkqngDtwngIntXir/l57hxc8/ADgGXNDG6" +
                "Q9mk5obGf84th+oNAFMeoV5nhYeqf2XUwoD2np0FMuHAAf6EC/7IsL4W8Me6Bnaz" +
                "WnHVdK5IqubpJ88Adw5bQKkRat4l6ttFMuMAcAjXADfShyYOE2el4HVAbqDUNXal" +
                "1thRXsc22JmK05mqBZykzo2jZAFOCDBf716/6O9+AXmHztROVwMND1w1QI8DVsLF" +
                "sh1wDTBxNo0ZWMEdQM1cVpbFcrQj8wA2yKy/OsgFJVYqjRgs5H8FsMcCe4lD3IKs" +
                "yZEXTo20MSn1mtG5OgZYwwVBpsFhc182N0ovKaFeANngouCXlFkMFYqs43hsZwhw" +
                "yWIubjpUbwD4CK656SdqUQI4BF24z+snJ/3Sa4YNwK18JL4K8iQz249sX8g+1dic" +
                "4i1A50moZh1gKRhbxlUvoNh5wC5gS1ikhT0syqBVAJsN9RngDXao1tiNWmeNdYMF" +
                "9F8DnGT0t00StQXgJEMDA3x91N8LIe/z3GUiJMC7NDD2UeuBqRblmoIBzBleZxkH" +
                "GCULsuCmB1ULa8OS4QP3WQlwgVIor7gruwHg25RLWAG37JSr/Ss7AqorGDgtWGLA" +
                "oNpXgG00eBsXzn1Xypw93HK1/n0IbAGWMUEyyONnAQtcIJsJ8kuU/IqYLgVPAJnS" +
                "qPQcyJj3IoSsUqhGvfb6OcAfEYsdZPd88PW/fjNVA9iU/AXgqQtNwG4wsIvUu3O0" +
                "I+elYOBGUHCEUijS2wfcBkDLPbN/xQw36uDqybBgDRctFa8DW4DXqWOl3njonuWi" +
                "k2xdyLb1ZG85jivevU4cFuAbY77gCvQ+nSoDTOtxj96yVCwz90yt69Sbknt2gImz" +
                "SrRMwcDNGOAAco4l9rzakVKsAN9UGUSD4w4qngAy/eeCDnAz9y1c5B88BFt93hFk" +
                "fkedq3FUbICVFQus2pQ1gJVF624rzh8pBlcBvxJsIL/m93DPAlwUZKZDnkGmRJKK" +
                "lWD9GuCndMQe0ejAHGjv4VfEYAcYFQObIUPLMQVPEWNl09gMydQCMOc5YRBhxXWZ" +
                "5EkWxQ0vAbUKGPVKwXLRpmCVQrjedVZqDDLu2QDXwI1zTZHAynbYndpRMkXbUXB3" +
                "BfdmYHvXAXwDFdNq3OUK3z3ajwdAPOC+yLTgjtGiBGwA+QhwVm6ajFnqdZYLVSwl" +
                "y/IkVnklWDdwu6i3aJBRMp2rPHBlHl0rLdSV1bVyJsCc8/UUd1Ua3eRN8GsKRr0l" +
                "AX7M71p51GGAD1/1+oevaXG+BvIrxWM8geDeBTLdKu8Ffx8KLgvwE7JsAHvPiMPP" +
                "UG5oHs/C42/8PIBlistVwFKusykmRFNMh6bIlKeBPkNCJZuVsXw+h3oXSK4ijP4i" +
                "gF0OLcZzkRN8Syynx4AbA64Ar1ACydYoe2Tr2Ab7UxtSsBIrBgSCmwBqEqhJJkHb" +
                "MpKqHc7lbhNnd3DJBnj8YvAE8h6Tn11qXAHeI3k6AOwBU6Ag/gpwYMcUTJzNUQrl" +
                "KIWyWI5LU3LciFPA8pzM17PIpkbxVj9whwIFA9mbQMnsW+W546pEieQAl1nHKQO3" +
                "dBu4AowJsBobireBevlazQ3glp+gUKxEeWS17yMyc5ob5Rf82Zt+AOOucdHlV/II" +
                "QLwnwNS5tCVLL0MXLbhPgQxgQZUVn9P0wDxcdeEZSg6t+OyEWpXtlakWoLZT7zIR" +
                "muH87Sw2p5hLBr1AR2oBd7zIUzE3MGbCamgwFYoxEYrSRxbgGHcsL9OtknpjqHaF" +
                "xbjVEPBqLWBi6yaXasdRa5zmRYI6NwHUJFAF1pkDnKQsSmC7KoekZCmaBbldwAqu" +
                "bJ+rfFMAPqCpYXClVueeGf1lVR5dpSTClD3naUkW6DOb3SYGh2otTgCWhoZ3b4R/" +
                "fLpbet4FMsN8HSAztxy66ACwIAM2BOxNqImByS3Tey4/xp6g0KdHJrjKoEsPcecT" +
                "JF23ibkcB1UMPnwDZLlptSVDBUvFpWeo9wX1tIGtAfyCOP2KhO01rU7ZG37uHX8v" +
                "VnrH0h1QKwI7DVQHeEbJlEogIAeAAUqslS2Z0QhpbfWXKX9WBPkSV/mzebF6idve" +
                "BZmNjCjJlCzGoGCFkwWyVV6vUd+uc4J+nUHBFvvJ8aujwKUH/SVg4uy2FMypvyQT" +
                "oUR3g9l2bxPumRHhVWbDQDUVy1VLxUOcP6L9mGaHOQ3sLFmyLEPjQk8H2J7X6UcL" +
                "sBIpAQ7N3DJbGwVNjB7Sn34AZKz0cAS3y0HwGyRdN2gzOruJCm/SkeKsb+mWjDpU" +
                "GxtALj/B7QK3/KTHAJefAfUp5gDTufJ0LJRjKUWOgXoTGHVw6Sm/r80N1nKKdzFU" +
                "XHyAy1b5Q8+59JJJ0SvstSwEW/t8w/d/4H/TD9TBtYClXsF1gAX53wBbcgVsYu58" +
                "M3dRMhWKAXblUgB4hYFBlKRqmUQqisVCc5Ad4A0GBpucD9qSezYF04OuVa8SKUGm" +
                "JNoG6DZ1bxJ3vE1itYNr3uXzEaxEoo+cwtKsuKbpI6fpUqXpWKVpYGSvyABMNyqL" +
                "cmWmYP5MDY48k6OC6t0vAfN1fpR6VDNfB/gBgB9wrOUe7vsGIzvqXrMQrgArwTK4" +
                "AnyX0d/9jn9TrrnmELBakwJs530dYCAHyj2JmhlYvOXveNvpl38gXr/Fg7zl735N" +
                "wvWacFEL9cvXBlkK7umrKtgA01acwf0KrmwOk3uuVbCy5yVc8BzbjotqQQJ3Bchr" +
                "ly/6q1IydW8MyFJvLeA1p2DgBoBpbDA0sPgL3AAwjQwy5R3irBScFFxsl9ZjEvVu" +
                "CzKtR3PLrNakbrKLNQ7g0FI0MDJ0qDK44CyuOANIWRbLkSlnr5MwCW74dY7yqOqe" +
                "FW/lqom5eWXO3O/s3R9GvWOBglFxEcCelttvAFRwVfsqcwaqA6zT+iXu3Cjfw3U/" +
                "QMnPGBs+o5QCrFOvat8jwLhVxoJSsI6gFO/hsh+cxlU7wIKM238HYPrO9pQLfiPQ" +
                "zjX/ipJfM2yY6R+ozOKKZ5jlzjConwGozAH+EvISsTbCmC9C9jzH7tQ8G49R9pRX" +
                "gLt2eQw3HQBeY39KydURYLpYHLAO3LMA46KpdzfpKW9hVRdNbN3GdsiUd7gbI8nA" +
                "wAHe0esawAeM/Q5oOabGjyBnBBrlCnDuGGgtAjBZCuE6wFmg5ymPqhkzcJVU6dr9" +
                "vEojrl/wHh0B9tjYkGmY4I2jYlOuXHOgXp3WLwmwKVgqxh5qoPC/Acx5Io8T+8WJ" +
                "EDB7VWWglt+2BfaO5w9AFmCpGBdctbf63nkSNcXgI9Dl1+xkOcCzqHSOFZs5XPAs" +
                "pZADO8cQQbaAsuWuq4CBPM8xEgFWeRTjI2dWBVnuGrhS8RqdqtV+NjssBgswMRiw" +
                "a8xw1zEBlsXpK8uSirm1gImzCaAmcdNSsGyH4YEUrARrnyU5A8xkKC03DdyM3DTH" +
                "O9PAFGQDLdi44hwxN8t2hpQsU+2bYwyYp+4VZClZcC1r5nYcKVhW5Boki8EWh0PA" +
                "99nYYKHO4zIVB1dPAS7LQsDlB4CRilUakVhZe/IFTynYFtxx0e5ML2eO7BAZyZX2" +
                "rspvcMtvBBjlhoDLP/Ba8VcKFuQfKdv0fM/XP2IGOojNBni2n4+uYzAgm5MqSaLm" +
                "AT3Pc47ti3k2HQPIAGZStEQSFRmWiknA2HgU4HlGfUuc3FtFwVKxAAuubIPO1Co1" +
                "8ApueRUTWAPMVMgB3goB10KWgrfZV5aLlu2YmwY0LcjtfjJq7OAa25NSMKs3ablj" +
                "AwxkgKZJrDIkUlkHlqe9JqnKmymTprEhuKzh2FObGgJ8l4z5liZK9II5b6Snd589" +
                "q8ckXKZg3LT2nR9qJZakyZKrAK6W6mQCXL6HoWADLNBANsACTWkULLcLMOrlWIoa" +
                "HBrsm4tm9bVMDC5Z3BVgXP4P/B1Y4JqDRMoAC7IAO/sRD/KO8uvteRTc030cMCqV" +
                "UueBPS+ImOKvQAvwoiDLRQNZ8VdwZQvNXHJG3F29QkYdqleA1+knb1AOrTLiE2AH" +
                "V88jwMyGQ8gJSqGqi+bUwRHgNtZ1MADvDLFKS8sxRUJlgInDKdxxGrDZWwz3b6Nm" +
                "Yq3FXhIpBzYHWFkepcpc7M1T9+bZb85T4xbY1igIMKcU1L3SQnshtNJjSqZHZNLA" +
                "rQIWZPWdQ/WW7oQKZqBfBQvcw4eo+CGAnoaQDbBiL1YD2C22e5RFDrBnCj6CbC6a" +
                "cqikREpwvwQcgi6/J8ma6e6uTAPtSMFS8RFgK42AvMQe1SJgl1C6EiwpeYlGRhWw" +
                "VIzFaF6solpTME2MdUyAZWuUPA7wOgresPh75KLjwE3SckxybaAlWTQzklIsveUd" +
                "Ghe7mADLdodYZhdgg3sEWOrN3uaICmCVSRtkueUQbi1gQbbYq3YkUAsa/UnFHOIu" +
                "3uN7l3DPgisV89RYsPSITPpLwI+0YIcipV4AG2R2rxxgwQ0M0OxdqUV5aEkWzQsB" +
                "lnpl2t5ge1Lu2dqTxF8puBZwCRdtbpoSqSzAKLX0PnTRTsH/BpjR3rRcsbnoAPCC" +
                "VAvQBczA6smwwNxz6KIjnD6Qi15ktXWBWe4ittTVSk3MeFCQBTiEK8CbIWTBrQJm" +
                "zWaTTpUsAEwsZs1mG7jbgE4Cd5vdqh0aGHLPe6za7FHryg44O6SsOYV7dgp2cTdL" +
                "vDXAxNmMYi1f/xpkp2IDbMpFvcAtCja34xQusx1xhVgs4yNwbHokwLZQF7ppAX4s" +
                "Jaur9X8AGMiHzH6D5fYQsMHlNQfHpF4t1pXeoNoa9Vr2/IMUiyd40xAAfitXjUv+";
        String imageString5 =
                "Aq6+PlIwgFGyP8vBalMvMAP3TAwmQ14ArOAuCiwDgyVcsRKsuabzfpRP5IwBU7Yi" +
                "A2KUxbgVOlWrDBMc4E1akc7WUbIAb4Zwt1CuAZZ6mQglmBAlBJYseYces2wX28P2" +
                "L7MTTZa8R4l0gIIPeJ0i3qa4xyqFYs01U/pkmBBl6CkLbpbpUJZYG6iXs8GhizY3" +
                "TefKwS3cC18DVh+coc9VKD0kY36oPWedWghXYdm38tyJBcF1gB+TKXOgzBTMZaKB" +
                "gnHNoYs+fCQFA4jzvyV2r8qcOypzNKX8LDROCHo0OEovgPMa9b7k514C7xVZsmpf" +
                "oJaUMQvoD/yZ4Dr7ke9/AdkAzw4OBjEYNz3D5SVy1QbVYjCgAbsA5Pk+rhHuaOWk" +
                "A5+2wsfOzHBx9mxTvQGOsiwXw1bYpVq9MspRUi5eYQNylRp3FdBruOI17n7c5Mjm" +
                "Fgeut4C9QY+5ChjQcbYgt1BqnGQqgVLj2A57VDuouQoZuPsGF8AA3ccdH5BIpWhg" +
                "CLIU60xgMwJ7Z9gyZwHO4n7z9JirgAVXxoZkQb1mkqncIHdFD/NRr1hRfWbtOGOl" +
                "R4MszumskRodJFS6UOXLKn6lAAAnzklEQVQuf67es6ZGtCXN6F6pLCqHgC32ciy0" +
                "rMW6e4Ch91ziKiQdCS0/Az4nBg3wc54AVgdLgEtkz2aCa4DV2AhN9S8xuPwTf68y" +
                "53d8/x0u+yfeGD/x+yHo8ns6WVOdnZUF+smLY2P+PMnRLH3kOeKrwM4BdZpmxkeg" +
                "fuK6e2fTwBXgOU7RR1l5XWF3KkZPeZWO1Cptx2WuT4gwtDcVS8l0rAR5XQbMDRKq" +
                "TSZFm9xsswHQDcqgOOuuW5RBAivACc4M7VD+7FIKmYKBuyv1AnPfLACcQqlS7q8C" +
                "5lrfHIBz98a4QX2M1yRXtCEDyJRNV3VOqZ7ZMHc/D3HSwBlnfQW4cBdoVcDANcC4" +
                "bhbpPGa/VcCaHNG1Mnsg1QNYpRGfllLiQzJKXKZSNQGme1V+TrKFmy5zuPsQuM5M" +
                "vShX5VHJYjBvjFf8Ti1cVFuWconB5b/RC/8rf89flGELuiBTn7/Tai3jwk/tbRVU" +
                "7C9Qxy7ShVrABPpj43kW4PkYnXo+hIPPM3Bw9ZzmU0lmuRV9npi7LPeMW44B2QCz" +
                "GCfAS+1k1ShZCpaSDTBw14G7IdeMK5ZbFlzZFoADyIF6t4G5TfmzKxULLi3HXak3" +
                "BLxHlrwvuGaUSnzfqbcaexn9ZQT5/kUAy9iBZoCQ4ybYTD+Hwgf4hJVBDlQDVsoV" +
                "4NwwCubDmnND9IfVsdIxFNRbElwZWbOnTUlOCZbUqZKCQ8BlTZAAbHA1FgSuJ8hf" +
                "Aub0vlvRKT+XikPIzj0DOGhTApn6t/QWVR4DzH+betd7wdbGe5T/d/6bfwcyz9J7" +
                "EsMnf2Im/FuSNT43SYAxf4EesgAbZFMyt901XQgBHyl4iotNpoErwAtsPwpwlM81" +
                "WGHUtxKqeLmrmbNKbHZ0cAF4qN7ATR8B3iDuxtlP3kS1AryJkmVSsGxbyhVg6txd" +
                "DoYJriA7wPtfAFYd7AA795wRYO6QzKq3DNw8cAsPUDIuOccwIcvFKVXAQ3LNQB4J" +
                "noJcpJnhqaFBHC4/xkXLAFxkS7LITTnBMdBAuYJrRgz2VBJpNMhgv8TJheOAUdlj" +
                "oJBFBxsc/J4BDlxzmeSqLAULbGhW/+KWy+aaUbPFXf77LxkXvmYzxAALMl4FBZd+" +
                "4H+fIBvgtlYDLNdcBUwyNcuZ3DlsmsX0j3VnqgqWa54BrmyRq3mXqXWjJFOmYAGm" +
                "pxzp4pZ3A0zZ1N2EeoM4LPfsFLyhZIpOVZxMWZADQ8mhi97GPQeApWIgc1+VA6wk" +
                "a59DYVLwAdlxShmz2pUkVylib5rYq/ibYeyX4XrBNOuugusA5xWLsRzbkVk+jSyH" +
                "Sw4M5Y4CWJ8IyrNIYmVbGsRdB1gnBR3gAqcE1XOWay475ToXbRMkXDyL7f8G+Cnu" +
                "1Oa+uFcb8BNLq+oVYBQt92zdK7leGT9DknX41hoYgYJfMzbESn9xKuZ/x094DQCb" +
                "vfyWGBwqeIrTBg6wyiMHeJ5TfrMsyX0K47DF3xDwEm1HqVcWoyRaNcAcUBPc0GIc" +
                "ul5h3LfGWuuaxV9isFwzYONqRWKbLKkLrLM4S3OCa4Bx0btSMhMic9MuBtcAPqC5" +
                "kaLOzWBpMuf0TbJnmQPMXlWO9Zs8kyEp2AEOnmTXDPLNNRN3BdcA84HNBjgsiY4B" +
                "1i2x+vhXtiSLN3GXxwCzjaG69ykK1XiQg93HAQNI8VfrOYJrBhglVsqeTcEArlVv" +
                "2MEq05IU4EPcs8x7FQD23p4KXTSe4ye6biFglBy4aMEFNAkWnSp6yfMkWbWALYNm" +
                "SW6qsa7qnuWmF+kzO8AGmZmu4rCDq6cAxxjWrxtgdp9xzesqi+hSJRgmyOJkypsh" +
                "YLnnJDH3GGC6VHvYLnDlos1Nh+qVgk3FuOE0ltHTQQ4BZwGcZVMjd38kUHKoYAe6" +
                "QGMjd5nPClb8DQHnLgFQChbgh6pzcc9PVCodKdgAaxWWa/hdYiW4gloGsJscle4r" +
                "eybRCk/uyzWXsCrg1wB+iQpDuHoe9Z6dgnm+R8X0oA/JmsvKnAFs9oaNj/fUxf+Q" +
                "i+a/8yP/m37AuxwDLMgdisXD9KLZ6sA9y6RgAZ6nn7xAfTvD7XGKv7KlwS5cdKBg" +
                "AV4RYLnoGgVHBRhb5WPQBdYAo+QtrjFKEIMNMgOGTRoZUrDF39A9By4asCHgPUoi" +
                "A8x817nnI8C46hBw5jZdrBoFC64BVjkkVx0CVnmUV2sSwAUOchf4oEjnogtXmAeb" +
                "iyYOA9gjwSo9BbB2rsIYXLyJknVLLBZMjQL1aqmuJPUyHixzJKX8BHfL7FdWfowL" +
                "ripXkFHzG4y6twqY80X/U8CC/ANeQIDfAFhwZW/P+IcALv9EjAZwaIGLNgUbYPae" +
                "Nec1IwYLrpoaBljDfxTO6o2yZwGOcLRzOXTRpmCyaQFe6uBjdIC8DNgo663mplHx" +
                "GrHWILMcF2eQYC6aBCpBwyKOag0w7tnFXwMs5QowMVYqDgCzuhMq1z3log0wpVAW" +
                "S9NfNhctuEyGpOIMh8UUh7McN8kJamg5boXNs+NclN3SoTRKJD721QALrjMp+C47" +
                "Ww4wR1A8IJtxFbDOHEnB1fNGDjDPEsdCZeaefw0wg4Wqil9TGln85XtV9xwqWIBp" +
                "TVqZpPgL3PJbZsdy0z+pTDoCXP6RceEnS7JacdEyDn6zNBeot5Mkqwu33QVgDHcs" +
                "NS+i4iVBpiUZ4YBY1UWzmbGiOIyKjwBrhVYumjgM4NWephrAJFiKwSHgBG1HAU6w" +
                "ahO45zDJqgUsyFIxiZS55RrIgmsuGrgZAaa/nGFKlCbJyjDTDYzzSZwOzDFYyLG4" +
                "nme3yoYMTI7ybErqdroii3RmXP2r7lUVrrlpVCzAusBbMZj4WwWMiss6UKaYy7EU" +
                "556D8SCATcVAfskk6X8GmO0NUzEtSs1+Awtd9PsawNS5ZcqhkgC/plR6IzthVv6B" +
                "MeMPZNaBsXTX0lT5yDz3yNiBlnvu5LAZNs2HVsxh8zLWb2QLMrYzlulORSmPooBd" +
                "EWC6VHLTtYAFV5BX2KlaZXdqdaCFjlZQIglwPAS8TTmUIFNOkCHv0F92JvVWFQxg" +
                "da8EeP8YXJIskqh0CDfDGDDNEc8Md2ik6E6lmek6y9DcyDE1ykvNakmq38yeldlN" +
                "9q0YKBQwu98qrH8tBtOO9B7XAJZ7dgoexyWy5+xp19kmRrhejQSdWUmEy5Z7/hLw" +
                "604SJpm2NgAsuBryC/CPNQp2gOlclTUKpKlResnW5ctvKJe+4fm1Wfk9gN+eNDt8" +
                "y+lCKdjB/WSgQ8C45VmW52bIoGdr4FYBM7yP0MBY5kYbQY5xY5xshTZkhNJIpdIy" +
                "Jw+iKFcW4wOVV7oxIG+w4hpXckUMNsDMdZOYVJykBbnNc0fGfRm71LfmngWXbFm2" +
                "x6RoH5d8gGpTuOIDgB4Qc1O0IxV701xxlCG2plFriltxHFw9M3yGglxyjpMJeYE9" +
                "BjiAW0C9llxp1iu3jHkyxWDmvEU+KbTIR6/LBNVsnGW42xi3tZt6NdQ3wIrDAGc8" +
                "WH5ObNaTIyoWe1/yGsDlWsDa4uB0/pF6USuJVfkt8TtMrvQ8JA6XXrH9UQNXkMvv" +
                "6W695w33DsjvAKwyqRbwJ0Z+c2TTir+yGT5nSIBNxTUKXmSveZkD2RFOIETVyUK5" +
                "BpgYHOPw9Qq95RUy51UZZdFamD2vA3cDBUvFzrZwy1tsQsZZbY1zAiHJnczbfP7u" +
                "Do0N2S595l3akbtsaeyRIZtJxdS6BzwFNsVrWQAY9QI4A+A01ywcA4xyBVhxuMAR" +
                "lKp6BTtUb+E2gHVKQWs5mvfWAn7EQIHRYNlMvWrUp9YkT2tsOAWz2F5+DCju3Sg/" +
                "5flMT1z4Y8ohzh+VnxMCuNis/ILvKYN+FZodGgPoG4wjoDY1YsBw+I74HQI+VEtS" +
                "Cn5DMyZUrvcqUHEAWJBRchUwIz9BloI/cU53jsRqVkZSFdTBAWC5ZqdglUjL3P8o" +
                "wMv0mKuAUWZMcIFscFUeAdcB3iDB2qRLFae+rQIWWBnuOc5yenyUNVmeR4AFV5C5" +
                "DI0Vm31e79Gh2lcsln0JWBm0A4xiHeAMCs4C0hRsiRWZM0oW5DzuWcot3JIpWcIl" +
                "25kjYOKerUQCdPkpbtqG+QC15fYAbFl7V8qeBfYl67LMfKtwaWwcGmCaIjoWysn9" +
                "kiZI3JhTAnBt9lxWBs0JhjJrOcFIELAANqsCxkX/yM+QOXuv5aa/pibGVWPlnwTX" +
                "GbfsWKOD8ugYYBRcBRxCrlXwPB2sCGeMltlrNsC46igqDRSsliWlExejSMWC/G+A" +
                "ibtb7FDFaWAI8lYtYI5yCrAzU7IpmINoDjCQBdggA/s44EDFBphdqrQAhyrOMMDP" +
                "odoqYG5kz2MaCxb5fl6AUa8+tNmjPWkzX/WaZYAty0Vj+oxBa27YgbJQucAtCy73" +
                "Xem80eErIMs1S70h4ENdR+gAA7nMhaGaHlUBv+I1GXRZ0yPbfyamq0Vp3SspmNeh" +
                "ezYVkz2XyJ6PAf4LcP/C7wH68D2NDtfJ+sixE1Mwn2sgF30McAjZqXdBwwTVvwIM" +
                "3AAyH4ClRIvFOVmUkiiG/RrgLWKvARZkYutxwDpWioLHZK0omc9p4H4qwXWATcV8" +
                "wmcAmSuU6CuniLsyJVdWA0vBAoxLTpNFS8VZAUaxDrCeAlwQZMojfTKoAda8V4Cl" +
                "Yq3jANhO6z9ldPiM0SFq9fgASU9tSa4iNOWGgA+1khMCNsiKuU7BqLj0mOy3BrJO" +
                "8BtgB1eAdYj7BVsdL1h0fylXG8Tc4MnrH/kdUzCA39HNCtXrvf4WuCFgIB/+hTLJ";
        String imageString6 =
                "Af7UxqEzc9FNIWCSLIGlwTFvT+pgZrxy04tMiSLAXJYxHVpWsoXFZEq0BJj2Y5Qh" +
                "wpeAVQdv0cgQ4IQMwDJzz3LRFoePACcvslXJuaEdFOsA70vB1Lf7XKHvLMXXKcqf" +
                "lAALrrnoEDCJVBq4ctEqj34VMFf+VgHr2n1lzWpu6EAZ06KyJkbEXwP8mD8HsFz1" +
                "l4BtHQf1Cq4za0ty36TF3ScCjIuWAddM+1cM9uWeA2Pe/IJECbhmryh7apUL3NKP" +
                "gFT9K8BvOKAmyG9+BfB0B2eTwlalAE9xdaAlWcqiQ7BVwNxws0jitUAPOoJ6l0mu" +
                "lpnrCm40BBwlHpuKAblMD1qQrQ/t4rCaHHSu4gaYIyshYHvShoyTVMVNvYGCBXib" +
                "U3/bgoztMv6TgvdQrYN7QBPjgPJHlmKA8O+AUTGtyIwG+tS+XwI2N83s18MsBpNg" +
                "FYGrssjTVQwGmGxYkJ8Qj5/x/QkN/VExg30p2NwzLvqQzNmB1fMzpwZlh9S+JSVW" +
                "xN4gBju4PLWiI+P2HAf5S8AlTY3eoUolWFKvAyw3TcZcNMDf/YqCHWAgy01PkXBZ" +
                "kvVrgFGzOlkRbr4JAAOZRMspeJkBfhRbIR6vWhwW4DZ/hTFgNclSxhy6ZsXgWsBJ" +
                "LiJLki3HOflnLhqgDvCu4MoUe3HP+8x095yCDTDnkoi3sjSQAwVzEanUi5vO8DTA" +
                "NDOca85ZDKbJwVNwtaVRxCUXAOsAF3UNYRUwkDUWFGDA2l1XUjLdqyD+AvrFEWAH" +
                "155vBBlvwAZHFTCn93WCPwCsJ0N8DpjZgF/nj2oUXHrNmSW1Jhnkl3HRUnDpHS1K" +
                "lUM/aGyIin9NwfSfAwWbiulmtTbTvQpKJCl4rqpi4NKaXGI8uHyZtRwmR+ai5aZR" +
                "rxlwYyRVUZVGtCKjpmDWd+SqWcdZZ+dqXUmVA1yrXl4L8DYbkQliboKT9wmuzU/K" +
                "RrBhjqxwGcrOSPDcpwTaJ+Ye4JYPVO+qqUE2nAKmg5xmDccAc5YoI7uMi6YdKbCm" +
                "4ipgwHIVQ5GYW2So4D3jKqWwseHpproawMEpfUDJTeuOK3Wv7uNarSxCwTXx90vA" +
                "n4H8WUpmwb2kuycf44Yf68IV4GGe7rbieiSd/7XxoGpfy6BR91t+9i0x2dwypx7I" +
                "lAW3Cvgtx13efu8f/pUY/VcSLJli8HRPF2eTOD5KJj1F52qKWOwAC+7cIHNibnpd" +
                "5EzvInAFOMqJwNhVThLS1DDIIeAoazYqkQR4BZe8IuCoNyYVY6v8+YZ6zl8ATtKt" +
                "StKh2ua5TWMjyaQozoHsOCfvE6El+YQTAd4G8A7X6e/fZvbLUEExN4i9ir+0Jom9" +
                "VeMOqywuOcNJQAPMTTg5WpE57pSUavNALXC3ZOEBirW2JMp8QhIFYO8p67G46aI2" +
                "OLRzRd1rFmbOake62+rKAC6xcyXIvwb48LUOeHezpdHtf37LazYoyxwPLWEeR1QE" +
                "2NO9k4L7+ARQecP8SMxm3/nwnRoc1MEaMGBKsEqKwWpF0tAo/0AcRsHlH/hdACvJ" +
                "CgDjzv92gWuUmi5U5jTgZ8AwRddqWo0NUy0XgWvhDqAGV4CxJfaeo8AV4Cpk4m5V" +
                "wQIsV00GbQqmqxXjZOAKLUpB3uBTtA0wrck4QGVJXgus2S1eS8UouBZwYiiAuz3K" +
                "wTPUauoVYC4j+zXAKdR7wJZGlvXXHKcRMmTJAp2TiyahKjAGzLOOIysAV1bUBuVT" +
                "ThECuPycI6PPtOgOdAMM5PCeDY/LvO1DnLlM1FPn6i5lDZsbZT7MysXf4GoGuWvA" +
                "GlxeA1eAP7/CpT9EhQAu6wySQQ4Al7jvyrpY74D8np/74QhwKcyeNRr0XvwZyLjn" +
                "v/PG+otiMl7gHW8OKfdvfP0PZsf/YOnu5/qzHD5jgqQlO5Q6O8iuMyAF1tkiJZGD" +
                "vHyZDUqplzus9FzhioUoHzC1PEjjg1XYZepfl1wpwYoyYIjSsoxx5HMF26AluSW4" +
                "9Jt/FTBwBXibgX588EJVwVLyNjfeSMH7gN3jtvUDqZijJqk7alfWKJgu1cElrvNn" +
                "/SbNwnruAVcYcvQkC9ScgWXJHdXmMT2rgNV7Bu4xe65Fd84R6VA3R1FKukyUT+oO" +
                "1MvE6TatSl0kysfQle7xD0tiVXpBm1I9Z8zghoANLoD/6x3xGPcswIfAPUTB5ceo" +
                "UEaJJPd8yAEzAT78iQ7Yj3zP4KLi9/w3mPV6T/9AKPkdQPkeMM3+Rq0ssP/B79YC" +
                "nmRbwwGeA/AcC+0Orik4BLwE+GXcs7noEHDsGl+r/zzEjXccR4nw6Z0CXIXMfZEG" +
                "mB70CicDNzk/ZArWiPALBZubDgHvsA1pcVguGtecIAYnuZRsl+nQPkAFeB93bIAF" +
                "WbCrLpo/G6kDMJ+4wpZGVqoVYGBKvXlWcAwuqnVPU/Bj3LMpN4Bcfj7G1wAmDntc" +
                "y6CrCI8Bvs/dWCi4CpjPOfr8egDVUk79bwB/1gwYt1zm9nZBLnOxmQAfMmA4RL0B" +
                "YDpgbEuWbD0WeOw+l9/jMeheec/+yOmH31MefXUE+O+ABbIAhxYo+EP9aeIvd2Kh" +
                "4LkhThaqD83rKmS5Z8VfTiwYYHafYwaYZMvqYTJpdp6jMlz0McCoOMa53lg4SRJc" +
                "Zw5wXHFXFiZZpmCBZqgg5SrBSgI5yWcE7jM12mf1dRfAe1Kt4DrjgtA06k2RMe+z" +
                "nSEFC3Kaj1UX4FwIOIB8pNwCCZXMYq8B5kywxWHOIT1RXMZ1y6z+pSxS/QvcQMU6" +
                "iU8ChIJ1HOXz634zB9kpuFa9UvDndyj8CXFScB8DWnBR7+H7Ttw4gAVZMVgKBnJZ" +
                "e1chYO/5n48AP0fFctGmYsDiosv/4O8B8uf/4GzSL7hoAf7AtqTgBoC7SK5ocDjI" +
                "BpiuFYvtgYJx0Vpwd7UwYK2LRWkU08iQfSvX6JCbjqFiueg1reXUAlaDw1TMFInY" +
                "m3TuueapLDqATAZNWXRggFmjNcD0oZ2bBnKauzTSJE/7QK0FfDB6mpMO9KCJt1nK" +
                "oRzlUJ5BgnPNBlijQEE1F41qAVp8TLMjBGyQn/ImUC9at+Vokd0+pQwV8xHsJa4B" +
                "DureALBA6+YcF39rAX/+gTgs0xaHVCzA3J5z+CODCxRsgHHRh9rBArDZX0m6/oIr" +
                "Jov2nkq9f8J+RyxGxS//ELjk/yDZ+xuAZf/R+AVgIH/UJAmoGvLPUfPOEVfnuf11" +
                "wWIy7llL7bjoCCVSRE0OU6+eAqxD4AJMJ4t9K5VJazxjYUcrhnte4zMA/w2wlUrM" +
                "gjkRmOTUwbasBvA2m5IJYrEUvEvGfABIS7AYMOzpa9ZvnIIFOMNlKQccFkuN4qJN" +
                "xbjp0TPYaRbgOU4aAhbkAg0Np94ig4Qg9nKKvwbqEWDBrbHn9Jp15leQ79NTZqH9" +
                "8JWDylMl0VtgvwkSK6nW2ecfeC3AP+piFmKxAHNV4eGPZOHMgQ9Nwdq9CgCX/8r3" +
                "AHz4N94QDPS9l1/xRqwBDGRLuFCxAf67VEyy9X+j4I+tDPw5+jmJgj/UnfJn+EhW" +
                "AxyOC6XkBSAvMhpU7I0w+11iTScALLgB4KiUi+m5Ctg1AcbWmRqtkzmvctZonQNl" +
                "FoO5jDvOnRoJLuJOmvGxOgwZtuhaJRgebFMm7Uxwwn+Cm3TuUhuPceh7jM8sZKAv" +
                "F21gq4ApjTg0ZsbZogz3aFj/mZo4za04qavMgy+fZy7M5yaxhpNFuYIbqBjIlEGC" +
                "XKQsUtZcUGlUq1wUe6ReufEAclmAX9DV0lMDBuLvIVchHb4lBjt7NwiwQbJm/pwW" +
                "5SFHU/6L+a8B/hHIAqxVnUe4Zw6ZfcY9HyrBEljsM+ePDom/isOC+/lvqPuvxFka" +
                "HGpRlt5+R3Pja+IwigZy+e+0QVFvAJk3zj+0VdnBXjRnjqYwPT+xB22ApWJBHkDF" +
                "XBKq+LvE5sYSA37ZUScr6GZF6Wgpm46y7xxjqU4ND9XBKzQ4VoC7ps1JPlFsi88E" +
                "3AJqHEtwy3oSSxB7E8qq+eCLTcqhLRQbp7mxzaWgOwz1d2ho7KLUPblnAQauJkgC" +
                "vc92hhSc5gYcwc0KMCs4rsGRdjUw48Asl4U6uA5wnl6zIAtwUR0s4BpggywXjek1" +
                "8bfErrO5Zx3k1gz4EQkQpVGJp0aEh28ZRrwbAg5gQ/usePuGbPolIHWom89dsOz5" +
                "WQMK7wCiFgJQ23uOlCr+ctD7GGA2OA6l4L/xsyy4fzYVA9hq3/D5I7Dfs7Lz4/fH" +
                "AB/+XTtZIeAAMp+2gppnaHpMk3TNUhPPMBqcZXtD9e8iTQ8bOPD1Ql+rvxjaEs8l";
        String imageString7 =
                "smdl0JHaDFrxl+aGFLyBmjc0RQKw4DrACa5cMMBk13HGgoIc54OX44BW7E1QGiXH" +
                "+EAOZc4yYq7i7xFgXgNUcB3gLG46fZ0JEnANMIP8DJbl4pQc1x7lmPfK8pwvyjMa" +
                "VFuyQBerQN+5wM5VgXGgx0J7kXKoSFkUPOlaqfdM50qmJEvuWeux5Zco+aXUyLz4" +
                "3TCAjiB/fitXjTtGxYcvUeJzFMhnGpVVGin+cmv74SvUrfj7Hhf9jsRK8dcpmObG" +
                "Z1OwAKNgbU5S8wrwIWADAzSAy+80D+Y1VgqeAszRlVDBH5s5qsJxlWm+toYHkGdY" +
                "rlMGHSH+ulrYXLS2OWhwLHGmaInaV2ANMJ+j4EqkFdS8zuxXFgAO5sAJPunETKAV" +
                "g6VgYnCCeBtHtUlAV0skAAvyDu1IB9hKJNQrBe/x0XJ76kGj5CPIWoCnBy31hnAz" +
                "wM3ymQq565oohYA13NcaLJlzkQ5WoGAaHorBnPct0tjwHvAGoP4tCqyrfwXXVAvY" +
                "F7joELBq4ABuCBhX7QBb7fsKwDItuAPWIAP6kPsnpV6LwVzq/dlctCBTFnGpSpk2" +
                "pZRrgIF8+BPf+xLwWyZJbwWY5ocAv6eN+dMpjQubAcyoUHCxSc78fqIf7QAvotwI" +
                "vWcBXuIcUtDNAi5u2lZmLZN2ZRLumQza3DMueQ3Froe2yXODMaGe8RBwXLHYAQay" +
                "kiypWIC3icVJblyPh4C3LxKDccVKtAwsJdIefec9VmL3FGuBfED3KkNTI4ulGeKb" +
                "ggGcZt85A1wBzl7TRCkAXCAeF9WtArDHU4ALuOSi3LIgK2OuJlY0MJ7Sl0axumvS" +
                "Yu9LlgAMrhQs0LqljjhsKhZcvSbRcs0Nal8DHIIu86EagnxIkqWTDKbgsESy4b7g" +
                "hoDL73gT/IXSR4D/CvgqYIAKrOwNJiWbek/6n/97m5bumtnJ4iQhZ33tyWK71nYE" +
                "eIGyaYlzvw6wulhqdiwqBjvAJFzKoi2T5sB2lIGCDRzCVqXi8CqwlWBt0NzYDGfB" +
                "5qa5fuFLwAk6WIkqZO7rwGUnqH+TIxdMwXLPViIZ2CPAB0Devy7IxFpO6GfoQQtw" +
                "iribAmoAmKG/AI9zN+UEyn02dgRYKmagXwSqLABckzXrrisB1kqsTJkz8dcSrOe4" +
                "aeteAVgXi8pFK4M2wDXZ8zv+zKmYEulQN+gwQTpUicQWx1GTA4Dcf2Vwq4A1+OfN" +
                "8FfKH9qTcs3lH4GrCZJMgOWiicMC/Pm/t/j/9f906Er/+sqk4Oq4KDbJ8RTBVg0s" +
                "uEtAFWCVSFJxRMmWA4x6tRcdAEa57GFZH1pQARrFXUf5jCLZyhADh2HOKHGCYYP1" +
                "2C3FXKfe8BnUwdTDUrCpGMDKqjmCoji8i5s2wIwHd69yX0cVMp+PFALe1zRJrpml" +
                "9jQflpG6QsmEco8pmMtDC8A15Uq9NVZkJecIcI2ClWTZzhWl0XNAuxLJamHKk0f/" +
                "P1ln99tkGcbhP9MYjWcwviYgqCQD1BNjooEjsgwWYF0rQRb/CpyujG24Lxhs7baC" +
                "dOv6lmNi8Lru533ad3hwpzUgJ1d/z3N/P5oNdUCb/jrgCrgfSY0SMuFRkVUcgPW8" +
                "+ZFwB/fp4FDF0T15h8RF7OCoQLZMeN+7F8gkNgqdrCrcAExX5f3PPwwe4ZH/fjEB" +
                "XqCaZP75CeMqkaYEbCQ88KBtdjcPvUJSI+ACOFRsmCTkDBivecV4twJ4zdCI0qBw" +
                "VwNwgrzOU+mbE1+yzsE5JaYKKfBHTZjU5Db3sHHwNipOx3QC3KLA36KJXcAt6sBt" +
                "iv27TAxadNilLWcP28c6qHZf5ZKafM2q3zeAND0ZKUrSkxYduhQUTFW+5e41JPJo" +
                "7k1VYNOS4zGd498jJ/ZjW2zZmiNYl5px94YHLWD6ne2W9MXu+H6LO5aVwEcMd/en" +
                "LxHzXokYWI+6IP4tKnAFbIhU8M5Cwf3bn/beRc3RSWkFie+kJ8OYXCjqfDdzVePI" +
                "JiwqHqJm886/aXzXHvB3HuKczY2natJfLCprmsUStIAxFdzEwVq4SNh0eZyS4Tco" +
                "OQFeKcOlgExXpXAz4FXUa+F/jePaOHgVxQZgKklrgBXwBhYqJou1OcG0w5UxBsIp" +
                "7rPLKmezRoCBSpdkm0kFw6Q2UOOINkQiF72HB63pSe+j2n1TldR8O/kO5v4dAi5z" +
                "0Oafuzw516XBTrPI3+N4DiVPXR8BxtHquXPDKlLseuZ7AEbNAp7kcwhYyLbjCBkH" +
                "idDI4e4eD1z1qf0OiH8LFGwGy7WEAVa42AAPelAXPDD1osODJg62yd0wiepRwSRD" +
                "wKW4EAr2iCYOjvqvUAE9EPKjZP0Gf163L3r83PvHp0/gWJ2hkmRVqQQM8EX+u4lH" +
                "vcDbu02Nwe6n7LpaBvYSNeBl4VYAP0PBHwPeoEV2CBjI6xzVAZg+6K0yTbl5FcjE" +
                "vi+sAV+j0M+9u82Ad4uGduPgNns0tN2bKJwOSZWcHK3jgDsBmAIECu6U3nOHl8i0" +
                "f7hz31ItSgoGsN9voGLCpGR41OzcsIPjULDs3OjpRWfAQhaupqOVvWea7JKCUWsA" +
                "5rjNgO8CeYpYmZfLCkuD5p7Z3u7dOwBygK2Rv9ZmOdYtNLCuIQDP8O8dA8z/x+Sg" +
                "eeciWmMBaLnwLscydy5ZqyHcBJkfxK/si6aD4/3jM3jPp0+GLTiPJNxsHNULTPIH" +
                "ZAAvXhrHWJlEGrN5/hRD4Hznrl0hXHo2wUvfQA4F402nbBZHNUV+a8FhqHgImMmF" +
                "LewVmavnQBbwFrHvljEwHnSLLFaGG4BvAJmkR+sHXl0pvemsYD+HgFWw3nOYHjbj" +
                "KzpatMV2iXcDLoBtzemy53kEWdiAZt73kHVIYRYWYqhbkPY9VwEnz9mFKgmyCh4B" +
                "VsUFjpWvhvZdTahF/IsTVEPNGW4ABnJdZ40fAznoAYWGDNgiQ1HPxg9gln+nZnID" +
                "yPfowwrn6jMg83dKBQ/mVDIFfwHbxZEB+/kne6+GgD26uYtHgIV8Dk+aH8Flvl8Y" +
                "Y/vOGI9lAZuJwmXGVJapAetJRz4aBW9iZrOOAWZJ9xbZK8dVXlk1wl4AObJYZrNI" +
                "drRZu3AMMKnIPSDvsOq3rYMVx3Q6ogMwR3Y+pnOIZBzc4ZgWsBbZLBIaXe7fbllF" +
                "6gq1ouRDWnQOcaoOGC7rMjXY+5mSoGZpULPQEOFRGRrhQeejOR3TqMcuDgBHkkPv" +
                "+TbOVCXB4TE9mC0hq976pbBC54rVDAP2YaXjmWPa45nJfcOjwiOa+3cIWE9awAGZ" +
                "T47mAg9awO/myEULOFpm2Rwr3OxNz5PwEKygDZeatMp6RCcFCxgni+GzxQuneKQD" +
                "r/viSV5DG/uwxOjo0lds3yFMWjMWBq5moiM86axgHKwEmHtXFZdK3rrKm8EC5siO" +
                "XPRN3mzIRzRw91B1i02wO6wZ3KO57piCA7D3Me2yhkjlMf3mJzJaAibJEWHSj7y/" +
                "ANAArIqp94ZyAzSwac8JbxrlHmS4fv7CqCgW9y5r+ftT1n01QE+qbhMYKBgnq1pF" +
                "KigNDu7R2SFk495beMO8w/CuQaw8S5arChj19m9/wY+DezvuX/4t4QZgIQOYTFZR" +
                "KvioZrqSMKlUcX8GyDXuZtT8bs41SgImsaE9PjUCHKAJlxZIgiwyJiroJg3vQn6C" +
                "LZvguA7kCX4EqHjx/BiATwIXyA6a4WiZplxnqdlGmcmy6W7VOxjIetACtrMjA36J" +
                "ii00vCyVvK3nzEr9XSwd0VdDwTpaAt7l5c897t0M2V6sjk4WsfBxwCnZMQJsRgs1" +
                "8zpK12KDCQ7acg5IT4axjj9CJZIcB6wmPBxCToB7zBv1Jk12CNnOjQT6yKVmHtEA" +
                "Nv+cS4QZcECexrHymJ4kLGqQCGmg4grgwSz/LlODAdkeLCf3uXuLOnC1jwD3Z3Wm" +
                "hGwMDGgAFzUh8/nA6cIK4PmzvABegTwP4PmzJ2ilRaXcxeaiBdzkaFbBAtaW8LJV" +
                "cQa88i2b4PGs1wScIZvoIIu1jle9PjH+YbMCWPUKWcDbOFY77JaMfDSTDQLeE7D3" +
                "sQrmmDZlGcf0dyQ/SG5kwJ24hyk02Dqrgo2HhyoWMs3vpiqBOzTeOerqXAn5JnNK" +
                "QkbRw1iYlfwjwEwUqmIdKwEzf+TbgwH5jsc1sEPFxwELulDBmsWFO9yPqLhAvQIu" +
                "GqiY+zeO6QZ/TousgPvM/oYHLWDBekSTpoy7NwoMwDVrJeBZfhQBmLu4pgn6EwCf";
        String imageString8 =
                "Q8HjScGh4tLh+oPjep7ER4LMvQzsJxQenPIX8jJ38EoJ2HDpKcdyAEbFf4ezpcMF" +
                "ZJMe7JVcd6qQ0Ok5at64xmJwpgizgquAXwG3VdpLiv3tGygYE7Je9C41330KCztM" +
                "KbS/5y6294o8dLp7kwedKkn/B/yGQsNrPOohXEHzUllXY7G3OWgLDYdMMCQFGycT" +
                "E+tNh4oZF6XBTvVqPiop4IJPx0KtAcfeKxVMH1ZWcLqHhYvTNcPnjH+X0MbPEnCC" +
                "zD3cwHSwpgDGeGhBq2w6nkvA1fs3UpLCLSEPAScVF7VP//0PAAD//2f78CwAAEAA" +
                "SURBVHy9VZNdZ5au63/Tce5OnLO7u7qru4sMZbZlCyxIZmYUM6PFLNkyFey9q0xi" +
                "Sik5U8lKZl6gc5tR8Z3nHXPOlUuq6n0xYq5MpeQIP/kO/r752pP8vKUneXnuSYFn" +
                "dXk57nFWullddroL7ElOunuaneYaCrNdU3mha99c6do3Vbpnm6vM2jeWupaiDNda" +
                "muU6+Ny5scSsa1Op69pc4nq2eNa7vdyZbSpy/XuqzQb2VLkhbHAvT2xkn2fD+6vd" +
                "8N4KN3Zks9n4kU1u/OhGPte40b0lbmRrlhvFxrbluPH95W7iQLmb3F/ipvYUmE3w" +
                "nN5buGz7+bw7x83uyjKb2c1zd7ab4ymb34sdKnQLn1e4hVPVZounq93i6Sq3eDjX" +
                "LRzIcKHjhS50qsSzM6Uuctqz0JkSFz7L5wvlLnwqz0V5Ri9VxCxyucxFrpRjZS56" +
                "tdRFr/G8Uuwi13neqHKRL/nZGxXuxZf82Q3+rfOJLnI+AVvvwlcy+PMsz66muvC1" +
                "FBe6luzC15OW7Qt9TuBnP3Phq5+5iOzamr+9Vpeba4DrBLiwwD0tKXINFWWuoarc" +
                "rLG6wjXJaipci6y20p7tW6qdmQ/4GV+3lue71opc98yHK8gB4G4A924pNevbXuZ6" +
                "t5a8DHhftRvcX+MGD9S64cD09dYCN1ibBfRyN35kI4A3uYkjtW78UJXBNcBAHt9V" +
                "YIAn9hbFAE/GA95X5GYOFruZQ2Vu7lilmzte5dmJSjd/osps4fNqN38SsJ9XuoWz" +
                "tYCt8eACOHSmyi0cynKh0yV8D8CyfwA4fBZo54HmA45cBhwWucLzqm/XeAI4fKnA" +
                "hU+n8EsBvC8EutIgR2+UuvBFQJ4D8IUNLnSRpwB/kQm4VwH7oL/k3/kqzUW/zXaR" +
                "73Jd9A+yHAAXFS09LSoGbLGr962htMQ1VpY7D24lcCtdM2BlAty6sdo1Fea4Z9s2" +
                "uo4dm7CNrnN7LVbjnlUXu/bqItdRIyu0Z2dtgeuSbSx03TI+924q8ADvrXED+wC5" +
                "rxa4NR7cgz5kAd5e6Ia25LnBjZluaHOOG9lZ6MYP17gJlDyKcke2ZLrxLagYyBP7" +
                "it3EnkI3iWqnADqFmqcPlrlpoM4e9mxGzyNAPgFMAY2zhZM1zux4OU+gntvE/+TN" +
                "2EYUtRGoFW7xZJELfV7kFmUnC1ErxjMk02fUGz6Vb5BfXEaZVyrNoleBFwOMugEc" +
                "uZjHfyMTyECSnU8HYL6Lfq1fiKxlwBfWu9AlIF9PR52AvAbkL9Jc+AZff4W6v46z" +
                "b/g3vst24T/mucgfc//2GnCXnhaXuKfFRS8BDiA3VQNV5gMW5NaNVa6pOM+1VBS7" +
                "ju0eYIMs0FurXFtFvmuvzHfPKvPMOqryXUd1ruusyTPr4tmzMd8931bq+vdWuwFc" +
                "8aAUDGCpeCgGmO9tK8RQ8aZss6HNWW54U6Yb2ZHvRncWuLGd+W58N+rdA1yATgJ0" +
                "CqAGls9S7MyhcgMsuNOCe6TcLB6uPscAA3d+f7ZbDACfB/SFzahpkwf4GGCwxROy" +
                "XIDL+B4WPpnr2ZkiF70ol/x/AHxBgAF5FlgCfDYFw82eS+LvAelSqotc5s+uAvIa" +
                "4L5AnTd8+4q/9xW/HNjLgNNc5Bv+zh/4uZcBLyt4WcnFrhF3bYBRcWtNFaCrXKtg" +
                "V5a4htw011Zb7jq2bUK9mCm5xnVsrnDtQA0AP6vKc4K8DDgfwHmuDzctyAPmnj3I" +
                "Q8AeOlDlKVng5aIBPLSdJ3ANsCBj4/vK3CTxeOpobcwmD1UCsRqrQLmlwJUtK1iA" +
                "Z33Ac0fL/qGCF4m/8/tziMcCsMmFABzxAYfOVgK5+BXAHlyBDgBHABw5h7u+7EGO" +
                "Xq16WcHXidUX+PnzgDwPqLOo0gATS89iF5JxucTjr0oAWMyTX5ivCviMd/gG+zrn" +
                "/wg48i2/EH/I+ttr9RUVS/VlZbhoqbjE1ccpWaAbyopdE5Bb4wCbmyYeN+Slu8aC" +
                "TFx1LUpGvQK8rRrAla5jS7l7FkD2AceruAcVKw4b5B1lKNcDPAhsQR4+gO2rjAOM" +
                "krfkvgR4TInVwSo3RUyOQT7M1wfL3fTRKkygAe67Z7nplwBLzUfLY5ADBS8qDh/M" +
                "c/P7slBouQsZXCl4sxPg0DkP8qKU7Cs3eHqAc1zkbCGABRkD8kuA5aoBHDLAKFGA" +
                "z2X4gBM9wBdxxSRbEQMLYEH+hn/rS5T5DaC/w74VbP5bX8epWC4aBQtw9Nt0AJdX" +
                "LjWUk1DJKoBG/G2IgyzAssYKsmRctadinqi4MT/TIDcX4353bjbAHcThDrLrTiB3" +
                "bqpAxSg5UHA1SsZVm4sW4C3FHuDtJFw7Sz03bYCJxVKyACv+bstDwcRi2eZsU68U" +
                "HACePFS9DBg1Tx4oBSoKBvDMsSqzWZKq2aN870jpsoLNXQeQSaJOEYNRrwDPHy4w" +
                "wPN7M93imWogeG46dJbYLMimZOKuAX7VRQswAM4D2Qz1xcdgAVaSdQEVnvcBCzIx" +
                "2NQrBV8CkgDf4N/ADPC3/DtSr9z0twUA9CzyHd8jsYp8C+hXATeUVS7VV3iAGysr" +
                "AAlk+7qUmAzsUuBiMcgoV3ANcGGWp+LcdNdWRVmEgjt2oGbAGmBB3oqSgWwuWqD9" +
                "ONxTk+9l1HLTsu3Frn8XSvYBm4opkQa35JsNGeR8N7wd81302P4KN0E2PWkWB/lw" +
                "pZsS5CMeXEGeRdGzegr0sQpT7lwc4NljXmIVlEcLR0s8wKh44ZBcKcmWFHxuGbCU" +
                "HDqlpOu/A4ziAsgXgESZtJxoAfi8APsuWoAvCjKxmOw5fAklxgE2JQvwtwLO38FF" +
                "R6ViMwGmNPsDT7JnXDOwSbyk4KfFpUv1pUAtq3QNPmADXYlCMbnnxjKyah9yUzlK" +
                "9iE3FuUQh3HTeRmuCevEVRtkYnAAuGtbpesCsgeYOIyKFYuXAZd6gInFz7eVuIFd" +
                "5eaiLRbvKXcDAeCtqBjIw9uxrVIx2TOAVS5JwWaHfcjHiMsCfJD4C1gDHEA+Xu2X" +
                "RyqNKJHImBWLDfCxMsueDTKl0vy+TDd/gNoYCx0H1sUt/M9HzUCWGeDzQD6ZH3PV" +
                "L7no8y8DjlAWWf2Le45S/4YMbhzgC4KMilUeXUaNN4jhvoIjXwEWuFFB/gqIX8lV" +
                "kymjXgMbACZ7Dv+RX0gsYmVSIWVScZkT5PpyQOOqpeLAmoDeVFVBUlXumirLXBOw" +
                "m4GsmNxcWujqSbQCwM0oupNYrBgcAO7cCuDtla4byJ1KtLAuIPdUewpWbWwKNsB8" +
                "RskeZDLqPWVuYDMuGshDWzEf8IggqzwiBnuAX4EM4CCLVjx+CfCxeMBAjpVJFQZ7" +
                "4Xip1cGqgRWD5w5ku/mDqPhAppVJ4fO1McAe6ApUV8GfFZiSlwHLRasm9t00Co5c" +
                "5HuXgIR7jlL3hsw9x7lo6uHwRWKxamDKJA8wvySC+41MLpm/77tpy6C/Vb3rQbZn" +
                "PGBl0XUAxnDH5Y6Ey4vFcZANsMEtdy2AlnqbAS3ILZW48ZxUc9NSsKytgto3HjCf" +
                "u7ZUuR4gd20pM8DdAJb1+s2PlwDvQMXE5ME9xN8dZNg+YIMsN40J8OiOPE/BBypx" +
                "05VuErdssVhJVpBcqQaWKXMOFPx3gOMgUx6p/l0gsVImvXAg1wDHIB+S2mot/gYq" +
                "Dp8TYEohQT6ppAu3e5IYfOYfAPYhR33IqoFDSq7kni/wNAXzvIRdRYGmYB/w1x5g" +
                "DzLfk5u2EinzFcD5ywoW4McFxQAudjQ8TMUNpuI4BQO9yQfcLCUbZGIw3a3GolyD" +
                "3ArotspiulhFBviZSqe4OGyAcdXdQO4BshQs66WFKQVbJh3EYgH2Ies5SB08tL3I" +
                "De8odsM7i93IrhI3thvbU0qSVebG9pV65dIBSqZDFQZ6itg7fRQ3jYv2Gh24akoj" +
                "gwzg2eN0svzulXWxAhUrexZY1GtKPlpIQwNFnyzjSefqBMbn0FmgEn89uDQlDLAg" +
                "KybzP5ha2ACrTAoUrOdFGeBNycTLi/zcJd+uoMQrxFEsIrjX+dlrevL1Dewrft5K" +
                "JP7+d3LV+hqVy77JArIfg//oAY78ia//lEcMLilbelxIiVRAN4tnfZkXjxsBHXPT" +
                "VcRiueqyUtdYTDuTHvXjlET3NC2JfnQN5vWj1Zfu2Frt2kppcFSpk1VMP1q96HJc" +
                "dIXrBnKvIG/mewDueRUwWfXzLYWuf3O+699ISbS7wg0ZWPrOO0sAzFNwdwMXwOOo" +
                "d4ye9PieEutiTe73mx0H1MGiJ039O3WYkimoh8mivUQLNw3gGGQ6WIrHc0dL3dzB" +
                "fDe3K9XN7kh0C8eKyWprAFmD0mooeWoxPh/nfyI96PAZEqVz1LOoeBky8E8BRgqO" +
                "B3xOigbKORSu5gYlUvQyoIjLkcsywcXVYpGrAP0ClX7B96/zb32BR5DRrowqg1b8" +
                "/VqZNH8GXEEOfyvInqu2+Psn/n0BrssvWmqorMU1V7onRYDGlHAZXCVagH7KMOJx" +
                "arJ7nJzoHicluDrg1qUmufrMVBodVa6d1uWzTZgAqyddnO3aSnIpieh0CXJtMa1K" +
                "jN5092b60AJNnSzAPZuKXe/GAtdXS+MDew5YmSBr8DBE+ST1eoBL3SgKNgP0+MFK" +
                "z00b4AAy3SwAT9F3Vrty5kStm/28lmSr0mt60IeeDRItlCuoM5RCMzvT3MwOgU1x" +
                "sztT3BwmFYcokcwAa26Z8mjhIIkQAwcNGsL0o0NnaHxg4bMaEqgFCXSrg1HwWZKe" +
                "M7hT3yJnAYJrjlwG4FVqWwMM0DjABvlLuWH+/heCLbgAVT/aAAOUFqVUHP1TCWDl" +
                "vvk3v+PP/RgsBUf+RC/6UWYuZVI1GXSta6wGdEUVgCtcXU6ee5ia7h5sSHAPEhLd" +
                "o0QsyQcM6DqsnqlTqwFGwQKMkju21LjWomzXQvLVoXgMZAOswYNv3RuLAQvs2kLX" +
                "Q+nUW5P7d4AHthXZhGl4b6XvnpcVHECWgmUTB5g4oeQJ3LW1KzVROgBgTZKIwbMn";
        String imageString9 =
                "N7m5kxsxYOOiZw6XuJk9OW56O1C3JRtYwTXAgPUAJ5Ns0YywQQOZs5R8Vk8NHdJc" +
                "6Aj/w2OANXjwAQPZmhvngX0SsKdRbBzgMICl4Ih60df5WVQcuYxq/zvANDoiX/gq" +
                "FuQb/F0UbG3KL1I8wIL8Z/6tP6J4yqTwjUQXur6KOP4xMTgzZwkVMzna6EGuqkG1" +
                "le5xZra7D9gHG7AAMJBNwT7ghpwsy6bbgewBposlBTNSbKHL1VKY6an4Fcg9qNmU" +
                "y+iwpyoXwK9CJnPeWbYMeJenYlNyTMFy0VUeYLpZ48TjcQBrXGgjQ6kYwJO7ct2s" +
                "qViAPcgzNDumt6WazWxP+YeAZ3cm0/BgTHiSuOqrWK46fAYFH0p3IUxDhrCv3njA" +
                "YXWv1Ic+I1f+MmApOHoe9xkARsX/CHD4C74vBSuDvgE4UzG1r59chdWL/pJ2Jl0s" +
                "UzGABTn6J/6bN5hAXVkB4E9QcEb20qOMHBIs1cGouKqWOFxJPC5ydbn5wE1yDwXY" +
                "h/wYFUu9sobcHJItL+FqR8GyZ5trXEtBlgFuzc9w7WVqbkjFcQrmsxT8fAeuelOh" +
                "KfglFdcKMPXwbtS7p8IzxWLfVY8Si0f9GGwKBrBaluP7UTATJQ8wsHHRk7vzmCoV" +
                "+yquNcgzh9WfRsXMgD0FL0OWegNTJi3AmgcHsTh8hlmxDzh0mGyXsaEHmYaHqRgl" +
                "E3tt0HARFx4P+CyuVi6aJCt6DRiBvRKD5aJfBizIqBwFRwP1atCAgsNfJLvoH/nv" +
                "GWB+IVT/0qYMf0U3LAD8MCMbl1xAYwMXLSsh7uYXkniRWQP6YVIygBMM8mOpGDPA" +
                "zJBbScDayKjbmDAZYJKuFsqlFhogAtzK5w4Srk6pGNdscdgAkz1vr6DuJSbjogOz" +
                "WMykaWhXpdkyYFx0HOAxauSx/YrBuGgf8AQx2UaGPuRJZsMCLJOKYwoWXMxGiHtz" +
                "UbDctOeqA7izO1MplZgHC/CpZcCh0zRDiMFSsNkxoJ0Gqim5iF8EDAVHL9HMYOAf" +
                "PhMfgz3AUeJv9JqG/j5kVPwCNx0kWQb4S1zuq40Ov8Fh7lkKBq6G/upaeeoFsDpZ" +
                "GjTIvqOT9TA9Z+lReq57lJ5NW5KkClddD+AnuG0D7EOuy8hwj9ZvcHXE5MeoWa66" +
                "sajQtZJdt1I6tdUwQTJX7QFuBrBBxlW34bINsBIt1NwtwCRbfSRbz4Hcp/mwD7mv" +
                "lgSLTNoDLPV6Kh6RkuMB7y1fBqw4HIPMACIGGBftA57eV+jmTm0yJZt6DTB9adQ8" +
                "d7DQea7aA22Qd6ehXIb+Aiw3bfGXDNoHvBgAlqs+DdQ4Vx0CcuQS2x2XiLM8w6eD" +
                "JMtX8BWBjQNMLI5eQdVWJnmgw/8IsGrhmILjAN9IQsX8/T/x39WY0GtT0soE8AMA" +
                "Yw7Q7nFGHireSCZdCmDKpjjIDdTJT7Oy3GMBliUCuNgD3OZDjgHOzXACbJABLCV3" +
                "VBQYZA8wMZjSSYA9FbPGU53jQ86h0cHgYRclksqk3eXmokeUbKlM8m3sVcA+ZOtL" +
                "qyZWLNbwPwC8O9/rRxOH/w4wfee5I2TclEdSsuLv3J4Ma3bEACsOk2iFTlEXo+DF" +
                "w3EqPoK7jAesUaFiMHCjWtU556k4QrIVIf5GrvK9qz5gwZWSr6Jqv0yKMvR/8aUf" +
                "g2/wb6ldGXSzqIWtwUEWHWZNJ4KKIzcUi5ke/VmACQGmXrY7AgULsExKflpcjnJL" +
                "3JM8gAowrroeFTfgqhsK9TnfFFyHipuYOrUymGijESIltxOPVTI1kUHHFCxX7UPu" +
                "9F21IPcGgH0VB7G4DyUP7mTIgMUDNlfNMEKQFYPHtKuFe5ZNWCbtqXgSJU8ySZok" +
                "Hr8KeIaYLFc9Q43suWhPwbNHACzIR4nVezIplQC8l1EhrnnxlKdgPcPUwSEaH4sH" +
                "0t1CHGD7rMF/APkscAwwLUkBvqg47auYLpbgxgN+cb3UvTAV+25aWx0kWVEge3Ng" +
                "wBlgnhoVfkOmLMByzwFgUzH/tkqlAPAf4hRsgNO0cJdv6n2Suwz4aYEH2UCj5IaC" +
                "AvckJcU1My9uAXALcNvY4WrHVT/TtgfLeQY4B7iouRXIbcTi9uIcGhyemxbgXvrU" +
                "5qYFeRuxmFHic2riALBBRsmxOBy4aVz12L7/DrDXtpxSV4sYPLHLi8HTKHgKNauj" +
                "9XeAKZtmyawFef5YKT3oHDe3P9cDbDFYcVhuGgV/XgzgjL8DvHiE0glX7SVaAIwD" +
                "LMhhEixBjuCeXwKMej3AUjSND9z0i+sFpmCpOABsz6BdSSfLXHUQg6Vg2VfYd9TD" +
                "McBpuOjEzKV7Cenu/gZZGmVRKglXoXtMTH5Mdl2X6dmTLNSdneOe5uQyYMgjg2Zl" +
                "R/3ocjY+gNyKigW4vabKNdMAaQauxWAAtwiy+tQouaOy0CD3MHHq24LR4Xoei8Ws" +
                "8dDNGtjhKdgD7MVguWrF4RGSqxEAjwqwWZyCUbIpGBVPHRTgQjexLdNNbsvCMsym" +
                "due66X3atiTx2ocdwHXvp3vF07pYh5gDYwvHWK7zy6RlNw3gEwA++PeAFw4D+Bhb" +
                "l6g4fC4AHOemL0nFxGBtVWrYYOa555iCpWKpF8BRS7BeBcz3bdjAUxsdVxkrXmPr" +
                "8tpa31bjqsmsv2Jp4Bv+7JsED/D99anu/vo0z4Bch3uuyy5wdbjtOkH27UkmkLOA" +
                "DOh6QDdKwai3RZm0Ei1UrGdDRioqBjJKbslJMwVLxabkggwPML3qXkEOAG+rAnS5" +
                "62fq9BLgnWTTfhyWkg0y3S0BXobMXFhbl3vL2M2iVNqrEsmLweNbAbw1w00B2kyA" +
                "cdHTewEL4LkD2P444+t5hgwLKHmR9dlgs1INDw3+tTa7gItePAhQP9FSPBZgUzED" +
                "h/A5uWXBlfEZBUe1unMB181M+EXMRQdxmKfgWjxGxbQp5Z6DYUNUA/+vaGXeoH6m" +
                "Dn5Bs+OFBg1XNwB5HU+tyK7F1ph6w98AGcARAX6YmL10b12qkwWQ63KKnFx0He76" +
                "cRxkAQ6UXJ+d65pKSonDJRZ/lWgpBj/DmotQdyElFJuXrQUyWpdk0u3Ux+3KqMsL" +
                "qINpcmC9G8mmN+GeqYv7ZHS3ntPC7Gf4MMAIcZAyanAHNTFz4mGSLgEeBfgos+LR" +
                "3WVePFZM3lXM8p1nE3S1AsATUm884D24acVgbFaQ4+HqM0qeB7ImShr6Wy3M8MGa" +
                "HeaiAX+U0eBRJkdHiYXHcOWUSotHidnHmA5hGh9GLgD2Au7YjNh5QeUTtawG/wwd" +
                "rFRiLzqqdqXsGnYdU+wV4C/4mev8PAOHKP3o6Jdek8MAUyIZYMXgKwIbGKC10YGL" +
                "Dn9DHWyAU3KW7qFeA2yQcdHZUjCQ9cwqMHctFT/BXT8JFJyXz/CB/WkSr2aebai4" +
                "XVbNYh4DidbSIveMJYFnZTzLMaZNnWZFlEllrM+WW8nUQ0zuoWzqpUbukzEn7lMs" +
                "3lzEqBDIjBQHthSxm0XrklnxMC3MEXsWMDLEVSseCzAWANZzgv60kqyJHbkGWJBl" +
                "03vyTcEzdLpmaWca5H1y0Z6K5xk2zAPZdqNRsbnqOMBhtS4Z/isWh2XWkwakFt/l" +
                "nrHIBQCrVDpHrIyfJjFwUBxWJ8vmwloAiBmZc1ALX0alTJSignsNsAJ8Ix4wfy4F" +
                "K8G6sj5OwWtx4baLRSxms/LbZBScnLN0PzHTAHsq9gFnFbnH2YWekjPzzE0/EWQZ" +
                "kBvIrJtLWQ4gu5Ypm/YA466ZOrUUsjoryAJcVmiQO1iz7aQ/LcA9W5gqodyeGuDK" +
                "gGyAawFcleOeY/0bC4FLTAbyIM+hbXGAN2noD2RGiAHgMdqYAWQBntA67c5cN+HD" +
                "NSUDWHANsFR8CMgAng0AS8FAXvicnvNxmhpk1gsnGCgYZPWjaX4cYxeL0aEHGKB0" +
                "s9TsMAN05CKjQ5octngXD/i8B9gbOAD6IvE2BpjEKg5whM0OwX1hgIEbp2BPxT7g" +
                "a5yAiLnoZcCUSAwhyKLv46LvJ2fHAEvNj4Fb59sTEq4nuRjuuY7EywCj5Ea2QAS4" +
                "iTFjE4CbWJ5vZ/pkkBWX83KZKBUAl+9jUnGnTIBRby+Tp16WAXrlnlU2AblPSqbp" +
                "0Ud/2iCj5H761AHkoa1AxkzBAoyNsJQ39oqKJwJXLcBS8PZsN7El3VMw2fQ0yjUX" +
                "bYCBzOQpcNVSr5IszYkXTtCWFGBskRWeoCctBS8e1ZoOkFGw2pUxwDq+AuDoJZlG" +
                "iS+r2DJptStlrOxENDb0IS8DJhkDcITBf/Qq7vg6oAH8gvgruFGLwfx9KVhu+qrv" +
                "oq+/DPiFlUmJWSg4y93bkOHurSXRWsesNxP1ZpJJY0+kYiA/xeriIDexAWKAAWuA" +
                "gayyyWIxrro1nxgM5HaOwrT7Ku54FTAq7sMEuaemCLi46FqelT5gQPcLMk2Qgc10" +
                "t4A7zN6W3PQw48Rhtj1GNue6UWxsR5GnZLnnALCOswjwjhwfcLo3YRLgQMXqaMkO" +
                "Flmypfg7f6TY5sMeYNy0AJNVh1QqkWiFVQsfyWelVicaGBUCeVGuWSo+qwRLcNmD" +
                "RsWCHLHdLOpX1PwS4HPAYrIUZbsyeinORWvo7wOOXAb0VQYKDBui/jw4eoOvAxct" +
                "yEEMvr4OF80vhdSLvQT4/oZMd3cNidY6FOzD1TNQsmLyU5RssRgX3SQFl7CjVcwS" +
                "AHWyTKBbcM9ScRttzBYNI+hXB7FYgGXdtRV0sgBrKq7yyiXmw73ANcDlOb6bBi6Q" +
                "n5uSczi+wsqOQUbJuGcpWDYmyFIya7XjzIknfcjmogEsyBObUTAqtsNoDB9mfMiz" +
                "gYqBPCfI+1jT0UK8FvKwBebFlmypbDqusSCZ9Gmy6yOcaiDJ0jEWKVlnlQywZdCB" +
                "ggXYszDu2Qb+wcBBUyUDLMgAY20neikY+scDZjuS0w2RK0D7gr9jCs4kBvN962Sh" +
                "YA6dGeQA8B/MPXuAUS8KZjSIig0wKn6cQYnkQ44BxmUHSn6ak28uWnCbXwHcDOQ2" +
                "drraSonDAJa1FbEbjYqXAbOjxe70MmQaHWp6GGTctQBXEocxATYD8oC6XPSqh0i6" +
                "hqXoTbluBOgjQJaKTcms1U6QUU9iExxtmdiOegE8tS3bTW5Ks4Np0wJskD33bO7a" +
                "V7L60nOs9PxDwGx4aHVHc2HBXTyq7Fl7WKhYUyVWaCNseCy76GXAL3QATTtZZ0mw" +
                "zhA/z3pmChZgTLtZkUtANAUDEBdtCvYB6+BZ9Et+1lw0f2adLHWzsGtk0OaiUfBL" +
                "gBOIwQaYOLw+w3PR6QAW5AB0Fm5agLGnubhkhhGNRZ56m+hbN+QVuIb8AlOwALdi" +
                "7exyteRo8I+KOZL6DFctJXcAuquW/ayNSrLiVExNbA0P6mBz0UAWYDMlXLJqzifJ" +
                "qnROCReNikdw1QZZbhob5/TD+Fa6VwaYc0sCjE1JxVLwHpYAgGuQlUnrxKFisAGm" +
                "i8XGh21axil4nlamqRgFLxJ/w6dYBFAcPoKCBfo4kBWLARylRIpewD1flEnJHmQB" +
                "fkENHJGSBdhMsVhwgYJFZOc5jyQjk45e4ucuC7IUTG/5Ct+/ynjwS37+hgc4ei0A" +
                "vB6FKwb7LhrIvovOXbq/QcN9z+4pBqcTf9PUzZJLBrSBZZWngLKogMSqtJr4S8/Z" +
                "h9yYh4sWYNx0M2VTC9aqJkh+fgyw4rEgd5RrLlzlAY6D3CfAMsVlLQQUpbme4jTX" +
                "W5Lm+rDnpWmu37eB8nT2o0vpaNHwILMepWySjbGcN04slo3tpE25w1cwgCcFWPXw" +
                "3qK/AzzHzpaOsGghfoFThwtsfizYUh4umoV4DzAqVcIlFQNXy3fmooFszxNkyFJw" +
                "ABjILykZwGpZavk9cgpgnxM7PwfOSZ4n9Ux00dNkxGcS+MUAkmpitS3Zz7JMmoNn" +
                "0ev8MnCENPoFLliALf76gL/g730RF4M9FdPJQsEP04oAzMBBoNdnukfAfSTI6XLL" +
                "7GnlsR6bz+50PmotwC0Dt6Wshid9ZyA3MJBoovvVBORmQQ5A57J1mc3WR262JVxt" +
                "xOMO2psxBSsWb5QxWcL6aXwIcD+ty57iDIPcW5zqZM/jIA/iqocFlqWA0e3UwD5k" +
                "ZdPjgaHgsaoUGh4cCsdVT20HMG5agLWrNc1I0c4KBwfR9BRgO2W4kTYlkHHVC3xP" +
                "SZcSLQOsJ5BDlEqLh7NZ3ZGb9ixMPPYUjHIvUCpdBKo6WjIbHzJUEOBzNEgE90Q8" +
                "YEZ+AnwaUNf5d65RI9PwWAZMkkUMfqGhPy46cpWfpeERS7a+FGgfsGrh7zLcC+1k" +
                "3fo4YelxZimlUal7lFHsHiazYMezLpuRYS6H0vJkpTHIjYWszvoKFuBmLegxWmwU" +
                "YFx1I7tcDUrCaGc246Kb02hZYi0Z9KYz04jFnP6vpsnBkoCsuwa4gO5j1bbXB6x4" +
                "3MtxF6m4VyoWYJ6CLBUP0eUaIQ6PSsFAtjIJyOPADgCPctx0tDwBFXNWmB71NEvy" +
                "U3sE1zsz7B0pZcuSyZPOLM1xGnGe5wILeguMFAV48ZSUDGQBxhaP0KY8THLlm5bh" +
                "F/bRojxI65K25eJhXKq2LMmkbdtSC3jqaPlzYT0F2IYPJ+gXxyv4lKfg6HnUK7ha" +
                "o7WOFtn1NaAqi0bFHmDF65UsyK8GJD/7LcmZtirpQ0c5G8zBb/eC5bsXf2Iv+ub7" +
                "65fursukqVFmkAW7LrOEgYMH2IPsARbopmKdaPBctAC3lKHiQpTNMKJBSwOqkWVZ" +
                "wBXkTGbDPuTmtBS2O9TB4miLnj7gXuD20fzoA7C5alQsyD2Fy4D7BBjrL89kZMjg" +
                "gcaH6uExpk1qWY6Zi15W8EhVqhspT3SjFYms7HDojMW8aQOtdR0mSnZm2AM8J8A6" +
                "ZUj8fRWwQT5SRPOD/rSMc0qLMkHGPQvwwoFUs9BRzXvZ4ngVMKs7wWxYcF9w2j+m" +
                "Yt9Fh0+hwNOoWMMG3HL0soCi5C+lZL6Wi5ah4MhV2pACfO5TS7QMMIfPot/xd4Cr" +
                "0/0GWIvvt95bv/Tze+vco1RcMip+DNxHKcRdKVgG6Ke5zIhRc70BJvaWyFCvXDQJ" +
                "V1MhCVcR55fIruszOJDGwp4BRskt2dzpkcr40FdxJ71qAe7i6Isgd6PmXlTci4p7";
        String imageString10 =
                "SbriAfdRG1ssRsl9UnFRKhl0CR0t5sIoeITND3PT9KnHDLLir5Rc6IaB6wFOcuMc" +
                "GPcAV6BiFMyC3kuAOWKqM8PzJ1h4l4KZGSsOG1zfTWv4IPUaYEDrzg6zg6j4gCBz" +
                "bwY1sQAbZCkZ83rSxF7ctMVgPw6/uMymB3A9FctVY2dIorRsdxlYVwClqZIAy64D" +
                "7ToqBXD4ItMjAZZd/JSjLILLLwHbHNaqDABrL1qAMXfnE/augCv3/Ci5wOKwAQby" +
                "0xzcNIAb8pU9V1MieYAbC2lVEpMNMJCbyaibAd2kSRMKbpKKsZbMTAPcisvupEYO" +
                "3LNAd1fT5BBkA0xNDGTFYTOpuCjdIAtwfxkHwNnEHAbyML3qEWyUs8XmphlAjLEQ" +
                "IHc9UkUSVppggEfKAYxNMmmSgqeYNk1TJ89wYcssM2Nz0XLT2HwAF8Dzx4Gt+Hsc" +
                "t63YzCG1RTpbi0qyDtPkQMULh4i9h3N8wDrAjXp9wAb5fBxgZdM2VZKCPVMGvQyY" +
                "mKoV2msCLAUDTUr+kqGDAN/A5KZJtMJnWYk95wO+sIKJ0gbgCjB/bvGXOlku+o8A" +
                "Rr2m4FvvrnMPkjQ9UhwGMCp+TPIVD7k+DnBDPkdOic9KujzIHmgPMjUwU6ZmQDez" +
                "5iPITaksybNA30EbU5A7GSt2o+JuIPcCuZdkq5esWoCl4n4aIVYbl3MCAlfdh4oH" +
                "anTSn8mS+tJsYyoOj9DZMhUrFqPicYYOQ8Ub3HAZgDHF4XFZVTJDBubEAsx1DzPY" +
                "LDPjAPAcKp4/7qsXuBaP5bLNPMCaMNmBcMaIoeOANlcNZKmYOKzF+Mg5T8GBkiPn" +
                "cc/EYSuXXgEcvYKKT9CkkHpPqwQCLqs7AuztSTPzBXCYJXiNDF98xS/ARea8AhxA" +
                "vvAppyRWeCs7AWBBZnXn/xPgWx8mGuCfAPzz++tRrrYo84Gcb0quQ9EB5IaCKgYL" +
                "VbhqwAZGZi3AjXLTMRV7gFs1SiyiXAJsc3q6a6e7ZYAF2Vw1CmVRr0d1MQOJnio2" +
                "Lf1SSYD7UfKADq4p2SqUewbuVmyzD5irmBSLY4CJx+Ms6Y1uynGjNZlutCqNGJzk" +
                "xgA9XraBnrS2OqiBSbZmGCnOkHDN+Oqd48CaAM9z3FRwPcBSr5dJewpeBhw+iQvG" +
                "vHoYyEfIqM+SOaNiDy6fyaStJ80abeQMSiTJihJ/o6ZgZdQkYDrG8jmQLyi28nNX" +
                "gIh6PcA8dUZJo0NUrDPCdk/HFX4hLjFFuvgZcH3AV9b4CtZNOwA2yGTRd1dnLd1d" +
                "k+Vur0x1Nz9IcHc/S48D7EPGdctNC7C5az7X56rB4YE2wL6rbibhasFVt/BsxV0b" +
                "ZEC3URt3sP1hLrqmmnZlDWCxjTWm4m5d6JKT7jpZEOjh2EtfDUdJgT0gJVdxIw9Z" +
                "9SCfh9gCGWKsaAoGsFz1KPNigwzcce7bGtuS78Y2cncWna5xbuaZ4FaA8epUN1aZ" +
                "goIBvEuAZSh5H3tZSrg4cjrPobV5TinOc55pGbIPWAfEzU0LMgfQOPUQphYOf67P" +
                "TJtOosbz1YCq4X88TzU6LlV7zY4LqJgTh+Gj1LzH+Z/P2FAx+AUKjl7W2BH3bOqV" +
                "ewbkpTjA15gJAzjC8l3sng7dtEPDw5oe3JcV0dD/EgnXDTpdzIOj38Yg/+21ewK8" +
                "mjalDNB3VmngkEU9nM3SO9uWiazUUjo9JcuuU12s5kcaO1lp+ZxP4m6tVLY80mRs" +
                "eqSRRWONyqbTSbbSslwjSVdrLq1KbgvooIXZWVVFglVt1sOCXg8rPt1k0z1VzIjL" +
                "Clw3SwIdWSmATnHd+cAuynR9ZbQpGUgMAnyQXa7BjcyGDTIKBvIobnuUPeoxFuWl" +
                "4LEd1MYbgQrgCQOsYYMHepLD41McP53ilp7pXRh3ac2yoCfIc2xiyub3kzVrzZbn" +
                "HOs88/uZLrEMoOOkskUlWQdyXMiSLbpYjBMX6U/raGnkvADHQVZyhUnBkdOAOwac" +
                "IyRXx5Vg4ZZP07DQVQ4+4KgAc+pQfWlT8lXi6peAv0HjAwXLwn5HK6zL0AQ4WL7T" +
                "0MFOO6Dwr8nIv0nxFewDvvNpurv1YbK7t5r58Gee3V+biaIBnMMyfBbblrjsulSy" +
                "7GTGh4ms8yTJssyeJHNnR3KWq08BbqrgkkUXMmFCwe1sf8g6KwEsMxXjfonFSrp6" +
                "lHAxiOgtZ5xYwvlhlNzNdmZ3Hu45lwSLcaLB5ea8QbY+hhhMDAsyS3pDtDGlYpVM" +
                "BhjQYzUe4HHctQeZr2vS3QQZ9ST3a03L6HBNMy+e41YexeK5g9zXQftyjl2uObY9" +
                "5pkdz7EBMrcnl1vwMAYRC9y+I7iLgA4dVUdL54JRtdqXQDYFS8VmqJhEyzJo1cMc" +
                "ZdHdHeHjDOMF+Di1sCwWf4HIVMkAXxRgwDNVCgtyPOBr/FKgYsGN3XjHblbk6mrU" +
                "rgaIjIbJVxtQ8CqW7lZlkkWnuVsfJWMp7u5KetJrPMAPE/PJoBV3Oc6ShYqB/JRy" +
                "ysonSqgGsuz6bNqYWZyCyKBMSmVfC8BNjBc9N822RxzgZ2x/dLL10eVbN8t6pmAl" +
                "Wlh3Kes8QO5lrac7jwwauLK+UqZJctm0MQeBOyTIbH8MVmYb4CFGiqO0L8elYmyU" +
                "E4oxN03TY7w6zWyiJo2pEr3prRidrVmugJjlLPEcsXeOrNozXLTcdMwY/NOrXmBW" +
                "vCjAzIvlprWzJVcdABZkXfEQMVfNk4TL62z5HS2dOARy9CwQTxF7A8BKtC4TX69g" +
                "AisFY3YpywUAC/IVGiC+giOUSwIsF22AL7N4dxn1Xl0DdP4tDp8Z4O/Yqry3MmPp" +
                "zgrgvg/cD1NMwXc+YcNydYZ7sF6blIDNqfQAo+IAcD2Q62ljNsiIx41YE+3MJmrl" +
                "xhw6W2yBNDNLbqHL1VZIDI6D3MkgwgCTbHWxCdLDU0pWPdyDintw1QLcy3JADzf5" +
                "9HCLQC/uegD3PMBywIDgchXEQDlDhwoACzKARxhCjDJOlKseYwhhgGtzaFmmYakx" +
                "yJNbmC4BeJayaYYrmGaxOUGWmwbyPM9luN7nBXW5KJcWqYcXDzNoOEyrUp+17aE4" +
                "TDwOnSImn8YdC/B53ePhJVxRVng8FROLDTBumP2s8GlKHtqVYXW1cNMG+YKn4NA5" +
                "oOrWnQuoXYB1KZogawn+S+Ar0QJw+AqLd5eoiy+t4zOArwNbgInDL/5X8d9eu/1x" +
                "6tLPHySRYAE4MEA/WMuCHXDrsoGKPc0FMkp+Algp2ACj3gapGMgC3MDUqSGdyRJ7" +
                "XE3AbUxReYSaicUtuOtWWpntJF4dpZzyVywWaMxUjJINMJl0DyruFWSsT2rmmiap" +
                "uJ8rEgew/oo8WpYsAcQDBvIwNiIlb+IGPEoouemxSpRbmW42Fqh4E4fOWJifO+zB" +
                "NcBcqCZX7UEWaNx1TMFawMNY71k8BFxd1rLfi8Pmrg8Sj7XhwUqtQEc4/a9sOgaY" +
                "2tjurlQs1vVK5qoBzIkHjQ8N8GkG+6zwaMMjfJb123NsbWIxyFyrJMjhyyRSN/i7" +
                "V/ilIJP24JJNC7IAXyPh+oqf+TNl1f8sIgavyibJyibByjG791muu489TCqmq1WO" +
                "K+ZguG+mZMViZdUBZJ4N2dySlyG4+TFrpnxqSucojNw1gGXNJF4t6ZmulU5XOyPF" +
                "Z5gHGAULcKBiuWkfch9K7kPJfaUM/mXUxYLrAQZyRY656GHi8HA18+Fa5sPY2GYg" +
                "MzseY+tjnGWAcTLrya0Yt+ZNsbs1Tfty9lAN6t1oCp4HsGzZTccD1oGzIjMPMMpV" +
                "Z8tisZItrj3E7LJSDSDYtAx/LneMYgU3MCn5PIsBAmxK1ootkM/zFGCuNgyf5Qng" +
                "MAoOmYL5rPs7LvF9XWvI4D+iaw3tUlJUbfdWEo+5jDRMFh0WXLUs/0ymLsB3Pk5b" +
                "ephA7ZtIgwOoD5NKqIExvsZ9G+zH6Yq5uGoUXa+nVAxkU7FgpxKnsXoya1MwoJtz" +
                "aXTkcb8WgBtT1ckCrowMuzUj07UzeWpnM7OVExLP8nNdN9c1GWQSrl4y6p4Shg1x" +
                "Sn5eiXLlnisL3ABl00A1bprLTmXDuOzRwGiAjEnBzItHKzOYBbN8Rytzkk7XFKu2" +
                "spl9dLQ0M8ZVz+whqQL0HBecGmCuYprjZp6Ygpkdz2MB4AUWAhaZDy9SMi0Qi2NJ" +
                "Fype4JIWgQ4DOcwhNdudZmc6wjqPJVt+whWoOMrpfzu3BGRdzBLh3iy7t4P4G7lE" +
                "XSwj0VJfWndX6oLS6DXi7zVc+2W5aAB/zb9BqzJmwNXxFZ0RZgkeF/1h6pJc8/3P" +
                "ONGf6IEV6EeAfrChEMgkW4B+QFb9MIGyKA2wUnE6GTX96zoaIgFgPRsooaTkZuKw" +
                "QcZdN6RwA09KpgcYyK1Absddy1U/4xhMW3Kya0tNds+yM11XEa6Z1mUPVzT1AriP" +
                "VdvnNWWMEkmwNjGMKMwgseJaQ1k1GTSAR+hZj/I0yD7gUUaKoywHjJZR/xKHBTiA" +
                "PA1k2SSQp7ZQNhGPZ7jUdJbGh7lpauG5g5ROjBQF1wMcQNaYEFeNmxZkr2QCLNct" +
                "mZJ1Ew/XDodVF7PlYacQDyYxVkR9J+gV0/QIVKx6OHqRr1UT6zCaAHOHR+QiFgA2" +
                "yMyAda2SALOEF1EWfRnFXlRyBUiND3VnlkB/yy8CFv4a+DfW46JXZNCLTnK33qXJ" +
                "sSrLUzLqFWDZ/c+YEQsymfZ9yqcHPB9+plOGue7xepVIQBfkFGXQGE9BbgoAa0DB" +
                "8nxjMlMllGwqBnIbg4lnxaUeZDpdUnI706b2VCZO6SnMg1mfJel6XisDMM8B2ply" +
                "zc9VF1cJMOrFRmhhGmRUPMKqrRRssVjxuCKdTlaKxeBJ2phTtDMDwNNc5jJJGSXA" +
                "VjZt49QDpdPM7kJOGHKshRp5jtmxAT7guWhTcDzgY0DkojTZMmD+B59kw8O/qCV0" +
                "mLPGh7gx4BADiUPEzmO4URbiX6izJbh2CpGTDZe1FUJ2jMuOXPQVbKADwIwjBZrb" +
                "Zw0wKg5fIPZeWM1JQ5YI4gBzCRqxOAkXvSJ96dZHae5nAAvy7Q9IsNYVmqt+5IO+";
        String imageString11 =
                "T4y+t4qtS+wBvwTKsJ/Q0rz/KUt6n6S4h3TBHq1OdY/pgj1JoAZOySPJ0tABN42r" +
                "bsknCRNg6mSZILdm05em49XhQ+7AZbelcGuPD7grJxOw1SzBA1gKFmAzyqncZFZ4" +
                "PBUP4649wN5TKh4D8miQVfMcKyOLLvc6WRObgMjpCHPVnFCcZjEgUPE0SwECPbOL" +
                "5gcbIDObuJSFNZ9ZNkHmtnPr3W4uRWOHWu7aFCwVyzR88CGbi5aKBVgqlrErLcgh" +
                "g0xpc5B+8nkUyxgxelGgPbjRKx5gJVkvq1irO1KwAMs9E2svAZdMOnyZf4uWZegi" +
                "CdYVEizduiMVKw7/IVsxOHPp9scZ7ua7ye7ndxJ5Yu8kAJMuVgIxWbE5scgHTPkE" +
                "ZA8wk6fEPHdvRbJ78KlnD1dyE49v9YIcAM4DMll1UwAZJbcxP36mjJry6RnWyY51" +
                "Bys+AeAO1PycNmYfDZDnQI4Bxk2rZOorSDc3PUxMHsZVLyuZZXh2qUcquSVeZZMA" +
                "V2YCmTIJyBMVKW6ihnNK3Psxw4RJNrVNrloq9gGj4DkGETOAnd2cZja3Jc3NbU11" +
                "81tT3PxOhguKwwFgFuS95gdKVgyWBTvT5qpVHqm88pRsKqZ1abfBxwO+TMeKbUtr" +
                "XeoWvIvAMgXruazi8CXcswHGG5BNhwLAl5RN0+z4CoVr8GCAP8xYuv1hBvUvKn47" +
                "0TNAS9G3KZeUgEnJDxOIx58C11SMglOJwWm48rW0NKViIJutTHGPViXHXHUz67at" +
                "qLgVyM2cP26SgonHrRnZBrgzAEyXq4t2Zhfnj5+lJLsOrIcbbp+zv9Vfi2tGxQMy" +
                "VNxXnOV6aWUOlJBB/wPAI2xijlIfj1E2jVbzXgdisQDLVQvwOD3pcWrjqe06ZehB" +
                "FlwpeVrxeA8tSsaJc+pTs24ryB5gHzJdLVNxzFVTC7PKE7hpuWo79SC4drTFA6z3" +
                "OiwekpKJybjp8GWGEZowWRyWiml0UAeHT1DbsqOlFqa2LD2LB0z9K8CXBRgF0+gw" +
                "BV9CxQAOX1lF+5L1ne8YNtzxAQvyzbdR8e89yDeBfVOKfi+RrhbxVknX2jzcMrGY" +
                "pKs+lcw6lUkTrvqBVMw8+eGnHui61Wn8Oes7xORGJVyZQEbNLdrIDACTaHXQADED" +
                "cpcMyD2s9HSxNP+MpKu7gLKIaVO/IBOPBXkQwP2qjWl+PM9JdkOUUUO46WFctpRs" +
                "7roc9VZgqouruHbYDBWXomIpuQKr9NQ8Rc96hhGizFw1rweY3e0Bnhdkrkyc3ZwK" +
                "4HQULGN7w9w06zsH6WjxEg+VTCF1tuSq9xOL5aJ1bikOsOKx3vGgu7RCR1L4WbJg" +
                "6mKdOjTIctOX6DVf4e/R2QqfIIE6Q585FosBjJuOsmUZuijAAWR+VpCt2eEpWIDD" +
                "V4F8dRVZ9AfppmABlv38+wT381uABbTsFoBldz4ixpJd31cMBnCdFGyA6U0nFbj7" +
                "H3Of1ifcyIM9SWDYQLLViDUJNOVTM3vWpmQU3ZzEmWGGEs849iLrJBZLyQIsFXdz" +
                "Z3U3pVNnZjrxVwrm2n+DHCgZN51NHM7FjRewoyUV+0oeoX05zGLACJCHcdNSsRlK" +
                "Hmcbc1wJF656HCVPAtmMLtfMTk7/M2ma4qriGaZNc2x9CPA8rnpuG6f+fVc9C+BF" +
                "hhCLBwBrtbEgY1rGO44bplyyjPoEQwEBjoMcu1fLIAPoPDH4Euu0QH4RKBnAkTPU" +
                "vQL8Of1lauDATQtwRBeVnvfhSsWXfBVbRysOsFR8BcC3AIzRxUonwULF76QAWJAT" +
                "liG/qywbyHS8HtAEeUDS9YRa+UkyCgb0U1z1YyZQD1YkuUefcEEaWXUAOAYZJbew" +
                "gmtKZvrUkirAxF8AS8WdxONAxd1A7qVn3UPJZIBZDHiOeZA1TSIucxS1HzctFQ9w" +
                "s94QZdNwFTvSHHsZLmMW7EMeQ8kCPI6KxxWLSwEsV13uuWsBngLwFM9pxeHtHE5j" +
                "Ziz37EEWaJYDgli8k4bGfuDKAByiLpaSQ0AOC3LgqrVaqxMPisVKuHxXHdyMZycR" +
                "aXpEcdO2iMcynkaIdqyUmtgAC/JJyiDicNiUTFwGbojr/sMXBVegvTgcqNhc9WUU" +
                "/HeA3/cg3xLkt+lJA/rmO7Qv301xt327Q0yWCXAdLrsORQvy0xRqY9T8UGs/q1Jd" +
                "PQOKBkaMMgE2yFIx1gLoNs4ft9AA8QD7btoH3M1xmG7q415mx71y11kZ1MNFAFai" +
                "5UGWmx6k8fGcsaIA92cnuSHu45KKhyihhnl304gAY6PxgEm6xml+jFM6TdC+nKCN" +
                "OalYzJRpupadaWyaNuasmh+s2xpgKVmNj13UyWTVc5ROMcCCTPm0GAA+RLtSEybO" +
                "LWmt1lqXguwDFlxZRDcAYGG7nRbXa2USgG3j0nPVisExyHphhyVcAD7nA74gwL6C" +
                "Y5D5OwwdwpwZlnHaARf9PknWR8yBP8kxu/tpLhlzPjPhYoYNQNtA8wN7lMBabYKe" +
                "ZM+AfbAm2z3NoLOVwTXE6SwApNHdSmZxj4bIUwDXsxVikAWYuXGTby2CnEbdy40+" +
                "7SwJdLAF0sludSflUncJkyXgynpQcB/WRfOjk4y6m1sDevOzLRYPstYzWE0CRhzu" +
                "y04BcKobYKzoASbxKmF3S5Bx06O0Mse4+HS8llMOjBbHaWFO0t2aYn9LNk1dPCPj" +
                "agjZrJ6s2s4xiJjnauJ5pk0LuOkFQeYQm0aJC8yKPcjABLBskSOnIQE+yHyY1wFo" +
                "pUfLAJ6LVpLF57P0qWXnZBpSqIeNyz3MBOg4jQkGEN7GBz9/iu9LweaqUbHalizE" +
                "RwCsF3aETMHUzDYbZsCv9iWv3YlwMM0uKf2WidS32uj4JG/pzqfLcAXYbGUeSRUJ" +
                "1DramAKNPRJo7HFiqbtHTJaKn2ZykXgW1zbINJRIAjKjxjpAP/kswz1di3Ekpl62" +
                "Id01JGSYNXMm+RlJVwwwkLuKBdeD3FNGnOV8kwBLxV1KugSaG26f52XT6GC9J5cY" +
                "bW6aQQTDiCHuyByiETJUTk+aDZBRGiBjMsHlWKoBpgkygU0JMldBTBtkkiyaHjIB" +
                "VpI1s1VLdbQvaV3KFhhELAB8bieQd3IL/K5lW9jNheHYom7mke2jq0XCZRsfFoMB" +
                "RpIVBbIA2xvSBPgEgI8Tb4+gPEE+TMw9xn70eXrVug3+uOIwCdRJ7BR/rp70BX4R" +
                "mC7ZjfBWFzNhuqpdahodanZ8ifE+JTU9eEmWOlkA/iTX3VmR5+6i4hhggY6HLNAb" +
                "PMiPN5S6BytpftABMxWno2QBFmyU/AQF19H1eiI1+5DrOTHRAOQAcBOA2xhGPMvl" +
                "OItUbEoGqEHGPQO6l6Srk6W9riwgZzD8pwkiyD3plFBYP4sBUvIQ2fVwLUdZNnJB" +
                "C4sBI9waMIK7HiWrlglyTMGoWIAnObw2tY2kinpYoE3FAWSe09XcOLur0APMKwMM" +
                "shSthYAdNDyALNALMgPMyztigMmkARzivukg0TLAQPaU7GfTx3G5XNwSPoY6jwDw" +
                "KHYEtR6lTGIp3rtumKkQe1oyXZZmVw0r2dLBtJcAA/UL4Mu+xG5obUcK/rSAeXCe" +
                "ATbIK4Ad765XklStpbMlwNgjID8W6HUF7h5l1IMVKFOAMzwV16fhrlM4pEYrs46O" +
                "19M1GJDr1wFXhoobOYvcaICJx7jqDoYSHXLTZNNdPLuxHmJxjwCzcisTZFOwIKuV" +
                "aYBVIgWAWYbn+Msw40RBHgP2GMsBY/SoDbAgy0ULcBzkac4ax5Ss5odULMDE5Zka" +
                "GhsszM/hpj3AgKZHraRrgWQrADy/S12uOMCAjrlqg4xyBTcwUzGxWXd6HAWuAcYl" +
                "C7IAy05QIpFseXd56AiLSigGEmp8cPIhco125lU+XyWGm4IBfF0qDiDz+atU7WQV" +
                "LWHE3cIYZAMuNWP3UPc91PwQdx2DjLt+DOA7AL5DQ+RxAvdopbP1QTxuUDwGcANJ" +
                "11OGE09x1wYYVy033YiSG3k2JdDsQMFtbIG0ZXC3dB6n/1nU6wKyAZaSSbxigIHc" +
                "Q9kkFXsKVqODO7UqWJONqRjA9K2HeYfiaK0gezbOms84e1yeq+Z4Ke56UiqOU/K0" +
                "VMwNtzHAG7lDmrNNsxvTgasxoheP59nfEuQFlCwVC7QBBvLinmXIBljJlgzIEW7I" +
                "CwBHlWipVNK1SwCOCLBBprlx2Af8OfEVwFrC8yCjYq3UCrBWeK4D2O6SxhVzA4BG" +
                "iOamA8i46ugNpkn3VgEYuHdX06kC9F19/jQ/BvsuihZg2YPP4pSMmu9SPt15myEF" +
                "rc0nKSwBKOlKI+kiNtenMCpk8vRUWyGBioEcA4yKW1nYCyC30+XqZPujC8gCbKby" +
                "idGiIHdnZrkeqTjdc9U9uOp+Jk5DAlwZD5mL05gfj9D8GI0DPLGZ65UAPbmRc8P0" +
                "ql+FLCUbYFQsBc9QMk0BeBqbY0nPA4yCBRhbEGSNEXcQcwWamLwA5AVfyVrIC3MS" +
                "QmaQuX4pgKxYHFV/+qin4MhRJk0CrF2tAPBJlOgDNshy0wIs9co9A9m7DZ4J0hdA" +
                "ZsvDLg3XCyx9N22A7+Oi76+kgbHSg2tqlqID2HLfUrFvD313/QgV330v2d35/QZc" +
                "NU2OjymP0jnpgNWTZddTPpmSqZHrBZmYXC8Vr5WCZRxGo4xqJaNuw9oVj3HXXQwm" +
                "PMiomYteOlkQkHUZZE4cmqtONSW3tnDDAAAvBElEQVT3cxx1qJxTDpiBtliMq+Y5" +
                "gopH6G4tq5iDaZs4/b8Z2wJoGaPFQMlTZNeCPEvSNSvIamNqzZYaWZDnKZsWlHBx" +
                "D+b8fu1nqakhJdOiRMUeZAH2YrKW8sKHAIwZYG4ECB8Hjh+Ho1x3GNYdlxojAtiD" +
                "LNCUPkq2TqLsC/y8tixNxQzwARy9KjcNREHmFp7INUBz4sGMe7TCX/G9r/ma46UG" +
                "+PaHOQAuBLCMCRF2j89SsiDfN9NcmCRsRQ7TI9z1Gk49APj+R+nu7lsb3F26X/cA" +
                "/YjtzEZi8VMANwgyrroR0I0GmbXaNemuHjU3GGSmSwwkWmlnSskxyOxyddEA6VY8" +
                "1syYW24708miZQZZrjrDdTNeHADwYADXV/JwtRItINPCHCnDVTNOHEfJZgCe2MTp" +
                "f46+TAF4aquMz1vVwSLpEuStjAoBPMfWx1QFpyF8wBaP97MjTckkwAFkKXkRJRtg" +
                "DSFQ8MIeVP13gOWuAcC9HgaZxocB1kIAkAU4Blkx+CQAlU1rjecSbhoTaIOsBQCV" +
                "TAIt9xwA1vMG9jUZOLfSAlp1cBatSsDFIHugcd0Wlx/wFOQHa3DP2APVyEB+BOQH";
        String imageString12 =
                "JGB33tzguWlBlqtmSUCAPRULMMdKcddNdLwa2LU2wGTXgtzM6m0L9XE8YFMykLsV" +
                "j3MBnMpNtWksxANY1g1cqbiHkxL9HDIfpBkiyBaLcdXD2IggV5JsCbDiMQsBAWQD" +
                "LBVjBlmw2cac4SjqNKXTNAfaDLLmxupu+TZDVj2L217gTup5NT98FQdKtvalAPuQ" +
                "vb1pKdiLw7q0JcyBtTBXPkR0SO0UCuZ2PDMfsJRsQ4gTxN94wEC2dVqdWdK1w1cF" +
                "XoAxZdJScQD6S8DalcNk2l9TJt16P2cJo9esOKuJEX3lGGxP0fr6wWpqYUA/+sy3" +
                "NTxx17ffADBw79LavIOa75F4GWBGjA1JHmCDLNAkXg3rgBwAZllAbroNyFKwqZjn" +
                "M5KuTq5S7OKmvc5k4AJZsbiLONxN2dTHIba+PPayuM54gGshBrimSa5abtoAV1Iy" +
                "kXiN0N0ywLzudpzMWpAF2CCj5ilTMurlfNO0DMCzJFqzJFxy1dO1Weam5aqVcM1U" +
                "cgvtDpYAFINpZS7EXDWDBnaqF+hPC/AiFtoHTDU/aHwErjqimCwVc+1DhJ2tMO9+" +
                "iAEmBivZ0skHc89ngKZ9Lfa0TMWmZMAaZAFXX5qftXjM50DFANZFLbryP/JVpoYN" +
                "uQbYg5wPYJRroAO37T2lZEF+gOuWgu+8m+Zu/nYdzY5yFuDZl06ikyVL4ZzxKnrV" +
                "6+hmoeaGRIYNwJU1B5DX4srJrpuZJ7fQt24zVx0HOJU7PWhldgK4W5bNfhYLAj1s" +
                "gfSw/dHLtKmPsaIA9xUyceLqxOdc9DJIVj1E4jXMMZgRKbmMZMtX8Rj3VY+TWU/w" +
                "mp+JwFUHSgbuDCqOKXgjVy+Vcjk4l7vMcU/13D7csoxFvQXGi/M7uGqJkeIiR1+W" +
                "IXsxeZFTEAK8yEgxzB51PGAv6WKZXTtbHBYPH+fzMRR3HDtBZsxKT+RzwJzCBPc0" +
                "X59GoWewsxgz4mARIModHh5gIOsOD+1qCbIPWJAN8N2P85fuEndvvZ+LoeSP8ymP" +
                "pGSB9mDfB+7dj3LcT79NcD/+x2fuh1+ucT/9xxp38zcAXs+Z4g10t7AnCWTNSWXu" +
                "IbPlxyuziLms3rLr9ZQV3PoN9KWTGPoTl5sZMTai4maOxZiCUXFLEmu1CdxIi7Un" +
                "etZNfdyV6UE2wIKcC2Ag9xWwXYmL7udA23PuxRzABgWZVZ8hrlIcLmWqxPubxhhM" +
                "jOKupeQxMusJg+zHYgFWLN5CXC6nR124wU0UrHcT+euwtWTSOt3ARIk7Mhe4gFyQ" +
                "BXi2lrHhDv5sJ9sdbH8s7Mb2sdJD6aTEywYRe+hScewlzL1bYR132U93ay9l0X62" +
                "JQ+QMXPtQ5gXTIePAUaADTJPAT6JsRwf1t2WAiwTYG16nOMXg7ZlhIX4KLWwrjuM" +
                "3cTzBX8/gIybfnGDGHzzzfSl+2tK2b0qpTwqwlUDeAU17scFDBuy3E+/S3Lf//tn" +
                "7i+/WOm+/7fVfF4N4NXuRyDf+u0G6mEPbh296qd0uAT4wXsMJCih6nzAT5hAPV3L" +
                "iYd13AJARt1Ip6uZI6pNxOQmMmtZC1l1K/VxG+WTID9jp7pbZRMnJLoUk7OAK8BY" +
                "L9dE9AG5vxjAQH5eiJoBLsBDAsxGphnnnEbJqMd4E8w4oMercdNsZkrF40yexhlG" +
                "jBUkurHstW485zM3liew69yknrkA5q1rc8TiedqXMkFeYG48W5nk5lgOiAEWZNke" +
                "Tv0zK7ZRInBDe8iuSbpCVh9L1QDeJwMwyZZWa8PcChBTsSB/jgE4ylpt5ByJ1VkA" +
                "SsGmYjJjAEdZqY1oIZ7beOzScB0vvc7P0fSw04d28oFs/CLDhh9/l7J0F5gGWaBl" +
                "q0rcX/9tjfvLv6zGVrm//Osqg/sDgM0EGAXfeoN3N6xlHgxkU28c4PvE5Ycf0K8W" +
                "ZKz+MwBjjQYZNeOe5aIbyKwb2eVqAXIrkNvodMk6mDp10qvuogEiwLIe3LUBFmRW" +
                "bvuLPMADUjKATcXAHuL180O0MYe42XaIseIYF65NbOImeD05VD7CofLhjHVuNEu2" +
                "FsDrALweE+gA8lpcNmNDkq8A7rwAq9NFLJ5VK1P1MSpeBg1cLh1f3IcxSrRY/BJg" +
                "HzIXimvSZID1FjVUHFOyAEvFAI6eJaGSis/iegX4NAo2FQNYwwdu5InoLg8B/pKf" +
                "5dSDDoiHTn3Iwt+H/PxHf3vtp9+mLP30O64TXs0AYXWZAb4nl/1OpvvhP9cDeKX7" +
                "K5C//8UaDAX/YpX7UaBR8u232MHyk64n64EsIx7fZ7x4z0qnBFdHz1quul5uGsAN" +
                "PAW5ESW3UD7JVTcBuRlr4RI2gwzojkze8cBmZpcgS8XUyN246x5ZNsdLDTDXDnMD" +
                "/QBKHuD1AgMvQQa0hg+cbxotp1Ti6OkENg7gMWbHY8WZbiQzDrBBFmAMBY9LwUq6" +
                "dlAS+Qq2J+XTLGeOpeLZTSzjcYPPy4CBHABGxYu7gLkbk4qx8B56zywFhLUQoJmx" +
                "lOwDtqfFYgCfJgYLsLlqPp8RdMAKsJbjDTBDCqZLy7cAABg3Hb3C9ubZTwVZgFOX" +
                "gMzcl7akQS6li1UI4CyzH/8rwf31n1e5vwI2ABwo+fbbqVY6PSK7fsx4sQ57gqu+" +
                "x+pPAPiBBhKKw6ZiXHQMMApWPGasGAP8WZpro1/dJsAcZutkbtwlYyBhgIFsgIHc" +
                "SwnVTytzGTDXDheyEO9DHpK75q7qIW6aH0bF5qIZM45vAbASLo6/jDN1Gs1CuShZ" +
                "NhFAlovGlHjNyoBqKgb03E7OFBvgRCBjHGAT4MAWd6FebpM3BUvFKDiAvAhoAQ4d" +
                "BhhwZQZaJyECyMf5JTiBncE9YwHgsJIuNj1eVjCAda/WVakYuKhYyZYuTItelQtf" +
                "DeBfpy79+JtUYi13Rq8qM7vz8TLgW+9mu5tvpLm//LOvZHPXnsu+824GpRN3amF1" +
                "KDkAfP/NRHdPJRN2nwbI44/SfMB5yypO4E4tALdQIzfS/DAFM5RoXSsXzRvTWO2R" +
                "daLebgB3o+guyqduH3Iv33vO0VRz076KB6VkXLQgB4AHczPdEGPF0QouRgPwBCcU" +
                "x5RwAVeQJwQ6l1sAMlGuAGMTqHgibz2ASagEWG6asmlB8Xg7d2yV0wDh9p7ZKlRc" +
                "g6smq14g6VoAtAGWmxZczjKpXFrcKRWTXGGLvK4nfITtj2NxgD8HdAww7lpTJhQc" +
                "VhyWgjHLquWqdcRFCiYOh7mVJ3xGkBkxBrcAKA7r/JJBphf9069w0b9OdT9it96h" +
                "4YGbvv1BHlsdnoKVaHlqxmX/6xrPXQsyir77Pms61MgPV3GnhyBLwcThewC+TwPE" +
                "DMgPWeB7slqdLLlpVIw1bgAwZVMLtXEL7rp5NS5abhprowHSkcmEicNsnUDuYuVW" +
                "kLvoV3uAFYO5uJSOVz8rPwPEYs9N0/ggHg9QRg0qFqNgAR7mnRFSsjLqcU5IjFE6" +
                "xQBXcoRF2XUBW5eoWPHYAOdvWAYM5Dkue5kXYBKvaS51mUbFM1JwVaKb28wreAC8" +
                "uBPQUjAWUkYtwDqshpsOVGygNWFi4+MlFR+PV7EPWG4ayCESrdBZgEvFeu+hlPwK" +
                "YF15aApmsvQS4B9/nbL0w69TAJziBPruimJWdAD8e5T7+yxAZ7pbwL6Nkm+/C+Rf" +
                "rnXfE5e/Jy7fM8Bc87CywCArHisO33uDrhYNEAF+QANE9lCuGsgGGNBNAkwjpAXI";
        String imageString13 =
                "rai4mV61VCzQ7dwk0MEmpqxTrhrzsmlKJiD3oOI+rk/so1c9IMA+ZLnrQfa5hqiP" +
                "h6RiFgMGsz24AjxCdj3OCu6YyicgT5RxA0A5KmY5YFKgS9nZkrsW5EIA0sqcoZVp" +
                "KgbyPBe9zG0pcDNlUrDiMHANcpJbYGFekBc4UG4qpn1p2x4oOaSYbJBRsZYBAGyz" +
                "YiALtHrUZjEVk1mfRrlSsQy4gizA4XM8rWRCwaeWFazXwgtwWDUxx1oUh6NXuPFd" +
                "ChbgAPKtt3MAmuNuvgVcg5ztbgH6tikZyO9lu59/leh+IC7f+4DrDwV3pQf5MSp+" +
                "QlZ9l/Lp7uu46DfWo2ZAG2TemvZxOpDpZGFNiVx5CGCDrFhMnaxYrGxagJ9xk8BL" +
                "gKVirIuFPan4OTVyP+91MpOrxqTkIdz0ECoeYmFvKB8FCzCnJIak5DxeC08bc4wM" +
                "2wMMZAGWqxZgbIIdLsXiySImSXS6ZrE5GiGCPCfAND9mSoFfhuGmDTCQ52tZhTUV" +
                "A5hLx9WfDtZ5wgcCFQOYzlaIG/PiAS8yaQqdkNtWySQXTRJ2iq9lPmQpOQZY7yA+" +
                "y3619rZOJ/humv71JVR8GfAs4xnkyxxd+fG/kpd++M9k98N/AZnn9/+Z5H5+I9P9" +
                "/DortDI+33wTN/1WpruNku8A+s67fP1mugf4EwDT+XpIi1NKrmNufIcOlwDLAlf9" +
                "QK6aXvXTVTRAGEo0EYMDyFKxrIml+lbOO3mABdlXshQswGTVlkmj4j5cdABYCu5H" +
                "zYMo2AADeViQWb0dZN1HkAd5Fe4gu1sjHCgfI7seK+KSFi57GS/jiZIVjydlQJ6q" +
                "opPFZqbgzgiyVAzkOSDPcH2xB5hSicvWBFiuWs95dqoXOfKySOMjJMA+ZHPVe1G4" +
                "YjGHx8MCrL0tXu5hCkbFIU2aThBrj5CI0dEK603irwD2XDUKPi818zNsfYRO86bR" +
                "Uyy+n+YA+OnPqI+1oMfONQt5kUuJf3vtr/+2fukv/7KOckimsmg9K7NZFpNN2b+S" +
                "62aV9jcY2bbs5u/Iut+gtKJ//VAtTAA/ALCULBXf/s16d/d32Ovr3D0f8gNz1+td" +
                "HWefpODGBLpaMlMyNwEwdWpZz+ABJbdTPj0zFQeumlgM5G7icQ9ZdQ/JVp+SLFT8" +
                "HBU/l6uWgrkEdZDTioO0MQc5BjOYw2otL7PuT010A9hgKvdn8aofwR1hSW+MV/yM" +
                "cQRmrJB9aS4/lU34NlUNSK5rMsCC7Kt4ppbjLSVSMK3MMmJwKeYDnqtKcAucb1rk" +
                "yuIQJxMF2IYQfsK1yNkmAQ5xO4Agh81V+5BRcRgVR6zDBcCTAoxLFmhUHLGXXPJ9" +
                "yqUwNXH4jAYTazjhuIpbBrDPZVyOdpFjLecYN5qt+9trP/wycemvwI23n99EwW9k" +
                "G2TFZoFWfI4HfPP1VHfnPZIyWpuCLHtEn1oqvv0bBhDY3ddx0YKMq35ATJY9RMn1" +
                "tDEb1wN3A6oFcIsgY630rdvocrWnFHJGKU7BxOIuFud7gNyDkns4kirABlmg6VE/" +
                "p9P1nKsTn3PmaYAL2AbzeGZnuQEAywZTk9xAGpejCTA96zF62KO8U3FUkAW4CMBY" +
                "DHANo8MaVmWJw7O83ieIwzMcg5kuQb3sV88IrkwZtdw1Cdf8Rhbj6VMLsI0RAxXL" +
                "TR9AtbZi6ytYSraMGrgWi1HwcaB+jgmwmWpmlU4kT1iYOXH4FM/TXIJ6DOUeXe1B" +
                "BnToBIAv6FgpKjbAaz3A//t/rHWyv/wzKv5XLkR7izgryK+TVKHgH3HfP+pJORVA" +
                "vvWGXDSbH7jsh5ZJAxj1PmbK9OA93lT6QZZ7xDru44+46PRjtiw/znCP2d+qW8EK" +
                "D8lWA4lWg5RM86OJFdxmns20M5vlpimX2jfgqhM4oEa/uoNedScDiS6mTt2KwZhU" +
                "bIa77lVM5n0SgvucJkg/NpjrAe5nG3MgOcENAnkoBcA5AKWdOU7CNVbIWq2yax+y" +
                "QAvwJDZTSzmEu55h+8MgKwZjs1vZ/EDFs8Ti2Y1sWHJacY6D5PO0Lhe4smmBZwjA" +
                "yqhDSrh4Lu7GPXNTjxS8oMaH+tJc5hI6gOkcE1cihrkSMaIhxBEUKjet9y8d01MG" +
                "VMEV5M99wNw5HTqRyIkKlCsVC7AUDGCt1Npa7TlalVLwX/55A4DXxSAbXAEOIP9X" +
                "sgcYyD8LMu76Dtn1vY/oWROX7xKTTcFqeGAPPuTr97l3+iNej2eAs9yTFSzLf8oT" +
                "q6fx0cihtgamTo3YMmBAA7h5JR0tauN2jqI+466uDiB3UjrJulJ4/yHWQTuzh6lT" +
                "jwHGZQP8Oe3MAZQcD3ggg7kxr8IV4MEAMNOnMWxc2TSQxwqIy4GSC1ExSp5hYW+a" +
                "jcxpuWpGjKZilGxxGBXPcoPArOByRcSchhJbKJE4UL6wDbB7KZGIwxaPDbJ60sCX" +
                "7aAWxiybNsjeueIw55kiOjh+GJAHdUCNJTxbyPMha732BPWvAH/O51P8G1ygFjr2" +
                "GUr2Iccr2Du79LfXvv9l8tL3v0xy//v/AfD/ux7I691PJFY/oV4p2BKuNzJQsQf5" +
                "p19xQA3Qd99lfvwRmx9vc78HKr7/fh7uGcBy1bjp+29xEO3DbPcQyHUfc4+WbAWA" +
                "P+H88FqW4eWegdwoFSvpMhUDmHKp6VMAA7mFkunZ+iwAc1AtifFhYo4PGVUnMCdm" +
                "KNGTnG0K7gO0APfLcNUDqHiA2fEAGyED3CBgKk7eYAoelXvGxuhZj0nJAB7PR73E" +
                "Y3PTXL42bYCpeavyDHLgqg0wZ55maziFGCgY5c7zOgEBXuToyyJnnBYNsubDUjFK" +
                "3YWKtc6zHde6wze1MHUzgB0ep74NAOuVeftRIQfGX1Ixs+KYinHVIQ6phY5v4EoJ" +
                "1GuQV3KvB78YthhvyRZJ1r8LcDLuGRUDWE/Lnn+XsQwZ0Dd/l26umrLKCfK99/Pd" +
                "vQ/ZxHzHA3wXJT9YoXLJg3z3LQ6Hv51mkB/jqgVYKn4C5Ia1zIgNMPUvsVeQm3zI" +
                "9uRCthZMkNuwdtqXHYmAFmSsK1kKZgkA6xJkJk997HQ9l4plAeAMALP5MZjGFUy8" +
                "73gQJQ+TeI0wWjTARYLMRWmUTeNAFuBJWSlxVoDZBJGbNqtFsYrFmh1X46I5AjPD" +
                "1RBy0fOmZCBrWV6lEoBD+1CxjLPGi+xRC7DMA0yc3oHxvuLFXbja/QwI5KoPSsG4" +
                "ZgOsg+JAOijIgJX5gKVkxeLQcQAL8pHVxGJULAWfp1NmmbRiscqkf6NM+rdk99d/" +
                "TXR/QcUeYJQL4MB+4vNNqfm3QFYsxu58yF70+7hoethWPgH4HgMKK5dQ8b132Nd6" +
                "U2NDYi9K9gB7kBvYBGmi62VJFipWLaxY3AzoZoH+hBviDbKn5LZVdLfWpJmSOwHd" +
                "lcS1xIJLz7qbZw9q7mGGHEA2FROT+1nWG2DdR5AHeC39QCJZNNsgIzRBPMBy1ZRJ";
        String imageString14 =
                "XNNkBlxBnqI2nmIDZCoO8AxKnmGfeo67qmdZ1ptlfjxXgcUAy10DmWU9U7BUrEya" +
                "5bwQx120mBfaRQzeDpjtqpmBu1PG513YXqABWSqOHAL4fgAfQMUygWadx4MsV43h" +
                "qmOAj3LC3wBz6AzAofPAVbJ1gVZlAPiHXyQZ4L/+DxT82yzgvgxZsAPIP/8mzd0l" +
                "wRLge++xdUmNfJdmiFz1PTpeUvF9ulx33kwGMtc7EI8NMkp+gpIbqJUFuHE9T5Tc" +
                "DGTLpAV5DYBXAJhD5S1cEdG6kmuIBZgzx+2CTJ/aALNX3ck7njzIABZkjqWaq0bF" +
                "/QKclkmJ5ANOwk0nSMHLgAPIAeAJDpTLVU+yjTlVxSpPNUZtPFVBaeQreW4zR0uV" +
                "WZcBt5zD4dWZbo4NEIvFuOl5zjUtcPQlHnKY1Z7Fvdr0IBbvYPgQADbIJEUCvIs7" +
                "PPayi3WQRArIoX3xgAWZpobOMcWUrDIJ9cpQ8eJhFIybjuhurXP8m6g4IsA//MJT" +
                "sFT8F7loAP/0G6kVyGYCvQxbkG+RZd99l8WA94CMxQCTeN19m3s83gcySwN3X8eV" +
                "S8W/52wxKn4iA3I9O9WNAG6gVGoWYKwFyK3scTUzbTIFB4ANMpezcGpRgJ/R7epg" +
                "ftyFkgPAXSRc3bwWtyeRey0TOa/EpS/9ZNYCPJCCew7c9AZfwfSqBfcfAZ6g+THJ" +
                "BsgUbyufYiNzqjzfFB0AnkXJc6qLyzm6YioGcq2SLiBjC9w2v8Dx0xhglUlWE1M6" +
                "7cV9C/A2gMYg8zlQ8W5AYuH9gNyHAvfytWIxChZgg6yLTE8A8YSSMJocPuDQ0TV8" +
                "5nQ/Co4I8Hkf8Pe/SFz6HvV+/wu6WP+axGgQBQNYkAPzFK1uFu74He7l+Ih25Ack" +
                "WPGATcUe4PuAfkR9fO/1FHf/Dc8evZ3u6izholVJO7MRFQtyEyqOQbZaGFVzlWLT" +
                "h7xCHmvGWj5KMGv9eINrW7HBtWNy1d0kWF1cftqN9WC9ydxMKxUnAZkb9vrT1Ogg" +
                "ixZkuWrc9HCumhzc4SHI3CAwRjyWghWHJ8qKUC+umeOpU4JcTQyWgnmH07RUjM2g" +
                "5Fni8RynI2bLgIuK5apnicfzKHmBaZMBDlTM3lbQ9Ajt9yAvbKa82YLqsIWtsg2e" +
                "bV8H+HWUVxw6O6KYDEhl07Z9CfDDMn4BdFiN04ihI/zcMSBzAjF0bC3GAfBz/PxZ" +
                "D7Dnon+VvvQ96vUg46b/JZGmxjLcn36Let/KJc7meybAH3NJ2ooSIKNSIN+m83WH" +
                "kuquD1mAHzCYePB7amWpGLuPkh8Rj+s4KfHUB2xxGMjNUrJsHQfE12MMIhreXu8a" +
                "313vmrikXNaCtX7oWfunCSy+MxtOZ4RIPFYmrUSrl7KpNy3bPcf6M2h6JHLqkDgc" +
                "AO5PSqEvDWBqZA+wYrCGDoAtZ7UWm6xiR4szTlPsVstNT1dwEvEVwAa5mqQLNy3I" +
                "UvJsFU8BZkFggeuaFgPAisVmxGHOFof28QuwBcC169zCJmwztsWzxa0A3ko8VbJ1" +
                "hK4VdXHEX62NHCFGW9nEU7Uxd0/bjbVH5aaBzElEdbbUoxZg75gpLvp//d9rl26+" +
                "kWvu+Idfpliy9eOv0lmwY5r0Zh6DBwD+Ps7eIe6iYNl9IN8D8h1c9m361Xcwg0wT" +
                "5A7tzLu/4wD5r3gfxK8YPLCwd/919rRWMBOmGdJAU6RhNdm0jH3rps/oTZNdt7CJ" +
                "KVfdyLXGgtwkyLxTouUDTIA/WIdrJv5SI/ekMfhntafbh9xLfdzHzQEC/Jx1294V" +
                "q+k/MzbMY0bMm2AGUlLdMBn2MIt7Y0VsebA4L5tg9XYSyBMCzDBiGgWbcYBtWkpm" +
                "djxNz9pULNj0qadLOSzOxGm2kF60Olvc/THHNRHz2gDZoSMtgGTbY4ETigvKpGW0" +
                "MMNSsRoeNWuXIW9aC2RsK9/bwcnCw3SyVDKxQ+1l1SjZdqepg5VsURMv7qUkOsTP" +
                "sl6rzpZl01IwcC2TvsTPXmJt9k//tIJ5MJMjYN58K48SCbAo9uabMr4nyG/lM1GS" +
                "5bnb77Nh+QELeh8C+WMAY3ffYSOTwcSt36a527Q1ZXd+y7EW7DZrP7f/g+HDf2H/" +
                "sdZTMHXyU6xhFeYDbhZkA0wspkfdQiyu//06T8XvrHfN760zyK2A7mTVtnODXDNd" +
                "LAD3skttKkbJfT7k3tUbDHDfZwkMHRg+8PKuEXrVI/SoR4E7xopPPOAA8iTKXQbM" +
                "PVo1KLoUqBwon2LNZ5omyHQJNwKYcfWD5saFCWazxYwNtRwgN61ky9Z5PMgCHNrr" +
                "tTDDB1H1Jly0VLwRE+DNHuSQsmld4nJAKgXwMUHms5SMig0wbnpxx0cutONDyiX+" +
                "7CxK1/VLZ/i75ymzLvI9JksG+I//9MnSn/+vTwFZQFMDoK9rPVYTpABy8NQvAAnV" +
                "h3LNngVKVsJ1501+MZhG3f61bBnw3d8kudv/Dtz/pCeNPUW5UnA97c3GlTQ8OCkh" +
                "yE0AbiYet3A0tZWkq42rm5q4YrERuFKxAcZNt5NRC3AHgJVoyU0bZI6/9BpgFuNT" +
                "+P7Ha7DVrvfjVZZsDXEMRpCl4FEGEoI8zvQpAC3AE1zbNMVdmVPczSXIMywITLOJ" +
                "aW66kLu1aGUa4GKOlmIGma3MGUHG5sioDbDctJItIM9LxdjiLrlnLx5LxWGt9dTg" +
                "koG8WOsBXkTFtiR/AEj7gcRb1QyyBhCHgWeQyZ73MmTY+THZN5D3sXt1hl8IAWZf" +
                "y1y0IF8A8MWMv732BwD/4Z9WmGu+CeCfX8+loaEaOFBwABiVouI77yvB8gGj4rvv" +
                "kE3L3sV1syhwR0qmEXL715w8RMH3mD7d+U9OPfwSwL/mghZamfUMJTzIBXwOALMA" +
                "EAAmo25TVq2O19sbXLNMbvp9kit2qzs5lio33UXJFLjp54Duk6IVi9eluK4PV7qe" +
                "jwQYW/n/t3WezVHdVxzOh0k8k4mNK5PQOxZEQRT1LtGMTcemGNFRBZvg4Ikzcb5B" +
                "CGBsqpCEBGJVLLRqK7rYlXYl3XvlD6Dx3Dy/c+8KwuTFmdXYst88OuV/zu+cLWQe" +
                "DNwQ8IttQJ4B/MqbRw9w1kGAMfNi8rFCdIqKOsWTyQouvHgMVeZYGjBf95PaKcDF" +
                "dLMAiRLT8jAh2g1NkD15cDiEEGhBdo6UEaoDyE4VLUeaHlp1MbgCrFwsLzYDYpiP" +
                "vVPrAQxcAcamWHUJAANW9zz+yX+bBnyREC3AF3+/wTw4ALwVyBRXyxWid8x4cyP5" +
                "dwYwoO+sAigWAA6eTC0UXbIm5WG8uWlJYAKsivoBnmsmTw7zsIVpVlO7iwL7GdAC" +
                "LOtCX92dUeJ3rS7xe2iA9DFx6kPi019IBU0bc4j1l2G+a3GYUG2Q8eSBrDy/D8CD" +
                "a3Px4lwL1U+orF8wQ5YHv9jKW5iJ08tdwLVwjTfLgwE8ypd1jclYg0nuVycrNAou" +
                "g2zND55ODCTkwebJOwjRmMPFgLQJrndakNXk4JOiS4CnrKrm53rlZXLxIcCSj1Vw" +
                "mRgAkbxXH3owHa4ZwOfx4vMAb+C5dBzvPYkB2T2dxR8GodpUl4CVykNaLYnj5cEX" +
                "f7t++uLvNvj/fmu9f+U9Jkl4seCaLQKywjaQ9dmYyTBfYP/MzDeD9ZU04BBys7yY" +
                "FmZLJrNhmiB36XK1ALpJYXteMdoszjrgvQJsXszPHXh0UGiFHgzkn1VJU1X3Eqp7" +
                "NJhYWeR3ZRCeyct9CAX6i+hJA1hePMjUKVaJ93KPywADeiC72B9YX+APZgF4bY4B" +
                "jq3P9Z9t4xIPxdZzAea7nEYovqzYkjdbiBZgTFU1NvYFjQ4BDkGbJ9MEGef5JEvp" +
                "2bSXlqW8mIJrkg0Jh01FF7lt2nsNLvtMU7yNPbUwBdhyMR7NCNGpKvUn5cXH8bwG" +
                "4GrCBOA0ZE8La6qo5cXotrwGcvdpmhp4sUceFmDz5K8psNBNe3wHk3nxd3j19wC+" +
                "Orts+vI7+f7Ft7J9gb42fzPKDg0X3oSMt2ai11qF4lLFFpYG3CzAhOcWQnUz+VjN" +
                "j7sCzQCilc82ul1NhOo21mPaWYuJ0MqMsOfUUcCR0kKOlvLZvnqj/+DjcgYNfFMa" +
                "xdZDQPdQUT+kou76C16MRflZgPuA21egRgd5uISQzCWfGICHN7PGso2vpi3kIk8R" +
                "F3gI1bH8Uj+2ocAfJlQ/LuIdDNjn9KgNMqBHdjA6NMCss3C6KUFVPbqPvWFsDMhJ" +
                "Kusxdp0sVFu4ZrIUAp7Am2XjnE2c4MkUAFb+xSi2XNZQZY561Pvx8KO0F5WLLVQD" +
                "2LyY7tchANdqhMgkSpqtWn6vHlgCzSjR1k4FmFWXX7Q0DmTvDE+jBp5GddlAJlTX" +
                "rAEseRqVR+DFNDr+gSaLdy+KDr1/mSh9WEonC73VvE3+T4CegbxE+qxdZrfx5ttU" +
                "27f1Njaj+UGBdXsFzyS6XLLGpVvIv3oq0dI0o13JH8B94LazbB5Bfx3JfwW4k1Dd" +
                "yf5xJJNrtUtRfSASiKDE7GQzooejqD1co3+IEjPK+7hPBlwDzBLbAGuoMdZgYgrT" +
                "Wxj+b93jD/OEihVWGuBHJdzSKuE9XMx1HgA/3YhGi7exIL9g2jSyDfkOoTrOGmqc" +
                "yjqB1CfBXS4DzL3qMaZNYzRBxuhwJWllJhlOJDm8ltwrY/twL9Ievsh6soqzw/Sp" +
                "HaS2kygwHTYUZS5PJoVph/tbk5L1fF4IUGBXVfC7wKK75RyjTdkgHReFVx2AJa+1" +
                "NRdA861q3jngnkcMIMCYW48XNwD4LPaVDLnOWTpZX1OkMSOeYoxoX3b53RuAr84u" +
                "96+8K+lOADz9+eNcZsCAVfH107yNrLGg4bLOF38Mc1hIm1PmX5+Llouxo+zWfN6/" +
                "CziBuFCF1iY8l6+s5b18j72n9hwW1FiNiWDmwYToLjxakCNZXAFgfty+vATQhX77" +
                "CkADu2OlwjNSniKq52KMkeIrwEBmxymGzCcADGS9jwvwXiA/Kg7ssUAXIt/BnpRV" +
                "Mlmi6VHBu5i38Us6W2b0qeNouOLMkOPc5Ypv5RreJ9y0/GQTQjyOpnGXawypj5kq" +
                "ambHKTpdE1+yw3SYipketQtg2SvA5F/E8g6iAOcYx1oOVfiTX1CQHSjCCnznAPn3" +
                "BONDAa4HXg1AAaznknaYvDoaF6qmBVhPJgGmfenW4cXy5BCwILtnsvljAPJfMX3+" +
                "DUXHjAfPLvMvzSryL7+NsoNuVhouIRzP3cnmw56gCFNOxm7ynLqlNzPeenMhuuq5" +
                "Ff4NQKcBNwK5mVlxK+G5TWEau8eA4j5bEwYY0B3yYvRcneRk5eIOulwR1B8dWCSj" +
                "3I8sKwwAA7qHI6hROl1ReTJHyaMGmU961X1cuB1ABRIjRBvkLRwrLSBMmxdXALnC" +
                "QvVwXpH/KL+EoUMAWJBfbGXrgduY8t44z6cE2xEJFJkJNhQTtDFHOb6W4BvZRhHs" +
                "CfAo97jG+JQXjx+gXWnhmilTCNnBiw2wvFihmudSOh87R3lGyY6ovSnAePNBeXQx" +
                "wOSZzI6l+JA4T5AZJ3qn8NZqPNIgh3n4DK1IAMuLXbzYPQvcOvIyTyZPuViAZd/k";
        String imageString15 =
                "//qbH8jBgnh5VqF/+Z0CsysflMwAvvlxAFeAb+tnVdZWePFsogmiYqtROZgWZtMq" +
                "Ci+0XI1LaFHSt25BFPA/gLMI00B+oDAtwDlABXCHvYkBjSd3oAbpWMvGoebGmdz9" +
                "kAej6episTxK4RVlpBhFmSnAvQwkopxP7OOUcV92OZC5I608TKiOseckLx4Gciyv" +
                "jKdSiT+MPcotxoM3+k/xYoXpOOeaEhxcS6CnDgBzoIWQLcCje4NcbAUX3wBj4Vrh" +
                "mTCdooU5fgDPtaIrBAzkSVZSFabNkPc4JzAaHwaZU8UOX8zlHGXwjzc7B+XJAJYn" +
                "c8RFO8WmvKwGLqNE7yQV80kVVTK6VkyarNDSvLgOsPVYA42S2hwzl3zsfUWr81wA" +
                "mX1iAH9UOn0JsJfezjczyO+h0Zpd6t9QvhXYtK3m5xBw4wr+nSprK7g4mgboJkA3" +
                "LkdDjSLkziK+iwkvviNxwEpWXIB9D8D32JpoX0s4FmQktwIcND2CUC0v7mC82Emo" +
                "7sKTu9dyHQ9FZiege/MJ03y9QC+ivd51TJg4Y9zLAdQ05H6OkQ/kAhVF5jCHXmJ5" +
                "nFzKKfWHNhT5MSrr4dwQcEkF8h0Ed3uUdzGDDGgaHzOQ5cGI814VXMh3lJOR3CaV" +
                "j8NQneJdPE77cgJ5z+RhQFeRbwnVDlJbxwAHT6fAi2l6VIVejCe7HBx3DpOXFaaP" +
                "MVWq0cUe4GnSdAKomCC78uIQsic5D40Pt1Zez39XDdyaALBTm82JCYb/AqwNiH/x" +
                "BdHk3OnLs/BceTD5V3bl/WL/Og2PW1TNt1bv5go8n2nIhOtbwNXTSZAbgXxHnrwS" +
                "wTxjxdtLOEvM7LiZ9qXCdOP8MtqVdLPIx3outbDn1MpI8T75+AFS2wiWDtPKxV1q" +
                "Xwow+bgLyN2CjHVy2rgH0d5DQnUPB1F76FX3ymYA832HeHE/3izIMTVBcsr9ISZP" +
                "QwwnYrml/jCe/KiAQos38cgevgqPc00vWWAT5IRBDrw4rjAtLxbgtBej/hhjic0A" +
                "481Jgear91JsL6Z2oLDcxY4SX0FvY0R0XFZ02bNJXgzkMFQ7uvMRhmrvGD1lQa6q" +
                "BLQgAv84cDWMmAEsyBRS9KjlxW6Niitydi0TqOpc4BKaa7G6PJbQUVieodj6O+9n" +
                "nXz4HsDXlm6bFszry3j/kleDnz/zf1QxxXMpnX8NNLDlzZaDLUwLNCF7mbYdNrPx" +
                "j5GTBbhFIVvjReRABhhPvkN3q3kRRkerNYPf4fM+U6cO9aUBrVxsBRdebIBfh4wa" +
                "U4B7shAArEPKsw69FmPFaA6tSy7q9SPSG6SiHpIh8RliiW0IxcdjOlyPt7B1SF5+" +
                "gvT2GftOz9BtPWV2/ILuliCbFxtkvFlenAYM5FHl4x2AFdzQUlTVqf3otRAHCHJy" +
                "O1sQIeRxNiImeBfr2SRprUN3S57spsM0b2LnCFAJ1S6APQALssuxcfcEx8ZVUTMv" +
                "9k4yAz7Fp/JwjXIu1sDPsjMoQWoBf46C7BvEASar5fMC/79v+WeaLl1QR4sNf7x3" +
                "+uof0VkZZAAve2VX/1SJCI+Caw7aaDU9lIMz9xp0NT7U9bLR4mIKLZkAL+YsMZCb" +
                "ycfWulzMAEI9agA3CW5orRlIaQnZd1lPvcsw4h4jxcgaSXaYD6vDtQYPlgG5m2Op" +
                "PXnopQs4uUTI7uWtHCVU92H95GMBHkQJMsSusWxQDZA8vvMQjx7KpnKuRIBnkFln" +
                "2UpPWpAR6T1VqCYfP2duPPIpY8MwH6fDdJzNiMR2Vlmw0dcgJ5kfp/Di1D5CtQou" +
                "Cq/kdpodO9Tw4BoPgCcPk581RmTPeGIPYfigINLK1JNJXizARwUYIKd4/9YC/ije" +
                "e5Lfk+ryND1nmfKxANcAtl6ABZo/gppi3tqI7c7whxCunAqwe4H/H3otlyraO6ci" +
                "64OS6Ut/yLOwfG0JYvfXAF9nZPiD3scUYWYflTI3RjrLePGGfncB1bNGi28CJkwr" +
                "J6sB0sL79/8CJi+3A7h9DRf0FiKMp5XZyv2PVsaLEQvRSHfWcQmPwUQPbcyHWC8t" +
                "zG4Wy3vx5ijy2xnASG0HKLoEeVCA8eJBwvQg3x0xuLaYbhbVM4OJp3jzM3aLnxtk" +
                "fq5gpUUVNQXXMxVdVNUjdLoSTJ3ivI/jCOcTn4WAX4OcRMeVIh+nPt/lp3bzFpYH" +
                "b2chTcaWorx48kvysYQB+xAFsGs8vrPIn9hFQcWleVdPpiO8dxHoedWMEDEBlvrS" +
                "raI/jW5rKg3YIAeAp3gyeSg9vDpCOCHaraY4O7mBYguYjBCl1XLNi/nDucDvGuAP" +
                "KbLIwf8B8uW3CzjdADQg32DYcEOwGSXOAAa03spXAX1jEf/8XW53vK9twxJ7Jt3E" +
                "W9NhupkmSAuA7xKqW2iEKEzfIQ/Lg1sI1W1IcR9kkYezeBphbUs4bIonty0s9NsW" +
                "8DzKQJNVQD86n64W1ivARYBWp4smSBT5bb88GBvg2WSAgTyUH3jxAN8fMUTRFZMX" +
                "A3hoHZDzOBy+mXblFhQdbEeMYM8qUF0COQDM7hKgX26mACuv8OOlZX68vNxPbOZ5" +
                "xH7T6HbyrozbHyq40pBVcCX5qp8UgFM7mQ3vBDCCAEF2qvjcj26L2x8TO/Hm3TyP" +
                "dtN/Pg1UhhBTMkFmGDElL1bbEsC/CHIIekpDCEBP1fImJlS7NYTnarpYeLGLF7uC" +
                "TD72ziHvEWDMNiC+rfz1vynpGd3DadWaAAAAAElFTkSuQmCC";

        String finalStr = imageString + imageString2 + imageString3 + imageString4 + imageString5
                + imageString6 + imageString7 + imageString8 + imageString9 + imageString10
                + imageString11 + imageString12 + imageString13 + imageString14 + imageString15;

        try {
            byte [] encodeByte= Base64.decode(finalStr, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createAppWallBackgroundDrawable () {
        return createDrawable(createAppWallBackgroundBitmap());
    }

    public static Bitmap createAppWallHeaderBitmap () {

        String imageString =
                "iVBORw0KGgoAAAANSUhEUgAAAGQAAAAdCAYAAABcz8ldAAAAAXNSR0IArs4c6QAA" +
                "ABxpRE9UAAAAAgAAAAAAAAAPAAAAKAAAAA8AAAAOAAAGHahaPi8AAAXpSURBVGgF" +
                "jJjZehQ3EIV9Y9/axu//DlnZQhYWA4FgGxKyAXmVyfmr+kglTc9yUV+pe9RqqX6d" +
                "KvWcfHV6vvla9o3sW9l3su9l92UPwi42D+UfnV5sHi/2g/wT2Y+yn2Q/y35Z7Kn8" +
                "M9nzxV7IX59ebl7KXi32Wv5X7Oxy80b+rTz2G6brd/I3xW7Vtt2pfXd2L+y9/Kpp" +
                "DO67X/o+BmN5fN6F8V7P442umRdzfK0282XurIG1XGtNL+S9RtbLuokBsSAmxAYj" +
                "TsSL2BHDh2EZW2JMrIk5sYfBCTD2AckBcjAGnWFUIIZhIEyaybOQALIsDhAsloW/" +
                "lY9AyA8wdG0It2o7uAngcvNBAce4dnvNG1gHmWMxZoCRf4dpLmyImI+uAdKgqA0Y" +
                "ryOg6JrNBpQKxFAqkAqFzU1M2ez35QFSoQQQyGBVHamQJFrVYWUcUodhGAg7jJ0W" +
                "6tBiAsYSAALhoNyoz62CTLAM4U73HNgI+mlC+F399lkF9L6MwbgJJN9zo2u/n03B" +
                "fAIIXsYGqiqxUhLIZQB5pueOU4mBXEQWmlXSgKylK9M0kFkdyNPpyuqwjBNIV4aB" +
                "RJrSAq0Mq6KmqQpjAFEA/KE2BhC3Zz/DMiCPaeChFM1pSF8KcIOittPXK/UzEJTi" +
                "1DWrhMxRU5fTVk9d62nrxOoYgaSknO/21Q6AAKMDyUk610aq0sRDGV6kPEDmmhHK" +
                "0H0C5aA5iA7uHPSP6rvLal8/j2fMHJ939RRW60qrKcucA4jaVSmuJQkllXKcSrIu" +
                "P1DcUEhVSQAxDKesXsx3145d6mBycyE3jKGIq1/sSPkIhLyVUWE4kA7uWvD/VIBn" +
                "q/38LN7jGTTvSiiZKkmZLX2hZJmV0lSiPiglN916LSE+VSW1jvTi7lrS68gApJ+u" +
                "kmA9XdV0Rf1wqqKIdXVw+uinqkEdXpgWE+pg4brH4snhhhH1QvcImINHIGuAaRvA" +
                "X6Xte7P3swbjcbtSBEXvbIVeYzIvK9hQBiD63alrrCXrJy6AYM42hpLFPYEQ/xUg" +
                "PV25dqydrtaBLOpQoGcYLIadtg2jK4Odyo6dYVQgDjYgjjH3xwPGUPCAGaDo/aRN" +
                "VIJq2TBAYc6hEnmnrjjC6zerJGvndtqyUtjEbGrXkgRCHelpiww1AckfoUb94KGE" +
                "cr513DWQp5okCnExv45J5lHXhdwpy8fcKOTLolEGQfBJai8Mna4qhL/13CFzf4P5" +
                "qDEMZqdSNKcEkkoByKASXbu4v1zW24q7rmsdMRArpAPJGJOFDCUUQv3AuMCyfnQg" +
                "VR0MWr87ttNV7pimDk0uYMiHOuR9qsrj7QJDgbUyDKSqwimK4BrAP2ofY+5fwayl" +
                "MCsljsQaO5Si+YZKFiChlGVNY3HPg0yDojhVKD5tEb9tIGMdOXFBr0C6Os4j5zEI" +
                "g83fHrwUyw9BF/NRHUh8SFfLIjsQnXLUx0DYtU4rBsHuNgxD+Ff3Dpn74gEzQ/F7" +
                "Wupa5pFQpBJdh1LkfepiY9W05TqSR+CMRT0CWyHEzkCI5yNt/vysGI+/A5D+MXjc" +
                "XyUG8lyTJGWxQ5gYMo50JT/A0G/sOBYZqUrXPuKyQ2d1OM0YBkEluAbxSe20q/Cf" +
                "z9J/Wrz7GcxRUDSmj8INiOYbQDTfGQjr3EpbulcVYigAMRQyzwgkv9onIC7oHQg0" +
                "9ymEL1TDAAiTaylL1+2oqzYF0qcqFguMuZB711odu2F0CJ81DjC6p52/J5Srlt4M" +
                "xbB5D++c64lTV1OI5r5a3Jf1pkIUC11Xhaz9lUI8H0shrtGuIQhiApIFJlNWpqta" +
                "Q9ZSVqYrq6OkK02spatlMXP9SCBZPxwQglNhGMisjArgi575IgC2CsYqAsyslDUo" +
                "rZao+KPiLO6p7Cju2kizSpy26vHX2cNA1utI/0D08XcFSOa2PF0dUofrx/j94dOV" +
                "gbQ/D7XAVEimrKqOtXS1DiN3fgb/3uY/gZjNYACV4K5amgPKPpU0IOp3O0EZ6ojW" +
                "4sLOeq0QF3anrENAiDMCMJD/AQAA///nJ6hhAAAE7klEQVTtmDlzFDEUhCfxUpB4" +
                "vc5cFJFT+POAbe7bXMbY3Ke5fsjSn556pJldPLMJJARdGu3lJ7W6+8nN5bX1+RXh" +
                "qrCzNp3vatzTeE3jdY03hJvCLeG2cEe4K9wT7mc80PhwbWP+SOO+xsfCk8nG/KlG" +
                "8FzPB8ILoPlLjUeTWcKx5q/0/Fp4I7wV3gnvhQ8ZHzV+Ej5PNudfEmbzrxpPKnzT" +
                "s+HX+QzgO5/zb/BbgN8H/C3A36YGagFHqc6Zap3ND3PtB3ktzzRnXU+AnlnzvsaH" +
                "eR+8L+wTYM/YO/aQvWRP2dtrwl7eb/ad/W+6hKxnQtbTh1cnJIpLhKhIiqb4RIie" +
                "IYTFscgjjccawThCYlPZ3JoMk/BdrwPPa1KCRL6/mYiFEMg2KRwCYFJcF4cmEZJr" +
                "51Cxlmd5bZABKawXUh4JHEwOKKRwaE2KCTEpJiRICSHsiJRECOoARR2rKYQiOgqh" +
                "UCERoveeC5yulhA9t4To+TRCrA4U8iWhKIPNNxE/9Aw8NzFFJSgslNYnBIXUhFAP" +
                "yg1C4hBRe1KIXm8J0XNLiN7HIYKQjQ4hf1IIpBSFTKUQEVLsCskEKdgVzI1TSJwI" +
                "5MoJaS1Lz09VJMV3FKL5KgoxIWFXxaq84RAAET8z+qSglLCtsDyI/aTXaoUsJUSf" +
                "axWidRxq3lqW1oDyk2XpeUghJgSV1JZllRARYVk9Qnb1hhlbnZCcIblQyOgoRHPy" +
                "4zTLsnWwQc6QQggKKXbVV4cJYTQpfKYQ4hwJ21pGCBniHMG2IkeyQlQ7lgUpHDKw" +
                "SMg02VXfskyI7QpSICMIIbNDCClDUAhAHQC2+MB4QigiAi2FG4WalFx4G+qaByFh" +
                "B9jCUIYsEjJLm7yMkF8iYDkhoay+ZZmUMQrhMGFb2K8ti0OXLEtjyZDYjzpDakIg" +
                "pYR67HMQki2LUC8ZUndZ8cWhLuuBiildlgrTvBPqWkAnQzRPXZZGh6dP5rIuq0vI" +
                "sGVBSJ0jJzrpxbJWyBAUIlDroWrlINUZ0lpWXm9LiOZDCglCoou1I7WW5S6rq5Bo" +
                "ycZliBUSXcZghqjglCEVIWNCnQzhhDuksaJ+jmBVfbsqllUyBJKtDre+C6HeEqK2" +
                "V7W2oa76rZBFyxrusrArWxYuBDoZYkLiHtLttMYT4ntIL9S1EIpHIaBkiEjR/FiL" +
                "S5a1NvYeEp0WpLDRJsWK8OjsCDJKd9a3LJOBZbnl5XCApA7VaIVQe2p7NZoQMhI3" +
                "qEMddQwppE8I6lhQSCFkfIb4cugMabssbTSnx8GeLEuvIXm3vrS9hOZQhnCS+7ZV" +
                "h7tJsVpMhpX0J7vidyHC+YFCbJ22UmpM9xCNywhJ+QEhep+1gyBkI91BfA+pMwQy" +
                "6gxxZtNQ4VK9i6Ez5PRQ5w+YjPu5iLiHLMkQFdsqJC+MFhKFcApNCKeSU3pajpTb" +
                "ujuuCHirpR5NiO8utLp833ZlyzIhtUKoqW55Heh124s66kBfPUPCrhYsqygj2q9+" +
                "dwWjdAaQAOp/m3AauvePaShDxaYbukYWkf5torHtsPSMXTk7OJnDLa/tihwpnVat" +
                "DCyrngdB8fkgpns5NDm2rjpHXstGw1I5OD3rUv0cMluXlbKv/UAl8S+UYetyuAcp" +
                "YVtNc7Y530wmF4VLBY2e/+Pv7AH7zl6Lg7PNhWZ7e/vM1tbWuf/493sAF78Bee7y" +
                "WfT6AOcAAAAASUVORK5CYII=";

        try {
            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createAppWallHeaderDrawable () {
        return createDrawable(createAppWallHeaderBitmap());
    }

    public static Bitmap createVideoGradientBitmap () {

        String imageString =
                "iVBORw0KGgoAAAANSUhEUgAAAAoAAAAICAYAAADA+m62AAAAAXNSR0IArs4c6QAA" +
                "ABxpRE9UAAAAAgAAAAAAAAAEAAAAKAAAAAQAAAAEAAAAYzTSV/QAAAAvSURBVCgV" +
                "YmBgYBAhEjOYAhXiwmZIcgyhQE4YEINodIwszlAGVADDpUhsmBiYBgAAAP//1nMT" +
                "5wAAAChJREFUY2BgYJiKhKcB2SCMLgbiM2wF4m1EYIarQEXXiMAM34CKCGIAAN0p" +
                "shJZ248AAAAASUVORK5CYII=";

        try {
            byte [] encodeByte= Base64.decode(imageString, Base64.DEFAULT);
            return decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Drawable createVideoGradientDrawable () {
        return createDrawable(createVideoGradientBitmap());
    }
}

class SADrawabale extends Drawable {

    // instance members
    private final float mCornerRadius;
    private final RectF mRect = new RectF();
    private final BitmapShader mBitmapShader;
    private final Paint mPaint;
    private final int mMargin;

    /**
     * Constructor that takes a bitmap, radius and margin
     *
     * @param bitmap        current bitmap to paint
     * @param cornerRadius  the corner radius to add
     * @param margin        the margin to add
     */
    SADrawabale(Bitmap bitmap, float cornerRadius, int margin) {
        mCornerRadius = cornerRadius;
        mMargin = margin;
        mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(mBitmapShader);
    }

    /**
     * Overridden Drawable method that repaints the image when the bounds change
     *
     * @param bounds a Rect of bounds
     */
    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mRect.set(mMargin, mMargin, bounds.width() - mMargin, bounds.height() - mMargin);
    }

    /**
     * Overridden Drawable method that draws on a canvas
     *
     * @param canvas the current canvas
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRect, mCornerRadius, mCornerRadius, mPaint);
    }

    /**
     * Overridden Drawable method that gets the opacity
     *
     * @return a type of pixel format
     */
    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    /**
     * Overridden Drawable method that sets the transparency
     *
     * @param alpha the current alpha blending factor
     */
    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    /**
     * Overidden Drawable method that sets the color filter
     *
     * @param cf the color filter
     */
    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

}