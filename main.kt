import java.util.Scanner

fun main(args: Array<String>) {


  do {
    println("Welcome to the Kotlin Challenge #1!")
    println("Option #1 = Fibonacci")
    println("Option #2 = Sumatory")
    println("Option #3 = PrimeNum")
    println("Option #4 = CircularArea")
    println("Option #5 = Centigrades")
    val reader = Scanner(System.`in`)
    print("Enter a option between 1-5, '0' to exit: ")
  
  // nextInt() reads the next integer from the keyboard
  var opt:Int = reader.nextInt()
  when (opt) {
    // Fibonacci
    1 -> {
      println("Insert the fibonaccia numbers that you want")
      var n:Int = reader.nextInt()
      println("Fibonaccia = " + calcFibonacci().take(n).toList())
    }
    // Sumatory
    2 -> {
      println("Insert the sumatory number that you want")
      var n:Int = reader.nextInt()
      print("Sumatory = " + ((n*(n+1))/2) )
    }
    // Prime numers
    3 -> {
      println("Insert the prime numbers that you want")
      var n:Int = reader.nextInt()
      println("Prime numers = "+ getPrimeNumbers().take(n).joinToString(", "))
    }
    //Area of circle
    4 -> {
      println("Insert the radious to calculate the area")
      var r:Double = reader.nextDouble()
      println("Area of a circle = "+ calcCircleArea(r))
    }

    //C -> F and C -> K
    5 -> {
      println("Insert the centigrades to convert")
      var c:Double = reader.nextDouble()
      convertCentigrades(c)
    }
    
    else -> { // Note the block
        print("Warning: The option is no between 1-5")
    }
  
  }
  } while (opt != 0)
}


fun calcFibonacci(): Sequence<Int> {
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

fun calcCircleArea(radius: Double): Double {
    val PI = 3.14
    return PI * radius * radius
}

fun convertCentigrades(cent: Double) {
    println("C -> K = "+ (cent + 273.15))
    println("C -> F "+ (1.8 * cent + 32))
}

