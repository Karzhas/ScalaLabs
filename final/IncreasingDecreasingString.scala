object Solution {
    def sortString(s: String): String = {
    // code do the same as written in task
    // while we didnt construct string of length of original string we make two procedurec
    // 1: append to answer the smallest distinct chars
    // and then 2: greatest

        var ans : String = ""
        var a = new Array[Int](26)
        var cnt = 0
        var n = s.length
        for(i <- 0 until n){
            a(s(i)-'a') = a(s(i)-'a') + 1
            cnt += 1
        }
        while(cnt != 0){
            for(i <- 0 until 26){
                if(a(i) > 0){
                    ans += (i+'a').toChar
                    cnt -= 1
                    a(i) = a(i) - 1
                }
            }
            for(i <- (0 to 25).reverse){
                if(a(i) > 0){
                   ans += (i+'a').toChar
                    cnt -= 1
                    a(i) -= 1
                }
            }
        }
        ans
    }
}