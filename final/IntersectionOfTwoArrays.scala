object Solution {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    	// remove firstly dublicates from arrays and then return their intersection
        var n1 = nums1.distinct
        var n2 = nums2.distinct
        List(n1,n2).reduce((a, b) => a intersect b)

    }
}