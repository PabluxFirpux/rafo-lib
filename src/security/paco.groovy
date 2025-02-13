def text = "Me llamo joseantoniopablo"
def pattern = "antonio"
println(addQuotesAroundString(text,pattern))










def addQuotesAroundString(def string, def pattern) {
    def pieces = string.split(pattern);
    return pieces[0] + "\"" + pattern + "\"" + pieces[1]
}