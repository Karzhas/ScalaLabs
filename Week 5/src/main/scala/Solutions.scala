import java.time.LocalDate
import java.time.format.DateTimeFormatter

// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
def maxProduct(nums: Array[Int]): Int = {
  val arr = nums.sorted
  (arr(arr.length-1)-1) * (arr(arr.length-2)-1)
}

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
def average(salary: Array[Int]): Double = {
  salary.sorted.slice(1,salary.length-1).sum/(salary.length-2).toDouble
}

// https://leetcode.com/problems/day-of-the-week/
def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
  val df = DateTimeFormatter.ofPattern("d/M/yyyy")
  LocalDate.parse(s"$day/$month/$year",df).getDayOfWeek.toString.toLowerCase.capitalize
}

// https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
def findPairs(nums: Array[Int], k: Int): Int = {
  val arr = nums.sorted
  var m = Map[Int,Int]()
  arr.foreach(v => {
    if(m.contains(v))
      m += (v -> {m(v) + 1})
    else
      m += (v -> 1)
  })
  var ans = 0
  arr.distinct.foreach(v => {
    if(m.contains(v + k)){
      if(k == 0 && m(v+k) > 1)
        ans += 1
      else if(k != 0)
        ans += 1
    }

  })
  ans

}

