package com.hust.soict.Bui_Phuong_Th.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String argv[]) throws IOException {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9898);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			String message = null;
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter array:");
			message = scanner.nextLine();
			out.println(message);
			
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			scanner.close();
		} catch (IOException e) {
			System.out.println("Cannot connect to server!");
		}finally {
			socket.close();
		}
	}
}
