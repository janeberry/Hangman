# Hangman Game
This is a classic Hangman game implemented in Java. <br>
The game selects a random word from a predefined list, and the player must guess the word one letter at a time. <br>
The player has a limited number of attempts to guess the word correctly before losing the game.

<h2> 👾How to play game</h2>
You can play the game in Java Console

```java
Hangman game = new Hangman();
game.playgame();
```

<h2> Field Declarations</h2>
<ul>
  <li> <b> words</b>: String [], random words list</li>
  <li> <b>secretWord</b>: String, the chosen secret word</li>
  <li> <b>correctLetters</b>: List(Character), correct guesses</li>
  <li><b>incorrectLetters</b>: List(Character), incorrect guesses</li>
  <li><b>stdin</b>: Scanner, user input</li>
</ul>



<h2> Constructor </h2>
<ul>
  <li>Randomly choose a word from list of words.</li>
  <li>and set the word as a <b>secretWord</b></li>
  <br>
  <li>Build a initial pattern with _ based on the secretWord (correctLetters)</li>
  <li>initialize incorrectLetters using an ArrayList</li>
</ul>

```java
Random rand = new Random();
int randIndex = rand.nextInt(words.length);
this.secretWord = words[randIndex];
correctLetters = new ArrayList<Character>();
for (int i=0; i<secretWord.length(); i++){
  correctLetters.add('_');
}
this.incorrectLetters = new ArrayList<Character>();
```

<h2>Methods</h2>
<ul>
  <li>playGame()</li>
  <li>handleGuess()</li>
  <li>gameWon()</li>
  <li>gameLost()</li>
  <li>gameOver()</li>
  <li>printHangman()</li>
  <li>toString()</li>
  <li>setCurrentWord()</li>
  <li>setCorrectLetters()</li>
  <li>setIncorrectLetters()</li>
  <li>setBadGuesses()</li>
</ul>

