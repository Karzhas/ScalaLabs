object Solution {
    def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    // sort array and take the first difference between first two element and then check for others adjacent elements for their difference
        var a = arr.sorted
        var d = a(1) - a(0)
        for(i <- 2 until a.length){
            if(a(i) - a(i-1) != d)
                return false;
        }
        return true;
    }
}