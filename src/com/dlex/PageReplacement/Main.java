package com.dlex.PageReplacement;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter number of frames: ");
		int Frame = scan.nextInt();

		scan.nextLine();
		//String RefTest = "2 4 2 1 5 2 4 5 3 2 5 2";
		String RefTest = "1 2 3 5 6 4 3 5 1 6 2 3";
		System.out.println("Enter reference string: " + RefTest);
		String ReferenceString;

		String[] strArray = RefTest.split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}

		System.out.print("\n1.FIFO | 2.LRU | 3. Optimal | Other to quit\n");
		System.out.print("Select algorithm above: ");
		int Select = scan.nextInt();
		System.out.println();

		if (Select == 1) {
			FIFO(intArray, Frame);
		} else if (Select == 2) {
			LRU(intArray, Frame);
		} else if (Select == 3) {
			Optimal(intArray, Frame);
		} else {
			System.out.print("Quit");
		}

		scan.close();
	}

	private static int[] setProcess(int[] Process) {
		for (int i = 0; i < Process.length; i++) {
			Process[i] = -1;
		}
		return Process;
	}

	private static void Print(int[] Process, int time) {
		System.out.print("String reference " + time + " -> [");
		for (int i = 0; i < Process.length; i++) {
			if (i == Process.length-1) {
				System.out.print(Process[i]);
			} else {
				System.out.print(Process[i] + ", ");
			}

		}
		System.out.println("]");
	}

	private static void FIFO(int[] Ref, int Frame) {
		int pageFault = 0;
		int[] Process = new int[Frame];
		setProcess(Process);
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int value : Ref) {
			boolean check = false;

			for (int j = 0; j < Process.length; j++) {
				if (!check) {
					if (Process[j] == -1) {
						check = true;
						queue.add(value);
						Process[j] = value;
					} else if (Process[j] == value) {
						check = true;
					}
				}
			}
			if (!check) {
				int recent = queue.poll();
				int index = 0;
				for (int k = 0; k < Process.length; k++) {
					if (Process[k] == recent) {
						index = k;
					}
				}
				Process[index] = value;
				check = true;
				queue.add(value);
				pageFault++;
				System.out.print("Page Fault --> ");
			}
			Print(Process, value);
		}
		System.out.println("\nPage fault: " + pageFault);
	}

	private static void LRU(int[] Ref, int Frame) {
		int pageFault = 0;
		int[] Process = new int[Frame];
		setProcess(Process);
		Queue<Integer> queue = new LinkedList<>();

		for (int value : Ref) {
			boolean check = false;

			for (int j = 0; j < Process.length; j++) {
				if (!check) {
					if (Process[j] == -1) {
						check = true;
						queue.add(value);
						Process[j] = value;
					} else if (Process[j] == value) {
						check = true;
						queue.remove(Process[j]);
						queue.add(value);
					}
				}
			}
			if (!check) {
				int recent = queue.poll();
				int index = 0;
				for (int k = 0; k < Process.length; k++) {
					if (Process[k] == recent) {
						index = k;
					}
				}
				Process[index] = value;
				check = true;
				queue.add(value);
				pageFault++;
				System.out.print("Page Fault --> ");
			}
			Print(Process, value);
		}
		System.out.print("\nPage fault: " + pageFault);
	}

	private static void Optimal(int[] Ref, int Frame) {
		int pageFault = 0;
		int[] Process = new int[Frame];
		setProcess(Process);
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < Ref.length; i++) {
			boolean check = false;

			for (int j = 0; j < Process.length; j++) {
				if (!check) {
					if (Process[j] == -1) {
						check = true;
						queue.add(Ref[i]);
						Process[j] = Ref[i];
					} else if (Process[j] == Ref[i]) {
						check = true;
					}
				}
			}
			
			if (!check) {
				int[] future = new int[Frame];
				setProcess(future);
				for(int k = 0; k < Process.length; k++) {
					int count = 0;
					boolean found = false;
					for(int l = i+1; l < Ref.length; l++) {
						if (Ref[l] == Process[k] && future[k] == -1 && !found) {
							future[k] = count;
							found = true;
						}
						count++;
					}
					if (!found) {
						future[k] = count;
					}
				}

				int max = getMaxValue(future);
				int index = 0;
				int v = 0;
				LinkedList<Integer> memMax = new LinkedList<>();
				for(int m = 0; m < Process.length; m++) {
					if (future[m] == max) {
						memMax.add(Process[m]);
					}
				}
				
				for(int tt:queue) {
					if (memMax.contains(tt)) {
						v = tt;
					}
				}
				
				for(int n = 0; n < Process.length; n++) {
					if (Process[n] == v) {
						index = n;
					}
				}
				queue.add(Ref[i]);
				Process[index] = Ref[i];
				check = true;
				pageFault++;
				System.out.print("Page Fault --> ");
			}
			Print(Process, Ref[i]);
		}
		
		System.out.print("\nPage fault: "+ pageFault);
	}
	
	private static int getMaxValue(int[] array) {
		int maxValue = Integer.MIN_VALUE;
		for (int j : array) {
			if (j > maxValue) {
				maxValue = j;
			}
		}
		return maxValue;
	}
	
}