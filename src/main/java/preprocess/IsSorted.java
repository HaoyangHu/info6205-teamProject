package preprocess;

public class IsSorted {
    public static boolean isSorted(String[][] a){
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            if(a[i][0].compareTo(a[i + 1][0]) > 0){
                return false;
            }

        }
        return true;
    }

    public static boolean isSorted(Name[] a){
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            if(a[i].compareTo(a[i + 1]) > 0){
                return false;
            }

        }
        return true;
    }

}
