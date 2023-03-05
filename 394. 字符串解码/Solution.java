class Solution {

    public static void main(String[] args) {
        System.out.println(decodeString("3"));
    }
    public static String decodeString(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) >= 'a' &&  s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }else{
                int start = i;
                while (i < n && s.charAt(i) != '['){
                    i++;
                }

                int cnt = Integer.parseInt(s.substring(start, i));

                i++;
                if (i >= n){
                    return sb.toString();
                }

                start = i;
                int temp = 1;

                while(temp !=  0 && i < n){
                    System.out.println(i);
                    if(s.charAt(i) == '['){
                        temp++;
                    }else if(s.charAt(i) == ']'){
                        temp--;
                    }
                    i++;
                }
                i--;
                int end = i;

                String sub = decodeString(s.substring(start, end));
                System.out.println(start + " " + end);
                for(int j = 0; j < cnt; j++){
                    sb.append(sub);
                }
            }
        }

        return sb.toString();
    }
}