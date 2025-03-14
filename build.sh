#!/bin/bash

# Ensure classpath is set for compilation, including the necessary libraries.
CLASSPATH="lib/core.jar:lib/SketchUI.jar"

# Step 1: Compile Java files, including necessary libraries in the classpath
javac -d bin -cp "$CLASSPATH" src/sketchui/*.java

# Step 2: Create the MANIFEST.MF file
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: sketchui.main" >> MANIFEST.MF  # Replace with your actual main class

# Step 3: Create the JAR file, including libraries in the classpath
jar cvfm SketchUI.jar MANIFEST.MF -C bin . -C lib core.jar

# Step 4: Move the JAR file to the SketchUI/library folder
mkdir -p SketchUI/library  # Create the directory if it doesn't exist
mv SketchUI.jar SketchUI/library/SketchUI.jar

# Step 5: Copy the SketchUI folder to /home/curiousdev/sketchbook/libraries
cp -r SketchUI /home/curiousdev/sketchbook/libraries/

# Step 6: Clean up
rm MANIFEST.MF

echo "Build and deployment completed successfully!
