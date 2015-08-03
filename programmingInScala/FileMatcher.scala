/*
  a file matcher API: reducing code duplication with higher function
*/

object FileMatcher {
    private def filesHere = java.io.File(".").listFiles
    
    def filesMatching(query: String,
            matcher: (String, String) => Boolean) = {
        
        for(file <- filesHere if matcher(file.getName, query))
            yield file
    }
    
    def filesEnding(query: String) =
        filesMatcher(query, _.endsWith(_))   // (fileName: String, query: String) => fileName.endsWith(query)
    def filesContaining(query: String) =
        filesMatcher(query, _.contains(_))
    def filesRegex(query: String) =
        filesMatcher(query, _.matches(_))
}

/* reduce parameters to simplify code further */
object FileMatcherClosure {
    private def filesHere = java.io.File(".").listFiles
    
    def filesMatching(matcher: (String) => Boolean) = {
        for(file <- filesHere if matcher(file.getName))
            yield file
    }
    
    def filesEnding(query: String) =
        filesMatcher(_.endsWith(query))
    def filesContaining(query: String) =
        filesMatcher(_.contains(query))
    def filesRegex(query: String) =
        filesMatcher(_.matches(query))
}
