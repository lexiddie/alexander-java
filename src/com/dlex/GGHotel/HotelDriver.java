package com.dlex.GGHotel;

import java.util.Scanner;

public class HotelDriver {
	public static void main(String[] args) {
		InputHotel hotel = new InputHotel();
		hotel.insertHotel("The Overstay", "Bangkok", 223, 3.5, 5, "1,2,3,4,8,9,");
		hotel.insertHotel("Klassique Sukhumvit", "Bangkok", 889, 4.8, 8, "2,3,4,9,12,13,");
		hotel.insertHotel("Wake Up Hostel Bangkok", "Bangkok", 564, 4.0, 4, "5,8,9,12,13,14,15,");
		hotel.insertHotel("Cinnamon Residence", "Bangkok", 1802, 4.0, 7, "1,2,3,4,7,8,10,");
		hotel.insertHotel("Holiday Inn Express Bangkok Sathorn", "Bangkok", 2625, 4.2, 7, "3,5,6,8,11,12,");
		hotel.insertHotel("The Chillax Pattaya Guest Houset", "Pattaya", 506, 4.8, 7, "2,3,4,5,9,12,14,");
		hotel.insertHotel("Inrawadee Resort", "Pattaya", 1200, 4.8, 1, "3,4,8,10,14,15,");
		hotel.insertHotel("Splendid Resort at Jomtien", "Pattaya", 2018, 4.0, 6, "8,9,10,12,14,15,");
		hotel.insertHotel("Brighton Grand Hotel Pattya", "Pattaya", 2735, 4.0, 3, "1,2,3,5,7,10,11,12,");
		hotel.insertHotel("Marine Beach Hotel Pattaya", "Pattaya", 3464, 4.5, 6, "3,4,5,7,8,9,12,13,");
		hotel.insertHotel("Proud Phuket Hotel", "Phuket", 3470, 4.8, 2, "3,5,7,8,11,12,");
		hotel.insertHotel("The Memory at On On Hotel", "Phuket", 1643, 4.2, 5, "2,3,4,5,6,8,9,10,");
		hotel.insertHotel("Cocoville Phuket", "Phuket", 2595, 4.8, 3, "4,5,6,9,13,14,15,");
		hotel.insertHotel("Arun Seaview Apartment", "Phuket", 404, 2.5, 9, "1,2,3,5,6,8,10,14,");
		hotel.insertHotel("The Tint At Phuket Town", "Phuket", 961, 4.4, 4, "4,6,7,8,11,13,14,15,");
		hotel.insertHotel("Lai-Thai Guest House", "Chiangmai", 454, 3.0, 6, "3,4,5,6,9,10,");
		hotel.insertHotel("Wiriya House", "Chiangmai", 637, 4.2, 4, "7,8,9,10,14,15,");
		hotel.insertHotel("Bann Rai Klai Weang Homestay", "Chaingmai", 1200, 3.8, 5, "1,2,5,6,7,9");
		hotel.insertHotel("Khuangsingh Residence", "Chaingmai", 1816, 3.95, 3, "1,2,3,5,6,7,10,14,15");
		hotel.insertHotel("Icon Park Hotel Chiang Mai", "Chaingmai", 2913, 4.9, 2, "2,3,4,5,6,9,10,11");
		hotel.insertHotel("J.P. Emerald Hotel", "Yasothon", 627, 3, 6, "1,2,3,4,5,6,");
		hotel.insertHotel("RP CIty Hotel", "Yasothon", 509, 4.5, 7, "1,3,4,6,");
		hotel.insertHotel("BM Grand", "Yasothon", 425, 4.5, 2, "1,5,6,12,");
		hotel.insertHotel("Zigzag Resort", " Yasothon", 340, 2.5, 5, "5,6,7,8,9,10,12,15,");
		hotel.insertHotel("Baan Suan Varaphan", "Yasothon", 342, 2.5, 10, "4,6,7,9,10,15,");
		hotel.insertHotel("Mandarin Betong", "Yala", 1603, 3.5, 9, "2,5,8,12,14,");
		hotel.insertHotel("Cathay Betong", "Yala", 850, 3, 2, "4,7,8,10,");
		hotel.insertHotel("Betong Merlin Hotel", "Yala", 1178, 3, 6, "1,2,3,4,5,6,7,10,15,");
		hotel.insertHotel("The Linux Harden Hotel", "Yala", 661, 4, 8, "1,2,4,5,7,8,9,");
		hotel.insertHotel("River Rock Palm Resort & Spa", "Yala", 1100, 2.5, 1, "5,6,7,8,9,10,12,15,");
		hotel.insertHotel("Seeharaj Hotel", "Uttaradit", 727, 4, 3, "1,2,3,4,5,6,8,9,");
		hotel.insertHotel("Friday Hotel", "Uttaradit", 727, 3.5, 10, "1,4,5,7,8,9,");
		hotel.insertHotel("Sunee Boutique Hotel", "Uttaradit", 501, 4, 5, "4,5,9,10,");
		hotel.insertHotel("Baan Suan Palm Resort", "Uttaradit", 598, 5, 11, "6,12,");
		hotel.insertHotel("Baan Thip", "Uttaradit", 607, 4, 4, "1,4,7,8,9,10,12,14,");
		hotel.insertHotel("Taimit Resort", "Uttaradit", 505, 3.5, 6, ",3,5,7,8,9,10,");
		hotel.insertHotel("K2 Living Uttaradit", "Uttaradit", 450, 2.5, 7, "5,6,8,9,10,12,");
		hotel.insertHotel("Comeneetee Uthai", "UthaiThani", 1122, 5, 12, "1,2,3,4,5,6,");
		hotel.insertHotel("Lyara Lake Hotel Resort", "UthaiThani", 3071, 4, 12, "1,3,4,6,8,");
		hotel.insertHotel("BN Organic Farm Resort", "UthaiThani", 467, 3, 4, "5,6,7,8,9,");
		hotel.insertHotel("Ruanmai Style Resort 2", "UthaiThani", 1682, 2.5, 10, "1,2,3,4,5,6,10,12,14,");
		hotel.insertHotel("THe Sun House Uthai Thani", "UthaiThani", 1334, 3, 6, "10,11,12,13,");
		hotel.insertHotel("P P House", "Uthai Thani", 612, 2.5, 7, "4,5,6,7,8,9,");
		hotel.insertHotel("Centara Hotel Convention UdonThani", "UdonThani", 2190, 4, 7, "1,2,3,4,5,6,7,8,9,10,");
		hotel.insertHotel("STC Homestay Bed & Breakfast", "UdonThani", 637, 5, 6, "1,2,3,4,5,6,");
		hotel.insertHotel("The Pannarai Hotel", "UdonThani", 1087, 4, 7, "4,5,6,7,");
		hotel.insertHotel("Prajaktra City Hostel", "UdonThani", 552, 4.5, 1, "10,12,13,14,");
		hotel.insertHotel("Ramiarndo Boutique Place", "AmnatCharoen", 374, 4.5, 5, "4,7,8,9,10,12,");
		hotel.insertHotel("Fai Kid Hotel", "AmnatCharoen", 661, 4, 4, "4,5,6,8,9,10,");
		hotel.insertHotel("LJ The Emrald Hotel", "AmnatCharoen", 425, 3, 6, "1,2,3,4,5,6,10,14,");
		hotel.insertHotel("Bangsean Heritage Hotel", "Chonburi", 1784, 3.5, 20, "4,5,6,7,8,9,");
		hotel.insertHotel("J Park Hotel", "Chonburi", 872, 4.5, 10, "14,15,");
		hotel.insertHotel("Costa Well Resort Pattaya", "Chonburi", 1528, 4, 1, "2,4,5,6,7,8,9,");
		hotel.insertHotel("Tamarina Resort", "Chonburi", 3476, 4, 8, "4,6,7,8,9,12,");
		hotel.insertHotel("Kroque Boutique and Bistro Hotel", "Chonburi", 1581, 3.5, 9, "4,5,6,7,8,9,");
		hotel.insertHotel("Rattanachol Hotel", "Chonburi", 1341, 4.5, 5, ",1,5,7,8,9,");
		hotel.insertHotel("Pak Oing Ing Tang Boutique Hotel", "Nonthaburi", 1243, 3.5, 8, "11,12,13,14,15,");
		hotel.insertHotel("Maleewana Hotel & Resort", "Nonthaburi", 1784, 4.5, 15, "1,2,3,4,5,6,7,8,9,10,11,12,13,");
		hotel.insertHotel("99 Hotel", "Nonthaburi", 644, 3.5, 10, "8,9,10,11,12,13,");
		hotel.insertHotel("The Sugar Hotel", "Nonthaburi", 636, 5, 3, "4,5,6,7,8,9,");
		hotel.insertHotel("IM-Aim Apartel", "Nonthaburi", 641, 4, 4, "8,9,10,11,12,13,14,");
		hotel.insertHotel("The Bliss Ubon", "UbonRatchathani", 756, 4.5, 1, "5,6,7,8,9,10,12,13,15,");
		hotel.insertHotel("The Outside Inn", "UbonRatchathani", 637, 4.5, 1, "5,6,7,8,9,10,");
		hotel.insertHotel("B2 Ubon Boutique & Budget Hotel", "UbonRatchathani", 583, 4.5, 2, "2,6,");
		hotel.insertHotel("Sunee Grand Hotel", "UbonRatchathani", 1072, 4, 6, "12,13,14,15,");
		hotel.insertHotel("V Hotel Ubon Ratchathani", "UbonRatchathani", 756, 4, 8, "2,3,5,6,8,12,14,");
		hotel.insertHotel("V Hotel Ubon Ratchathani", "UbonRatchathani", 756, 4, 7, "1,2,3,4,5,6,7,");
		hotel.insertHotel("Srilamduan", "Sisaket", 684, 4, 3, "6,7,8,9,");
		hotel.insertHotel("Unity Hotel", "Sisaket", 727, 4, 12, "2,3,4,5,6,7,8,");
		hotel.insertHotel("Tree House Hotel", "Sisaket", 466, 3.5, 10, "2,3,5,6,8,9,");
		hotel.insertHotel("Vijitnakorn Nonpak Hotel", "Sisaket", 920, 4, 1, ",4,5,6,7,8,9,10,");
		hotel.insertHotel("Pornsiri Hotel Sisaket", "Sisaket", 561, 5, 5, "1,2,3,4,5,6,7,8,9,10,");
		hotel.insertHotel("Kessiri Hotel", "Sisaket", 385, 2.5, 12, "5,6,8,9,");
		hotel.insertHotel("Gallery Design Hotel Srisaket", "Sisaket", 1026, 4.5, 10, "2,5,8,9,12,15,");

		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\tWelcome to Booking Hotel Service");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter 1 to Show Menu / 0 to Exit: ");
		int n = sc.nextInt();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		do {
			System.out.print("Enter 1 for Searching Hotel Name / 2 for Searching location / 3 for Booking / 0 to Exit: ");
			int m = sc.nextInt();
			if (m == 1) {
				hotel.searchingName();
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			} else if (m == 2) {
				System.out.print("Enter your Destination: ");
				String location = sc.next();
				System.out.println("Enter 1 to show result \nEnter 2 to searching price \nEnter 3 to searching rating stars:");
				System.out.print("Enter your Input: ");
				int num = sc.nextInt();
				if (num == 1) {
					System.out.println("Name \t\t\t\t        Location           Price(Baht)    Rating	AvailableRoom(s)     of December");
					hotel.searchingLocation(location);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				} else if (num == 2) {
					System.out.print("Price starting from: ");
					int price1 = sc.nextInt();
					System.out.print("To: ");
					int price2 = sc.nextInt();
					System.out.println("Name \t\t\t\t        Location           Price(Baht)    Rating	AvailableRoom(s)     of December");
					hotel.sortingPrice(location, price1,price2);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				} else if (num == 3) {
					System.out.print("Rating Stars start from: ");
					double star = sc.nextDouble();
					System.out.println("Name \t\t\t\t        Location           Price(Baht)    Rating	AvailableRoom(s)    of December");
					hotel.sortingStar(location, star);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				}

			} else if (m == 3) {
				hotel.Booking();
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			} else if (m == 0) {

				break;
			}
		} while (n == 1);
		System.out.println("-----------------Thank you for Using and Hope to see you again !------------------------------");
	}
}
