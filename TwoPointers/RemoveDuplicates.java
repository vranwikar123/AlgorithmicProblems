

public class RemoveDuplicates {

    public static void main(String[] args)
    {
        int[] inp = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeDuplicates(inp));
    }

    private static int removeDuplicates(int[] inp) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 0; i < inp.length; i++) {
            if (inp[nextNonDuplicate - 1] != inp[i]) {
                inp[nextNonDuplicate] = inp[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}


