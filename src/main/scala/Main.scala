import scopt.OParser

object Main extends App {
    case class Config(numbers: Int, words: String)

    val myBuilder = OParser.builder[Config]

    val myParser = {
        import myBuilder._
        OParser.sequence(
            programName("daniel"),
            head("scopt", "1.0.0-alpha"),
            help("help").text("prints this usage text"),
            opt[Int]('n', "numbers")
              .action((value, cfg) => cfg.copy(numbers = value))
              .text("My name property"),
            opt[String]('w', "words")
              .action((value, cfg) => cfg.copy(words = value))
              .text("My name property")

        )
    }

    val config = OParser.parse(
        myParser,
        args,
        Config(numbers = 0, words = "")).getOrElse {
        println("Not enough or incorrect command-line arguments. Exiting...")
        sys.exit(-1)
    }

    println(s"Numbers: ${config.numbers} ------> Words: ${config.words}")
}
