/*
 * Antonio Fabrizio
 * Lab 6 Webify
 * October 16th 2023
 * Asks user for name and then reads text file and spits out html version
 */

package text_to_html;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class text_to_html {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of a plain text file: ");
        String fileName = scanner.nextLine();
        File myObj = new File(fileName);
        Scanner myReader = null;

        try {
            if (!myObj.exists()) {
                System.out.println("The file " + fileName + " does not exist.");
                return;
            }

            myReader = new Scanner(myObj);
            StringBuilder output = new StringBuilder("<html>\n<body>\n");

            boolean inList = false; 

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().trim(); 

                if (line.startsWith("_") && line.endsWith("_")) {
                    String content = line.substring(1, line.length() - 1);
                    output.append("<h1>").append(content).append("</h1>\n");
                } else if (line.isEmpty()) {
                    output.append("<p>").append(line).append("</p>\n");
                } else if (line.startsWith("- ")) {
                    if (!inList) {
                        output.append("<ul>\n");
                        inList = true;
                    }
                    String content = line.substring(2);
                    output.append("<li>").append(content).append("</li>\n");
                } else {
                    if (inList) {
                        output.append("</ul>\n");
                        inList = false;
                    }
                    output.append(line).append("<br />\n");
                }
            }

            if (inList) {
                output.append("</ul>\n");
            }

            output.append("</body>\n</html>");

            String outputFileName = "output.html";
            FileWriter writer = new FileWriter(outputFileName);
            writer.write(output.toString());
            writer.close();

            System.out.println("HTML content has been written to " + outputFileName);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            if (myReader != null) {
                myReader.close();
            }
            scanner.close(); // Close the scanner
        }
    }
}