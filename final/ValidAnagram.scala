def isAnagram(s: String, t: String): Boolean = {
		// sort two string and check are they equal
        var a = s.sorted
        var b = t.sorted
        if(a.equals(b))
             true
        else
            false
        
}