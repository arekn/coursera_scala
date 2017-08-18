package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if ((c == r) || (c == 0)) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def accBalance(chars: List[Char], acc: Int): Boolean = {
      if (chars.isEmpty && acc == 0) true
      else if (acc < 0) false
      else if (chars.head == '(') accBalance(chars.tail, acc + 1)
      else if (chars.head == ')') accBalance(chars.tail, acc - 1)
      else accBalance(chars.tail, acc)
    }

    accBalance(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
