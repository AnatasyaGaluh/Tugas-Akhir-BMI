/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anatasya
 */
import java.util.*;

public class urut {
        public static void main(String[] args){
            int n;
            String jml = "Masukkan jumlah bilangan acak : ";
            n = inputAngka(jml);
            
            int[] array = new int[n];
            Random rand = new Random();
            for (int i = 0; i < array.length; i++){
                array[i] = rand.nextInt(20 - 1 + 1) + 1;
            }
            
            boolean cetakMenu = false;
            do{
                System.out.println("===========Menu===========");
                System.out.println("1. Lihat Angka");
                System.out.println("2. Acak Angka");
                System.out.println("3. Sort Angka (Ascending)");
                System.out.println("4. Sort Angka (Descending)");
                System.out.println("5. Keluar");   
                
                int menu;
                String pilMenu = "Masukkan pilihan menu : ";
                do{
                    menu = inputAngka(pilMenu);
                } while (!nomenu(menu));
                
                System.out.println();
                
                switch(menu){
                    case 1:
                        System.out.println("1. Lihat Angka");
                        printArray(array);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("2. Acak Angka");
                        shuffleArray(array);
                        printArray(array);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("3. Urutan Angka Ascending");
                        selectionAsc(array);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("4. Urutan Angka Descending");
                        selectionDsc(array);
                        System.out.println();
                        break;
                    case 5:
                        cetakMenu = true;
                }
            }while(!cetakMenu);
        }

        
        public static int inputAngka (String n){
            Scanner input = new Scanner(System.in);
            boolean angka;
            int menu = 0;
            do{
                try{
                    System.out.print(n);
                    menu = input.nextInt();
                    input.nextLine();
                    angka = true;
                } catch(InputMismatchException e){
                    System.out.println("Inputan tidak valid!");
                    input.next();
                    angka = false;
                }
            } while(!angka);
            return menu;
        }
        
        public static boolean nomenu(int n){
            boolean oneToFive = true;
            if(n < 1 || n > 5){
                System.out.println("Pilih angka 1-5!");
                oneToFive = false;
            }
            return oneToFive;
        }
        
        public static void shuffleArray(int[] array){
            ArrayList<Integer> list = new ArrayList<>(array.length);
            for(int i=0; i < array.length; i++){
                list.add(array[i]);
            }
            Collections.shuffle(list);
            
            for(int i=0; i < list.size(); i++){
                array[i] = list.get(i);
            }
        }
        
        public static void printArray(int[] array){
            for(int i=0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
        }
        
        public static void selectionAsc(int[] array){
                for (int i=0 ; i < array.length ;i++){
                int temp = array[i];
                for (int j=i ; j < array.length ; j++){
                    if (array[j] <= array[i]){
                        array[i] = array [j];  
                        array[j] = temp;
                        temp = array[i];
                    }
                }
        }
                for (int k=0; k < array.length ; k++){
                    System.out.print(array[k]+" ");
        }
            System.out.println();
        }
        
        public static void selectionDsc(int[] array){
                for (int i=0 ; i < array.length ;i++){
                int temp = array[i];
                for (int j=i ; j < array.length ; j++){
                    if (array[j] >= array[i]){
                        array[i] = array [j];  
                        array[j] = temp;
                        temp = array[i];
                    }
                }
        }
                for (int k=0; k < array.length ; k++){
                    System.out.print(array[k]+" ");
        }
            System.out.println();
        }
}
