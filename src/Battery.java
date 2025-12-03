public class Battery {
    public static int findBig(String input){
        int biggest = 0;
        for (int i=0;  i < input.length(); i++){
            for (int j=i+1; j < input.length(); j++){
                String temp = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(j));
                Integer number = Integer.valueOf(temp);
                if (number > biggest){
                    biggest = number;
                }

            }
        }
        return biggest;
    }
    public static int findBiggestAtIndex(String input, int startIndex, int limit){
        int biggest = 0;
        int index = 0;
        for (int i = startIndex; limit + i <= input.length(); i++){
            int r = input.length()-i;
            int stringlen = input.substring(i).length();
            int number = input.charAt(i)-'0';
            if (number > biggest){
                biggest = number;
                index = i;
            }

        }

//        System.out.println("biggest number at index: "+index+": "+biggest);
        return index;

    }

    public static long findBiggest12Digit(String input){
        StringBuilder biggest = new StringBuilder();
        int index = 0;
        int limit = 12;
        while (biggest.length()<12 ){
//            System.out.println("start index: "+index);
            index = findBiggestAtIndex(input, index, limit) ;
//            System.out.println("updated index: "+index);
            biggest.append(input.charAt(index ));
//            System.out.println(biggest);
            index +=1;
            limit -= 1;

        }
        System.out.println();
        System.out.println(biggest);
        return Long.parseLong(biggest.toString());
    }



}
