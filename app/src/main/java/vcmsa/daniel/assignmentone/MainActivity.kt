package vcmsa.daniel.assignmentone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.foodImage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declaring variables for future use.
        var userTimeOfDay = findViewById<EditText>(R.id.userTimeOfDay)
        var resetButton = findViewById<Button>(R.id.resetButton)
        var mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)
        var nextStep = findViewById<Button>(R.id.nextStep)
        var timesOfDay = findViewById<TextView>(R.id.timesOfDay)
        // Reset button that clears the user input and food suggestion and also resets the help text.
        resetButton.setOnClickListener {
            userTimeOfDay.text.clear()
            mealSuggestion.text = ""
            timesOfDay.text = "For example : Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner or Late-night"
        }
        // Button that checks the users input and matches it with the if statements.
        // It then converts user input to lowercase to make it case insensitive.
        // If if the input is directly equal to the statement then the meal suggestion is displayed.
        // If not, an appropriate error message is displayed.
        // As an additional feature I've decided to remove the help text "timesOfDay" if the user
        // inputs a valid time of day or an incorrect output.
        // It simply serves as a hint for the user when they open the app.
        nextStep.setOnClickListener {

            if (userTimeOfDay.text.toString().lowercase() == "morning") {
                timesOfDay.text = " "
                mealSuggestion.text =
                    "Breakfast Options: \nPorridge \nPancakes \nScrambled Eggs \nYogurt \nFruit"

            }else if (userTimeOfDay.text.toString().lowercase() == "mid-morning") {
                timesOfDay.text = " "
                mealSuggestion.text = "Brunch Options: \nFrench Toast \nCheese and Ham Sandwich \nAvocado on Toast \nFruit Salad \nCake and Tea"

            } else if (userTimeOfDay.text.toString().lowercase() == "afternoon") {
                            timesOfDay.text = " "
                            mealSuggestion.text = "Lunch Options: \nGrilled Cheese Sandwich \nBurger and Chips \nHot-dogs \nChicken and Avocado Salad \nBeef Wrap."

            }else if (userTimeOfDay.text.toString().lowercase() == "mid-afternoon") {
                            timesOfDay.text = " "
                            mealSuggestion.text = "Afternoon-snack Options: \nMicrowave-Muffins \nPeanut Butter Bars \nApple chips \nPop-corn \nChip-Roll"

            } else if (userTimeOfDay.text.toString().lowercase() == "dinner") {
                timesOfDay.text = " "
                mealSuggestion.text = "Dinner Options:\nLasagna \nButter Chicken Curry \nPasta and Meatballs \nPizza \nSteak with Potatoes and Gravy"

            }    else if (userTimeOfDay.text.toString().lowercase() == "late-night") {
                    timesOfDay.text = " "
                    mealSuggestion.text = "Late-Snack Options: \nIce-cream \nMicrowave Cake \nChocolate pudding \nCustard \nHot Chocolate"

            } else {
            timesOfDay.text = " "
            mealSuggestion.text = "Invalid input.\nNumbers, special characters and misspelled words are not allowed.\nPlease enter a valid time of day." +
                    "\nFor example: \nMorning \nMid-morning \nAfternoon \nMid-afternoon \nDinner \nLate-night"
}
}
    }
    }