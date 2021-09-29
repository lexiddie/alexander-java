package com.dlex.PageReplacement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainCode {
    private static int fault = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Page Replacement");
        System.out.print("No. of frames: ");
        int frame = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter reference string: ");
        String ref = sc.nextLine();

        int[] page_ref = convertToIntArray(ref);

        System.out.println("Select Algorithm");
        System.out.println("1. FIFO | 2. LRU | 3. Optimal");
        System.out.println("Other numbers to quit");
        System.out.print("Select: ");
        int s = sc.nextInt();

        if (s == 1) {
            FIFO(page_ref, frame);
        } else if (s == 2) {
            LRU(page_ref, frame);
        } else if (s == 3) {
            OPTIMAL(page_ref, frame);
        } else {
            System.out.println("quit");
        }
        sc.close();
    }

    private static int[] convertToIntArray(String input) {
        String[] strArray = input.split("\\s+");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }


    private static void FIFO(int[] ref, int frame) {
        int[] process = new int[frame];
        initializeProcess(process);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ref.length; ++i) {
            boolean allocation = false;
            for (int j = 0; j < process.length; ++j) {
                if (!allocation) {
                    if (process[j] == -1) {
                        allocation = true;
                        q.add(ref[i]);
                        process[j] = ref[i];
                    } else if (process[j] == ref[i]) {
                        allocation = true;
                    }
                }
            }
            if (!allocation) {
                int temp = q.poll();
                int index = 9;
                for (int h = 0; h < process.length; ++h) {
                    if (process[h] == temp) {
                        index = h;
                    }
                }
                process[index] = ref[i];
                allocation = true;
                q.add(ref[i]);
                fault++;
            }
            printProcess(process, i);
        }
        System.out.println("page fault: " + fault);
    }
    private static int[] initializeProcess(int[] process) {
        for (int i = 0; i < process.length; ++i) {
            process[i] = -1;
        }
        return process;
    }
    private static void printProcess(int[] process, int time) {
        System.out.print(time + ": ");
        for (int j : process) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private static void LRU(int[] ref, int frame) {
        int[] process = new int[frame];
        initializeProcess(process);
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < ref.length; ++i) {
            boolean allo = false;
            for (int j = 0; j < process.length; ++j) {
                if (!allo) {
                    if (process[j] == -1) {
                        allo = true;
                        q.add(ref[i]);
                        process[j] = ref[i];
                    } else if (process[j] == ref[i]) {
                        allo = true;
                        q.remove(process[j]);
                        q.add(ref[i]);
                    }
                }
            }
            if (!allo) {
                int least_recent = q.poll();
                int index = 0;
                for (int h = 0; h < process.length; ++h) {
                    if (process[h] == least_recent) {
                        index = h;
                    }
                }
                process[index] = ref[i];
                allo = true;
                q.add(ref[i]);
                fault++;
                System.out.println("Page fault");
            }
            printProcess(process, i);
        }
        System.out.println("page fault: " + fault);
    }

    private static void OPTIMAL(int[] ref, int frame) {
        Queue<Integer> q = new LinkedList<>();
        int[] process = new int[frame];
        initializeProcess(process);
        for (int i = 0; i < ref.length; ++i) {
            boolean allo = false;
            for (int j = 0; j < process.length; ++j) {
                if (!allo) {
                    if (process[j] == -1) {
                        allo = true;
                        q.add(ref[i]);
                        process[j] = ref[i];
                    } else if (process[j] == ref[i]) {
                        allo = true;
                    }
                }
            }
            if (!allo) {
                int[] future_use = new int[frame];
                initializeProcess(future_use);
                for (int g = 0; g < process.length; ++g) {
                    int count = 0;
                    boolean found = false;
                    for (int f = i + 1; f < ref.length; ++f) {
                        if (ref[f] == process[g] && future_use[g] == -1 && !found) {
                            future_use[g] = count;
                            found = true;
                        }
                        count++;
                    }
                    if (!found) {
                        future_use[g] = count;
                    }
                }
                System.out.println("Future: " + Arrays.toString(future_use));
                int max = getMaxValue(future_use);
                System.out.println("Print max " + max);
                int index = 0;
                int victim = 0;
                LinkedList<Integer> containMax = new LinkedList<>();
                 for (int m = 0; m < process.length; ++m) {
                    if (future_use[m] == max) {
                        containMax.add(process[m]);
                    }
                }
                for (int tt : q) {
                    if (containMax.contains(tt)) {
                        victim = tt;
                    }
                }
                for (int h = 0; h < process.length; ++h) {
                    if (process[h] == victim) {
                        index = h;
                    }
                }
                q.add(ref[i]);
                process[index] = ref[i];
                allo = true;
                fault++;
                System.out.println("Page fault");
            }
            printProcess(process, i);
        }
        System.out.println("page fault: " + fault);
    }
    private static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
