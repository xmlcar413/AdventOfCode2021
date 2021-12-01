import scala.io.Source

object Day1 {
  lazy val list: List[Int] = Source.fromResource("day1.txt").getLines.map(x => x.toInt).toList

  def main(args: Array[String]): Unit = {
    var result = 0
    for( a <- 0 to (list.size-2)){
      if(list(a) < list(a+1)){
        result += 1
      }
    }
    println(result.toString )

    var resultt = 0
    for( a <- 0 to (list.size-4)){
      if((list(a)+list(a+1)+list(a+2)) < (list(a+1)+list(a+2)+list(a+3))){
        resultt += 1
      }
    }
    println(resultt)
  }
}