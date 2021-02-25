//object ConvertBinaryNumberInALinkedListToInteger {
//  def getDecimalValue(head: ListNode): Int = {
//    var s = ""
//    var curr = head
//    while(curr != null){
//      s += curr.x
//      curr = curr.next
//    }
//    Integer.parseInt(s,2)
//  }
//  def getDecimalValue(head: ListNode): Int = {
//    var s: String = ""
//    var res: Int = 0
//    var curr = head
//    while (curr != null) {
//      s += curr.x
//      curr = curr.next
//    }
//    s = s.reverse
//    var m = 1;
//    print(s)
//    for (c <- s) {
//      res = res + m * c.asDigit;
//      m *= 2;
//    }
//    res
//  }
//}
