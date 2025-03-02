import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FairRations {
    public static String fairRations(List<Integer> loaves) {
        List<Integer> mutableLoaves = new ArrayList<>(loaves); // Mutable copy
        int[] loafCount = {0};

        IntStream.range(0, mutableLoaves.size()).forEach(i -> {
            if (mutableLoaves.get(i) % 2 != 0) {
                mutableLoaves.set(i, mutableLoaves.get(i) + 1);
                mutableLoaves.set(i + 1, mutableLoaves.get(i + 1) + 1);
                loafCount[0] += 2;
            }
        });

        return mutableLoaves.get(mutableLoaves.size() - 1) % 2 == 0 ? String.valueOf(loafCount[0]) : "NO";
    }

    public static void main(String[] args) {
        List<Integer> loaves = List.of(2, 3, 4, 5, 7);
        System.out.println(fairRations(loaves));
    }
}