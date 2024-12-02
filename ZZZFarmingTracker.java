import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ZZZFarmingTracker {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a TreeMap for characters and their elements
        TreeMap<String, String> characterElements = new TreeMap<>();
        characterElements.put("Anby", "Electric");
        characterElements.put("Anton", "Electric");
        characterElements.put("Ben", "Fire");
        characterElements.put("Billy", "Physical");
        characterElements.put("Burnice", "Fire");
        characterElements.put("Caesar", "Physical");
        characterElements.put("Corin", "Physical");
        characterElements.put("Ellen", "Ice");
        characterElements.put("Grace", "Electric");
        characterElements.put("Jane", "Physical");
        characterElements.put("Koleda", "Fire");
        characterElements.put("Lighter", "Fire");
        characterElements.put("Lucy", "Fire");
        characterElements.put("Lycaon", "Ice");
        characterElements.put("Nekomata", "Physical");
        characterElements.put("Nicole", "Ether");
        characterElements.put("Piper", "Physical");
        characterElements.put("Qingyi", "Electric");
        characterElements.put("Rina", "Electric");
        characterElements.put("Seth", "Electric");
        characterElements.put("Soldier 11", "Fire");
        characterElements.put("Soukaku", "Ice");
        characterElements.put("Yanagi", "Electric");
        characterElements.put("Zhu Yuan", "Ether");

        // Step 2: Display the sorted list of characters, 3 per line
        System.out.println("Select a character by typing their name from the list below:");
        int count = 0;
        for (String character : characterElements.keySet()) {
            System.out.printf("%-15s", character); // Print characters in fixed-width columns
            count++;
            if (count % 3 == 0) {
                System.out.println(); // Start a new line after every 3 characters
            }
        }
        if (count % 3 != 0) {
            System.out.println(); // Add a final new line if the last row isn't complete
        }
        System.out.print("Your choice: ");
        String selectedCharacter = scanner.nextLine();

        // Validate the character choice
        if (!characterElements.containsKey(selectedCharacter)) {
            System.out.println("Invalid character name. Please restart the program and try again.");
            scanner.close();
            return;
        }

        // Step 3: Get the selected character's element
        String characterElement = characterElements.get(selectedCharacter);

        // Step 4: Ask for current and target skill levels
        System.out.println("\nEnter the current levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Example input: 1 1 1 1 1 (if all skills are level 1)");
        System.out.print("Current skill levels: ");
        int[] currentLevels = new int[5];
        for (int i = 0; i < 5; i++) {
            currentLevels[i] = scanner.nextInt();
        }

        System.out.println("\nEnter the target levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Example input: 12 12 12 12 12 (if all skills should be maxed to level 12)");
        System.out.print("Target skill levels: ");
        int[] targetLevels = new int[5];
        for (int i = 0; i < 5; i++) {
            targetLevels[i] = scanner.nextInt();
        }

        // Step 5: Display the required materials
        System.out.println("\nYou selected character: " + selectedCharacter + " (" + characterElement + " Element)");
        System.out.println("Current skill levels: " + arrayToString(currentLevels));
        System.out.println("Target skill levels: " + arrayToString(targetLevels));

        calculateMaterials(characterElement, currentLevels, targetLevels);

        // Close scanner
        scanner.close();
    }

    // Helper method to calculate and display materials needed
    private static void calculateMaterials(String element, int[] currentLevels, int[] targetLevels) {
        // Initialize total costs
        int totalDennies = 0;
        int basicChips = 0;
        int advancedChips = 0;
        int specializedChips = 0;
        int hamsterCages = 0;

        // Loop through each skill and calculate the cost
        for (int i = 0; i < 5; i++) {
            for (int level = currentLevels[i]; level < targetLevels[i]; level++) {
                switch (level + 1) {
                    case 2:
                        basicChips += 2;
                        totalDennies += 2000;
                        break;
                    case 3:
                        basicChips += 3;
                        totalDennies += 3000;
                        break;
                    case 4:
                        advancedChips += 2;
                        totalDennies += 6000;
                        break;
                    case 5:
                        advancedChips += 3;
                        totalDennies += 9000;
                        break;
                    case 6:
                        advancedChips += 4;
                        totalDennies += 12000;
                        break;
                    case 7:
                        advancedChips += 6;
                        totalDennies += 18000;
                        break;
                    case 8:
                        specializedChips += 5;
                        totalDennies += 45000;
                        break;
                    case 9:
                        specializedChips += 8;
                        totalDennies += 67500;
                        break;
                    case 10:
                        specializedChips += 10;
                        totalDennies += 90000;
                        break;
                    case 11:
                        specializedChips += 12;
                        totalDennies += 112500;
                        break;
                    case 12:
                        specializedChips += 15;
                        hamsterCages++;
                        totalDennies += 135000;
                        break;
                }
            }
        }

        // Use DecimalFormat to format numbers with commas
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Display the results
        System.out.println("\nMaterials Needed:");
        System.out.println("- Dennies: " + formatter.format(totalDennies));
        System.out.println("- Basic " + element + " Chips: " + basicChips);
        System.out.println("- Advanced " + element + " Chips: " + advancedChips);
        System.out.println("- Specialized " + element + " Chips: " + specializedChips);
        System.out.println("- Hamster Cage Passes: " + hamsterCages);
    }

    // Helper method to convert an integer array to a string for display
    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}