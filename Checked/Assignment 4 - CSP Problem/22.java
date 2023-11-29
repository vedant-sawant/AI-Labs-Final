import java.util.Arrays;

class csp {
    static int[] use = new int[10]; // Set 1 when one character is assigned previously

    static class Node {
        char letter;
        int value;
    }

    static int isValid(Node[] nodeList, int count, String s1, String s2, String s3) {
        int val1 = 0, val2 = 0, val3 = 0, m = 1, j, i;

        for (i = s1.length() - 1; i >= 0; i--) {
            char ch = s1.charAt(i);
            for (j = 0; j < count; j++) {
                if (nodeList[j].letter == ch) { 
                    break;
                }
            }
            val1 += m * nodeList[j].value; 
            m *= 10; 
        }

        m = 1;
        for (i = s2.length() - 1; i >= 0; i--) { // Loop to find number for the second string
            char ch = s2.charAt(i);
            for (j = 0; j < count; j++) {
                if (nodeList[j].letter == ch) {
                    break;
                }
            }
            val2 += m * nodeList[j].value;
            m *= 10;
        }

        m = 1;
        for (i = s3.length() - 1; i >= 0; i--) { // Loop to find number for the third string
            char ch = s3.charAt(i);
            for (j = 0; j < count; j++) {
                if (nodeList[j].letter == ch) {
                    break;
                }
            }
            val3 += m * nodeList[j].value;
            m *= 10;
        }

        if (val3 == (val1 + val2)) { // Check whether the sum is the same as the third string
            return 1;
        }
        return 0;
    }

    static boolean permutation(int count, Node[] nodeList, int n, String s1, String s2, String s3) {
        if (n == count - 1) { // When values are assigned for all characters
            for (int i = 0; i < 10; i++) {
                if (use[i] == 0) { // For those numbers that are not used
                    nodeList[n].value = i; // Assign the value i
                    if (isValid(nodeList, count, s1, s2, s3) == 1) { // Check validation
                        System.out.print("Solution found:");
                        for (int j = 0; j < count; j++) { // Print the assigned values
                            System.out.print(" " + nodeList[j].letter + " = " + nodeList[j].value);
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        for (int i = 0; i < 10; i++) {
            if (use[i] == 0) { // For those numbers that are not used
                nodeList[n].value = i; // Assign the value i and mark as not available for future use
                use[i] = 1;
                if (permutation(count, nodeList, n + 1, s1, s2, s3)) { // Go for next characters
                    return true;
                }
                use[i] = 0; // When backtracking, make the number available again
            }
        }
        return false;
    }

    static boolean solvePuzzle(String s1, String s2, String s3) {
        int uniqueChar = 0; // Number of unique characters
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int[] freq = new int[26]; // There are 26 different characters

        for (int i = 0; i < len1; i++) {
            // ++freq[s1.charAt(i) - 'A'];
            freq[s1.charAt(i) - 'A'] = (s1.charAt(i) - 'A') + 1;
        }
        for (int i = 0; i < len2; i++) {
            freq[s2.charAt(i) - 'A'] = (s2.charAt(i) - 'A') + 2;
        }
        for (int i = 0; i < len3; i++) {
            freq[s3.charAt(i) - 'A'] = (s3.charAt(i) - 'A') + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { // If the frequency is > 0, the character is present
                uniqueChar++;
            }
        }

        if (uniqueChar > 10) { // As there are 10 digits in the decimal system
            System.out.println("String is Invalid");
            return false;
        }

        Node[] nodeList = new Node[uniqueChar];
        for (int i = 0, j = 0; i < 26; i++) { // Assign all characters found in three strings
            if (freq[i] > 0) {
                nodeList[j] = new Node();
                nodeList[j].letter = (char) (i + 'A');
                j++;
            }
        }
        return permutation(uniqueChar, nodeList, 0, s1, s2, s3);
    }

    public static void main(String[] args) {
        String s1 = "SEND";
        String s2 = "MORE";
        String s3 = "MONEY";
        

        if (!solvePuzzle(s1, s2, s3)) {
            System.out.println("Theres No solution Available");

        }
    }
}
