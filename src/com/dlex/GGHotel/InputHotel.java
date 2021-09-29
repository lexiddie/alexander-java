package com.dlex.GGHotel;

import java.util.Scanner;

public class InputHotel {
	Node start;
	Node end;
	Customer customer;

	public void insertHotel(String name, String location, double price, double star, int room, String availableDay) {
		Hotel newHotel = new Hotel(name, location, price, star, room, availableDay);
		Node newNode = new Node(newHotel, null);
		if (start == null) {
			start = newNode;
			end = newNode;

		} else {
			end.setNext(newNode);
			end = newNode;
		}

	}

	public void Print() {
		Node current = start;
		while (current != null) {
			System.out.println(current.getHotel().toString());
			current = current.getNext();
		}
	}

	public void searchingName() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		System.out.print("Enter Hotel name: ");
		String name = sc.nextLine();
		Node current = this.start;
		while (current != null) {
			if (current.getHotel().getName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println(
						"Name \t\t\t\t        Location          Price(Baht)    Rating	   AvailableRoom(s)        of December");
				System.out.println(current.getHotel().toString());
				n++;
			}
			current = current.getNext();
		}
		if (n == 0) {
			System.out.println("Not Found or Wrong Input, Please Check and Try again! ");
		}

	}

	public void sortingPrice(String name, int price1, int price2) {
		Node current = this.start;
		int n = 0;
		while (current != null) {
			if (current.getHotel().getLocation().toLowerCase().equals(name.toLowerCase())) {
				if (current.getHotel().getPrice() >= price1&&current.getHotel().getPrice()<=price2) {
					System.out.println(current.getHotel().toString());
					n++;
				}
			}
			current = current.getNext();
		}
		if (n == 0) {
			System.out.println("Not Found or Wrong Input, Please Check and Try again! ");
		}
	}

	public void searchingLocation(String destination) {
		Node current = this.start;
		int n = 0;
		while (current != null) {
			if (current.getHotel().getLocation().toLowerCase().equals(destination.toLowerCase())) {
				System.out.println(current.getHotel().toString());
				n++;
			}
			current = current.getNext();
		}
		if (n == 0) {
			System.out.println("Not Found or Wrong Input, Please Check and Try again");
		}
	}

	public void sortingStar(String name, double star) {
		Node current = this.start;
		int n = 0;
		while (current != null) {
			if (current.getHotel().getLocation().toLowerCase().equals(name.toLowerCase())) {
				if (current.getHotel().getStar() >= star) {
					System.out.println(current.getHotel().toString());
					n++;
				}
			}
			current = current.getNext();
		}
		if (n == 0) {
			System.out.println("Not Found or Wrong Input, Please Check and Try again");
		}
	}

	public void Booking() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean Name = false;
		boolean Room = false;
		double totalMoney = 0;
		Node current = this.start;
		System.out.print("Enter Hotel Name: ");
		String name = sc.nextLine();
		System.out.print("Enter amount of Room: ");
		int amount = sc.nextInt();
		System.out.print("Enter Date Seperate each date by (,) : ");
		String date = sc.next() + ",";
		System.out.print("Enter your Name: ");
		String user = sc.next();
		System.out.print("Enter your Phone number: ");
		int phoneNumber = sc.nextInt();
		Customer customer = new Customer(user, phoneNumber);
		String[] newDate = date.split(",");
		String[] freeDates = current.getHotel().getAvailableDay().split(",");
		while (current != null) {
			if (current.getHotel().getName().toLowerCase().equals(name.toLowerCase())) {
				if (current.getHotel().getRoom() >= amount) {
					Room = true;
					for (String s : newDate) {
						for (String freeDate : freeDates) {
							if (s.equals(freeDate)) {
								n++;
							}
						}
					}
					if (n == newDate.length) {
						totalMoney = current.getHotel().getPrice() * newDate.length * amount;
						current.getHotel().setRoom(current.getHotel().getRoom() - amount);
						break;
					}
				}
				Name = true;
			}
			current = current.getNext();
		}
		if (n == newDate.length) {
			System.out.println(
					"*************************************Booking Success !*******************************************");
			System.out.println("User: " + user + " Have Book " + name + " " + amount + " Room(s) for " + newDate.length
					+ " Night(s)");
			System.out.println("-------------" + "Amount to Pay is " + totalMoney + " Baht " + "----------------");

		} else if (!Name) {
			System.out.println(
					"************************************* Wrong Hotel Name ! *******************************************");
		} else if (!Room) {
			System.out.println(
					"********************************* Amount of Room Not Available! ************************************");
		} else if (n != newDate.length) {
			System.out.println(
					"************************************* Date not available! *******************************************");
		}
	}
}