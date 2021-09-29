package com.dlex.BookingHotel;

public class HotelDriver {
	public static void main (String[] args) {
		HotelLinkedList i = new HotelLinkedList();
		i.insertHotel("The Continent Hotel ", "Bangkok", 5777);
		i.insertHotel("Eastin Grand Hotel Sathorn", "Bangkok", 7789);
		i.insertHotel("Shangri-La Hotel Bangkok", "Bangkok", 6188);
		i.insertHotel("Dream Bangkok", "Bangkok", 5506);
		i.insertHotel("Bangkok Marriott Hotel The Surawongse", "Bangkok", 8300);
		i.insertHotel("Pathumwan Princess Hotel", "Bangkok", 7414);
		i.insertHotel("Banyan Tree Bangkok", "Bangkok", 5301);
		i.insertHotel("Akara Hotel", "Bangkok", 3727);
		i.insertHotel("Millennium Hilton Bangkok", "Bangkok", 6283);
		i.insertHotel("Amari Watergate Bangkok", "Bangkok", 4500);
		i.insertHotel("Anantara Riverside Bangkok Resort", "Bangkok", 1100);
		i.insertHotel("SSAW Boutique Hotel Shanghai Bund", "Shanghai", 5659);
		i.insertHotel("Les Suites Orient, Bund Shanghai", "Shanghai", 8842);
		i.insertHotel("Shanghai Marriott Hotel City Centre", "Shanghai", 5324);

		System.out.println(i.count());
		i.searchLocation("Bangkok");
	}
}
