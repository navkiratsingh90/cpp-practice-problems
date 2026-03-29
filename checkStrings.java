class Solution {
    public boolean checkStrings(String s1, String s2) {
        StringBuilder str = new StringBuilder(s2);
        StringBuilder e = new StringBuilder("");
        StringBuilder o = new StringBuilder("");
        StringBuilder e1 = new StringBuilder("");
        StringBuilder o1 = new StringBuilder("");
        for (int i=0;i<s2.length();i++){
            if (i%2 == 0){
                e.append(s1.charAt(i));
                e1.append(s2.charAt(i));
            }
            else {
                o.append(s1.charAt(i));
                o1.append(s2.charAt(i));
            }
        } 
        char[] arr = e.toString().toCharArray();
        Arrays.sort(arr);
        e = new StringBuilder(new String(arr));
        char[] arr1 = e1.toString().toCharArray();
        Arrays.sort(arr1);
        e1 = new StringBuilder(new String(arr1));
        char[] arr2 = o.toString().toCharArray();
        Arrays.sort(arr2);
        o = new StringBuilder(new String(arr2));
        char[] arr3 = o1.toString().toCharArray();
        Arrays.sort(arr3);
        o1 = new StringBuilder(new String(arr3));
        if (e.toString().equals(e1.toString()) && o.toString().equals(o1.toString())) return true;
        return false;
    }
}
