package com.example.mysocialspark // Ensure this matches your project package name

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Tag for logging purposes
    private val TAG = "SocialSparkApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Linking the UI components using the IDs from your Layout
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeofDay)
        val edtSuggestion = findViewById<EditText>(R.id.edtSuggestion) // Used to display output
        val btnGetSuggestion = findViewById<Button>(R.id.btnGetSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // 2. Logic for the "Get Suggestion" button
        btnGetSuggestion.setOnClickListener {
            val userInput = edtTimeOfDay.text.toString().trim().lowercase()
            Log.d(TAG, "User clicked Get Suggestion. Input: $userInput")

            // Error Handling: check if input is empty
            if (userInput.isEmpty()) {
                edtSuggestion.setText("Please enter a time of day (e.g., Morning)!")
                Log.w(TAG, "Input error: Text field was empty.")
                return@setOnClickListener
            }

            /*
               3. Social Spark Suggestion Logic
               Using 'if' statements as specified in your assignment requirements.
            */
            var result = ""

            if (userInput.contains("morning") && !userInput.contains("mid")) {
                result = "Send a 'Good morning' text to a family member. ☀️"
            }
            else if (userInput.contains("mid-morning") || userInput.contains("mid morning")) {
                result = "Reach out to a colleague with a quick 'Thank you.' ☕"
            }
            else if (userInput.contains("afternoon") && !userInput.contains("snack")) {
                result = "Share a funny meme or interesting link with a friend. 😂"
            }
            else if (userInput.contains("snack")) {
                result = "Send a quick 'thinking of you' message. 🥨"
            }
            else if (userInput.contains("dinner")) {
                result = "Call a friend or relative for a 5-minute catch-up. 📞"
            }
            else if (userInput.contains("night") || userInput.contains("after dinner")) {
                result = "Leave a thoughtful comment on a friend's post. 🌙"
            }
            else {
                // Constructive feedback for invalid information
                result = "Hmm, I don't recognize that time. Try typing 'Morning', 'Dinner', or 'Afternoon' to get a spark! ✨"
                Log.i(TAG, "Invalid input: $userInput")
            }

            // Display the result in your suggestion field
            edtSuggestion.setText(result)
            Log.d(TAG, "Suggestion displayed: $result")
        }

        // 4. Logic for the "Reset" button
        btnReset.setOnClickListener {
            Log.d(TAG, "Reset button clicked. Clearing all fields.")
            edtTimeOfDay.text.clear()
            edtSuggestion.setText("") // Clears the suggestion box
        }
    }
}