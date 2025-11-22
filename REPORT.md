
#Project Report

## Challenges

**Challenge 1: Public API Key (Silly Mistake)**
* Problem: I accidentally committed my config.properties file that had my API key because I added it to .gitignore after the initial commit. 
* Solution: I deleted the config.properties file on github, generated a new key and have it saved locally.

**Challenge 2: Rate Limits**
* Problem: Using OpenAI resulted in "429 Too Many Requests? errors because I did not have anymore tokens.
* Solution: I switched the Google Gemini, which was free.

## Design Pattern Justifications

**1. Strategy Pattern**
 Justification: Needed different AI behaviors that could be swapped at runtime. Using the Strategy to encapsulate each prompt logic into its own class.

**2. Singleton Pattern (ConfigManager)** 
Justification: The Singleton pattern makes sure the configuration is loaded into memory and is reused instead of reading from the drive, which is slow.

**3. Factory Pattern**
 Justification: The Factory handles the logic of converting a User Interface string such as "Professional" into a specific Java Object "new ProfessionalStrategy()".

**4. Observer Pattern**
 Justification: Using "ActionListener" to the "Generate" button, the Controller waits for user input asynchronously, the View handles display while the Controller handles logic.

## AI Usage
Used ChatGPT as a Search Engine

**1. Freezing UI Problem**
 Context: In Swing, I learned that running a long network request on the main thread blocks the Event Dispatch Thread. When I clicked "Generate" the window froze while waiting for the API.
 Asked: Asked chatGPT "I put the API call inside the button listener and now the whole screen freezes when I run it. Is there a way to make the code wait for the internet without freezing?"
 Result: The AI explained that I was blocking the main thread and provided the specific boilerplate code using "new Thread()" for the network call and "SwingUtilities.invokeLater()" to update the text box.

**2. Complex json**
 Context: Having trouble reading Gemini's API response. I didnt want to write 5 different Java classes just to extract the string.
 Prompt: Asked Chatgpt "The json coming back from the api is long, Is there an simpler way to get the specific text string I need using Gson? I dont want to use seperate classes."
 Result: The AI showed me how to use chain method calls into the json text. 


## Time Spent: ~20 hours
