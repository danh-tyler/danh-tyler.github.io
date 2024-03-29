class Main {
    public static List<String> removeInvalidParentheses(String s) {
        int longest = -1;
        Set<String> res = new HashSet<String>();
        dfs(s,0,res,0,0);
        return res;
    }
    public static void (String s, int index, Set<String> current, int l, int r){
        if (i >= s.length()){
            if (l == r){
                if (current.size() > longest){
                    longest = current.size();
                    HashSet<String> res = new HashSet<String>();
                }
            }
        }
    }
  public static void Main(String[] args){
    String s = "()())()";
    List<String> list = removeInvalidPrantheses(s);
    System.out.println(list);
  }
}
