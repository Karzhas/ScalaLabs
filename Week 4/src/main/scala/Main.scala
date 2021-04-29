import scala.io.StdIn

object Main{
  def isStringNumber(str : String) : Boolean = str forall(_.isDigit)
  def main(args: Array[String]): Unit = {
    val input : String = StdIn.readLine()
    val partition = input.replace(' ', '+').split("(?<=[-+*/])|(?=[-+*/])").partition(isStringNumber)
    val numbers = partition._1.map(_.toInt)
    val operators = partition._2
    var result = numbers(0)
    var ind = 0
    for(i <- 1 until numbers.length){
      operators(ind) match {
        case "+" => result += numbers(i)
        case "-" => result -= numbers(i)
        case "*" => result *= numbers(i)
        case "/" => result /= numbers(i)
      }
      ind += 1

    }
    println(result)



    //    val operators = input.split(" ").partition{
//      case "+" | "-" | "*" | "/" => false
//      case _ => true
//    }


  }
}