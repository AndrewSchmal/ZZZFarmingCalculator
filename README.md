# ZZZ Farming Tracker

## Overview

The **ZZZ Farming Tracker** is a Java-based console application designed to help players of **Zenless Zone Zero** (ZZZ) optimize their farming strategies for upgrading both **Combat Skills** and **Core Skills** of their characters. By inputting their characters’ current and target skill levels, players can efficiently calculate the required materials, energy, and the number of days needed to farm these materials.

This was my final project for my ITCS-3112 - Design and Implementation of Object-Oriented Systems class at UNC Charlotte (I probably went too ham on this but oh well).

## Download and Usage Instructions

1. **Download the Project**  
   Clone or download the repository from GitHub:  
   [GitHub Repository - ZZZFarmingCalculator](https://github.com/AndrewSchmal/ZZZFarmingCalculator)

2. **Set Up Your Environment**  
   Ensure you have Java Development Kit (JDK 8 or higher) installed.  
   If you're using Visual Studio Code, I recommend the [Coding Pack for Java](https://code.visualstudio.com/docs/languages/java), which includes VS Code, the JDK, and helpful Java extensions.

3. **Compile and Run the Program**  
   - Open `ZZZFarmingTracker.java` in your IDE or text editor.  
   - Compile and run the program:  
     - **Command Line:**  
       ```bash
       javac ZZZFarmingTracker.java
       java ZZZFarmingTracker
       ```
     - **VS Code:** Right-click on the file and select **Run Java**.

4. **Using the Program**  
   - Follow the prompts to select a character, specify skill progressions, and calculate the materials and energy required.  
   - The program will display the results clearly, including the estimated time and energy required.

5. **Explore Additional Features**  
   - For more detailed explanations and project features, read the full documentation in this repository’s [README.md](https://github.com/AndrewSchmal/ZZZFarmingCalculator/blob/main/README.md).

### Object-Oriented Principles

I made this project for my Object-Oriented Programming (OOP) class, so I kept the following OOP principles in mind while designing and implementing it:

- **Encapsulation**: Each class has clearly defined attributes and methods that represent its responsibilities. For example, `CharacterInfo` encapsulates all data related to a character’s attributes and required materials.
- **Abstraction**: Complex operations, such as calculating materials and energy requirements, are abstracted into methods like `calculateCombatMaterials` and `calculateCoreMaterials`, simplifying the logic for the user.
- **Inheritance**: Although not heavily utilized in this project, the program demonstrates how shared properties and behaviors could be extended if a hierarchy of characters or materials were introduced in the future.
- **Polymorphism**: The program leverages method parameters to handle varying input and calculations, making it flexible for different scenarios, such as "Combat," "Core," or "Both" skill progressions.
- **Modularity**: Each class, such as `Materials` or `CharacterInfo`, is designed with a single responsibility, making the code easier to maintain and extend.

These principles helped ensure the program is both functional and scalable while maintaining clean, readable code.


## Features

1. **Character Information:**
   - Includes all 24 characters from ZZZ (up to Version 1.3).
   - Each character is mapped to their respective element, Notorious Hunt items, and Expert Challenge items.

2. **Skill Calculations:**
   - **Combat Skills**: Calculates Dennies and chips (Basic, Advanced, and Specialized) required to upgrade up to five combat skills: Basic, Dodge, Assist, Special Attack, and Chain Attack.
   - **Core Skills**: Calculates Dennies, Notorious Hunt items, and Expert Challenge items required to unlock and upgrade core skills (A → F).

3. **Energy Calculations:**
   - Estimates the energy and days needed for Combat Skills farming through Combat Simulations.
   - Estimates the energy required for Core Skills farming, including Expert Challenge runs and Notorious Hunts.

4. **Customizable Options:**
   - Players can choose to upgrade **Combat Skills**, **Core Skills**, or both.
   - Allows skipping certain skills or setting them to max directly.

5. **Detailed Results:**
   - Displays the required materials for Combat and Core Skills separately.
   - Combines results to show the total materials and energy needed for both upgrades.

---

## How to Use

### 1. Select Your Character
- The application provides a list of all 24 characters, sorted alphabetically.
- Input the name of your chosen character (case-insensitive).

### 2. Choose Skills to Upgrade
- Select whether you want to upgrade:
  - **Combat Skills**
  - **Core Skills**
  - **Both**

### 3. Input Current and Target Levels
#### For Combat Skills:
- Enter current levels for all five skills (Basic, Dodge, Assist, Special Attack, Chain Attack).
- Specify target levels for the skills using:
  - `X` to skip upgrading a skill.
  - `M` to max a skill (level 12).
  
#### For Core Skills:
- Specify the current core skill unlocked (`X` for none, or `A` through `F`).
- Input the target core skill to unlock (`A` through `F`).

### 4. View Results
- The application calculates:
  - Required materials (Dennies, chips, Notorious Hunt items, Expert Challenge items).
  - Estimated energy and days for farming materials.

---

## Sample Output

**Combat Skill Calculation Example:**

Combat Skill Materials Needed:

    Dennies: 135,000
    Basic Electric Chips: 15
    Advanced Electric Chips: 30
    Specialized Electric Chips: 25 This will take you between 5 and 7 days for the Combat Skill Chips, assuming you get chips only from Combat Simulations.




**Core Skill Calculation Example:**
Core Skill Materials Needed:

    Dennies: 415,000
    Expert Challenge Items (Steel Malice): 60
    Notorious Hunt Items (Living Drive): 12

This will take you 12 Expert Challenge runs against Hans, for a total of 480 energy. You need 12 Living Drives, which might take up to 720 energy. Total Core Skill Energy Needed: 480 Energy, up to 1,200 if "Pursuit to the Depths" is used for every Notorious Hunt item.



**Combined Material Calculation Example:**
Total Skill Materials Needed (Combat + Core):

    Total Dennies: 550,000
    Total Basic Chips: 15
    Total Advanced Chips: 30
    Total Specialized Chips: 25
    Total Expert Challenge Items (Steel Malice): 60
    Total Notorious Hunt Items (Living Drive): 12

Combat Skills will take you between 5 and 7 days, assuming you get chips only from Combat Simulations. Core Skills will take you 12 Expert Challenge runs (480 energy) against Hans. Core Notorious Hunts will require up to 720 energy. Total Energy Needed: 1,200 energy (Combat + Core).


---

## Character Data

Each character is associated with:
- **Element:** The elemental type of the character.
- **Notorious Hunt Item:** Item required for upgrading core skills.
- **Notorious Hunt Enemy:** The boss that drops the Notorious Hunt item.
- **Expert Challenge Item:** Item required for core skills.
- **Expert Challenge Enemy:** The boss that drops the Expert Challenge item.

### Example:
Anby:

    Element: Electric
    Notorious Hunt Item: Ferocious Grip (dropped by Newborn Dead End Butcher)
    Expert Challenge Item: Murderous Obituary (dropped by Dullahan)


---

## Energy Calculations

### Combat Simulations
- Each card costs **20 energy**.
- Best and worst case scenarios calculated based on chip drop ranges.

### Core Skills
- Expert Challenges: **40 energy/run**, yielding 5 items.
- Notorious Hunts: **60 energy/item**.

---

## Technical Details

### Core Classes
1. **CharacterInfo**:
   - Stores data for each character’s element, Notorious Hunt/Expert Challenge items, and associated enemies.
   
2. **ZZZFarmingTracker**:
   - Main class that handles user input, calculations, and displays results.

### Calculation Methods
- **`calculateCombatMaterials`**: Calculates materials for Combat Skills.
- **`calculateCoreMaterials`**: Calculates materials for Core Skills.
- **`displayCombatMaterials`**: Displays Combat Skill materials and energy/days.
- **`displayCoreMaterials`**: Displays Core Skill materials and energy requirements.
- **`displayCombinedMaterials`**: Combines results for Combat and Core Skills.

---

## Requirements

- **Java 8 or above**: The application is written in Java and requires a JDK to compile and run.
- **Terminal/Command Prompt**: Used for input/output interaction.

---

## How to Run

1. Clone or download the repository.
2. Compile the code using:
   ```bash
   javac ZZZFarmingTracker.java

3. Run the application
    java ZZZFarmingTracker

Potential Future Improvements

    Add support for other farming scenarios (e.g., level cap materials, core skill variations).
    Implement a GUI for easier interaction.
    Store user profiles to save progress across sessions.



## Disclaimer

I don't work for MiHoYo this is just a school project lol

<p align="center">
  <img src="EllenSpin.gif" alt="Ellen Spin" width="100" height="100">
  <img src="EllenSpin.gif" alt="Ellen Spin" width="100" height="100">
  <img src="EllenSpin.gif" alt="Ellen Spin" width="100" height="100">
  <img src="EllenSpin.gif" alt="Ellen Spin" width="100" height="100">
  <img src="EllenSpin.gif" alt="Ellen Spin" width="100" height="100">
  </p>
