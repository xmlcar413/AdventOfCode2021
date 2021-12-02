import scala.io.Source

object Day2 {
  lazy val list: List[Array[String]] = Source.fromResource("day2.txt").getLines.map(x => x.split(" ")).toList

  def main(args: Array[String]): Unit = {
    println(part1())
    println(part2())
  }
  def part1(): Int = {
    var hor = 0
    var ver = 0
    for( a <- list.indices){
      if(list(a)(0) == "forward"){
        hor += list(a)(1).toInt
      }
      else{
        ver = list(a)(0) match {
          case "down" => ver + list(a)(1).toInt
          case "up" => ver - list(a)(1).toInt
        }
      }
    }
    hor*ver
  }

  def part2(): Int = {
    var hor = 0
    var ver = 0
    var aim = 0
    for( a <- list.indices){
      if(list(a)(0) == "forward"){
        hor += list(a)(1).toInt
        ver += list(a)(1).toInt * aim
      }
      else{
        aim = list(a)(0) match {
          case "down" => aim + list(a)(1).toInt
          case "up" => aim - list(a)(1).toInt
        }
      }
    }
    hor*ver
  }

}
