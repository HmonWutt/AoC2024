public class DayNineUtil {
       public static int getFreeSpaceNeeded(String input,int index){
           //System.out.println("Index: "+index);
           return Integer.parseInt(Character.toString(input.charAt(index)));
       }
       public static int checkFreeSpaceLeft(int freeSpace, int spaceNeeded) {
           return freeSpace-spaceNeeded;
       }

       public static int calculateIndexTimesValue(int value, int index){
           return value*index;
       }

       public static String replaceaCharInString (String input, int indexOfReplacement, String replacment){
           String newString = "";
           for (int i=0; i <input.length(); i++){
               if (i==indexOfReplacement){
                   newString+=replacment;
               }
               else{
                   newString+=input.charAt(i);
               }
           }
           return newString;
       }

}
