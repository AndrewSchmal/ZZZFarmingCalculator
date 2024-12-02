// import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ZZZFarmingTracker {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        

        // Step 1: Create a TreeMap for characters and their elements
        // Define TreeMap with detailed CharacterInfo
TreeMap<String, CharacterInfo> characterData = new TreeMap<>();
characterData.put("Anby", new CharacterInfo("Electric", "Ferocious Grip", "Newborn Dead End Butcher", "Murderous Obituary", "Dullahan"));
characterData.put("Anton", new CharacterInfo("Electric", "Living Drive", "Unknown Corruption Complex", "Destructive Advance", "Typhon Slugger"));
characterData.put("Ben", new CharacterInfo("Fire", "Living Drive", "Unknown Corruption Complex", "Steel Malice", "Hans"));
characterData.put("Billy", new CharacterInfo("Physical", "Ferocious Grip", "Newborn Dead End Butcher", "Ethereal Pursuit", "Armored Hati"));
characterData.put("Burnice", new CharacterInfo("Fire", "Scarlet Engine", "Corrupted Overlord Pompey", "Stealth Phantom", "Doppelganger"));
characterData.put("Caesar", new CharacterInfo("Physical", "Scarlet Engine", "Corrupted Overlord Pompey", "Stealth Phantom", "Doppelganger"));
characterData.put("Corin", new CharacterInfo("Physical", "Finale Dance Shoes", "Twin Marionettes", "Crimson Awe", "Wanted Enforcer"));
characterData.put("Ellen", new CharacterInfo("Ice", "Ferocious Grip", "Newborn Dead End Butcher", "Murderous Obituary", "Dullahan"));
characterData.put("Grace", new CharacterInfo("Electric", "Living Drive", "Unknown Corruption Complex", "Destructive Advance", "Typhon Slugger"));
characterData.put("Jane", new CharacterInfo("Physical", "Ferocious Grip", "Newborn Dead End Butcher", "Falling Fist", "Rampant Brute"));
characterData.put("Koleda", new CharacterInfo("Fire", "Living Drive", "Unknown Corruption Complex", "Steel Malice", "Hans"));
characterData.put("Lighter", new CharacterInfo("Fire", "Scarlet Engine", "Corrupted Overlord Pompey", "Crimson Awe", "Wanted Enforcer"));
characterData.put("Lucy", new CharacterInfo("Fire", "Ferocious Grip", "Newborn Dead End Butcher", "Steel Malice", "Hans"));
characterData.put("Lycaon", new CharacterInfo("Ice", "Finale Dance Shoes", "Twin Marionettes", "Ethereal Pursuit", "Armored Hati"));
characterData.put("Nekomata", new CharacterInfo("Physical", "Ferocious Grip", "Newborn Dead End Butcher", "Crimson Awe", "Wanted Enforcer"));
characterData.put("Nicole", new CharacterInfo("Ether", "Ferocious Grip", "Newborn Dead End Butcher", "Murderous Obituary", "Dullahan"));
characterData.put("Piper", new CharacterInfo("Physical", "Finale Dance Shoes", "Twin Marionettes", "Crimson Awe", "Wanted Enforcer"));
characterData.put("Qingyi", new CharacterInfo("Electric", "Living Drive", "Unknown Corruption Complex", "Ethereal Pursuit", "Armored Hati"));
characterData.put("Rina", new CharacterInfo("Electric", "Finale Dance Shoes", "Twin Marionettes", "Destructive Advance", "Typhon Slugger"));
characterData.put("Seth", new CharacterInfo("Electric", "Living Drive", "Unknown Corruption Complex", "Falling Fist", "Rampant Brute"));
characterData.put("Soldier 11", new CharacterInfo("Fire", "Finale Dance Shoes", "Twin Marionettes", "Destructive Advance", "Typhon Slugger"));
characterData.put("Soukaku", new CharacterInfo("Ice", "Finale Dance Shoes", "Twin Marionettes", "Murderous Obituary", "Dullahan"));
characterData.put("Yanagi", new CharacterInfo("Electric", "Living Drive", "Unknown Corruption Complex", "Destructive Advance", "Typhon Slugger"));
characterData.put("Zhu Yuan", new CharacterInfo("Ether", "Living Drive", "Unknown Corruption Complex", "Ethereal Pursuit", "Armored Hati"));


        // Step 2: Display the sorted list of characters, 3 per line
        System.out.println("Select a character by typing their name from the list below:");
        int count = 0;
        for (String character : characterData.keySet()) {
            System.out.printf("%-15s", character);
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }
        if (count % 3 != 0) {
            System.out.println();
        }
        System.out.print("Your choice: ");
        String selectedCharacter = scanner.nextLine();

        // Find character in a case-insensitive manner
        String matchedCharacter = characterData.keySet().stream()
            .filter(name -> name.equalsIgnoreCase(selectedCharacter))
            .findFirst()
            .orElse(null);

        if (matchedCharacter == null) {
            System.out.println("Invalid character name. Please restart the program and try again.");
            scanner.close();
            return;
        }

        CharacterInfo characterInfo = characterData.get(matchedCharacter);

        // Ask if they want to raise Core, Combat, or Both
        System.out.println("\nDo you want to raise your Core Skill, Combat Skill, or both? (Enter 'Core', 'Combat', or 'Both')");
        String choice = scanner.nextLine().toLowerCase();

        int[] combatMaterials = {0, 0, 0, 0};
        int[] coreMaterials = {0, 0, 0};
        boolean calculateCombat = false;
        boolean calculateCore = false;

        if (choice.equals("combat") || choice.equals("both")) {
            calculateCombat = true;
            System.out.println("\nEnter your current Combat Skill Investments (5 skills: Basic, Dodge, Assist, Special Attack, Chain Attack).");
            System.out.println("Example: 1 1 1 1 1 (for all level 1)");
            int[] currentLevels = new int[5];
            for (int i = 0; i < 5; i++) {
                currentLevels[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume leftover newline

            System.out.println("\nEnter your target Combat Skill levels (use 'X' to skip a skill or 'M' for max level 12).");
            String[] targetInputs = scanner.nextLine().split(" ");
            int[] targetLevels = new int[5];

            for (int i = 0; i < 5; i++) {
                if (targetInputs[i].equalsIgnoreCase("X")) {
                    targetLevels[i] = currentLevels[i];
                } else if (targetInputs[i].equalsIgnoreCase("M")) {
                    targetLevels[i] = 12;
                } else {
                    targetLevels[i] = Integer.parseInt(targetInputs[i]);
                }
            }

            combatMaterials = calculateCombatMaterials(currentLevels, targetLevels, characterInfo.element);
        }

        if (choice.equals("core") || choice.equals("both")) {
            calculateCore = true;
            System.out.println("\nEnter your current Core Skill unlocked (enter 'X' if none unlocked yet, otherwise 'A' through 'F'):");
            String currentCoreInput = scanner.nextLine();
            int currentCoreLevel = currentCoreInput.equalsIgnoreCase("X") ? 0 : currentCoreInput.charAt(0) - 'A' + 1;

            System.out.println("\nEnter your target Core Skill to unlock ('A' through 'F'):");
            String targetCoreInput = scanner.nextLine();
            int targetCoreLevel = targetCoreInput.charAt(0) - 'A' + 1;

            coreMaterials = calculateCoreMaterials(currentCoreLevel, targetCoreLevel);
        }

        // Display Results
        if (calculateCombat) {
            System.out.println("\nCombat Skill Materials Needed:");
            displayCombatMaterials(combatMaterials, characterInfo.element);
        }
        if (calculateCore) {
            System.out.println("\nCore Skill Materials Needed:");
            displayCoreMaterials(coreMaterials, characterInfo);
        }

        // Total Materials
        if (calculateCombat && calculateCore) {
            System.out.println("\nTotal Skill Materials Needed (Combat + Core):");
            displayCombinedMaterials(combatMaterials, coreMaterials, characterInfo);
        }

        scanner.close();
    }

    private static int[] calculateCombatMaterials(int[] currentLevels, int[] targetLevels, String element) {
        int totalDennies = 0;
        int basicChips = 0;
        int advancedChips = 0;
        int specializedChips = 0;

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
                        totalDennies += 135000;
                    }
                }
            }
        }

        return new int[]{totalDennies, basicChips, advancedChips, specializedChips};
    }

    private static int[] calculateCoreMaterials(int currentCoreLevel, int targetCoreLevel) {
        int totalDennies = 0;
        int totalExpertChallengeItems = 0;
        int totalNotoriousHuntItems = 0;

        for (int level = currentCoreLevel; level < targetCoreLevel; level++) {
            switch (level + 1) {
                case 1 -> totalDennies += 5000;
                case 2 -> {
                    totalDennies += 12000;
                    totalExpertChallengeItems += 2;
                }
                case 3 -> {
                    totalDennies += 28000;
                    totalExpertChallengeItems += 4;
                }
                case 4 -> {
                    totalDennies += 60000;
                    totalExpertChallengeItems += 9;
                    totalNotoriousHuntItems += 2;
                }
                case 5 -> {
                    totalDennies += 100000;
                    totalExpertChallengeItems += 15;
                    totalNotoriousHuntItems += 3;
                }
                case 6 -> {
                    totalDennies += 200000;
                    totalExpertChallengeItems += 30;
                    totalNotoriousHuntItems += 4;
                }
            }
        }

        return new int[]{totalDennies, totalExpertChallengeItems, totalNotoriousHuntItems};
    }

    private static void displayCombatMaterials(int[] combatMaterials, String element) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        // Extract the combat materials
        int totalDennies = combatMaterials[0];
        int basicChips = combatMaterials[1];
        int advancedChips = combatMaterials[2];
        int specializedChips = combatMaterials[3];
        
        // Calculate the worst and best case energy requirements for Combat Skill Chips
        int totalCards = basicChips + advancedChips + specializedChips;
        int worstCaseDays = (int) Math.ceil(totalCards * 20.0 / 320);
        int bestCaseDays = (int) Math.floor(totalCards * 20.0 / 320);
    
        // Display the Combat Skill materials and energy/days
        System.out.println("- Dennies: " + formatter.format(totalDennies));
        System.out.println("- Basic " + element + " Chips: " + basicChips);
        System.out.println("- Advanced " + element + " Chips: " + advancedChips);
        System.out.println("- Specialized " + element + " Chips: " + specializedChips);
        System.out.println("This will take you between " + bestCaseDays + " and " + worstCaseDays + " days for the Combat Skill Chips, assuming you get chips only from Combat Simulations.");
    }
    
    private static void displayCoreMaterials(int[] coreMaterials, CharacterInfo characterInfo) {
        DecimalFormat formatter = new DecimalFormat("#,###");
    
        // Extract the core materials
        int totalDennies = coreMaterials[0];
        int totalECItems = coreMaterials[1];
        int totalNHItems = coreMaterials[2];
    
        // Calculate Expert Challenge energy and runs
        int ecRunsRequired = (int) Math.ceil(totalECItems / 5.0);
        int ecEnergyRequired = ecRunsRequired * 40;
    
        // Calculate Notorious Hunt energy
        int nhEnergyRequired = totalNHItems * 60;
    
        // Display the Core Skill materials and energy requirements
        System.out.println("- Dennies: " + formatter.format(totalDennies));
        System.out.println("- Expert Challenge Items (" + characterInfo.expertChallengeItem + "): " + totalECItems);
        System.out.println("- Notorious Hunt Items (" + characterInfo.notoriousHuntItem + "): " + totalNHItems);
    
        System.out.println("\nThis will take you " + ecRunsRequired + " Expert Challenge runs against " + characterInfo.expertChallengeEnemy + ", for a total of " + ecEnergyRequired + " energy.");
        System.out.println("You need " + totalNHItems + " " + characterInfo.notoriousHuntItem + "s, which might take up to " + nhEnergyRequired + " energy.");
        System.out.println("Total Core Skill Energy Needed: " + ecEnergyRequired + " Energy, up to " + (ecEnergyRequired + nhEnergyRequired) + " if \"Pursuit to the Depths\" is used for every Notorious Hunt item.");
    }
    
    private static void displayCombinedMaterials(int[] combatMaterials, int[] coreMaterials, CharacterInfo characterInfo) {
        DecimalFormat formatter = new DecimalFormat("#,###");
    
        // Combine Dennies
        int totalDennies = combatMaterials[0] + coreMaterials[0];
    
        // Combine Combat Skill Chips
        int totalBasicChips = combatMaterials[1];
        int totalAdvancedChips = combatMaterials[2];
        int totalSpecializedChips = combatMaterials[3];
    
        // Extract Core Skill data
        int totalECItems = coreMaterials[1];
        int totalNHItems = coreMaterials[2];
    
        // Calculate energy requirements for Combat Skill Chips
        int totalCombatCards = totalBasicChips + totalAdvancedChips + totalSpecializedChips;
        int combatWorstCaseDays = (int) Math.ceil(totalCombatCards * 20.0 / 320);
        int combatBestCaseDays = (int) Math.floor(totalCombatCards * 20.0 / 320);
    
        // Calculate energy requirements for Core Skills
        int ecRunsRequired = (int) Math.ceil(totalECItems / 5.0);
        int ecEnergyRequired = ecRunsRequired * 40;
        int nhEnergyRequired = totalNHItems * 60;
    
        // Display combined results
        System.out.println("- Total Dennies: " + formatter.format(totalDennies));
        System.out.println("- Total Basic Chips: " + totalBasicChips);
        System.out.println("- Total Advanced Chips: " + totalAdvancedChips);
        System.out.println("- Total Specialized Chips: " + totalSpecializedChips);
    
        System.out.println("- Total Expert Challenge Items (" + characterInfo.expertChallengeItem + "): " + totalECItems);
        System.out.println("- Total Notorious Hunt Items (" + characterInfo.notoriousHuntItem + "): " + totalNHItems);
    
        System.out.println("\nCombat Skills will take you between " + combatBestCaseDays + " and " + combatWorstCaseDays + " days, assuming you get chips only from Combat Simulations.");
        System.out.println("Core Skills will take you " + ecRunsRequired + " Expert Challenge runs (" + ecEnergyRequired + " energy) against " + characterInfo.expertChallengeEnemy + ".");
        System.out.println("Core Notorious Hunts will require up to " + nhEnergyRequired + " energy.");
        System.out.println("Total Energy Needed: " + (ecEnergyRequired + nhEnergyRequired + totalCombatCards * 20) + " energy (Combat + Core).");
    }
    
}
class CharacterInfo {
    String element;
    String notoriousHuntItem;
    String notoriousHuntEnemy;
    String expertChallengeItem;
    String expertChallengeEnemy;

    CharacterInfo(String element, String notoriousHuntItem, String notoriousHuntEnemy, String expertChallengeItem, String expertChallengeEnemy) {
        this.element = element;
        this.notoriousHuntItem = notoriousHuntItem;
        this.notoriousHuntEnemy = notoriousHuntEnemy;
        this.expertChallengeItem = expertChallengeItem;
        this.expertChallengeEnemy = expertChallengeEnemy;
    }
}
