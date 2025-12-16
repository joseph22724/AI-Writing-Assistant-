# AI-Writing-Assistant
AI-powered writing tool with different modes

## Setup
1. Java JDK 17 and Maven 
2. Get API key from https://aistudio.google.com/app/api-keys
3. go to/create "src/main/resources/config.properties " and add your key:

  api.key=" "
  api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent
5. Run Main.java

## Features
- Creative writing mode
- Professional writing mode
- Academic writing mode
- Grammar Check mode
- Translation mode

## Design Patterns
- Strategy: Different writing modes
- Factory: Request creation
- Observer: UI updates using ActionListener

## Video Demo
https://youtu.be/GoUBtaMLi84 
