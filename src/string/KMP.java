package string;

//String matching algorithm
//LPS array. Longest proper prefix whic is also a suffix
public class KMP {
    public static void main(String[] args) {
        String str = "ABABA";
        String pattern = "AB";
        int patternLength = pattern.length();
        int[] lps = createLPSArray(pattern);
        int length = str.length();
        int strIndex = 0;
        int patternIndex = 0;
        while (strIndex < str.length()) {
            if (str.charAt(strIndex) == pattern.charAt(patternIndex)) {
                strIndex++;
                patternIndex++;
            }
            if (patternIndex == patternLength) {
                System.out.println("Pattern found at index " + (strIndex - patternIndex));
                patternIndex = lps[patternIndex - 1];
            } else if (strIndex < length && str.charAt(strIndex) != pattern.charAt(patternIndex)) {
                if (patternIndex != 0)
                    patternIndex = lps[patternIndex - 1];
                else
                    strIndex++;
            }
        }
    }

    //https://www.youtube.com/watch?v=tWDUjkMv6Lc&lc=z12bxp2htrrgfzxdy225hrgbqm2sj3a5s04
    private static int[] createLPSArray(String pattern) {
        int length = pattern.length();
        int[] lps = new int[length];
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j != 0) {
                j = lps[j - 1];
            } else if (j == 0) {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
