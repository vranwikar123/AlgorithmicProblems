package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 * Example 4:
 *
 * Input: String="cbbebi", K=10
 * Output: 6
 * Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */
public class LngSubKDistChars
{
    public static void main(String[] args)
    {
        System.out.println("Length of the longest substring: "
                + longestSubstringWithKDistChars("araaci", 2));
        System.out.println("Length of the longest substring: "
                + longestSubstringWithKDistChars("araaci", 1));
        System.out.println("Length of the longest substring: "
                + longestSubstringWithKDistChars("cbbebi", 3));
    }

    public static int longestSubstringWithKDistChars(String str, int k)
    {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++)
        {
            char rChar = str.charAt(windowEnd);
            charFreqMap.put(rChar, charFreqMap.getOrDefault(rChar, 0)+1);

            while(charFreqMap.size() > k)
            {
                char lChar = str.charAt(windowStart);
                charFreqMap.put(lChar, charFreqMap.get(lChar) - 1);

                if(charFreqMap.get(lChar) == 0)
                {
                    charFreqMap.remove(lChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }

        return maxLength;
    }
}
