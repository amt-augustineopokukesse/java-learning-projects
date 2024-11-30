import java.util.Scanner;

 class GradeAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("Enter the grades separated by spaces:");
        String input = scanner.nextLine();
        String[] gradesStr = input.trim().split("\\s+");
        int[] scores = new int[gradesStr.length];
        for (int i = 0; i < gradesStr.length; i++) {
            scores[i] = Integer.parseInt(gradesStr[i]);
        }

        // Calculate max, min, and average
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
        for (int score : scores) {
            if (score > max) max = score;
            if (score < min) min = score;
            sum += score;
        }
        double average = sum / (double) scores.length;

        // Display max, min, and average
        System.out.printf("The maximum grade is %d%n", max);
        System.out.printf("The minimum grade is %d%n", min);
        System.out.printf("The average grade is %.6f%n%n", average);

        // Categorize scores into stats array
        int[] stats = new int[5];
        for (int score : scores) {
            if (score <= 20) stats[0]++;
            else if (score <= 40) stats[1]++;
            else if (score <= 60) stats[2]++;
            else if (score <= 80) stats[3]++;
            else stats[4]++;
        }

        // Generate and display the bar graph
        int maxBarHeight = 0;
        for (int count : stats) {
            if (count > maxBarHeight) maxBarHeight = count;
        }

        System.out.println("Graph:\n");
        for (int i = maxBarHeight; i > 0; i--) {
            System.out.print(String.format("%3d  > ", i));
            for (int j = 0; j < stats.length; j++) {
                if (stats[j] >= i) {
                    System.out.print("   #######");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }

        // Bottom axis of the graph
        System.out.println("      +-----------+---------+---------+---------+---------+");
        System.out.println("      I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");
    }
}
