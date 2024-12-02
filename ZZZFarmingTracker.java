import java.util.Scanner;

public class ZZZFarmingTracker {
    // Main method to run the application
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 1: Display all characters and ask which one the player wants to check
        String[] characters = {
            "Anby", "Anton", "Ben", "Billy", 
            "Burnice", "Caesar", "Corin", "Ellen", 
            "Grace", "Jane", "Koleda", "Lighter", "Lucy",
            "Lycaon", "Nekomata", "Nicole", "Piper", "Qingyi",
            "Rina", "Seth", "Soldier 11", "Soukaku", 
            "Yanagi", "Zhu Yuan"
        };
        
        System.out.println("Select a character by typing their name from the list below:");
        for (String character : characters) {
            System.out.println("- " + character);
        }
        System.out.print("Your choice: ");
        String selectedCharacter = scanner.nextLine();

        // Step 2: Ask for current skill levels
        System.out.println("\nEnter the current levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Example input: 1 1 1 1 1 (if all skills are level 1)");
        System.out.print("Current skill levels: ");
        int[] currentLevels = new int[5];
        for (int i = 0; i < 5; i++) {
            currentLevels[i] = scanner.nextInt();
        }

        // Step 3: Ask for target skill levels
        System.out.println("\nEnter the target levels of your 5 skills (Basic, Dodge, Assist, Special Attack, Chain Attack).");
        System.out.println("Example input: 12 12 12 12 12 (if all skills should be maxed to level 12)");
        System.out.print("Target skill levels: ");
        int[] targetLevels = new int[5];
        for (int i = 0; i < 5; i++) {
            targetLevels[i] = scanner.nextInt();
        }

        // Placeholder for further processing and calculations
        System.out.println("\nYou selected character: " + selectedCharacter);
        System.out.println("Current skill levels: " + arrayToString(currentLevels));
        System.out.println("Target skill levels: " + arrayToString(targetLevels));

        // TODO: Add calculations for materials and costs here

        // Close scanner
        scanner.close();
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
