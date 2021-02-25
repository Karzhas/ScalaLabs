object KidsWithTheGreatestNumberOfCandies {

  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] =
    for(c <- candies) yield if(c + extraCandies >= candies.max) true else false
  
}