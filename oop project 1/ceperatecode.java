// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.HashSet;
// import java.util.Set;

// public class ceperatecode {

//   public  ceperatecode() {  
//         String file1Path = "Files/all.txt";
//         String file2Path = "Files/coursedata.txt";
//         String outputFilePath = "Files/planner.txt";

//         try {
//             Set<String> file1Lines = readLines(file1Path);
//             Set<String> file2Lines = readLines(file2Path);

//             Set<String> unmatchedRows = findUnmatchedRows(file1Lines, file2Lines);

//             writeToFile(unmatchedRows, outputFilePath);

//             System.out.println("Unmatched rows have been written to " + outputFilePath);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static Set<String> readLines(String filePath) throws IOException {
//         Set<String> lines = new HashSet<>();
//         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 lines.add(line.trim());
//             }
//         }
//         return lines;
//     }

//     private static Set<String> findUnmatchedRows(Set<String> set1, Set<String> set2) {
//         Set<String> unmatchedRows = new HashSet<>(set1);
//         unmatchedRows.addAll(set2);
//         Set<String> intersection = new HashSet<>(set1);
//         intersection.retainAll(set2);
//         unmatchedRows.removeAll(intersection);
//         return unmatchedRows;
//     }

//     private static void writeToFile(Set<String> lines, String filePath) throws IOException {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//             for (String line : lines) {
//                 writer.write(line);
//                 writer.newLine();
//             }
//         }
//     }
// }
