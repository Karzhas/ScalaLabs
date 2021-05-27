object Solution {
    def largestPerimeter(nums: Array[Int]): Int = {
    	// non zero area triangle only if sum of two sides greater than third
    	// to maximize answer start from greatest values and check are tree elements valid
        var a = nums.sorted
        var n = a.length
        for(i <- (0 until n-2).reverse ){
            if(a(i) + a(i+1) > a(i+2))
                return a(i) + a(i+1) + a(i+2)
        }
        return 0
    }
}