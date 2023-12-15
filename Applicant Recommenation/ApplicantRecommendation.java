// Antonio Fabrizio
// Hiring Recommender Extra Credit
// December 11th 2023

package hiring_recommender;

//Criteria Selected:
//1. Relevant Skills (Java programming language)
//2. Academic Performance (GPA 3.5 or better)
//3. Major (CS)

//Justification:
//- Java skills are crucial for the position.
//- A higher GPA suggests a strong academic foundation.
//- Considering a major in Computer Science (CS) aligns with the requirements of the position.

// What we missed
//Diversity and Inclusion: Automation might unintentionally exclude candidates from diverse backgrounds or those with unconventional yet valuable experiences.
//Soft Skills: Automated processes may overlook essential soft skills like communication, team work, and problem-solving, which are vital for success in a professional environment.
//Holistic Evaluation: Focusing on specific criteria may neglect candidates with a unique combination of skills and experiences that could contribute significantly to the team.

//Code
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Applicant {
    String lastName;
    String firstName;
    List<String> languages;
    double gpa;
    String major;

    public Applicant(String lastName, String firstName, List<String> languages, double gpa, String major) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.languages = languages;
        this.gpa = gpa;
        this.major = major;
    }

    // Getter for GPA
    public double getGpa() {
        return gpa;
    }

    // Getter for Major
    public String getMajor() {
        return major;
    }

    // Getter for Languages
    public List<String> getLanguages() {
        return languages;
    }
}

public class ApplicantRecommendation {
    public static void main(String[] args) {
        // Read data from CSV and store in a list of applicants
        List<Applicant> applicants = readApplicantData("applicant_data.csv");

        // Filter applicants based on criteria
        List<Applicant> filteredApplicants = filterApplicants(applicants);

        // Sort applicants by GPA in descending order and then by major
        filteredApplicants.sort(Comparator.comparingDouble(Applicant::getGpa).reversed()
                .thenComparing(Comparator.comparing(Applicant::getMajor)));

        // Display the top 10 recommended applicants
        displayTopApplicants(filteredApplicants);
    }

    private static List<Applicant> readApplicantData(String fileName) {
        List<Applicant> applicants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Skip the header line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String lastName = data[0];
                String firstName = data[1];
                List<String> languages = Arrays.asList(data[7].split(" "));  // Multiple languages
                double gpa = parseAverageGPA(data[8]);  // New method to handle multiple GPAs
                String major = data[9];

                applicants.add(new Applicant(lastName, firstName, languages, gpa, major));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return applicants;
    }

    private static double parseAverageGPA(String gpaString) {
        String[] individualGPAs = gpaString.split(" ");
        double sum = 0.0;
        int count = 0;

        for (String gpa : individualGPAs) {
            try {
                sum += Double.parseDouble(gpa);
                count++;
            } catch (NumberFormatException ignored) {
                // Ignore invalid GPA values
            }
        }

        // Calculate average GPA, return 0 if no valid GPAs found
        return count > 0 ? sum / count : 0.0;
    }

    private static List<Applicant> filterApplicants(List<Applicant> applicants) {
        List<Applicant> filteredApplicants = new ArrayList<>();

        for (Applicant applicant : applicants) {
            // Criteria: Java as a programming language, GPA greater than or equal to 3.5, and a major containing "CS" (Computer Science)
            if (applicant.getLanguages().contains("Java") && applicant.getGpa() >= 3.5 && applicant.getMajor().toLowerCase().contains("cs")) {
                filteredApplicants.add(applicant);
            }
            // Additional criteria can be added here
        }

        return filteredApplicants;
    }

    private static void displayTopApplicants(List<Applicant> applicants) {
        System.out.println("Top 10 Recommended Applicants:");

        int count = 0;
        for (Applicant applicant : applicants) {
            System.out.println(applicant.firstName + " " + applicant.lastName +
                    " (GPA: " + applicant.gpa + ", Major: " + applicant.major + ", Languages: " + applicant.languages + ")");
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}

