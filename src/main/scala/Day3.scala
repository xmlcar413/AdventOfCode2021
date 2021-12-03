import scala.collection.immutable
import scala.io.Source

object Day3 {
  lazy val list: List[String] = Source.fromResource("day3.txt").getLines.toList
  def main(args: Array[String]): Unit = {
    println(part1())
    println(part2())
  }
  def part1(): Int = {
    var nrBits = list.head.length
    var occurrence = Array.fill(nrBits)(0)
    var common: String = ""
    var uncommon: String = ""

    list.foreach(s => {
      for ( i <- s.indices) {
        if (s.charAt(i).equals('1')) {
          occurrence(i) += 1
        }
      }
    })

    for ( a <- 0 until nrBits){
      if (occurrence(a) > (list.length/2)) {
        common = common + "1"
        uncommon = uncommon + "0"
      }
      else{
        common = common + "0"
        uncommon = uncommon + "1"
      }
    }

    var gamma = Integer.parseInt(common, 2)
    var epsilon = Integer.parseInt(uncommon, 2)
    gamma*epsilon
  }

  def part2(): Int = {
    var lookAtBit: Int = 0
    var lOxy: List[String] = list
    var lScrub: List[String] = list
    var loop: Boolean = true
    while (loop){
      if(isBitMajorityAtIndex(lOxy, lookAtBit, '1')){
        lOxy = trimList(lOxy, lookAtBit, '1')
      }
      else{
        lOxy = trimList(lOxy, lookAtBit, '0')
      }

      if(lOxy.length == 1){
        loop = false
      }
      lookAtBit += 1
    }

    lookAtBit = 0
    loop = true
    while (loop){
      if(isBitMinorityAtIndex(lScrub, lookAtBit, '0')){
        lScrub = trimList(lScrub, lookAtBit, '0')
      }
      else{
        lScrub = trimList(lScrub, lookAtBit, '1')
      }

      if(lScrub.length == 1){
        loop = false
      }
      lookAtBit += 1
    }

    var oxy = Integer.parseInt(lOxy.head, 2)
    var scrub = Integer.parseInt(lScrub.head, 2)
    oxy*scrub
  }
  def isBitMajorityAtIndex(l: List[String],lookAtBit: Int, lookForBit: Char): Boolean = {
    var occurrence: Int = 0
    l.foreach(s => if (s.charAt(lookAtBit).equals(lookForBit)) occurrence += 1)
    occurrence >= (l.length-occurrence)
  }
  def isBitMinorityAtIndex(l: List[String],lookAtBit: Int, lookForBit: Char): Boolean = {
    var occurrence: Int = 0
    l.foreach(s => if (s.charAt(lookAtBit).equals(lookForBit)) occurrence += 1)
    occurrence <= (l.length-occurrence)
  }
  def trimList(l: List[String],lookAtBit: Int, lookForBit: Char): List[String] = {
    l.filter(a => a.charAt(lookAtBit).equals(lookForBit))
  }
}
