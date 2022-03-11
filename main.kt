import java.util.Scanner

fun main(args: Array<String>) {
  
  println("Welcome to the Kotlin Challenge #1!")
  
  println("Option #1 = Fibonacci")
  val reader = Scanner(System.`in`)
  print("Enter a option between 1-5: ")
  // nextInt() reads the next integer from the keyboard
  var opt:Int = reader.nextInt()
  when (opt) {
  
    1 -> {
      println("Insert the fibonaccia numbers that you want")
      var n:Int = reader.nextInt()
      println("Fibonaccia = " + calcFibonacci().take(n).toList())
    }
    
    2 -> {
      println("Insert the sumatory number that you want")
      var n:Int = reader.nextInt()
      print("Sumatory = " + ((n*(n+1))/2) )
    }

    3 -> {
      println("Insert the prime numbers that you want")
      var n:Int = reader.nextInt()
      println("Prime numers = "+ getPrimeNumbers().take(n).joinToString(", "))
    }
    else -> { // Note the block
        print("Warning: The option is no between 1-5")
    }
  
  }
}


fun calcFibonacci(): Sequence<Int> {
    // fibonacci terms
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
    return generateSequence(Pair(0, 1), { Pair(it.second, it.first + it.second) }).map { it.first }
}

fun getPrimeNumbers(): Sequence<Long> {
    var i = 0L

    return sequence {
        generateSequence { i++ }
            .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
            .forEach { yield(it) }
    }
}


