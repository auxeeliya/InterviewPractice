import java.util.List;

public class LisasWorkBook {

    public static int countSpecialProblems(int k, List<Integer> chapters) {
        int specialProblems = 0;
        int currentPage = 1;

        for (int problemsInChapter : chapters) {
            int pages = (int) Math.ceil((double) problemsInChapter / k);

            for (int page = 1; page <= pages; page++) {
                int startProblem = (page - 1) * k + 1;
                int endProblem = Math.min(page * k, problemsInChapter);

                // Check if the current page is within the problem range
                if (currentPage >= startProblem && currentPage <= endProblem) {
                    specialProblems++;
                }

                currentPage++;
            }
        }

        return specialProblems;
    }

    public static void main(String[] args) {
        int k = 3;
        List<Integer> chapters = List.of(4, 2, 6, 1, 10);

        int result = countSpecialProblems(k, chapters);
        System.out.println("Special problems: " + result);
    }
}
