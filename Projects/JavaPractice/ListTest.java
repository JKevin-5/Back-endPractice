public class ListTest {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        int copyArr[] = new int[10];
        System.arraycopy(arr, 0, copyArr, 0,arr.length);
        
        for (int i : copyArr) {
            System.out.print(i+",");
        }
    }
}