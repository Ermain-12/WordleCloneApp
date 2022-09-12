package com.ermain.wordlecloneapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var enteredWord: EditText

    lateinit var guessOneValue: TextView
    lateinit var guessOneCheckValue: TextView

    lateinit var guessTwoValue: TextView
    lateinit var guessTwoCheckValue: TextView

    lateinit var guessThreeValue: TextView
    lateinit var guessThreeCheckValue: TextView

    lateinit var showWordGuess: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Guess button
        val guessButton: Button = findViewById(R.id.button)

        // Guess entered
        enteredWord = findViewById(R.id.textViewWordGuess)

        // Store random selected word
        val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        // ?? Guess One
        val guessOneTitle = findViewById<TextView>(R.id.textViewGuessOneTitle)
        guessOneValue = findViewById<TextView>(R.id.textViewGuessOneValue)

        val guessOneCheckTitle = findViewById<TextView>(R.id.textViewGuessOneCheckTitle)
        guessOneCheckValue = findViewById(R.id.textViewGuessOneCheckValue)

        // ?? Guess Two
        val guessTwoTitle = findViewById<TextView>(R.id.textViewGuessTwoTitle)
        guessTwoValue = findViewById(R.id.textViewGuessTwoValue)

        val guessTwoCheckTitle = findViewById<TextView>(R.id.textViewGuessTwoCheckTitle)
        guessTwoCheckValue = findViewById(R.id.textViewGuessTwoCheckValue)

        // ?? Guess Three
        val guessThreeTitle = findViewById<TextView>(R.id.textViewGuessThreeTitle)
        guessThreeValue = findViewById(R.id.textViewGuessThreeValue)

        val guessThreeCheckTitle = findViewById<TextView>(R.id.textViewGuessThreeCheckTitle)
        guessThreeCheckValue = findViewById(R.id.textViewGuessThreeCheckValue)

        // Show word guess
        showWordGuess = findViewById(R.id.textViewShowWord)

        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                result += if (guess[i] == wordToGuess[i]) {
                    "O"
                } else if (guess[i] in wordToGuess) {
                    "+"
                } else {
                    "X"
                }
            }
            return result
        }

        var guessCount: Int = 1
        guessButton.setOnClickListener {
            when(guessCount) {
                    1 -> {
                            guessOneTitle.visibility = View.VISIBLE

                            guessOneValue.text = enteredWord.text.toString()
                            guessOneValue.visibility = View.VISIBLE

                            guessOneCheckTitle.visibility = View.VISIBLE
                            guessOneCheckValue.visibility = View.VISIBLE
                            guessOneCheckValue.text = checkGuess(enteredWord.text.toString())

                            guessCount++
                            enteredWord.text.clear()
                        }
                    2 -> {
                        guessTwoTitle.visibility = View.VISIBLE
                        guessTwoValue.visibility = View.VISIBLE
                        guessTwoValue.text = enteredWord.text.toString()

                        guessTwoCheckTitle.visibility = View.VISIBLE
                        guessTwoCheckValue.visibility = View.VISIBLE
                        guessTwoCheckValue.text = checkGuess(enteredWord.text.toString())

                        guessCount++
                        enteredWord.text.clear()
                    }
                    3 -> {
                        guessThreeTitle.visibility = View.VISIBLE
                        guessThreeValue.visibility = View.VISIBLE
                        guessThreeValue.text = enteredWord.text.toString()

                        guessThreeCheckTitle.visibility = View.VISIBLE
                        guessThreeCheckValue.visibility = View.VISIBLE
                        guessThreeCheckValue.text = checkGuess(enteredWord.text.toString())

                        guessCount++
                        enteredWord.text.clear()
                    }
                    4 -> {
                        enteredWord.visibility = View.INVISIBLE
                        guessButton.text = "Show Word"
                        guessButton.isClickable = false
                        showWordGuess.text = wordToGuess
                        showWordGuess.visibility = View.VISIBLE
                    }
                }
            }
        }
    }


// author: calren
object FourLetterWordList {
    // List of most common 4 letter words from: https://7esl.com/4-letter-words/
    private const val fourLetterWords =
        "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash," +
        "City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film," +
        "Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand," +
        "Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life," +
        "Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note," +
        "Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest," +
        "Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size," +
        "Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type," +
        "Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear," +
        "Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop," +
        "Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have," +
        "Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead," +
        "Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must," +
        "Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride," +
        "Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing," +
        "Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote," +
        "Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue," +
        "Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy," +
        "Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half," +
        "Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long," +
        "Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open," +
        "Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim," +
        "Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very," +
        "Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep," +
        "Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High," +
        "Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over," +
        "Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

    // Returns a list of four letter words as a list
    private fun getAllFourLetterWords(): List<String> {
        return fourLetterWords.split(",")
    }

    // Returns a random four letter word from the list in all caps
    fun getRandomFourLetterWord(): String {
        val allWords = getAllFourLetterWords()
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }
}


