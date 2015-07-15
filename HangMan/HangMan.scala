import scala.util.control._

object HangMan {

  def newAnswerArray(length: Int, word: Array[Char]): Array[Char] = {
    var n = 0
    var array = new Array[Char](length)
    for( n <- 0 to length-1 ) {
      if(word(n) == ' '){
        array(n) = ' '
      }else{
        array(n) = '_'
      }
    }
    return array
  }

  def printArray(array: Array[Char]): Unit = {
    var n = 0
    for( n <- 0 to array.length-1){
      print(array(n))
    }
  }

  def updateAnswer(guess: Char, word: Array[Char], current: Array[Char]): Array[Char] = {
    var n = 0
    for( n <- 0 to word.length-1 ){
      if(word(n) == guess){
        current(n) = guess
      }
    }
    return current
  }

  def isAnswerComplete(word: Array[Char], current: Array[Char]): Boolean = {
    if(word.deep == current.deep) {
      return true
    }else{
      return false
    }
  }

  def drawNoose(level: Int): Unit = {
    println(raw"    _______")
    println(raw"   |/      |")

    if(level >= 1) {
      println(raw"   |      (_)")
    }else{
      println(raw"   |")
    }

    if(level == 2) {
      println(raw"   |       | ")
    }else if(level == 3){
      println(raw"   |      \| ")
    }else if(level >= 4) {
      println(raw"   |      \|/")
    }else{
      println(raw"   |")
    }

    if(level >= 5) {
      println(raw"   |       |")
    }else{
      println(raw"   |")
    }

    if(level == 6) {
      println(raw"   |      /")
    }else if(level == 7) {
      println(raw"   |      / \ ")
    }else{
      println(raw"   |")
    }

    println(raw"   |")
    println(raw"___|___")
  }

  def main(args: Array[String]) {
    print("Enter a word: "); var word = scala.io.StdIn.readLine
    word = word.toUpperCase
    var wordArray = word.toCharArray

    var answerArray = newAnswerArray(wordArray.length, wordArray)

    var win = false
    var incorrectGuesses: Int = 7
    var guessed: Int = 0
    val loop = new Breaks

    loop.breakable {
      while(win == false){
        if(guessed >= incorrectGuesses){
          loop.break
        }
        drawNoose(guessed)
        printArray(answerArray)
        println()

        print("Guess a letter: "); var letter: Char = scala.io.StdIn.readChar
        answerArray = updateAnswer(letter.toUpper, wordArray, answerArray)

        if(answerArray contains letter.toUpper){
          println("Nice Guess!")
        }else{
          guessed += 1
          println(s"You've had $guessed out of $incorrectGuesses incorrect guesses")
        }
      
        win = isAnswerComplete(wordArray, answerArray)
    
      }
    }
    printArray(answerArray)
    if(win) {
      println("Congrats! You got it right!")
    }else{
      drawNoose(guessed)
      println("You've exhausted all your guesses, you'll get'em next time champ")
      print("By the way, the answer was"); printArray(wordArray)
    }

  }
}
