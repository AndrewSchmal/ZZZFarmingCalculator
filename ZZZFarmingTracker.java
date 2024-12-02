// import java.util.Map;
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

        // Convert user input to lowercase and find a matching key in the TreeMap
        String matchedCharacter = characterElements.keySet().stream()
            .filter(name -> name.equalsIgnoreCase(selectedCharacter))
            .findFirst()
            .orElse(null);

        // Validate the character choice
        if (matchedCharacter == null) {
            System.out.println("Invalid character name. Please restart the program and try again.");
            scanner.close();
            return;
        }

        // Get the element of the matched character
        String characterElement = characterElements.get(matchedCharacter);

        // Step 4: Ask for current skill levels
        System.out.println("\nEnter the current levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Example input: 1 1 1 1 1 (if all skills are level 1)");
        System.out.print("Current skill levels: ");
        int[] currentLevels = new int[5];
        for (int i = 0; i < 5; i++) {
            currentLevels[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume leftover newline character

        // Step 5: Ask for target skill levels, allowing "X" and "M"
        System.out.println("\nEnter the target levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Use 'X' if you don't care about that skill or 'M' if you want it maxed to 12.");
        System.out.println("Example input: X X M X M");
        System.out.print("Target skill levels: ");
        String[] targetInputs = scanner.nextLine().split(" ");
        int[] targetLevels = new int[5];

        for (int i = 0; i < 5; i++) {
            if (targetInputs[i].equalsIgnoreCase("X")) {
                targetLevels[i] = currentLevels[i]; // Keep the current level if "X"
            } else if (targetInputs[i].equalsIgnoreCase("M")) {
                targetLevels[i] = 12; // Max the level if "M"
            } else {
                targetLevels[i] = Integer.parseInt(targetInputs[i]); // Otherwise, parse the level as an integer
            }
        }

        // Step 6: Display the required materials
        System.out.println("\nYou selected character: " + matchedCharacter + " (" + characterElement + " Element)");
        System.out.println("Current skill levels: " + arrayToString(currentLevels));
        System.out.println("Target skill levels: " + arrayToString(targetLevels));

        int[] materials = calculateMaterials(characterElement, currentLevels, targetLevels);

        // Step 7: Calculate energy requirements based on materials
        calculateEnergyRequirements(materials);

        // Close scanner
        scanner.close();
    }

    // Helper method to calculate and display materials needed
    private static int[] calculateMaterials(String element, int[] currentLevels, int[] targetLevels) {
        int totalDennies = 0;
        int basicChips = 0;
        int advancedChips = 0;
        int specializedChips = 0;
        int hamsterCages = 0;

        for (int i = 0; i < 5; i++) {
            for (int level = currentLevels[i]; level < targetLevels[i]; level++) {
                switch (level + 1) {
                    case 2 -> {
                        basicChips += 2;
                        totalDennies += 2000;
                    }
                    case 3 -> {
                        basicChips += 3;
                        totalDennies += 3000;
                    }
                    case 4 -> {
                        advancedChips += 2;
                        totalDennies += 6000;
                    }
                    case 5 -> {
                        advancedChips += 3;
                        totalDennies += 9000;
                    }
                    case 6 -> {
                        advancedChips += 4;
                        totalDennies += 12000;
                    }
                    case 7 -> {
                        advancedChips += 6;
                        totalDennies += 18000;
                    }
                    case 8 -> {
                        specializedChips += 5;
                        totalDennies += 45000;
                    }
                    case 9 -> {
                        specializedChips += 8;
                        totalDennies += 67500;
                    }
                    case 10 -> {
                        specializedChips += 10;
                        totalDennies += 90000;
                    }
                    case 11 -> {
                        specializedChips += 12;
                        totalDennies += 112500;
                    }
                    case 12 -> {
                        specializedChips += 15;
                        hamsterCages++;
                        totalDennies += 135000;
                    }
                }
            }
        }

        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println("\nMaterials Needed:");
        System.out.println("- Dennies: " + formatter.format(totalDennies));
        System.out.println("- Basic " + element + " Chips: " + basicChips);
        System.out.println("- Advanced " + element + " Chips: " + advancedChips);
        System.out.println("- Specialized " + element + " Chips: " + specializedChips);
        System.out.println("- Hamster Cage Passes: " + hamsterCages);

        return new int[]{basicChips, advancedChips, specializedChips};
    }

    // Helper method to calculate energy requirements
    private static void calculateEnergyRequirements(int[] materials) {
        int specializedChips = materials[2];
        int advancedChips = materials[1];

        int worstCaseCards = (int) Math.ceil((double) specializedChips + advancedChips / 2.0);
        int bestCaseCards = (int) Math.ceil((double) specializedChips + advancedChips / 3.0);

        System.out.println("\nEnergy Requirements:");
        System.out.println("Worst case: " + worstCaseCards + " cards requiring " + (worstCaseCards * 20) + " energy.");
        System.out.println("Best case: " + bestCaseCards + " cards requiring " + (bestCaseCards * 20) + " energy.");
        System.out.println("This will take between " 
            + (int) Math.ceil(worstCaseCards * 20 / 320.0) 
            + " and " 
            + (int) Math.ceil(bestCaseCards * 20 / 320.0) 
            + " days, give or take, assuming you use all 240 energy per day plus get the Tin Master Special Coffee for +80 energy.");
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
