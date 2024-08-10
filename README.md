# Hangman Game
This is a classic Hangman game implemented in Java. <br>
The game selects a random word from a predefined list, and the player must guess the word one letter at a time. <br>
The player has a limited number of attempts to guess the word correctly before losing the game.

<h2> 👾How to play game</h2>

```java
Hangman game = new Hangman();
game.playgame();
```

<h2> Field Declarations</h2>



<h2> Constructor </h2>
- Randomly choose a word from list of words. <br>
- Set the word as a <b>secretWord</b> <br>
- Build a initial pattern with _ based on the secretWord (correctLetters) <br>
- initialize incorrectLetters here using an ArrayList

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
