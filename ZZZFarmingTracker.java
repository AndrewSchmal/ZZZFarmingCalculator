import java.util.HashMap;
import java.util.Scanner;

public class ZZZFarmingTracker {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a HashMap for characters and their elements
        HashMap<String, String> characterElements = new HashMap<>();
        characterElements.put("Anby", "Electric");
        characterElements.put("Anton", "Electric");
        characterElements.put("Ben", "Fire");
        characterElements.put("Billy", "Physical");
        characterElements.put("Burnice", "Fire");
        characterElements.put("Caesar", "Physical");
        characterElements.put("Corin", "Physical");
        characterElements.put("Ellen", "Ether");
        characterElements.put("Grace", "Ice");
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

        // Step 2: Display all characters and ask the user to select one
        System.out.println("Select a character by typing their name from the list below:");
        for (String character : characterElements.keySet()) {
            System.out.println("- " + character);
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
                if (level >= 1 && level < 7) {
                    basicChips += 1;
                    totalDennies += (level + 1) * 1000; // Dennies scale with level
                } else if (level >= 7 && level < 10) {
                    advancedChips += 1;
                    totalDennies += (level + 1) * 5000; // Dennies scale more for higher levels
                } else if (level >= 10 && level < 12) {
                    specializedChips += 1;
                    totalDennies += (level + 1) * 10000; // Dennies scale further for final levels
                }
            }
        }

        // Add the Hamster Cage for max levels
        for (int i = 0; i < 5; i++) {
            if (targetLevels[i] == 12) {
                hamsterCages++;
            }
        }

        // Display the results
        System.out.println("\nMaterials Needed:");
        System.out.println("- Dennies: " + totalDennies);
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
